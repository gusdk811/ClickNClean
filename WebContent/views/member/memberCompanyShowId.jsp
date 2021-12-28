<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- JSTL 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- css -->
<link href="/assets/css/memberCompanyShowId.css?afdter" rel="stylesheet" type="text/css" />

</head>
<body>
	<c:choose>
		<c:when test="${requestScope.id!=null }">
			<div id="wrap">
		        <div id="header">
		
		        </div>
		
		        <div id="content">
		            <div id="content_inner">
		                <div id="showId">
		                    <div>
		                        <h2>고객님의 클릭N클린 계정을 찾았습니다.</h2>
		                        <div>아이디 확인 후 로그인해 주세요.</div>
		                    </div>
		                    <div id="showId_center">
		                        <div><img src="/assets/img/user_icon.png"></div>
		                        <div><p>${requestScope.id }</p></div>
		                    
		                    </div>
		                    <div id="findPwdbtn"><a href="/views/member/MemberCompanyFindPwd.jsp">비밀번호 찾기</a></div>
		                    <div id="loginbtn"><a href="/views/member/loginMemberCompany.jsp">로그인</a></div>
		
		                </div>
		            </div>
		        </div>
		
		        <div id="footer">
		
		        </div>
		
		    </div>
		</c:when>
		
		<c:otherwise>
			<script>
				alert('이름과 핸드폰 번호를 확인해주세요\r\n핸드폰 번호는 숫자만 입력해 주세요.')
				history.back();
			</script>
		</c:otherwise>
	</c:choose>	

</body>
</html>