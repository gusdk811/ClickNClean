package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.admin.model.service.AdminService;
import kr.or.iei.admin.model.service.AdminServiceImpl;
import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/admin/loginAdmin.do")
public class LoginAdminServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public LoginAdminServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      // loginAdmin.jsp 에서 넘겨준 데이터 받기
      String adminId = request.getParameter("adminId");
      String adminPwd = request.getParameter("adminPwd");
      String secureConnect = request.getParameter("secureConnect");

      // userId와 userPwd로 비즈니스 로직 처리
      AdminService adminService = new AdminServiceImpl();
      Admin ad = adminService.selectOneUser(adminId, adminPwd);

      if (ad != null) { // userId와 userPwd가 일치하는 회원있다면
         HttpSession session =request.getSession();
         session.setAttribute("admin", ad);

			response.sendRedirect("/views/admin/adminMain.jsp");


      } else { // 없다면
         RequestDispatcher view = request.getRequestDispatcher("/views/commons/loginFail.jsp");
         view.forward(request, response);
      }
      
      
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