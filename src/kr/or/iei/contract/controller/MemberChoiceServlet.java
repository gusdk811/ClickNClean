package kr.or.iei.contract.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.contract.model.service.ContractService;
import kr.or.iei.contract.model.service.ContractServiceImpl;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class MemberChoiceServlet
 */
@WebServlet(name = "UserChoiceServlet", urlPatterns = { "/contract/myEstimate.do" })
public class MemberChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {

			currentPage  = 1;
		
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		ContractService cService = new ContractServiceImpl();
		HashMap<String, Object> map = cService.MemberChoice(currentPage,userId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/myEstimate.jsp");
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
