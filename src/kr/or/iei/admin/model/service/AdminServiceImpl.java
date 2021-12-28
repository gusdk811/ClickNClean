package kr.or.iei.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.iei.admin.model.dao.AdminDAO;
import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.admin.model.vo.HeadOffice;
import kr.or.iei.common.JDBCTemplate;


public class AdminServiceImpl implements AdminService {

   private AdminDAO adDAO= new AdminDAO();
   
   @Override
   public Admin selectOneUser(String adminId, String adminPwd) {
      Connection conn = JDBCTemplate.getConnection();
      Admin ad =adDAO.selectOneUser(conn, adminId, adminPwd);
      JDBCTemplate.close(conn);
      return ad;
   }

    @Override
    public ArrayList<Admin> adminAccount() {
    	Connection conn = JDBCTemplate.getConnection();
		ArrayList<Admin> list = adDAO.adminAccount(conn);
		JDBCTemplate.close(conn);
		
		return list;
}

	@Override
	public ArrayList<HeadOffice> headOffice() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<HeadOffice> list = adDAO.headOffice(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

}