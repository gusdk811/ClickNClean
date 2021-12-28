package kr.or.iei.contract.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.contract.model.service.ContractService;
import kr.or.iei.contract.model.service.ContractServiceImpl;

/**
 * Servlet implementation class MemberInsertContractServlet
 */
@WebServlet("/contract/insertContract.do")
public class MemberInsertContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conditionNo=request.getParameter("conditionNo");
		String userId=request.getParameter("userId");
		String coId=request.getParameter("coId");
		int price=Integer.parseInt(request.getParameter("price"));
		System.out.println(conditionNo);
		System.out.println(userId);
		System.out.println(coId);
		System.out.println(price);
		
		ContractService conService=new ContractServiceImpl();
		int result =conService.insertContract(conditionNo,userId,coId,price);
		
		PrintWriter out = response.getWriter();
		
		if(result>0) {
			out.print("success");
		}else {
			out.print("fail");
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
