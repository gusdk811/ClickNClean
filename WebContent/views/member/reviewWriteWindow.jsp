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

        /* 콘텐트 부분 */
        #content {
            width: 1344px;
            height: 920px;
            
        }

        #content1 {
            width: 800px;
            height: 100%;
            margin: 0 100px;
        }

        #content-1 {
            width: 100%;
            height: 110px;
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
            font-size: 30px;
            position: relative;
            top: 30px;
            left: 340px;
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
<%
	int contractNo = Integer.parseInt(request.getParameter("contractNo"));
	String coId = request.getParameter("coId");

%>

  
        <div class="line"></div>

        <!--회원 정보 수정 비밀번호 체크-->
        <div id="content">
            <div id="content1">
                <div id="content-1">
                    <div id="content1-1">
                        <span id="detail">리뷰작성</span>
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
                    
                    <form name="myform" id="myform" method="post" onsubmit="return false;">
                    <div id="star">
                        
                            <fieldset>

                                <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
                                <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
                                <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
                                <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
                                <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
                            </fieldset>
                      
                    </div>
                    <div id="reviewContent">
                    
                     		<input type="hidden" name="contractNo" value="<%=contractNo%>"/>
                     		<input type="hidden" name="coId" value="<%=coId%>"/>
                     	
                            <textarea rows="12" cols="52" style="resize:none;" placeholder="내용을 입력하세요" name="content"></textarea>
                            <br><br>
                            <input type="button" onclick="return reviewWrite();" id="complete" value="작성완료" class="btn rounded " style="border: 1px solid #0E76B3; color: #0E76B3;" />
                            <input type="button" id="list" value="목록" class="btn rounded " style="background-color:#0E76B3; color: white" onclick="location.replace('/review/review.do');" />
                            <input type="reset" id="clear" class="btn rounded " style="border: 1px solid #0E76B3; color: #0E76B3;" value="초기화" />
                     
                    </div>
                   </form> 
                </div>
            </div>
        </div>
        <div class="line"></div>
        
        <script>
		function reviewWrite() {
            
            if(confirm("리뷰를 등록하시겠습니까?")) {
                var frm = document.myform;
                    frm.action = "/review/reviewWrite.do";
                    
                    frm.submit();
                    return true;
            }
        };
        
        </script>
      
        
       
 
</body>
</html>