package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberCompanyFindIdServlet
 */
@WebServlet("/member/memberCompanyFindIdUsingEmail.do")
public class MemberCompanyFindIdUsingEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberCompanyFindIdUsingEmailServlet() {
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

		String email = request.getParameter("email");

		String id = null;

		switch (roll) {
		case "UR-1":
			MemberService mService = new MemberServiceImpl();
			id = mService.searchIdUsingEmail(roll, userName, email);
			break;
		case "CO-1":
			CompanyService comService = new CompanyServiceImpl();
			id = comService.searchIdUsingEmail(roll, userName, email);
			break;
		}

		PrintWriter out = response.getWriter();
		out.print(id);

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
