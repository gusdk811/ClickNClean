package kr.or.iei.member.model.service;

import java.sql.Connection;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDAO;
import kr.or.iei.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDAO mDAO= new MemberDAO();
	
	@Override
	public Member selectOneUser( String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m =mDAO.selectOneUser(conn, userId, userPwd);
		JDBCTemplate.close(conn);
		return m;
		
	}

	@Override
	public int updateOneMember(Member m, String newPwd) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.updateOneMember(conn, m, newPwd);
		
		System.out.println(m.getPhone());
		
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
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

	

}
