package kr.or.iei.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.vo.Company;
import kr.or.iei.member.model.vo.Member;

public class AdminAllListDAO {

	public ArrayList<Member> memberAllList(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = "SELECT * FROM MEMBER ORDER BY USERNO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Member m = new Member();
				
				m.setUserNo(rset.getInt("userno"));
				m.setUserName(rset.getString("username"));
				m.setUserId(rset.getString("userid"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setEnrollDate(rset.getDate("enrollDate"));
				m.setEndYN(rset.getString("end_yn").charAt(0));
				
				list.add(m);
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

	public ArrayList<Company> companyAllList(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Company> list = new ArrayList<Company>();
		
		String query = "SELECT * FROM COMPANY ORDER BY CONO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Company co = new Company();
				
				co.setCoNo(rset.getInt("coNo"));
				co.setCoId(rset.getString("coId"));
				co.setCoName(rset.getString("coName"));
				co.setEmail(rset.getString("email"));
				co.setBusNum(rset.getString("busNum"));
				co.setAddress(rset.getString("address"));
				co.setPhone(rset.getString("phone"));
				co.setTel(rset.getString("tel"));				
				co.setEnrollDate(rset.getDate("enrollDate"));
				co.setEnd_YN(rset.getString("end_yn").charAt(0));
				
				list.add(co);
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


}
