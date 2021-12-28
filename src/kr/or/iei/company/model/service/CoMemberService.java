package kr.or.iei.company.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.contract.model.vo.Contract;

public interface CoMemberService {

	HashMap<String, Object> MemberAllList(int currentPage, String coId);

	HashMap<String, Object> selectSearchMember(String coId, int currentPage, String memberKey, String searchType);

	public ArrayList<Contract> selectReservationDay(String coId);

}
