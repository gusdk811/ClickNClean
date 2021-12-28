package kr.or.iei.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.vo.Company;

public class CompanyDAO {

	public ArrayList<Company> selectAllCompany(Connection conn) {
		PreparedStatement pstmt =null;
		ResultSet rset=null;
		ArrayList<Company> list=new ArrayList<Company>();
		String query="select * from company " + 
				" left join companyinfo on (company.coid=companyinfo.coid) " + 
				" left join (select review.COID, count(*) as reviewnum,sum(score) as sumScore from review GROUP BY  COID) R "
				+ " on (company.coid=R.coid)";
		try {
			pstmt=conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Company com=new Company();
				com.setCoNo(rset.getInt("cono"));
				com.setCoId(rset.getString("CoId"));
				com.setCoPwd(rset.getString("CoPwd"));
				com.setCoName(rset.getString("CoName"));
				com.setPhone(rset.getString("Phone"));
				com.setCeoName(rset.getString("CeoName"));
				com.setEmail(rset.getString("Email"));
				com.setBusNum(rset.getString("BusNum"));
				com.setAddress(rset.getString("Address"));
				com.setTeam(rset.getInt("Team"));
				com.setCareer(rset.getInt("Career"));
				com.setGrade(rset.getString("Grade"));
				com.setEnrollDate(rset.getDate("EnrollDate"));
				com.setSign_YN(rset.getString("Sign_YN").charAt(0));
				com.setEnd_YN(rset.getString("End_YN").charAt(0));
				com.setLogo(rset.getString("Logo"));
				com.setCoInfo(rset.getString("CoInfo"));
				com.setMeetHour(rset.getString("MeetHour"));
				com.setWorkHour(rset.getString("WorkHour"));
				com.setArea(rset.getString("Area"));
				com.setCleanType(rset.getString("cleanType"));
				com.setTel(rset.getString("tel"));
				com.setPrice(rset.getInt("Price"));
				com.setRoll(rset.getString("roll"));
				com.setReviewNum(rset.getInt("reviewNum"));
				com.setSumScore(rset.getInt("sumScore"));
				list.add(com);
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

	public Company selectOneCompany(String coId, Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Company com=null;
		String query="select * from company " + 
				" left join companyinfo on (company.coid=companyinfo.coid) " + 
				" left join (select review.COID, count(*) as reviewnum,sum(score) as sumScore from review GROUP BY  COID) R "
				+ " on (company.coid=R.coid) where company.coId=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, coId);
				rset=pstmt.executeQuery();
				if(rset.next()) {
					com=new Company();
					com.setCoNo(rset.getInt("cono"));
					com.setCoId(rset.getString("CoId"));
					com.setCoPwd(rset.getString("CoPwd"));
					com.setCoName(rset.getString("CoName"));
					com.setPhone(rset.getString("Phone"));
					com.setCeoName(rset.getString("CeoName"));
					com.setEmail(rset.getString("Email"));
					com.setBusNum(rset.getString("BusNum"));
					com.setAddress(rset.getString("Address"));
					com.setTeam(rset.getInt("Team"));
					com.setCareer(rset.getInt("Career"));
					com.setGrade(rset.getString("Grade"));
					com.setEnrollDate(rset.getDate("EnrollDate"));
					com.setSign_YN(rset.getString("Sign_YN").charAt(0));
					com.setEnd_YN(rset.getString("End_YN").charAt(0));
					com.setLogo(rset.getString("Logo"));
					com.setCoInfo(rset.getString("CoInfo"));
					com.setMeetHour(rset.getString("MeetHour"));
					com.setWorkHour(rset.getString("WorkHour"));
					com.setArea(rset.getString("Area"));
					com.setCleanType(rset.getString("cleanType"));
					com.setTel(rset.getString("tel"));
					com.setPrice(rset.getInt("Price"));
					com.setRoll(rset.getString("roll"));
					com.setReviewNum(rset.getInt("reviewNum"));
					com.setSumScore(rset.getInt("sumScore"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return com;
	}
			
			
	public Company selectOneUser(Connection conn, String coId, String coPwd) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Company com = null;

        String sql ="SELECT * FROM COMPANY WHERE coId=? AND coPwd=? AND end_yn='N'";

        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, coId);
            pstmt.setString(2, coPwd);

            rset=pstmt.executeQuery();

            if(rset.next()) {
                com=new Company();
                com.setCoNo(rset.getInt("cono"));
                com.setCoId(rset.getString("CoId"));
                com.setCoPwd(rset.getString("CoPwd"));
                com.setCoName(rset.getString("CoName"));
                com.setPhone(rset.getString("Phone"));
                com.setCeoName(rset.getString("CeoName"));
                com.setEmail(rset.getString("Email"));
                com.setBusNum(rset.getString("BusNum"));
                com.setAddress(rset.getString("Address"));
                com.setTeam(rset.getInt("Team"));
                com.setCareer(rset.getInt("Career"));
                com.setEnrollDate(rset.getDate("EnrollDate"));
                com.setSign_YN(rset.getString("Sign_YN").charAt(0));
                com.setEnd_YN(rset.getString("End_YN").charAt(0));
                com.setTel(rset.getString("tel"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }


        return com;
    }

	public String searchIdUsingEmail(Connection conn, String roll, String userName, String email) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String coId=null;
		
		String query="SELECT * FROM COMPANY WHERE coName= ? AND email=? AND roll=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			pstmt.setString(3, roll);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				
				coId = rset.getString("coId");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return coId;
	}

	public String searchIdUsingPhone(Connection conn, String roll, String userName, String phone) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String coId=null;
		
		String query="SELECT * FROM COMPANY WHERE coName= ? AND phone=? AND roll=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			pstmt.setString(3, roll);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				
				coId = rset.getString("coId");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return coId;
	}

	public boolean searchPwdUsingEmail(Connection conn, String roll, String userId, String email) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		boolean result=false;
		
		String query="SELECT * FROM COMPANY WHERE coId= ? AND email=? AND roll=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			pstmt.setString(3, roll);
			
			rset= pstmt.executeQuery();
			
			result= rset.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int upadateCompanyPwd(Connection conn, String roll, String userId, String userPwd) {
		PreparedStatement pstmt =null;
		int result=0;
		
		String query="UPDATE COMPANY SET coPwd=? WHERE coId=? AND roll=? AND end_YN='N'";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, roll);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	
	}

	public boolean searchPwdUsingPhone(Connection conn, String roll, String userId, String phone) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		boolean result=false;
		
		String query="SELECT * FROM COMPANY WHERE coId= ? AND phone=? AND roll=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, phone);
			pstmt.setString(3, roll);
			
			rset= pstmt.executeQuery();
			
			result = rset.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertJoinMember(Connection conn, Company com) {
		PreparedStatement pstmt =null;
		int result = 0;
		
		String sql="INSERT INTO COMPANY VALUES(CO_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,sysdate,'N','N',?,'CO-1')";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, com.getCoId());
			pstmt.setString(2, com.getCoPwd());
			pstmt.setString(3, com.getCoName());
			pstmt.setString(4, com.getPhone());
			pstmt.setString(5, com.getCeoName());
			pstmt.setString(6, com.getEmail());
			pstmt.setString(7, com.getBusNum());
			pstmt.setString(8, com.getAddress());
			pstmt.setInt(9, com.getTeam());
			pstmt.setInt(10, com.getCareer());
			pstmt.setString(11, com.getTel());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

}
