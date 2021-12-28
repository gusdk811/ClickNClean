package kr.or.iei.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.model.service.AdminAllListService;
import kr.or.iei.admin.model.service.AdminAllListServiceImpl;
import kr.or.iei.common.MemberAuthorityCheck;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class MemberAllListServlet
 */
@WebServlet("/admin/memberAllList.do")
public class MemberAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       String roll = MemberAuthorityCheck.authorityRootCheck(request, response);
		
		if(roll==null) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		//모든 회원의 정보를 가져오는 비즈니스 로직 처리
		AdminAllListService adService = new AdminAllListServiceImpl();
		ArrayList<Member> list = adService.memberAllList();
		
		//가져온 회원 정보를 가지고 ,jsp(view) 페이지로 이동
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberAllList.jsp");
		
		request.setAttribute("list", list);
		
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
