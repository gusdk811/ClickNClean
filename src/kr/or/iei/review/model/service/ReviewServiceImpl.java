package kr.or.iei.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.review.model.dao.ReviewDAO;

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

}
