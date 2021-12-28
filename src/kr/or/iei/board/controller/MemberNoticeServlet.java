package kr.or.iei.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.board.model.service.BoardService;
import kr.or.iei.board.model.service.BoardServiceImpl;

/**
 * Servlet implementation class MemberNoticeServlet
 */
@WebServlet("/board/memberNotice.do")
public class MemberNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage;
		
		if(request.getParameter("currentPage")==null)
		{
			//index.jsp 에서 게시판으로 이동하는 경우에는 가장 첫페이지면 1page로 셋팅
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//요청한 Page값(currentPage)을 가지고 페이지에 따른 데이터 목록화를 비즈니스 로직으로 처리
		BoardService bService = new BoardServiceImpl();
		HashMap<String, Object> pageDataMap = bService.memberNotice(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/memberNotice.jsp");
	    
		request.setAttribute("pageDataMap", pageDataMap);
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
