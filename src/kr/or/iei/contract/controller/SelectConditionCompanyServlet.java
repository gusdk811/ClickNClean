package kr.or.iei.contract.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.vo.Company;
import kr.or.iei.contract.model.service.ContractService;
import kr.or.iei.contract.model.service.ContractServiceImpl;
import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class SelectConditionCompanyServlet
 */
@WebServlet("/contract/selectConditionCompany.do")
public class SelectConditionCompanyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectConditionCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      //로그인 확인
      HttpSession session = request.getSession();
      Member m=(Member)session.getAttribute("member");
      if(m==null) {
         response.sendRedirect("/views/commons/error.jsp");
         return;
      }
      
      String cleanType=request.getParameter("cleanType");
      String houseType=request.getParameter("houseType");
      String houseSize=request.getParameter("houseSize");
      String area1=request.getParameter("area1");
      String area2=request.getParameter("area2");
      String reqDate=(request.getParameter("reqDate"));
      String area=area1+" "+area2;
      
      
      System.out.println(area1);
      System.out.println(area2);
      
      
      
      
      Date date=Date.valueOf(reqDate);
      String userId=m.getUserId();
      int size=Integer.parseInt(houseSize.substring(0, 2));
      String condition=cleanType+" / "+houseType+" / "+houseSize+" / "+area+" / "+reqDate;
      
      String conditionNo=request.getParameter("conditionNo");
      ContractService conService=new ContractServiceImpl();
      if(conditionNo==null) {
            
      long currentTime=Calendar.getInstance().getTimeInMillis();
      SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
      Timestamp searchTime=Timestamp.valueOf(formatter.format(currentTime));
      conditionNo=searchTime+"/"+userId;
      Contract con=new Contract();
      con.setUserId(userId);
      con.setCleanType(cleanType);
      con.setHouseType(houseType);
      con.setHouseSize(size);
      con.setArea(area);
      con.setReqDate(date);
      con.setConditionNo(conditionNo);
      
      
      conService.insertCondition(con);
      
      }
      
      ArrayList<Company> list= conService.selectConditionCompany(area,cleanType);
      
      
      
      
      RequestDispatcher view=request.getRequestDispatcher("/views/contract/conditionCompany.jsp");
      request.setAttribute("list", list);
      request.setAttribute("condition", condition);
      request.setAttribute("size", size);
      request.setAttribute("conditionNo", conditionNo);
      
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