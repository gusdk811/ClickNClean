<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		boolean result = (boolean)request.getAttribute("result");
	%>
	<script>
	<% if(result){ %>
		alert('[<%=(String)request.getAttribute("userId")%>] 회원 탈퇴가 되었습니다. \n 이용해주셔서 감사합니다.');
	
	<%}else{ %>
		alert('회원 탈퇴를 실패하였습니다. \n 지속적인 문제 발생 시 관리자에게 문의 바람');
	<%} %>
	location.replace("/");
	</script>

</body>
</html>