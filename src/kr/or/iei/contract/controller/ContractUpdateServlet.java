package kr.or.iei.contract.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.contract.model.service.ContractService;
import kr.or.iei.contract.model.service.ContractServiceImpl;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class ContractUpdateServlet
 */
@WebServlet("/contract/contractYNUpdate.do")
public class ContractUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contractNo = Integer.parseInt(request.getParameter("contractNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
	
		
		ContractService cService = new ContractServiceImpl();
		int result = cService.updateContractYN(userId, contractNo);
		
		if(result>0) {
			
			response.sendRedirect("/reiview/reservationList.do?currentPage="+currentPage);
			
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
