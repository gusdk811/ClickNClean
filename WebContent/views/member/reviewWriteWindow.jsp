<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <!--JQuery CDM-->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <style>
        * {
            box-sizing: border-box;
            font-family: 'NanumSquare';
        }

        #wrap {
            width: 100%;
            margin: 0 auto;
            background-color: #fafafa;
        }

        /*헤더 부분 */
        #header {

        width: 100%;
        /*height: 92px;*/
        height: 70px;

        background-color: #fafafa;

    }

    #headerFixed {
        position: fixed;
        width: 100%;
        height: 70px;
        background-color: #fafafa;
        z-index: 98;
    }


    #headerInner {

        width: 1344px;
        height: 100%;
        margin: 0 auto;

    }

    #logo {
        width: 30%;
        height: 100%;
        float: left;
        
    }

    .logoImg {
        width: 100%;
        height: 100%;
    }

    #estimate {

        width: 40%;
        height: 100%;

        float: left;
    }

    
    #estimateBtn>a {
        text-decoration: none;
        line-height: 46px;
        font-size: 20px;
        color: #0E76B3;
    }

    #menu {

        width: 30%;
        height: 100%;

        float: left;
    }

    #login {
        width: 80%;
        height: 100%;
        float: left;
    }

    #login>ul {

        width: 320px;
        height: 100%;
        margin: 0;
    }

    #login>ul>li {
        list-style: none;
        width: 80px;
        float: right;
        display: inline;
        margin-right: 30px;
    }
    
    #menu a {
        text-decoration: none;
        font-size: 20px;
        display: inline;

        text-align: center;
        color: #0E76B3;
        font-weight: bold;
        line-height: 70px;

    }
       

        #mypage {
            width: 1344px;
            height: 120px;
            margin: 0 auto;

        }

        #mypageFont {
            position: relative;
            font-size: 35px;
            top: 38px;
            left: 580px;
            color: #555;
        }

        /* 메뉴 바 */
        #submenu {
            width: 1344px;
            height: 67px;
            margin: 0 auto;
        }

        #navigator {
            height: 67px;
            width: 800px;
            margin: 0 auto;
        }

        #gnb {
            margin: 0;
            padding: 0;
            height: 100%;
            overflow: hidden;
        }

        #gnb a {
            text-decoration: none;
            color: #555;
            width: 100%;
            display: block;
            font-size: 20px;
        }

        #gnb li {
            float: left;
            width: 25%;
            height: 100%;
            list-style-type: none;
            text-align: center;
            line-height: 70px;

        }

        #gnb li:hover {
            background-color: #0E76B3;
        }

        #gnb a:hover {
            color: white;
        }

        /* 콘텐트 부분 */
        #content {
            width: 1344px;
            height: 950px;
            margin: 0 auto;
        }

        #content1 {
            width: 800px;
            height: 100%;
            margin: 0 auto;
        }

        #content-1 {
            width: 100%;
            height: 140px;
        }

        #content1-1 {
            width: 30%;
            height: 100%;
            float: left;

        }

        #content1-2 {
            width: 69%;
            height: 100%;
            float: left;

        }

        #detail {
            display: block;
            font-size: 35px;
            position: relative;
            top: 46px;
            left: 60px;
            color: #555;
        }

        #search {
            border: none;
        }

        #sub {
            width: 50%;
            height: 30px;
            position: relative;
            left: 140px;
            top: 0px;
        }

        #subNavi {
            width: 100%;
            height: 34px;
        }

        #subNavi a {
            text-decoration: none;
            color: black;
            width: 100%;
            display: block;
            position: relative;
            top: -15px;
            font-size: 15px;
        }

        #subNavi li {
            float: left;
            width: 25%;
            height: 100%;
            list-style-type: none;
            text-align: center;
            line-height: 70px;

        }

        #subNavi li:hover {
            background-color: #0E76B3;
        }

        #subNavi a:hover {
            color: white;
        }

        #content-2 {
            width: 100%;
            height: 110px;
        }

        #coInfo {
            width: 500px;
            height: 100%;
            border: 2px solid #0E76B3;
            border-radius: 5px;
            margin: 0 auto;
        }

        #logoImg {
            width: 145px;
            height: 100%;
            float: left;
        }

        #coName {
            width: 155px;
            height: 100%;
            float: left;
        }

        #resInfo {
            width: 195px;
            height: 100%;
            float: left;
        }

        #Logo {
            width: 80px;
            height: 80px;
            border: 1px solid black;
            margin: 13px 33px;
        }

        #coName>p {
            font-size: 22px;
            color: #555;
            display: block;
            position: relative;
            top: 36px;
            left: 13px;
        }

        #resInfo>p {
            font: 15px;
            color: #555;
            display: block;
            position: relative;
            top: 23px;
        }

        .nemo {
            width: 100%;
            height: 40px;
        }

        #nemo2 {
            width: 500px;
            height: 2px;
            background-color: rgba(14, 118, 179, 0.2);
            margin: 0 auto;
        }

        #content3 {
            width: 500px;
            height: 570px;
            margin: 0 auto;
            border: 2px solid #0E76B3;
            border-radius: 5px;
        }

        #serviceGood {
            width: 100%;
            height: 100px;
        }

        #serviceGood>p {
            font-size: 25px;
            color: #555;
            display: block;
            position: relative;
            top: 50px;
            left: 100px;

        }

        #star {
            width: 100%;
            height: 60px;
        }

        #reviewContent {
            width: 450px;
            height: 380px;
            margin: 17px auto;
        }

        textarea {
            border: 2px solid rgba(14, 118, 179, 0.2);
            border-radius: 5px;
        }

        #complete {
            float: left;
            position: relative;
            left: 90px;
        }

        #list {
            float: left;
            position: relative;
            left: 110px;
        }

        #clear {
            float: left;
            position: relative;
            left: 130px;
        }



        .line {
            width: 800px;
            height: 6px;
            background-color: #0E76B3;
            margin: 0 auto;
        }

        /*footer 부분 */
        #footer-1 {
            width: 100%;
            height: 66px;
        }

        #footer {
            width: 100%;
            height: 66px;

        }

        #footer_inner {
            padding-top: 20px;
            width: 100%;
            height: 232px;
        }

        #caution {
            border-top: 1px solid #D9D9D9;
            border-bottom: 1px solid #D9D9D9;
            width: 100%;
            height: 70px;
            color: #666;


        }

        #caution>p {
            text-align: center;
            line-height: 70px;
            font-weight: 600;
        }

        #footer_inner_center {

            width: 1344px;
            height: 100%;
            margin: 0 auto;
        }

        #footer_inner_left {

            font-weight: bold;
            width: 26%;
            height: 100%;
            padding-left: 83.52px;
            float: left;
        }

        #footer_inner_left span {
            font-size: 20px;
            color: #666;
        }

        #footer_inner_left a {

            font-size: 25px;
            color: black;
            text-decoration: none;
            display: block;
            height: 30px;
            padding: 10px 0;
        }

        #footer_inner_right {

            width: 74%;
            height: 100%;
            float: left;
        }

        #busyInfo {
            color: #666;
            font-weight: bold;
            font-size: 13px;
            float: left;
            padding-left: 83.52px;
        }

        #busyInfo>p:first-child {
            font-size: 20px;
            color: #666;
        }

        #footer_inner_right ul {
            float: right;
            display: inline-block;
            width: 250px;
            padding-left: 50px;
            list-style: none;
        }

        #footer_inner_right ul li {
            margin-bottom: 20px;
            width: 100%;
        }

        #footer_inner_right ul li a {
            text-decoration: none;
            color: #666;
            font-weight: bold;
        }

        /*별점 부분 */

        #myform fieldset {
            display: inline-block;
            /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
            border: 0;
            /* 필드셋 테두리 제거 */
        }

        #myform input[type=radio] {
            display: none;
            /* 라디오박스 감춤 */
        }

        #myform label {
            font-size: 2.1em;
            /* 이모지 크기 */
            color: transparent;
            /* 기존 이모지 컬러 제거 */
            text-shadow: 0 0 0 #f0f0f0;
            /* 새 이모지 색상 부여 */
            position: relative;
            top: 5px;
            left: 115px;
        }

        color: transparent;
        /* 기존 이모지 컬러 제거 */
        text-shadow: 0 0 0 #f0f0f0;

        /* 새 이모지 색상 부여 */
        #myform label:hover {
            text-shadow: 0 0 0 #FFDD73;
            /* 마우스 호버 */
        }

        #myform label:hover~label {
            text-shadow: 0 0 0 #FFDD73;
            /* 마우스 호버 뒤에오는 이모지들 */
        }

        #myform fieldset {
            display: inline-block;
            /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
            direction: rtl;
            /* 이모지 순서 반전 */
            border: 0;
            /* 필드셋 테두리 제거 */
        }


        #myform fieldset legend {
            text-align: center;
        }

        #myform input[type=radio]:checked~label {
            text-shadow: 0 0 0 #FFDD73;
            /* 마우스 클릭 체크 */
        }
    </style>
</head>
<body>
    <div id="wrap">
        <div id="header">
              <div id="header">
            <div id="headerFixed">
                <div id="headerInner">
                    <div id="logo">
                        <a href=""><img src="image/%ED%81%B4%EB%A6%ADN%ED%81%B4%EB%A6%B0_3nor.png" class="logoImg"></a>
                    </div>

                    <div id="estimate">
                       
                    </div>

                    <div id="menu">
                        <div id="login">
                            <ul>
                                <li><a href="">로그아웃</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
           
        </div>
       
       
       
        <div id="mypage">
            <span id="mypageFont">마이페이지</span>
        </div>
        <div id="submenu">
            <div id="navigator">
                <ul id="gnb">
                    <li><a href="">개인정보수정</a></li>
                    <li><a href="">나의 견적서</a></li>
                    <li><a href="">이용내역</a></li>
                    <li><a href="">설정</a></li>
                </ul>
            </div>
        </div>
        <div class="line"></div>

        <!--회원 정보 수정 비밀번호 체크-->
        <div id="content">
            <div id="content1">
                <div id="content-1">
                    <div id="content1-1">
                        <span id="detail">리뷰작성</span>
                    </div>
                    <div id="content1-2">
                        <div id="sub">
                            <ul id="subNavi">
                                <li><a href="">예약확정</a></li>
                                <li><a href="">리뷰작성</a></li>
                                <li><a href="">리뷰보기</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!--업체 테이블 연결 필요-->
                <div id="content-2">
                    <div id="coInfo">
                        <div id="logoImg">
                            <div id="Logo"></div>
                        </div>
                        <div id="coName">
                            <p>청소클라쓰</p>
                        </div>
                        <div id="resInfo">
                            <p>청소 서비스 : 이사청소</p>
                            <p>청소 날짜 : 2021-11-14</p>
                        </div>
                    </div>

                </div>
                <div class="nemo"></div>
                <div id="nemo2"></div>
                <div class="nemo"></div>
                <!--리뷰 작성란 로직 연결-->
                <div id="content3">
                    <div id="serviceGood">
                        <p>청소 서비스는 어떠셨나요?</p>
                    </div>
                    <div id="star">
                        <!--볌점 api 사용-->
                        <form name="myform" id="myform" method="post" action="./save">
                            <fieldset>

                                <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
                                <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
                                <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
                                <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
                                <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
                            </fieldset>
                        </form>


                    </div>
                    <div id="reviewContent">
                        <form>
                            <textarea rows="12" cols="52" style="resize:none;" placeholder="내용을 입력하세요" name="content"></textarea>
                            <br><br>
                            <input type="submit" id="complete" value="작성완료" class="btn rounded " style="border: 1px solid #0E76B3; color: #0E76B3;" />
                            <input type="button" id="list" value="목록" class="btn rounded " style="background-color:#0E76B3; color: white" onclick="location.replace('');" />
                            <input type="reset" id="clear" class="btn rounded " style="border: 1px solid #0E76B3; color: #0E76B3;" value="초기화" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="line"></div>
        <!-- 풋터 영역 -->
        <div id="footer-1"></div>
        <div id="footer">
            <div id="caution">
                <p>클릭N클린은 통신판매중개자로서 청소서비스의 주거래 당사자가 아니며, 청소서비스의 분쟁과 계약사항은 회원사와 당사자간에 있습니다.</p>
            </div>
        </div>
        <div id="footer_inner">
            <div id="footer_inner_center">
                <div id="footer_inner_left">
                    <span>클릭N클린 고객센터</span>
                    <br>
                    <a href="tel:010-3306-6303">010-3306-6303</a>
                    <br>
                    영업시간 : 09:00 ~ 18:00
                    <br>
                    (공휴일 휴무)
                </div>
                <div id="footer_inner_right">
                    <div id="busyInfo">
                        <p>클릭N클린(주)</p>
                        <address>
                            대표: 김승현
                            <br>
                            주소 : 서울특별시 중구 세종대로 136 파이낸스빌딩 3층 저스트코 S3119 (태평로1가)
                            <br>
                            사업자등록번호 : 585-86-00882
                            <br>
                            통신판매업번호 : 2017-인천계양-0583호
                            <br>
                            E-mail : help@clickNclean.co.kr
                            <br>
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
</body>
</html>