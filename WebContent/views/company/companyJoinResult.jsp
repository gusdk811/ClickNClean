<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- JSTL 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<script>
		var result ='<c:out value="${requestScope.result }"/>';
		if(result=='true'){
			alert('입점신청에 성공하였습니다.\r\n로그인 후 마이페이지에서 프로필 설정 해주세요. ');
			location.replace('/views/member/loginMemberCompany.jsp');
		}else{
			alert('입점신청에 실패하였습니다.\r\n지속적인 문제 발생시 관리자에게 문의해 주세요.');
			history.back();

		}
				
			
	</script>
</body>
</html>