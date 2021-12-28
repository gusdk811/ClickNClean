package kr.or.iei.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.company.model.service.CompanyInfoService;
import kr.or.iei.company.model.service.CompanyInfoServiceImpl;
import kr.or.iei.company.model.vo.Company;

/**
 * Servlet implementation class CoProfileServlet
 */
@WebServlet("/co/coProfileUpdate.do")
public class CoProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoProfileUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String coId = ((Company)request.getSession().getAttribute("company")).getCoId();
		
		String area1 = request.getParameter("area1");
		String area2 = request.getParameter("area2");
		String coInfo = request.getParameter("coIntroduce");
		String[] cleanTypeValues = request.getParameterValues("cleanType");
		String history = request.getParameter("history");
		String  grade = request.getParameter("gradeType");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String startMeetTime = request.getParameter("startMeetTime");
		String endMeetTime = request.getParameter("endMeetTime");
		
		
		String area = area1 + " " + area2;
		String workHour = startTime + "-" + endTime;
		String meetHour = startMeetTime + "-" + endMeetTime;
		
		
		String cleanType;
		
		if(cleanTypeValues == null) {
			cleanType = "";
		}else {
			cleanType = String.join(", ", cleanTypeValues);
		}
		
		
		
		Company co = new Company(grade, coInfo, area, cleanType, history,meetHour, workHour );
		
		
		
		
		CompanyInfoService ciService = new CompanyInfoServiceImpl();
		int result = ciService.updateCompanyInfo(co, coId);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/company/updateCompanyInfo.jsp");
		
		if(result>0) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
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
