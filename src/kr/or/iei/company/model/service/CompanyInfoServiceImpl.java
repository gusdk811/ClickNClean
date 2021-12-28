package kr.or.iei.company.model.service;

import java.sql.Connection;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.dao.CompanyInfoDAO;
import kr.or.iei.company.model.vo.Company;

public class CompanyInfoServiceImpl implements CompanyInfoService {
	
	private CompanyInfoDAO ciDAO = new CompanyInfoDAO();
	
	
	@Override
	public int insertCompanyInfo(Company co, String coId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = ciDAO.insertCompanyInfo(conn, co, coId);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	
	
	@Override
	public Company SearchCompanyInfo(String coId) {
		Connection conn = JDBCTemplate.getConnection();
		Company co = ciDAO.SerchCompanyInfo(conn, coId);
		JDBCTemplate.close(conn);
		return co;
	}
	
	
	
	@Override
	public int updateCompanyInfo(Company co, String coId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = ciDAO.updateCompanyInfo(conn, co, coId);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	

	

}
