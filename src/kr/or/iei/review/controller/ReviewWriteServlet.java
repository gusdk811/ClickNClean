package kr.or.iei.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;
import kr.or.iei.review.model.vo.Review;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet("/review/reviewWrite.do")
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int contractNo = Integer.parseInt(request.getParameter("contractNo"));
		String coId = request.getParameter("coId");
		
		System.out.println(coId);
		
		
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("rating"));
		
		if(request.getSession().getAttribute("member")==null) {   
			
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		
		Review r = new Review();
		r.setUserId(userId);
		r.setContent(content);
		r.setScore(score);
		r.setContractNo(contractNo);
		r.setCoId(coId);
	
		ReviewService rService = new ReviewServiceImpl();
		
		int result = rService.insertReviewWrite(r);
		int result1 = rService.updateCleanYN(contractNo, userId);
		
		if(result>0 && result1>0) {
			
			response.sendRedirect("/views/member/reviewResult.jsp");
			
		}else {
			response.sendRedirect("/views/commons/error.jsp");
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
