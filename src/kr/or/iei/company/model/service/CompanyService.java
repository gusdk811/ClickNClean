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
}
