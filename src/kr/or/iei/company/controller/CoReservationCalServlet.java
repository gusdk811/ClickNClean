package kr.or.iei.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.iei.company.model.service.CoMemberService;
import kr.or.iei.company.model.service.CoMemberServiceImpl;
import kr.or.iei.company.model.vo.Company;
import kr.or.iei.contract.model.vo.Contract;

/**
 * Servlet implementation class CoConditionSpanServlet
 */
@WebServlet("/co/conditionSpan.do")
public class CoReservationCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoReservationCalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String coId = ((Company)session.getAttribute("company")).getCoId();
		
		String month = request.getParameter("month2");
		String day = request.getParameter("day");
		
		
		CoMemberService coMService = new CoMemberServiceImpl();
		ArrayList<Contract> list = coMService.selectReservationDay(coId);
		
		
		
		JSONArray jsonArray = new JSONArray();
		
		for(Contract c : list) {
			
			JSONObject json = new JSONObject();
			json.put("reqDate", c.getReqDate());
			json.put("userId", c.getUserId());
			
			jsonArray.add(json);
		}
		
		
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
