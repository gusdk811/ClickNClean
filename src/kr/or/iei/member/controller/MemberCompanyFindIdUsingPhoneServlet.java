package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberCompanyFindIdUsingPhoneServlet
 */
@WebServlet("/member/memberCompanyFindIdUsingPhone.do")
public class MemberCompanyFindIdUsingPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberCompanyFindIdUsingPhoneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String roll = request.getParameter("roll");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");

		String id = null;
		switch (roll) {
		case "UR-1":
			MemberService mService = new MemberServiceImpl();
			id = mService.searchIdUsingPhone(roll, userName, phone);
			break;
		case "CO-1":
			CompanyService comService = new CompanyServiceImpl();
			id = comService.searchIdUsingPhone(roll, userName, phone);
			break;
		}

		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberCompanyShowId.jsp");
		
		request.setAttribute("id", id);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
