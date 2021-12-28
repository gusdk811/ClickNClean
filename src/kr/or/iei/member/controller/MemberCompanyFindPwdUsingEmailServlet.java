package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class MemberCompanyFindPwdUsingEmailServlet
 */
@WebServlet("/member/memberCompanyFindPwdUsingEmail.do")
public class MemberCompanyFindPwdUsingEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCompanyFindPwdUsingEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String roll = request.getParameter("roll");

		String userId = request.getParameter("userId");

		String email = request.getParameter("email");

		boolean result = false;
		switch (roll) {
		case "UR-1":
			MemberService mService = new MemberServiceImpl();
			result = mService.searchPwdUsingEmail(roll, userId, email);
			break;
		case "CO-1":
			CompanyService comService = new CompanyServiceImpl();
			result = comService.searchPwdUsingEmail(roll, userId, email);
			break;
		}

		PrintWriter out = response.getWriter();
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
