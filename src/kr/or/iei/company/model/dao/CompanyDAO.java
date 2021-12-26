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

}
