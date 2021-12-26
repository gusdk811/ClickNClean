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

}
