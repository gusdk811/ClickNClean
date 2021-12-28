package kr.or.iei.review.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;
import kr.or.iei.review.model.vo.Review;

/**
 * Servlet implementation class SelectReviewServlet
 */
@WebServlet("/review/selectReview.do")
public class SelectReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		int contractNo = Integer.parseInt(request.getParameter("contractNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String coName = request.getParameter("coName");
		String cleanType = request.getParameter("cleanType");
		String cleanDate = request.getParameter("cleanDate");
		
		ReviewService rService = new ReviewServiceImpl();
		Review r = rService.selectOneReview(contractNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberWatchReview.jsp");
		request.setAttribute("review", r);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("coName", coName);
		request.setAttribute("cleanType", cleanType);
		request.setAttribute("cleanDate", cleanDate);
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
