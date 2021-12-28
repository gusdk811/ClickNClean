package kr.or.iei.company.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.company.model.service.CoMemberService;
import kr.or.iei.company.model.service.CoMemberServiceImpl;
import kr.or.iei.company.model.vo.Company;

/**
 * Servlet implementation class CoMemberAllListServlet
 */
@WebServlet("/co/coMemberAllList.do")
public class CoMemberAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoMemberAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String coId = ((Company)session.getAttribute("company")).getCoId();
		
		
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {
			
			currentPage=1;
		
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
		}
		
		
		CoMemberService coMService = new CoMemberServiceImpl();
		HashMap<String, Object> pageDataMap = coMService.MemberAllList(currentPage, coId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/company/companyContractMember.jsp");
		
		request.setAttribute("pageDataMap",pageDataMap);
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
