package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemeberCompanyChangePwdServlet
 */
@WebServlet("/member/memeberCompanyChangePwd.do")
public class MemeberCompanyChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemeberCompanyChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String roll = request.getParameter("roll");
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(roll);
		int result=0;


		switch (roll) {
				case "UR-1":
					MemberService mService = new MemberServiceImpl();
					result = mService.updateMemberPwd(roll, userId, userPwd);
					break;
				case "CO-1":
					CompanyService comService = new CompanyServiceImpl();
					result = comService.upadateCompanyPwd(roll, userId, userPwd);
					break;
				}
		
		boolean data= false;
		if(result>0) {
			data=true;
		}else {
			data=false;
		}
		System.out.println(data);
		PrintWriter out =response.getWriter();
		out.print(data);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
