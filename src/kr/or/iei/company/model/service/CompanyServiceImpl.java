package kr.or.iei.company.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.dao.CompanyDAO;
import kr.or.iei.company.model.vo.Company;

public class CompanyServiceImpl implements CompanyService{
	private CompanyDAO comDAO = new CompanyDAO();
	@Override
	public ArrayList<Company> selectAllCompany() {
		Connection conn= JDBCTemplate.getConnection();
		ArrayList<Company> list= comDAO.selectAllCompany(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	@Override
	public Company selectOneCompany(String coId) {
		Connection conn=JDBCTemplate.getConnection();
		Company com=comDAO.selectOneCompany(coId,conn);
		JDBCTemplate.close(conn);
		return com;
	}
	public Company selectOneUser(String coId, String coPwd) {
		Connection conn= JDBCTemplate.getConnection();
		Company com = comDAO.selectOneUser(conn, coId, coPwd);
		JDBCTemplate.close(conn);
		return com;
	}
	@Override
	public String searchIdUsingEmail(String roll, String userName, String email) {
		Connection conn = JDBCTemplate.getConnection();
		String coId = comDAO.searchIdUsingEmail(conn, roll, userName, email);
		JDBCTemplate.close(conn);
		return coId;
	}
	@Override
	public String searchIdUsingPhone(String roll, String userName, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		String coId = comDAO.searchIdUsingPhone(conn, roll, userName, phone);
		JDBCTemplate.close(conn);
		return coId;
	}
	@Override
	public boolean searchPwdUsingEmail(String roll, String userId, String email) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = comDAO.searchPwdUsingEmail(conn, roll, userId, email);
		JDBCTemplate.close(conn);
		return result;
	}
	@Override
	public int upadateCompanyPwd(String roll, String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = comDAO.upadateCompanyPwd(conn,roll, userId,userPwd);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	@Override
	public boolean searchPwdUsingPhone(String roll, String userId, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = comDAO.searchPwdUsingPhone(conn, roll, userId, phone);
		JDBCTemplate.close(conn);
		return result;
	}
	@Override
	public int insertJoinMember(Company com) {
		Connection conn = JDBCTemplate.getConnection();
		int result= comDAO.insertJoinMember(conn, com);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}	

}
