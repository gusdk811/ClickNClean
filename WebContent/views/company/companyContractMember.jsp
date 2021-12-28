<%@page import="kr.or.iei.contract.model.vo.Contract"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/cheader.css">
<link rel="stylesheet" href="/assets/css/companyContractMember.css">

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    

    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

 <style>
 		 
    </style>
</head>
<body>
	<%
		HashMap<String, Object> pageDataMap = (HashMap<String, Object>)request.getAttribute("pageDataMap");
		ArrayList<Contract> list = (ArrayList<Contract>)pageDataMap.get("list");
		String pageNavi = (String)pageDataMap.get("pageNavi");
		int currentPage = (int)request.getAttribute("currentPage");
		String memberKey = (String)request.getAttribute("memberKey");
		
	%>
 
 
 <jsp:include page="/views/company/cheader.jsp" />
<div id="allArea">

        
        <div id="content">
            <div id="left-content"></div>
            <div id="center-content">
                <div id="center-content-top"></div>
                <div id="center-content-bottom">
                    <span><B>회원정보</B></span>
                    <br>
                    <hr>
                    <div id="memberInfo">
                        <div id="MemberSearch">
                            <form action="/co/coMemberSearch.do" method="get">
                                <span>회원검색 : </span>
                                <select name="searchType" style="height: 30px">
                                    <option value="contractNo">계약번호</option>
                                    <option value="userId">ID</option>
                                    <option value="phone">전화번호</option>
                                </select>

                                <input type="text" size="30" name="memberKey" placeholder="회원 정보를 입력해주세요." />
                                <input type="submit" value="검색" class="btn btn-primary"/>
                            </form>
                        </div>
                        <div id="infoArea">
                            <%if(!list.isEmpty()){ %>
                            <table id="searchT">
                                <tr>
                                    <th>계약번호</th>
                                    <th>청소분류</th>
                                    <th>이름</th>
                                    <th>ID</th>
                                    <th>전화번호</th>
                                    <th>이메일</th>
                                    <th>예약일</th>
                                    <th>청소예약날짜</th>
                                    <th>청소여부</th>
                                </tr>
                                <%for (Contract c : list){ %>
                                <tr>
                                    <td><%=c.getContractNo() %></td>
									<td><%=c.getCleanType() %></td>
									<td><%=c.getUserName() %></td>
									<td><%=c.getUserId() %></td>
									<td><%=c.getPhone() %></td>
									<td><%=c.getEmail() %></td>
									<td><%=c.getContractFinDate() %></td>
									<td><%=c.getReqDate() %></td>
                                    <td><%=c.getCleanYN() %></td>  
                                </tr>
                                <%} %>
                                <tr>
                                <td colspan="9" align = "center"><%=pageNavi %></td>
                            	</tr>
                            </table>
                            <%}else{%>
                            <h3>현재 회원 목록이 없습니다.</h3>
                            <%} %>
                        </div>
                    </div>
                    <hr>

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
    <link rel="stylesheet" href="/assets/css/footer.css">
</body>
</html>