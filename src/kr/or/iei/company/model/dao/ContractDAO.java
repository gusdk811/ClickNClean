package kr.or.iei.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.contract.model.vo.Contract;

public class ContractDAO {

	public ArrayList<Contract> MemberAllList(Connection conn, String coId,  int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Contract> list = new ArrayList<Contract>();
		
	
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		
		
		
		String query = "select * from (select ROW_NUMBER() OVER (order BY contractNo asc) " + 
						" as num, contract.*, condition.cleanType, member.phone, member.email, condition.reqDate, member.userName " + 
						" from CONTRACT left join condition on (contract.conditionNo = condition.conditionNo) " + 
						" left join member on (contract.userId = member.userId) " + 
						" where coId = ? and reqContract_YN = 'Y') " + 
						" where num between ? and ? ";
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			
			pstmt.setString(1, coId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Contract c = new Contract();
				c.setContractNo(rset.getInt("contractNo"));
				c.setCleanType(rset.getString("cleanType"));
				c.setUserId(rset.getString("userId"));
				c.setUserName(rset.getString("userName"));
				c.setPhone(rset.getString("phone"));
				c.setEmail(rset.getString("email"));
				c.setContractFinDate(rset.getDate("contractFinDate"));
				c.setReqContractYN(rset.getString("reqContract_YN").charAt(0));
				c.setReqDate(rset.getDate("reqDate"));	
				c.setCleanYN(rset.getString("clean_YN").charAt(0));
				
				list.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public String getPageNavi(Connection conn, String coId, int naviCountPerPage, int currentPage, int recordCountPerPage) {
		int recordTotalCount = totalCount(conn, coId);
		
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = (recordTotalCount/recordCountPerPage)+1;
		}else {
			pageTotalCount = (recordTotalCount/recordCountPerPage);
		}
		
		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage)+1;
		int endNavi = startNavi + (naviCountPerPage -1);
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi != 1) {
			sb.append("<a href='/co/coMemberAllList.do?currentPage=" + (startNavi-1)+"'>< Prev</a>     ");
		}
		
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a href='/co/coMemberAllList.do?currentPage=" + i + "'><b style='font-size:1.2rem'>"+i+"</b></a>" );
			}else {
				sb.append("<a href='/co/coMemberAllList.do?currentPage=" + i + "'>" + i + "</a> " );
			}
		}
		
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/co/coMemberAllList.do?currentPage="+(endNavi+1)+"'>   Next ></a> ");
		}
		return sb.toString();
	}

	private int totalCount(Connection conn, String coId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "select count(*) as count from Contract where coId = ? and reqContract_YN = 'Y' ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, coId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}

	public ArrayList<Contract> selectSearchMember(String coId, Connection conn, int currentPage, int recordCountPerPage,
			String memberKey, String searchType) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Contract> list = new ArrayList<Contract>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		System.out.println(start);
		System.out.println(end);
		
		String query="";
		
		switch(searchType) {
		case "contractNo" : 
			query = "select contract.*, condition.cleanType, member.phone, member.email,condition.reqDate, " + 
					"member.userName from CONTRACT left join condition on (contract.conditionNo = condition.conditionNo) " + 
					"left join member on (contract.userId = member.userId) " + 
					"where contract.coId = ? and CONTRACT.CONTRACTNO like ? and contract.reqContract_YN = 'Y'";
			break;
			
		case "userId" : 
			query = "select contract.*, condition.cleanType, member.phone, member.email,condition.reqDate, " + 
					"member.userName from CONTRACT left join condition on (contract.conditionNo = condition.conditionNo) " + 
					"left join member on (contract.userId = member.userId) " + 
					"where contract.coId = ? and member.userId like ? and contract.reqContract_YN = 'Y'";
			break;
			
		case "phone" : 
			query = "select contract.*, condition.cleanType, member.phone, member.email,condition.reqDate, " + 
					"member.userName from CONTRACT left join condition on (contract.conditionNo = condition.conditionNo) " + 
					"left join member on (contract.userId = member.userId) " + 
					"where contract.coId = ? and member.phone like ? and contract.reqContract_YN = 'Y'";
			break;
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, coId);
			pstmt.setString(2, "%"+memberKey+"%");
			
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Contract c = new Contract();
				c.setContractNo(rset.getInt("contractNo"));
				c.setCleanType(rset.getString("cleanType"));
				c.setUserId(rset.getString("userId"));
				c.setUserName(rset.getString("userName"));
				c.setPhone(rset.getString("phone"));
				c.setEmail(rset.getString("email"));
				c.setContractFinDate(rset.getDate("contractFinDate"));			
				c.setReqDate(rset.getDate("reqDate"));	
				c.setCleanYN(rset.getString("clean_YN").charAt(0));
				
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String searchMemberPageNavi(String coId, Connection conn, int naviCountPerPage, int currentPage, int recordCountPerPage,
			String memberKey, String searchType) {
		
		int recordTotalCount = totalMemberSearchCount(coId, conn, memberKey, searchType);
		
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = (recordTotalCount/recordCountPerPage)+1;
		}else {
			pageTotalCount = (recordTotalCount/recordCountPerPage);
		}
		
		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage)+1;
		int endNavi = startNavi + (naviCountPerPage -1);
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi != 1) {
			sb.append("<a href='/co/coMemberAllList.do?currentPage=" + (startNavi-1)+"&keyword="+memberKey+"&type="+searchType+"'>< Prev</a>     ");
		}
		
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a href='/co/coMemberAllList.do?currentPage=" + i+"&keyword="+memberKey+"&type="+searchType+"'><b style='font-size:1.2rem'>"+i+"</b></a>" );
			}else {
				sb.append("<a href='/co/coMemberAllList.do?currentPage=" + i + " &keyword="+memberKey+"&type="+searchType+"'>" + i + "</a> " );
			}
		}
		
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/co/coMemberAllList.do?currentPage"+(endNavi+1)+"&keyword="+memberKey+"&type="+searchType+"'>Next ></a> ");
		}
		return sb.toString();
		
	}

	private int totalMemberSearchCount(String coId, Connection conn, String memberKey, String searchType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query ="";
		
		switch(searchType) {
		case "contractNo" : 
			query = "select count(*) as count from  contract " + 
					"where coId= ? and contractNo like ? and contract.reqContract_YN = 'Y'";
			break;
			
		case "userId" : 
			query = "select count(*) as count from  contract " + 
					"left join member on contract.userId = member.userId " + 
					"where contract.coId = ? and member.userId like ? and contract.reqContract_YN = 'Y'";
			break;
			
		case "phone" : 
			query ="select count(*) as count from  contract " + 
					"left join member on contract.userId = member.userId " + 
					"where contract.coId = ? and member.phone like ? and contract.reqContract_YN = 'Y'";
			break;
			
		}
		try {
			pstmt = conn.prepareStatement(query);
			
				pstmt.setString(1, coId);
				pstmt.setString(2, "%"+memberKey+"%");
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	public ArrayList<Contract> selectReservationDay(Connection conn, String coId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Contract> list = new ArrayList<Contract>();
		
		String query = "select condition.*, contract.coId from condition left join contract on (condition.userId = contract.userId) where coId = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setString(1, coId);
				
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Contract c = new Contract();
				
				
				c.setUserId(rset.getString("userId"));
				c.setCleanType(rset.getString("cleanType"));
				c.setHouseType(rset.getString("houseType"));
				c.setArea(rset.getString("area"));
				c.setHouseSize(rset.getInt("houseSize"));
				c.setReqDate(rset.getDate("reqDate"));
				c.setCoId(rset.getString("coId"));
				
				list.add(c);
				
			
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
