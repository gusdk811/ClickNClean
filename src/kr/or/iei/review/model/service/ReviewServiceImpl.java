package kr.or.iei.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.review.model.dao.ReviewDAO;
import kr.or.iei.review.model.vo.Review;

public class ReviewServiceImpl implements ReviewService{

	private ReviewDAO rDAO = new ReviewDAO();
	
	@Override
	public HashMap<String, Object> inqueryhistory(String userId, int currentPage){
		
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 4;
		
		ArrayList<Contract> list = rDAO.inqueryhistory(userId,conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5;
		
		String pageNavi =  rDAO.getPageNavi(naviCountPerPage, conn, currentPage, recordCountPerPage, userId);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	
	}

	@Override
	public HashMap<String, Object> review(String userId, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 4;
		
		ArrayList<Contract> list = rDAO.review(userId,conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5;
		
		String pageNavi =  rDAO.getReviewPageNavi(naviCountPerPage, conn, currentPage, recordCountPerPage, userId);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}

	@Override
	public HashMap<String, Object> reviewWriteList(String userId, int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 4;
		
		ArrayList<Contract> list = rDAO.reviewWriteList(userId,conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5;
		
		String pageNavi =  rDAO.getReviewWritePageNavi(naviCountPerPage, conn, currentPage, recordCountPerPage, userId);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	
	
	
	}

	@Override
	public int insertReviewWrite(Review r) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = rDAO.inserReview(r, conn);
		
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public Review selectOneReview(int contractNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Review r = rDAO.selectOneReview(conn, contractNo);
		
		JDBCTemplate.close(conn);
		
		return r;
	}

	@Override
	public int searchReviewNo(Review r) {

		Connection conn = JDBCTemplate.getConnection();
		
		int reviewNo = rDAO.searchBoardNo(conn, r);
		
		JDBCTemplate.close(conn);
		
		return reviewNo;
		
	}

	@Override
	public int updateCleanYN(int contractNo, String userId) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = rDAO.updateCleanYN(conn, contractNo, userId);
		
		if(result1>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result1;
	}

	@Override
	public int reviewContentUpdate(String content, int reviewNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = rDAO.reviewContentUpdate(conn, content, reviewNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	@Override
	public int reviewDelete(int reviewNo, String userId) {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = rDAO.reviewDelete(conn, userId, reviewNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
