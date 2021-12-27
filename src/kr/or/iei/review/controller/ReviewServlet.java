package kr.or.iei.review.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review/review.do")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
int currentPage;
		
		if(request.getParameter("currentPage")==null) {

			currentPage  = 1;
		
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		ReviewService rService = new ReviewServiceImpl();
		HashMap<String, Object> map = rService.review(userId, currentPage);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/review.jsp");
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
