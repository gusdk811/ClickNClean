<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
			<div id="headerFixed">
				<div id="headerInner">
					<div id="logo">
						<a href="/"><img src="/assets/img/logo_icon.png"
							class="logoImg"></a>
					</div>

					<div id="estimate">
						<ul id="navi-ul">
					<li><a href="/co/coSearchCompanyInfo.do">프로필 설정</a></li>
					<li><a href="/views/company/companyReservationCalendar.jsp">예약현황</a></li>
					<li><a href="/co/coMemberAllList.do">회원정보</a></li>
					<li><a href="/co/coReviewAllList.do">청소리뷰</a></li>
				</ul>
					</div>


					<div id="menu">
						<div id="login">
							<ul>
							
								<c:choose>
								
									<%--로그인 했다면 --%>
									<c:when test="${sessionScope.member != null || sessionScope.company != null || sessionScope.admin != null }">
									
										

										<li>
										
											<c:choose>
												<c:when test="${sessionScope.member != null }">
														<a href="/contract/myEstimate.do"><c:out value="${sessionScope.member.userName}"></c:out> 님</a>
												
													<ul id="login_success">
		                                        <li><a href="/contract/myEstimate.do">마이페이지</a></li>
		                                        
												</c:when>
												
												
												<c:when test="${sessionScope.company != null }">
														<a href="/views/company/companyMyPage.jsp"><c:out value="${sessionScope.company.coName}"></c:out> 님</a>
														
													<ul id="login_success">
		                                        <li><a href="/views/company/companyMyPage.jsp">마이페이지</a></li>												
												</c:when>
												<c:otherwise>
														<a href="/admin/adminHome.do"><c:out value="${sessionScope.admin.adminName}"></c:out> 님</a>
												
													<ul id="login_success">
		                                        <li><a href="/admin/adminHome.do">마이페이지</a></li>												
												
												</c:otherwise>											
											</c:choose>											
										
										
											
		                                        <li><a href="/member/logout.do">로그아웃</a></li>
                                    		</ul>
										</li>
									</c:when>
									
								
									<%--로그인 안했다면 --%>
									<c:otherwise>
									
										<li><a href="/views/member/loginMemberCompany.jsp">로그인</a></li>
										<li><a href="">회원가입</a></li>	
									</c:otherwise>
								
								</c:choose> 
								
					
							</ul>
						</div>
						<div id=menuIconForm>
							<img src="/assets/img/menu_icon.png" id='menuIcon'>
						</div>
					</div>

				</div>
			</div>
			<div id="sub_menu">
				<div>
					<img src='/assets/img/logo_icon.png' class="logoImg">
					
					
				</div>
				<div id="sub_menu_inner">
					<ul>
						
						
					<%-- 회원에 따라 로그인시 보일  서브 메뉴 --%>
						
						<%-- 개인 회원 로그인 시 --%>
						<c:if test="${sessionScope.member != null }">
							<li><a href='/contract/myEstimate.do'>마이페이지(회원)</a></li>
							<li><a href='/board/memberNotice.do'>공지사항 및 FAQ(회원)</a></li>
							<li><a href='/board/memberInquiry.do'>1:1 문의(회원)</a></li>
						</c:if>
						
						<%-- 사업자 회원 로그인 시 --%>
						<c:if test="${sessionScope.company != null }">
							<li><a href='/admin/adminHome.do'>마이페이지(업체)</a></li>
							<li><a href='/board/companyNotice.do'>공지사항 및 FAQ(업체)</a></li>
						</c:if>
						
						
						<%-- 관리자 회원 로그인시 보일 메뉴(추가 예정) --%>
						<c:if test="${sessionScope.admin !=null }">
								<li><a href='/admin/adminHome.do'>마이페이지(관리자)</a></li>
						</c:if>
						
						<li><a href='/company/selectAllCompanyList.do'>우리 동네 업체 찾기</a></li>
						<li><a href='/views/info/cleanType.jsp'>청소 항목 소개</a></li>
					</ul>
				</div>
				<hr>
				<div>
					<dl>
						<dt>[유선 상담 안내]</dt>
						<dd>1600-1777</dd>
					</dl>
					<dl>
						<dt>[고객센터 운영 시간]</dt>
						<dd>09:00 ~ 18:00</dd>
					</dl>
				</div>

			</div>

			<script>
				$('#menuIcon').click(function() {
					if ($('#sub_menu').css('visibility') == 'hidden') {
						$('#sub_menu').css('visibility', 'visible');
						$('#sub_menu').animate({
							right : '0px',
						}, 1000);
					} else {

						$('#sub_menu').animate({
							right : '-280px'
						}, 1000, function() {
							$('#sub_menu').css('visibility', 'hidden');
						});
					}

				});
			</script>
		</div>
</body>
</html>