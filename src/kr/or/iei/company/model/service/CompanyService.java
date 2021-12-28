package kr.or.iei.company.model.service;

import java.util.ArrayList;

import kr.or.iei.company.model.vo.Company;

public interface CompanyService {
	ArrayList<Company> selectAllCompany();

	Company selectOneCompany(String coId);
	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 24.
	 * @return : Company
	 * @subscription : 사업자 회원 로그인
	 */
	public Company selectOneUser(String coId, String coPwd);

	
	
	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription :  이름, 이메일, roll 을 통해 userId 찾는 메소드
	 */
	String searchIdUsingEmail(String roll, String userName, String email);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription :  이름, 핸드폰, roll 을 통해 userId 찾는 메소드
	 */
	String searchIdUsingPhone(String roll, String userName, String phone);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 26.
	 * @return : String
	 * @subscription : 아이디, 이메일, roll 을 통해 userPwd 찾는 메소드
	 */
	boolean searchPwdUsingEmail(String roll, String userId, String email);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 27.
	 * @return : int
	 * @subscription : 비밀번호 찾기를 통한 비밀번호 변경
	 */
	int upadateCompanyPwd(String roll, String userId, String userPwd);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 27.
	 * @return : String
	 * @subscription : 아이디, 핸드폰, roll 을 통해 userPwd 찾는 메소드
	 */
	boolean searchPwdUsingPhone(String roll, String userId, String phone);

	/**
	 * @Author : SeungHyun Kim(kshlove735)
	 * @Date : 2021. 12. 27.
	 * @return : void
	 * @subscription : 회원 가입
	 */
	int insertJoinMember(Company com);
	
}
