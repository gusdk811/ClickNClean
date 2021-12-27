package kr.or.iei.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.contract.model.vo.Contract;

public class ReviewDAO {

	public ArrayList<Contract> inqueryhistory(String userId, Connection conn, int currentPage, int recordCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Contract> list = new ArrayList<Contract>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end =  currentPage * recordCountPerPage;
		
		String query = "select * " + 
						"from(select row_number()over(order by contractNo desc)as num, contract.*,coname, CLEANTYPE " + 
						"from contract " + 
						"join company on(contract.coid=company.coid) " + 
						"left join condition on(contract.conditionNo=condition.conditionNo) " + 
						"where contract.userId=? and contract_YN='N') " + 
						"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Contract cd = new Contract();
				
				cd.setContractNo(rset.getString("CONTRACTNO"));
				cd.setCleanType(rset.getString("cleantype"));
				cd.setCoName(rset.getString("coName"));
				cd.setCoCheckYN(rset.getString("COCHECK_YN").charAt(0));
				cd.setCleanDate(rset.getDate("cleanDate"));
				cd.setReqContractDate(rset.getDate("reqContractDate"));
				cd.setPrice(rset.getInt("price"));
				
				list.add(cd);
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
	
	public String getPageNavi(int naviCountPerPage, Connection conn, int currentPage, int recordCountPerPage, String userId) {

		
		int recordtotalCount = totalCount(conn, userId); //전체 글 개수
			
		int pageTotalCount = 0; //전체 페이지 개수
			
		pageTotalCount = (int)Math.ceil(recordtotalCount / (double)recordCountPerPage);
			
		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage) +1;
		int endNavi = startNavi + (naviCountPerPage - 1);
			
			
		if(endNavi > pageTotalCount) {
			
			endNavi = pageTotalCount;
		}
		
			StringBuilder sb = new StringBuilder();
			
			if(startNavi!=1) {
				sb.append("<a href='/reiview/reservationList.do?currentPage="+(startNavi-1)+"'> 이전  </a> ");
			}
			
			for(int i=startNavi; i<=endNavi;i++ ) {
				
				if(i==currentPage) {
					sb.append("<a href='/reiview/reservationList.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			
				}else {
					sb.append("<a href='/reiview/reservationList.do?currentPage="+i+"'>"+i+"</a> ");
				}
			}
			
			if(endNavi!=pageTotalCount) {
				sb.append("<a href='/reiview/reservationList.do?currentPage="+(endNavi+1)+"'> 다음 </a> ");
			}
			
			return sb.toString();
		}
		
	public int totalCount(Connection conn, String userId) {
			
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		int count = 0;
		String query = "select count(*) as count from contract where userId=?";
			
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
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

	public ArrayList<Contract> review(String userId, Connection conn, int currentPage, int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Contract> list = new ArrayList<Contract>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end =  currentPage * recordCountPerPage;
		
		String query = "select * " + 
						"from(select row_number()over(order by contractNo desc)as num, contract.*,coname, CLEANTYPE " + 
						"from contract " + 
						"join company on(contract.coid=company.coid) " + 
						"left join condition on(contract.conditionNo=condition.conditionNo) " + 
						"where contract.userId=? and clean_YN='Y') " + 
						"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Contract cd = new Contract();
				
				cd.setContractNo(rset.getString("CONTRACTNO"));
				cd.setCleanType(rset.getString("cleantype"));
				cd.setCoName(rset.getString("coName"));
				cd.setCoCheckYN(rset.getString("COCHECK_YN").charAt(0));
				cd.setCleanDate(rset.getDate("cleanDate"));
				cd.setReqContractDate(rset.getDate("reqContractDate"));
				cd.setPrice(rset.getInt("price"));
				cd.setContractFinDate(rset.getDate("contractFinDate"));
				
				list.add(cd);
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

	public String getReviewPageNavi(int naviCountPerPage, Connection conn, int currentPage, int recordCountPerPage,
			String userId) {
		int recordtotalCount = totalCount(conn, userId); //전체 글 개수
		
		int pageTotalCount = 0; //전체 페이지 개수
			
		pageTotalCount = (int)Math.ceil(recordtotalCount / (double)recordCountPerPage);
			
		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage) +1;
		int endNavi = startNavi + (naviCountPerPage - 1);
			
			
		if(endNavi > pageTotalCount) {
			
			endNavi = pageTotalCount;
		}
		
			StringBuilder sb = new StringBuilder();
			
			if(startNavi!=1) {
				sb.append("<a href='/review/review.do?currentPage="+(startNavi-1)+"'> 이전  </a> ");
			}
			
			for(int i=startNavi; i<=endNavi;i++ ) {
				
				if(i==currentPage) {
					sb.append("<a href='/review/review.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			
				}else {
					sb.append("<a href='/review/review.do?currentPage="+i+"'>"+i+"</a> ");
				}
			}
			
			if(endNavi!=pageTotalCount) {
				sb.append("<a href='/review/review.do?currentPage="+(endNavi+1)+"'> 다음 </a> ");
			}
			
			return sb.toString();
		}
		
	public int reviewTotalCount(Connection conn, String userId) {
			
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		int count = 0;
		String query = "select count(*) as count from contract where userId=? and clean_YN='Y'";
			
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
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

	public ArrayList<Contract> reviewWriteList(String userId, Connection conn, int currentPage,
			int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Contract> list = new ArrayList<Contract>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end =  currentPage * recordCountPerPage;
		
		String query = "select * " + 
						"from(select row_number()over(order by contractNo desc)as num, contract.*,coname, CLEANTYPE " + 
						"from contract " + 
						"join company on(contract.coid=company.coid) " + 
						"left join condition on(contract.conditionNo=condition.conditionNo) " + 
						"where contract.userId=? and clean_YN='Y' and ) " + 
						"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Contract cd = new Contract();
				
				cd.setContractNo(rset.getString("CONTRACTNO"));
				cd.setCleanType(rset.getString("cleantype"));
				cd.setCoName(rset.getString("coName"));
				cd.setCoCheckYN(rset.getString("COCHECK_YN").charAt(0));
				cd.setCleanDate(rset.getDate("cleanDate"));
				cd.setReqContractDate(rset.getDate("reqContractDate"));
				cd.setPrice(rset.getInt("price"));
				cd.setContractFinDate(rset.getDate("contractFinDate"));
				
				list.add(cd);
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

	public String getReviewWritePageNavi(int naviCountPerPage, Connection conn, int currentPage, int recordCountPerPage,
			String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
