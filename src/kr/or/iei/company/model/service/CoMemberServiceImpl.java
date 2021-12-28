package kr.or.iei.company.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.company.model.dao.ContractDAO;
import kr.or.iei.contract.model.vo.Contract;

public class CoMemberServiceImpl implements CoMemberService {

	private ContractDAO cDAO = new ContractDAO();

	@Override
	public HashMap<String, Object> MemberAllList(int currentPage, String coId) {
		Connection conn = JDBCTemplate.getConnection();

		int recordCountPerPage = 5;

		ArrayList<Contract> list = cDAO.MemberAllList(conn, coId, currentPage, recordCountPerPage);

			
		int naviCountPerPage = 5;

		String pageNavi = cDAO.getPageNavi(conn, coId, naviCountPerPage, currentPage, recordCountPerPage);
		
		JDBCTemplate.close(conn);

		HashMap<String, Object> hm = new HashMap<String, Object>();

		hm.put("list", list);
		hm.put("pageNavi", pageNavi);

		return hm;

	}

	@Override
	public HashMap<String, Object> selectSearchMember(String coId, int currentPage, String memberKey, String searchType) {

		Connection conn = JDBCTemplate.getConnection();

		int recordCountPerPage = 5;

		ArrayList<Contract> list = cDAO.selectSearchMember(coId, conn, currentPage, recordCountPerPage, memberKey, searchType);
		
		
		int naviCountPerPage = 5;

		String pageNavi = cDAO.searchMemberPageNavi(coId, conn, naviCountPerPage, currentPage, recordCountPerPage, memberKey, searchType);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
		
		

	}

	@Override
	public ArrayList<Contract> selectReservationDay(String coId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Contract> list = cDAO.selectReservationDay(conn, coId);
		JDBCTemplate.close(conn);
		return list;
	}

}
