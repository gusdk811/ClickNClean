package kr.or.iei.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.review.model.vo.Review;

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
						"where contract.userId=? and contract_YN='Y' and clean_YN='N') " + 
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
				cd.setCoId(rset.getString("coId"));
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
		String query = "select count(*) as count from contract where userId=? and clean_YN='N'";
			
		
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
				"from(select row_number()over(order by contract.contractNo desc)as num, " + 
				"contract.*,company.coname, condition.CLEANTYPE ,review.reviewNo " + 
				"from contract " + 
				"join company on(contract.coid=company.coid) " + 
				"left join condition on(contract.conditionNo=condition.conditionNo) " + 
				"left join review on(contract.contractNo=review.contractNo) " + 
				"where contract.userId=? and contract_YN='Y' and clean_YN='Y' and review.end_YN='N') " + 
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
				cd.setCoId(rset.getString("coId"));
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
				sb.append("<a href='/review/reviewList.do?currentPage="+(startNavi-1)+"'> 이전  </a> ");
			}
			
			for(int i=startNavi; i<=endNavi;i++ ) {
				
				if(i==currentPage) {
					sb.append("<a href='/review/reviewList.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			
				}else {
					sb.append("<a href='/review/reviewList.do?currentPage="+i+"'>"+i+"</a> ");
				}
			}
			
			if(endNavi!=pageTotalCount) {
				sb.append("<a href='/review/reviewList.do?currentPage="+(endNavi+1)+"'> 다음 </a> ");
			}
			
			return sb.toString();
		}
		
	public int reviewWriteTotalCount(Connection conn, String userId) {
			
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		int count = 0;
		String query = "select count(*) as count from review where userid=? and end_YN='N'";
			
		
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

	public int inserReview(Review r, Connection conn) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println(r.getContractNo());
		
		
		String query = "insert into review values(rev_seq.nextval,?,?,?,?,?,sysdate,'사진','N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, r.getContractNo());
			pstmt.setString(2, r.getUserId());
			pstmt.setString(3, r.getCoId());
			pstmt.setString(4, r.getContent());
			pstmt.setInt(5, r.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Review selectOneReview(Connection conn, int contractNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		
		String query = "select * from review where contractNo=? and end_yn='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, contractNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				r = new Review();
				
				r.setReviewNo(rset.getInt("reviewNo"));
				r.setContractNo(rset.getInt("contractNo"));
				r.setUserId(rset.getString("userId"));
				r.setCoId(rset.getString("coId"));
				r.setContent(rset.getString("content"));
				r.setScore(rset.getInt("score"));
				r.setRegDate(rset.getDate("regdate"));
				r.setEndYN(rset.getString("end_YN").charAt(0));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return r;
	}

	public int searchBoardNo(Connection conn, Review r) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int reviewNo = 0;
		
		String query = " SELECT reviewNo FROM   " +
					   "(SELECT ROW_NUMBER() OVER(order BY reviewNo DESC) AS NUM,review.*  FROM review " + 
					   "WHERE userId=? AND contractNo=? AND CONTENT=?) " + 
					   "WHERE NUM = 1";
				
				
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, r.getUserId());
			pstmt.setInt(2, r.getContractNo());
			pstmt.setString(3, r.getContent());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reviewNo = rset.getInt("reviewNo");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return reviewNo;
	}

	public int updateCleanYN(Connection conn, int contractNo, String userId) {

		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = "update contract set clean_YN='Y' where userid=? and contractNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, contractNo);
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result1;
	}

	public int reviewContentUpdate(Connection conn, String content, int reviewNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update review set content=? where reviewNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, reviewNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	public int reviewDelete(Connection conn, String userId, int reviewNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update review set end_YN='Y' where userId=? and reviewNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
