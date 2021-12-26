package kr.or.iei.member.model.service;

import kr.or.iei.member.model.vo.Member;

public interface MemberService {

	
	
	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 23.
	 * @return : Member
	 * @subscription : 개인 회원 로그인
	 */
	public Member selectOneUser( String userId, String userPwd);

	/**
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 25
	 * @return : int 
	 * @subscription : 회원 정보 수정 - 업데이트
	 */
	public int updateOneMember(Member m, String newPwd);
	
	/**
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 26
	 * @return : int 
	 * @subscription : 회원  탈퇴
	 */
	public int deleteOneMember(int userNo);

	

}
