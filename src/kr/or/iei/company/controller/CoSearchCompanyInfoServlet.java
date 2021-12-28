package kr.or.iei.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD:src/kr/or/iei/admin/controller/AdminAccountServlet.java

import kr.or.iei.admin.model.service.AdminService;
import kr.or.iei.admin.model.service.AdminServiceImpl;
import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.common.MemberAuthorityCheck;

/**
 * Servlet implementation class AdminAccountServlet
 */
@WebServlet("/admin/adminAccount.do")
public class AdminAccountServlet extends HttpServlet {
=======
import kr.or.iei.company.model.service.CompanyInfoService;
import kr.or.iei.company.model.service.CompanyInfoServiceImpl;
import kr.or.iei.company.model.vo.Company;

/**
 * Servlet implementation class CoSearchCompanyInfoServlet
 */
@WebServlet("/co/coSearchCompanyInfo.do")
public class CoSearchCompanyInfoServlet extends HttpServlet {
>>>>>>> d5d0fd2854348823739179368d3969a354511cac:src/kr/or/iei/company/controller/CoSearchCompanyInfoServlet.java
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
<<<<<<< HEAD:src/kr/or/iei/admin/controller/AdminAccountServlet.java
    public AdminAccountServlet() {
=======
    public CoSearchCompanyInfoServlet() {
>>>>>>> d5d0fd2854348823739179368d3969a354511cac:src/kr/or/iei/company/controller/CoSearchCompanyInfoServlet.java
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD:src/kr/or/iei/admin/controller/AdminAccountServlet.java
		AdminService adService = new AdminServiceImpl();
		ArrayList<Admin> list = adService.adminAccount();
		
		//가져온 회원 정보를 가지고 ,jsp(view) 페이지로 이동
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/adminAccount.jsp");
		
		request.setAttribute("list", list);
		
=======
		String coId =((Company)request.getSession().getAttribute("company")).getCoId();
		
		CompanyInfoService ciService = new CompanyInfoServiceImpl();
		Company co = ciService.SearchCompanyInfo(coId);
		
		
		RequestDispatcher view;
		if(co != null) {
			view = request.getRequestDispatcher("/views/company/companyProfileUpdate.jsp");
			request.setAttribute("Company", co);
			
		}else {
			
			 view = request.getRequestDispatcher("/views/company/companyProfileInsert.jsp");
		}
>>>>>>> d5d0fd2854348823739179368d3969a354511cac:src/kr/or/iei/company/controller/CoSearchCompanyInfoServlet.java
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
