<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/companyMain.css">
<link rel="stylesheet">
<script
	src=https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css"
	rel="stylesheet">



</head>
<body>
	<div id="allArea">

		<div id="header">

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

		</div>
		<div id="content">
			<div id="left-content"></div>
			<div id="center-content">
				<div id="center-content-top"></div>
				<div id="center-content-bottom">
					<span>
						<h3>요약</h3>
					</span>
					<hr>
					<div id="content1">
						<span>예약현황</span>
						<hr>
						<br>
						<ul type="none">
							<li>오늘청소 - - - - - - - <a style='cursor: pointer; color: purple;'>0건</a>
							</li>
							<br>
							<li>예약중 - - - - - - - - <a style='cursor: pointer; color: purple;'>0건</a></li>
								
							<br>
							<li>최소요청 - - - - - - - <a style='cursor: pointer; color: purple;'>0건</a></li>
								
						</ul>
					</div>
					<div id="content2">
						<span id="font">요청</span>
						<hr>
						<br>
						<ul type="none">
							<li>000님 요청 - - - -
								<button>상세보기</button>
							</li>
							<br>

						</ul>
					</div>
					<div id="content3">
						<span>청소 리뷰</span>
						<hr>
						<br>
						<ul type="none">
							<li>000님 리뷰작성 - 21/12/17</li>
							<br>

						</ul>

					</div>

					<div id="m-sales">
						<span>일 매출 통계</span>
						<br>
						<hr>
						<br>
						<canvas id="myChart" width="30%" height="8%"></canvas>
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

	<script>
		var today = new Date();

		/*var year = today.getFullYear(); year + '-' +*/
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);

		var dateString = month + '-' + day;

		console.log(dateString);
		// 결과 : 2021-05-30

		const ctx = document.getElementById('myChart').getContext('2d');
		const myChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : [ dateString, 'Blue', 'Yellow', 'Green', 'Purple',
						'Orange', 'grey', 'grey', 'grey', 'grey', 'grey',
						'grey', 'grey', 'grey', 'grey' ],
				datasets : [ {

					data : [ 1000, 3000, 2500, 2800, 5000, 1800, 400, 400, 400, 400,
							400, 400, 400, 400, 400 ],
					backgroundColor : [ '#0099FF', '#0099FF', '#0099FF',
							'#0099FF', '#0099FF', '#0099FF', '#0099FF',
							'#0099FF', '#0099FF', '#0099FF', '#0099FF',
							'#0099FF', ],
					borderColor : [ '#0099FF', '#0099FF', '#0099FF', '#0099FF',
							'#0099FF', '#0099FF', '#0099FF', '#0099FF',
							'#0099FF', '#0099FF', '#0099FF', '#0099FF', ],
					borderWidth : 1
				} ]
			},
			options : {
				plugins : {
					legend : {
						display : false
					}
				},

				scales : {
					y : {
						beginAtZero : true
					}
				}
			}
		});
	</script>
	
	<link rel="stylesheet" href="/assets/css/footer.css">
</body>
</html>