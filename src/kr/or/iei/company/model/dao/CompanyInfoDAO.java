package kr.or.iei.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.vo.Company;

public class CompanyInfoDAO {

	
	public Company SerchCompanyInfo(Connection conn, String coId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Company co = null;
		
		String query = "select * from companyInfo where coId = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, coId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				co = new Company();
				
				co.setCoInfo(rset.getString("coInfo"));
				co.setMeetHour(rset.getString("meetHour"));
				co.setWorkHour(rset.getString("workHour"));
				co.setArea(rset.getString("area"));
				co.setCleanType(rset.getString("cleanType"));
				co.setGrade(rset.getString("grade"));
				co.setHistory(rset.getString("history"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return co;
	}
	
	
	
	
	
	public int insertCompanyInfo(Connection conn, Company co, String coId) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = "insert into COMPANYINFO values(?,'사진',?,?,?,?,'10000',?,?,?')";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, coId);
			pstmt.setString(2, co.getCoInfo());
			pstmt.setString(3, co.getMeetHour());
			pstmt.setString(4, co.getWorkHour());
			pstmt.setString(5, co.getArea());
			pstmt.setString(6, co.getCleanType());
			pstmt.setString(7, co.getGrade());
			pstmt.setString(8, co.getHistory());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateCompanyInfo(Connection conn, Company co, String coId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update companyInfo set area=?, coInfo=?, cleanType=?, history=?, grade=?, workHour=?,meetHour=? where coId = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, co.getArea());
			pstmt.setString(2, co.getCoInfo());
			pstmt.setString(3, co.getCleanType());
			pstmt.setString(4, co.getHistory());
			pstmt.setString(5, co.getGrade());
			pstmt.setString(6, co.getWorkHour());
			pstmt.setString(7, co.getMeetHour());
			pstmt.setString(8, coId);
			
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
