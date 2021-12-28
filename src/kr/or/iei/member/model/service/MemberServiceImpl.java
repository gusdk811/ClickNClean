package kr.or.iei.member.model.service;

import java.sql.Connection;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDAO;
import kr.or.iei.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDAO mDAO = new MemberDAO();

	@Override
	public Member selectOneUser(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.selectOneUser(conn, userId, userPwd);
		JDBCTemplate.close(conn);
		return m;

	}

	@Override
	public int updateOneMember(Member m, String newPwd) {

		Connection conn = JDBCTemplate.getConnection();

		int result = mDAO.updateOneMember(conn, m, newPwd);

		System.out.println(m.getPhone());

		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);

		return result;
	}

	@Override
	public String searchIdUsingEmail(String roll, String userName, String email) {

		Connection conn = JDBCTemplate.getConnection();
		String userId = mDAO.searchIdUsingEmail(conn, roll, userName, email);
		JDBCTemplate.close(conn);
		return userId;

	}

	@Override
	public String searchIdUsingPhone(String roll, String userName, String phone) {

		Connection conn = JDBCTemplate.getConnection();
		String userId = mDAO.searchIdUsingPhone(conn, roll, userName, phone);
		JDBCTemplate.close(conn);
		return userId;
	}

	@Override
	public boolean searchPwdUsingEmail(String roll, String userId, String email) {

		Connection conn = JDBCTemplate.getConnection();
		boolean result = mDAO.searchPwdUsingEmail(conn, roll, userId, email);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int updateMemberPwd(String roll, String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updateMemberPwd(conn, roll, userId, userPwd);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public boolean searchPwdUsingPhone(String roll, String userId, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = mDAO.searchPwdUsingPhone(conn, roll, userId, phone);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int deleteOneMember(int userNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.deleteOneMember(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	public int insertJoinMember(Member m) {

		Connection conn = JDBCTemplate.getConnection();

		int result = mDAO.insertJoinMember(conn, m);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);

		return result;

	}

	@Override
	public boolean checkDuplicateId(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = mDAO.checkDuplicateId(conn, userId);
		JDBCTemplate.close(conn);

		return result;
	}

}
