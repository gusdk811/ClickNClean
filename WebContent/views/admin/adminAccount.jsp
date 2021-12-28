<%@page import="kr.or.iei.admin.model.vo.HeadOffice"%>
<%@page import="kr.or.iei.admin.model.vo.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <!-- Title -->
    <title>관리자 정보</title>
<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
    <!-- CSS Front Template -->
    <link rel="stylesheet" href="/assets/css/theme.min.css">
    <link rel="stylesheet" href="/assets/css/docs.min.css">
</head>
<body>
     <%
         ArrayList<Admin> list = (ArrayList<Admin>)request.getAttribute("list");   
     %>
<style>
    * {
        box-sizing: border-box;
        font-family: 'NanumSquare';
        
    }
    
    #wrap {

        width: 1344px;
        margin: 0 auto;
        
    }
            /*헤더 부분 */
        #header{
            width: 100%;
            height: 70px;
        }
         #logo{
            width: 300px;
            height: 100%;
            border: 1px solid black;
            display: inline-block;
            float: left;
            left: 100px;
        }
         
        #menu{
            width: 160px;
            height: 100%;
            display: inline-block;
            float: left;
            border: 1px solid black;
        }
        #adminpage{
             width: 1344px;
            height: 120px;
             margin: 0 auto;
           
        }
         #adminpageFont{
            position: relative;
            font-size : 35px;
            top : 38px;
            left: 580px;
            color: #555;
        }
        /* 메뉴 바 */
           #navigator {
            height: 67px;
            width : 1344px;
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
            width: 20%;
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

        .line{
            width: 1344px;
            height: 6px;
            background-color: #0E76B3;
            margin : 0 auto;
        }
    
    #memberlistsub{
        text-align: center;
        font-size: 30px;
        height: 50px;
        padding: 60px;
 
    }
    
    #change{
        text-align: right;
        padding: 15px;
    }
    #btn1{
        position: absolute;
        top: 344px;
        left: 1220px;
    }
    
    #btn2{
        position: absolute;
        top: 720px;
        left: 1220px;
    }
    
    #table{
        width: 900px;
        margin:auto;
        padding :30px;
    }
    
    /*footer*/
    #footer {
      
        width: 100%;
        height: 302px;
        background-color: #E6E6E6;
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

    #footer_inner {
        padding-top: 20px;

        width: 100%;
        height: 232px;
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

</style>
<body>
    
    
    <div id="wrap">
    
	<div id="header">
            <div id="logo">
          </div>
        </div>
         
          <div id="adminpage">
            <span id="adminpageFont">관리자 페이지</span>
            </div>    
               <div id="submenu">
                    <div id="navigator">
                        <ul id="gnb">
                            <li><a href="">Home</a></li>
                            <li><a href="/admin/adminAccount.do">관리자 계정</a></li>
                            <li><a href="/admin/companyAllList.do">전체 업체 LIST</a></li>
                            <li><a href="/admin/memberAllList.do">전체 회원 LIST</a></li>
                            <li><a href="/board/memberNotice.do">게시판 관리</a>
                            
                        </ul>
            </div>
         </div> 
         <div class="line"></div>

           <div style=" width: 100%;">
               <!--관리자 정보-->
                <div id= "memberlistsub">
                    <p>관리자 정보</p>
                </div>
               
                </div>
                
                
                <div id = "table">
                <%if(!list.isEmpty()){ %>
                <table class="table table-text-center">
                    <thead>
                        <tr>
                            <th style="width: 8%;">번호</th>
                            <th style="width: 15%;">이름</th>
                            <th style="width: 15%;">아이디</th>
                            <th style="width: 20%;">전화번호</th>
                            <th style="width: 20%;">휴대폰번호</th>
                            <th style="width: 22%;">이메일주소</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(Admin ad : list){ %>
                        <tr>
                            <th><%=ad.getAdminNo() %></th>
                            <td><%=ad.getAdminName() %></td>
                            <td><%=ad.getAdminId() %></td>
                            <td><%=ad.getTel() %></td>
                            <td><%=ad.getPhone() %></td>
                            <td><%=ad.getEmail() %></td>
                        </tr>
                    </tbody>
                    <%} %>
                </table>
                <%} %>
                </div>
                    
                    
                
            
            <!--footer-->
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
</body>

</html>