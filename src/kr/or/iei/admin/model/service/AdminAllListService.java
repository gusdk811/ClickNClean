package kr.or.iei.admin.model.service;

import java.util.ArrayList;

import kr.or.iei.company.model.vo.Company;
import kr.or.iei.member.model.vo.Member;

public interface AdminAllListService {

		
		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-24
		 * @subscription : 전체 회원 리스트
		 */
	ArrayList<Member> memberAllList();

		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-27
		 * @subscription : 전체 업체 리스트
		 */
	ArrayList<Company> companyAllList();


}
