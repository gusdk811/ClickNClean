<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<link href="/assets/css/footer.css" rel="stylesheet" type="text/css" />
<link href="/assets/css/selectCondition.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	 <link href="/assets/css/header.css" rel="stylesheet" type="text/css"/>

<style>
</style>

<body id="bodycss">
	<jsp:include page="/views/commons/header.jsp" />
	<div id="contentArea">
		<div class="contentHead">
			<span id="contentTitle">청소 조건 선택</span> 찾으시는 청소업체에 맞는 조건을 선택해주세요.
		</div>
		<div id="contentBody">
			<form action="/contract/selectConditionCompany.do" method="post">
				<div id="condition1">
					<div class="conditionName">청소 종류</div>
					<div class="cleanTypeArea">
						<span class="cleanTypeName">1. 이사 청소 </span> <input type="radio"
							class="cleanType" name="cleanType" value="이사청소" />
					</div>
					<div class="cleanTypeArea">
						2. 입주 청소 <input type="radio" class="cleanType" name="cleanType"
							value="입주청소" />
					</div>
					<div class="cleanTypeArea">
						3. 부분 청소 <input type="radio" class="cleanType" name="cleanType"
							value="부분청소" />
					</div>
				</div>
				<div id="condition2">
					<div class="conditionName">청소 장소/평수</div>
					<div class="houseTypeSize">
						<select name="houseType"
							style="width: 70%; height: 120px; font-size: 30px; text-align: center; border-radius: 5px;">
							<option>아파트</option>
							<option>빌라</option>
							<option>전원주택</option>
							<option>원룸</option>
							<option>오피스텔</option>
						</select>
					</div>
					<div class="houseTypeSize">
						<select name="houseSize"
							style="width: 70%; height: 120px; font-size: 30px; text-align: center; border-radius: 5px;">
							<option>10평이하</option>
							<%
								for (int i = 11; i < 71; i++) {
							%>
							<option>
								<%=i%>평
							</option>
							<%
								}
							%>
							<option>71평이상</option>
						</select>

					</div>
				</div>
				<div id="condition3">
					<div class="conditionName">청소 지역</div>
					<div class="areaArea">
						<select name="area1"
							style="width: 90%; height: 100px; font-size: 30px; text-align: center; border-radius: 5px;"
							onchange="categoryChange(this)">
							<option value>시/도 선택</option>
							<option value="서울">서울</option>
							<option value="경기">경기</option>
							<option value="인천">인천</option>
							<option value="강원">강원</option>
							<option value="대전">대전</option>
							<option value="세종">세종</option>
							<option value="충남">충남</option>
							<option value="충북">충북</option>
							<option value="부산">부산</option>
							<option value="울산">울산</option>
							<option value="경남">경남</option>
							<option value="경북">경북</option>
							<option value="대구">대구</option>
							<option value="광주">광주</option>
							<option value="전남">전남</option>
							<option value="전북">전북</option>
							<option value="제주">제주</option>
						</select>
					</div>
					<div class="areaArea">
						<select name="area2"
							style="width: 90%; height: 100px; font-size: 30px; text-align: center; border-radius: 5px;"
							id="area2">
							<option>군/구 선택</option>
						</select>
					</div>

					<script>
						function categoryChange(e) {

							var seoul = [ "강남구", "강동구", "강북구", "강서구", "관악구",
									"광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구",
									"동작구", "마포구", "서대문구", "서초구", "성동구", "성북구",
									"송파구", "양천구", "영등포구", "용산구", "은평구", "종로구",
									"중구", "중랑구" ];

							var gyeonggi = [ "고양시", "과천시", "광명시", "광주시", "구리시",
									"군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시",
									"수원시", "시흥시", "안산시", "안성시", "안양시", "양주시",
									"오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시",
									"평택시", "포천시", "하남시", "화성시", "가평군", "양평군",
									"여주군", "연천군" ];

							var incheon = [ "계양구", "남구", "남동구", "동구", "부평구",
									"서구", "연수구", "중구", "강화군", "옹진군" ];

							var gangwon = [ "강릉시", "동해시", "삼척시", "속초시", "원주시",
									"춘천시", "태백시", "고성군", "양구군", "양양군", "영월군",
									"인제군", "정선군", "철원군", "평창군", "홍천군", "화천군",
									"횡성군" ];

							var daejeon = [ "대덕구", "동구", "서구", "유성구", "중구" ];

							var sejong = [ "세종특별자치시" ];

							var chungnam = [ "천안시", "공주시", "보령시", " 아산시",
									" 서산시", "논산시", "계룡시", "당진시", "금산군", "부여군",
									"서천군", "청양군", "홍성군", "에산군", "태안군" ];

							var chungbuk = [ "제천시", "청주시", "충주시", "괴산군", "단양군",
									"보은군", "영동군", "옥천군", "음성군", "증평군", "진천군",
									"청원군" ];

							var busan = [ "강서구", "금정구", "남구", "동구", "동래구",
									"부산진구", "북구", "사상구", "사하구", "서구", "수영구",
									"연제구", "영도구", "중구", "해운대구", "기장군" ];

							var ulsan = [ "남구", "동구", "북구", "중구", "울주군" ];

							var gyeongnam = [ "거제시", "김해시", "마산시", "밀양시",
									"사천시", "양산시", "진주시", "진해시", "창원시", "통영시",
									"거창군", "고성군", "남해군", "산청군", "의령군", "창녕군",
									"하동군", "함안군", "함양군", "합천군" ];

							var gyeongbuk = [ "경산시", "경주시", "구미시", "김천시",
									"문경시", "상주시", "안동시", "영주시", "영천시", "포항시",
									"고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군",
									"예천군", "울릉군", "울진군", "의성군", "청도군", "청송군",
									"칠곡군" ];

							var daegu = [ "남구", "달서구", "동구", "북구", "서구", "수성구",
									"중구", "달성군" ];

							var gwangju = [ "광산구", "남구", "동구", "북구", "서구" ];

							var jeonnam = [ "광양시", "나주시", "목포시", "순천시", "여수시",
									"강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군",
									"보성군", "신안군", "영광군", "영암군", "완도군", "장성군",
									"장흥군", "진도군", "함평군", "해남군", "화순군" ];

							var jeonbuk = [ "군산시", "김제시", "남원시", "익산시", "전주시",
									"정읍시", "고창군", "무주군", "부안군", "순창군", "완주군",
									"임실군", "장수군", "진안군" ];

							var jeju = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

							if (e.value == "서울") {
								var d = seoul;
							} else if (e.value == "경기") {
								var d = gyeonggi;
							} else if (e.value == "인천") {
								var d = incheon;
							} else if (e.value == "강원") {
								var d = gangwon;
							} else if (e.value == "대전") {
								var d = daejeon;
							} else if (e.value == "세종") {
								var d = sejong;
							} else if (e.value == "충남") {
								var d = chungnam;
							} else if (e.value == "충북") {
								var d = chungbuk;
							} else if (e.value == "부산") {
								var d = busan;
							} else if (e.value == "울산") {
								var d = ulsan;
							} else if (e.value == "경남") {
								var d = gyeongnam;
							} else if (e.value == "경북") {
								var d = gyeongbuk;
							} else if (e.value == "대구") {
								var d = daegu;
							} else if (e.value == "광주") {
								var d = gwangju;
							} else if (e.value == "전남") {
								var d = jeonnam;
							} else if (e.value == "전북") {
								var d = jeonbuk;
							} else if (e.value == "제주") {
								var d = jeju;
							}

							area2.options.length = 0;
							// 군/구 갯수;

							for (x in d) {
								var opt = document.createElement("option");
								opt.value = d[x];
								opt.innerHTML = d[x];
								area2.appendChild(opt);
							}
						}
					</script>
				</div>
				<div id="condition4">
					<div class="conditionName">청소 날짜</div>

					<div id="datepicker"></div>

					<input name="reqDate" id="date" type="text"
						style="margin-bottom: 50px;" />

				</div>

				<input type="submit" style="width: 500px; height: 77px;"
					id="toInfoBtn" value="업체 프로필 보기">

			</form>
		</div>
		<script>
			$(function() {
				$("#datepicker")
						.datepicker({
									minDate : +1,
									dateFormat : "yy.mm.dd",
									appendText : "yyyy-mm-dd",
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									dayNames : [ '일', '월', '화', '수', '목', '금',
											'토' ],
									dayNamesShort : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									showMonthAfterYear : true,
									nextText : '다음달',
									yearSuffix : '년',
									prevText : '',
									onSelect : function() {
										var currentDate = $("#datepicker")
												.datepicker("getDate");
										$('#date').val(
												$.datepicker
														.formatDate("yy-mm-dd",
																currentDate));

									}
								});
			});
		</script>
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
</body>
</html>