package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneUser(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		Member m = null;
		
		// userId와 userPwd가 일치하고 탈퇴하지 않은 회원 검색
		String sql = "SELECT * FROM MEMBER WHERE userId=? AND userPwd=? AND end_yn='N'";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m=new Member();
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userId"));
				m.setUserPwd(rset.getString("userPwd"));
				m.setUserName(rset.getString("userName"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setEnrollDate(rset.getDate("enrollDate"));
				m.setEndYN(rset.getString("end_YN").charAt(0));
				m.setRoll(rset.getString("roll"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	
	}

	public int updateOneMember(Connection conn, Member m, String newPwd) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "";
		
		if(newPwd.equals("")) {
			
			query = "update member set userName=?, phone=?, email=? where userId=? and userPwd=? and end_YN='N'";

		}else {
			
			query = "update member set userName=?, phone=?, email=?, userPwd=? where userId=? and userPwd=? and end_YN='N'";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			
			if(newPwd.equals("")) {
				
				pstmt.setString(1, m.getUserName());
				pstmt.setString(2, m.getPhone());
				pstmt.setString(3, m.getEmail());
				pstmt.setString(4, m.getUserId());
				pstmt.setString(5, m.getUserPwd());
				
			}else {
				
				pstmt.setString(1, m.getUserName());
				pstmt.setString(2, m.getPhone());
				pstmt.setString(3, m.getEmail());
				pstmt.setString(4, newPwd);
				pstmt.setString(5, m.getUserId());
				pstmt.setString(6, m.getUserPwd());
			}
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteOneMember(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member set end_YN='Y' where userNo=?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deleteOneMember() 메소드 에러");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}

	

}
