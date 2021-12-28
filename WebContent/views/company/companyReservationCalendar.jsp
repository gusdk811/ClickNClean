<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/cheader.css">
<link rel="stylesheet" href="/assets/css/companyReservationCalendar.css">
<link rel="stylesheet" href="/assets/css/footer.css">
<link rel="stylesheet">
<script
	src=https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

<jsp:include page="/views/company/cheader.jsp" />
	<div id="allArea">

		<!-- <div id="header">

			<div id="logo">
				<a href="/views/company/companyMain.jsp"><img src="/assets/img/clicknclean.png"></a>
			</div>
			<div id="navi">
				<ul id="navi-ul">
					<li><a href="/views/company/companyProfileUpdate.jsp">프로필 설정</a></li>
					<li><a href="/views/company/companyReservationCalendar.jsp">예약현황</a></li>
					<li><a href="/co/coMemberAllList.do">회원정보</a></li>
					<li><a href="/co/coReviewAllList.do">청소리뷰</a></li>
				</ul>
			</div>

		</div> -->
		<div id="content">
			<div id="left-content"></div>
			<div id="center-content">
				<div id="center-content-top"></div>
				<div id="center-content-bottom">

					<div id="container">
						<div class="calendar">
							<div class="month">
								<i class="fas fa-angle-left prev"></i>
								<div class="date">
									<h1></h1>
									<p></p>
								</div>
								<i class="fas fa-angle-right next"></i>
							</div>
							<div class="weekdays">
								<div>Sun</div>
								<div>Mon</div>
								<div>Tue</div>
								<div>Wed</div>
								<div>Thu</div>
								<div>Fri</div>
								<div>Sat</div>
							</div>
							<div class="days"></div>
						</div>
					</div>
					<div class="container2"></div>
					<div id="reservationbg">
						<div id="reservation">
							<div id="reservationDay"></div>
								<br>
								<br>
								
							<table id="print" border="1px">
								
							</table>
								
								<br>
								<br> 
								<br>
								<br>

						</div>
					</div>
				</div>
			</div>
			<div id="rigth-content"></div>
		</div>
		<div id="footer">
			<div id="caution">
				<p>클릭N클린은 통신판매중개자로서 청소서비스의 주거래 당사자가 아니며, 청소서비스의 분쟁과 계약사항은 회원사와
					당사자간에 있습니다.</p>
			</div>
			<div id="footer_inner">
				<div id="footer_inner_center">
					<div id="footer_inner_left">
						<span>클릭N클린 고객센터</span> <br> <a href="tel:010-3306-6303">010-3306-6303</a>
						<br> 영업시간 : 09:00 ~ 18:00 <br> (공휴일 휴무)
					</div>
					<div id="footer_inner_right">
						<div id="busyInfo">
							<p>클릭N클린(주)</p>
							<address>
								대표: 김승현 <br> 주소 : 서울특별시 중구 세종대로 136 파이낸스빌딩 3층 저스트코 S3119
								(태평로1가) <br> 사업자등록번호 : 585-86-00882 <br> 통신판매업번호 :
								2017-인천계양-0583호 <br> E-mail : help@clickNclean.co.kr <br>
								FAX : 070-5165-8603
							</address>
							<p>Copyright © 클릭N클린</p>
						</div>
						<ul>
							<li><a href="">개인정보취급방침</a></li>
							<li><a href="">이용약관</a></li>
							<li><a href="">관리자 페이지</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>

	</div>



	<script src="/assets/js/companyReservationCalendarScript.js"></script>
	


</body>
</html>