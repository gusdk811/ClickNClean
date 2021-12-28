package kr.or.iei.contract.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.company.model.vo.Company;
import kr.or.iei.contract.model.vo.Contract;

public interface ContractService {

	ArrayList<Company> selectConditionCompany(String area, String cleanType);


	HashMap<String, Object> MemberChoice(int currentPage, String userId);

	int insertCondition(Contract con);


	/**
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 26
	 * @return : HashMap<String, Object> 
	 * @subscription : 나의 견적서 리스트 가져오기
	 */
	HashMap<String, Object> searchMemberCondition(String startdate,  String enddate, String userId, int currentPage);

	/**
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 28
	 * @return : HashMap<String, Object> 
	 * @subscription : 예약 확정 누를 시 contract_YN='Y' 로 변경 
	 */
	int updateContractYN(String userId, int contractNo);
	
}
