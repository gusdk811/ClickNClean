<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
 <link href="/assets/css/footer.css" rel="stylesheet" type="text/css"/>
 <link href="/assets/css/cleanType.css" rel="stylesheet" type="text/css"/>
 <link href="/assets/css/header.css" rel="stylesheet" type="text/css"/>

<style>

</style>

<body id="bodycss">

    <jsp:include page="/views/commons/header.jsp" />
    <div id="contentArea">
        <div class="contentHead">
            <div id="contentTitle">클릭N클린에 요청 할 수 있는 청소
                
            </div>
            <span class="cleanType" style="margin-left: 50px;"
            onclick="move('1')">입주청소 /</span>
            <span class="cleanType"  onclick="move('2')">이사청소 /</span>
            <span class="cleanType"  onclick="move('3')">부분청소</span>
        
        </div>
        <div id="content">
           <span class="typeName">입주청소란?</span>
            <div class=cleanTypeArea id="1">
                <div class="imgArea">
                    <img style="width: 100%; height: 100%; box-shadow: 0px 3px 6px rgb(0 0 0/ 16%);" src="/assets/img/%EC%9E%85%EC%A3%BC%EC%B2%AD%EC%86%8C.JPG"/>
                </div>
                <div class="textArea">
                    <span class="typeName">입주청소란?</span><br><br>
                    <span class="text">입주청소는 신축건물을 청소하는 상품으로 새로지어진 건물에 입주하여 들어가기전에 하는 청소를 의미합니다.</span>
                    
                </div>
            </div>
            <span class="typeName">이사청소란?</span>
            <div class=cleanTypeArea id="2">
                <div class="imgArea">
                    <img style="width: 100%; height: 100%; box-shadow: 0px 3px 6px rgb(0 0 0/ 16%);" src="/assets/img/이사청소.JPG"/>
                </div>
                <div class="textArea">
                     <span class="typeName">이사청소란?</span><br><br>
                     <span class="text">이사청소는 구축건물을 청소하는 상품으로 지어진지 어느정도 지난 건물에 입주하여 들어가기전에 하는 청소를 의미합니다.
                     
                     </span>
                </div>
            </div>
            <span class="typeName">부분청소란?</span>
            <div class=cleanTypeArea id="3">
                <div class="imgArea">
                    <img style="width: 100%; height: 100%; box-shadow: 0px 3px 6px rgb(0 0 0/ 16%);" src="/assets/img/부분청소1.JPG"/>
                </div>
                <div class="textArea">
                    <span class="typeName">부분청소란?</span><br><br>
                     <span class="text">부분청소는 건물의 한부분을 청소하는 상품으로 화장실,문틈,주방 등 어느 한부분을 정하여 하는 청소를 의미합니다.</span>
                </div>
            </div>
        
    </div>
    </div>
    <script>
        function move(seq){
            var offset=$('#'+seq).offset();
            $('html, body').animate({scrollTop : offset.top-200},400);
        }
    </script>
        <div id="footer">
            <div id="caution">
                <p>클릭N클린은 통신판매중개자로서 청소서비스의 주거래 당사자가 아니며, 청소서비스의 분쟁과 계약사항은 회원사와 당사자간에 있습니다.</p>
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
    
    
</body>
</html>