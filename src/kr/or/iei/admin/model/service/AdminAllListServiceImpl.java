package kr.or.iei.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.iei.admin.model.dao.AdminAllListDAO;
import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.vo.Company;
import kr.or.iei.member.model.vo.Member;


public class AdminAllListServiceImpl implements AdminAllListService{
	
	private AdminAllListDAO adDAO = new AdminAllListDAO();

	@Override
	public ArrayList<Member> memberAllList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = adDAO.memberAllList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

	@Override
	public ArrayList<Company> companyAllList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Company> list = adDAO.companyAllList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}


}
