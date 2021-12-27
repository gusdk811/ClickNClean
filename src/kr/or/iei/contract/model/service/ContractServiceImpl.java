package kr.or.iei.contract.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.vo.Company;
import kr.or.iei.contract.model.dao.ContractDAO;
import kr.or.iei.contract.model.vo.Contract;

public class ContractServiceImpl implements ContractService{

	
	private ContractDAO conDAO=new ContractDAO();
	
	
	@Override
	public ArrayList<Company> selectConditionCompany(String area, String cleanType) {
		Connection conn =JDBCTemplate.getConnection();
		ArrayList<Company> list=conDAO.selectConditionCompany(area,cleanType,conn);
		return list;
	}

	@Override
	public int insertCondition(Contract con) {
		Connection conn=JDBCTemplate.getConnection();
		int result =conDAO.insertCondtion(con,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public HashMap<String, Object> MemberChoice(int currentPage, String userId) {

		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 4;
		
		ArrayList<Contract> list = conDAO.memberChoice(currentPage, conn, recordCountPerPage, userId);
		
		
		int naviCountPerPage = 5;
		
		String pageNavi =  conDAO.getPageNavi(naviCountPerPage, conn, currentPage, recordCountPerPage, userId);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}

	@Override
	public HashMap<String, Object> searchMemberCondition(String startdate, String enddate, String userId, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 4;
		
		ArrayList<Contract> list = conDAO.searchDateCondition(startdate, enddate, userId, conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5;
		
		String pageNavi =  conDAO.getPageNavi_searchDate(naviCountPerPage, conn, currentPage, recordCountPerPage, userId, startdate, enddate);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
		
	}

	

}
