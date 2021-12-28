package kr.or.iei.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.admin.model.vo.Admin;


public class MemberAuthorityCheck {

	public static String authorityRootCheck(HttpServletRequest req,HttpServletResponse res)
	        throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("admin");
		
		if(obj==null)
		{
			return null;
		}
		
		Admin m = (Admin)obj;
		
		if(!m.getRoll().substring(0, 2).equals("AD")) //관리자가 아니라면
		{
			return null;
		}else if(!m.getRoll().substring(3,4).equals("0"))//최고 관리자가 아니라면
		{
			return null;
		}
		else //관리자이면서 최고 관리자인 경우
		{
			return m.getRoll();
		}
		
	}
}
