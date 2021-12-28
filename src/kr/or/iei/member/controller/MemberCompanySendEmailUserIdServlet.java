package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.company.model.service.CompanyService;
import kr.or.iei.company.model.service.CompanyServiceImpl;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;
import kr.or.iei.util.Gmail;

/**
 * Servlet implementation class MemberCompanySendEmailUserIdServlet
 */
@WebServlet("/member/memberCompanySendEmailUserId.do")
public class MemberCompanySendEmailUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberCompanySendEmailUserIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String roll =request.getParameter("roll");;
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		String verificationNumber =request.getParameter("verificationNumber");

		String id = null;
		boolean result = false;

		PrintWriter out = response.getWriter();
		
		
		if (code.equals(verificationNumber)) {
			
			switch (roll) {
			case "UR-1":
				MemberService mService = new MemberServiceImpl();
				id = mService.searchIdUsingEmail(roll, userName, email);
				break;
			case "CO-1":
				CompanyService comService = new CompanyServiceImpl();
				id = comService.searchIdUsingEmail(roll, userName, email);
				break;
			}
			

			// 이메일 발송 로직
			String host = "http://127.0.0.1/";
			String from = "kshlove735@gmail.com"; // 보내는 사람
			String to = email; // 받는 사람
			String subject = "[클릭N클린] 인증 메일입니다.";
			String content = "아이디 : " + id; // 인증코드 Random으로 설정

			Properties p = new Properties();

			p.put("mail.smtp.host", "smtp.gmail.com");
			// google - TLS : 587, SSL: 465
			p.put("mail.smtp.port", 465);
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.ssl.enable", "true");
			p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			p.put("mail.debug", "true");

			try {
				Authenticator auth = new Gmail();
				Session ses = Session.getInstance(p, auth);
				ses.setDebug(true);
				MimeMessage msg = new MimeMessage(ses);
				msg.setSubject(subject);
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr);
				Address toAddr = new InternetAddress(to);
				msg.addRecipient(Message.RecipientType.TO, toAddr);
				msg.setContent(content, "text/html;charset=UTF8");
				Transport.send(msg);
			} catch (Exception e) {
				e.printStackTrace();

			}
			result = true;
			out.print(result);

		} else {
			result=false;
			out.print(result);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
