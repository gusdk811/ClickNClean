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


	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription : 이름, 이메일, roll 을 통해 userId 찾는 메소드
	 */
	public String searchIdUsingEmail(String roll, String userName, String email);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription :  이름, 핸드폰, roll 을 통해 userId 찾는 메소드
	 */
	public String searchIdUsingPhone(String roll, String userName, String phone);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription : 아이디, 이메일, roll 을 통해 userPwd 찾는 메소드
	 */
	public boolean searchPwdUsingEmail(String roll, String userId, String email);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : int
	 * @subscription : 비밀번호 찾기를 통한 비밀번호 변경
	 */
	public int updateMemberPwd(String roll, String userId, String userPwd);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 27.
	 * @return : String
	 * @subscription :  아이디, 이메일, roll 을 통해 userPwd 찾는 메소드
	 */
	public boolean searchPwdUsingPhone(String roll, String userId, String phone);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 27.
	 * @return : void
	 * @subscription : 회원 가입
	 */
	public int insertJoinMember(Member m);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 28.
	 * @return : boolean
	 * @subscription : ID 중복 확인
	 */
	public boolean checkDuplicateId(String userId);


}
