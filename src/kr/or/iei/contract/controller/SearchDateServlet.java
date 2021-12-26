package kr.or.iei.contract.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.contract.model.service.ContractService;
import kr.or.iei.contract.model.service.ContractServiceImpl;
import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class SearchDateServlet
 */
@WebServlet("/contract/searchDate.do")
public class SearchDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {
			
			//즉, index.jsp 에서 게시판으로 이동하는 경우에는 가장 첫 페이지인 1page로 셋팅
			currentPage  = 1;
		
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String startDate = request.getParameter("startDate");
		
		startDate = String.join("/", startDate.split("-"));
		
		String endDate = request.getParameter("endDate");
		
		endDate = String.join("/", endDate.split("-"));
		
		
		
		
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();

		ContractService cService = new ContractServiceImpl();
		HashMap<String, Object> map = cService.searchMemberCondition(startDate, endDate, userId, currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/selectDateSearchEstimate.jsp");
		request.setAttribute("map", map);
		request.setAttribute("currentPage", currentPage);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
