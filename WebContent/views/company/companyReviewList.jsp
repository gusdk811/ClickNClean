<%@page import="kr.or.iei.review.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/assets/css/cheader.css">
<link rel="stylesheet" href="/assets/css/companyReviewList.css">
<link rel="stylesheet" href="/assets/css/footer.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src=https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
   
   
</head>
<body>

	<%
		HashMap<String, Object> pageDataMap = (HashMap<String, Object>)request.getAttribute("pageDataMap");
		ArrayList<Review> list = (ArrayList<Review>)pageDataMap.get("list");
		String pageNavi = (String)pageDataMap.get("pageNavi");
		int currentPage = (int)request.getAttribute("currentPage");
	%>


	<div id="allScreen">
  </div>
  
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
                   
                   <span><b>고객<small>의</small>소리</b></span>
                   <br><br>
                   <hr> 
                    <br><br>
                    <div id="reviewContent">
                    
                    <%if(!list.isEmpty()) {%>
                    
                    	<table id="reviewT">
	                    	
                    	<%for(int i =0; i <list.size(); i++){ %>
		                    <tr>
		                    	<td class="openCommentArea">
		                    	
			                    	<fieldset class="reviewArea" style="cursor: pointer" >
			                        <legend id="legendText"> <%=list.get(i).getUserName() %>-<%=list.get(i).getRegDate() %></legend><br>
			                            <div id="inReviewArea"><span id="cleanText"><%=list.get(i).getCleanType() %></span></div>
			                            <div id="inReviewArea"><span id="areaText"><%=list.get(i).getArea() %></span></div><br>
			                            <div id="reviewText">
			                            <a name="reviewContent" id="contentText" ><%=list.get(i).getContent() %></a>
			                            </div><br>
			                   		 </fieldset><br>
			                   	
		                    	</td>
		                    	
			                    	
			                 </tr>
		                
		                
		                <div id="reviewClickpopUp">
		                  <div id="popupTop"><span id="popupName"> </span>
		                       <div id="closeBtn" style="cursor: pointer">
		                           <button type="button" class="btn-close" id="close"><b>X</b></button>
		                       </div>
		                   </div>
		                   <br>
		                   <div>
		                      <div style="text-align: center; font-size: 15px"><p id="popupCleanType"> </p>   <span id="popupArea"></span> </div><br>                     
		                           <div id="popupContent">
		                           
		                       </div>
		                   </div>
		                   <br>
		                   <div style="margin-left: 50px">
		                       <form action="" method="post">
		                           <textarea name="" cols="48" rows="6" style="float: left; resize: none" ></textarea>
		                           <button type="submit" style="width: 55px; height: 90px; float: left" >댓글작성</button>
		                       </form>
		                   
		               				</div>
		              			 <br><br><br><br><br><br>
           			</div> 
                    	<%} %>
                    		<tr>
                                <td style="text-align:center;"><%=pageNavi %></td>
                           	</tr>
	                   			
	                  </table> 		
                    <%} else{%>
                    	<h1>현재 고객의 소리가 없습니다.</h1>
                    <%} %>
  
                   </div>   
                </div>
            </div>
            <div id="rigth-content"></div>
        </div>
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

    </div>
    
     <script src="/assets/js/companyReviewList.js"></script>
     
</body>
</html>