package kr.or.iei.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.company.model.vo.Company;

/**
 * Servlet implementation class CompanyJoinServlet
 */
@WebServlet("/company/companyJoin.do")
public class CompanyJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyJoinServlet() {
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
		String coId = request.getParameter("coId");
		String coPwd = request.getParameter("coPwd");
		String coName = request.getParameter("coName");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String phone = request.getParameter("phone");
		String ceoName = request.getParameter("ceoName");
		String address= request.getParameter("address1")+" "+request.getParameter("address2");
		int team = Integer.parseInt(request.getParameter("team"));
		int career = Integer.parseInt(request.getParameter("career"));
		String busNum = request.getParameter("busNum");

		
		System.out.println(coId);
		System.out.println(coPwd);
		System.out.println(coName);
		System.out.println(email);
		System.out.println(tel);
		System.out.println(phone);
		System.out.println(ceoName);
		System.out.println(address);
		System.out.println(team);
		System.out.println(career);
		System.out.println(busNum);
		
		Company com = new Company(coId, coName, coPwd, phone, ceoName, email, busNum, address, team, career, tel);
		
		CompanyService comService = new CompanyServiceImpl();
		int result =comService.insertJoinMember(com);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/company/companyJoinResult.jsp");
		if(result>0) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
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
