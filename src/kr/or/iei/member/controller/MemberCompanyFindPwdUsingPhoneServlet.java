package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberCompanyFindPwdUsingPhoneServlet
 */
@WebServlet("/member/memberCompanyFindPwdUsingPhone.do")
public class MemberCompanyFindPwdUsingPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCompanyFindPwdUsingPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roll = request.getParameter("roll");
		String userId = request.getParameter("userId");
		String phone = request.getParameter("phone");

		boolean result=false;
		
		switch (roll) {
		case "UR-1":
			MemberService mService = new MemberServiceImpl();
			result = mService.searchPwdUsingPhone(roll, userId, phone);
			break;
		case "CO-1":
			CompanyService comService = new CompanyServiceImpl();
			result = comService.searchPwdUsingPhone(roll, userId, phone);
			break;
		}

		if(result) {
			RequestDispatcher view = request.getRequestDispatcher("/views/member/memberCompanyChangePwd.jsp");
			
			request.setAttribute("userId", userId);
			request.setAttribute("roll", roll);
			view.forward(request, response);
		}else {
			response.sendRedirect("/views/member/memberCompanyUserCheck.jsp");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
