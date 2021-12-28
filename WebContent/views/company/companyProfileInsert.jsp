<%@page import="kr.or.iei.company.model.vo.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    
  <link rel="stylesheet" href="/assets/css/cheader.css">
  <link rel="stylesheet" href="/assets/css/companyProfileUpdate.css">
  <link rel="stylesheet" href="/assets/css/footer.css">
   <!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    

    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    
</head>

<body>
	<%
		Company co = (Company)session.getAttribute("company");
	%>

<jsp:include page="/views/company/cheader.jsp" />
    <div id="allArea">

        
        <div id="content">
            <div id="left-content"></div>
            <div id="center-content">
                <div id="center-content-top"></div>
                <form  action="/co/coProfileInsert.do" method="post">
                    <div id="center-content-bottom">
                        <%if(co != null) {%>
                        <span><B>프로필 설정</B></span>
                        <hr>
                        <table id="t1">
                            <tr>
                                <td>
                                    <div>프로필 사진</div>
                                </td>
                                <td colspan="3">
                                    <div id="coImg"></div>
                                    <div>
                                        <input type="file" class="form-control" id="inputImg" style="width: 25%">
                                        <input type="hidden">
                                        <label>사진 선택</label>
                                        <p>
                                            320px 이상 <br> 정사각형 이미지 <br>
                                          	  확장자 jpg, png 가능
                                        </p>
                                    </div>
                                </td>
                            </tr>
                        </table>

                        <hr>
                        <table id="t2">
                            <tr>
                                <td>
                                    <div>업체명</div>
                                </td>
                                <td style="text-align:center;">
                                    <div > <%=co.getCoName() %></div>
                                </td>
                                <td>청소지역</td>
                                <td>
                                    <div class="area1" style="margin:10px;">
                                        <select name="area1"  onchange="categoryChange(this)">
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
                                        <select name="area2" id="state">
                                            <option>군/구 선택</option>
                                        </select>

                                    </div>
                                </td>
                            </tr>
                        </table>

                        <hr>
                        <table id="t3">
                            <tr>
                                <td>
                                    <div>소개</div>
                                </td>
                                <td colspan="3">
                                    <div class="area1">
                                        <textarea id="text" name="coIntroduce" cols="90" rows="11" maxlength="499" style="resize: none; font-size: 1rem;" placeholder="업체를 자랑해주세요."></textarea><br>
                                        <span id="textLength">0</span>/500
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <hr>
                        <br><br>
                        <span><b>청소분야</b></span><br>
                        <hr>
                        <input class="form-check-input" type="checkbox" name="cleanType" value="입주" /> 입주청소 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="form-check-input" type="checkbox" name="cleanType" value="이사" /> 이사청소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="form-check-input" type="checkbox" name="cleanType" value="부분청소" /> 부분청소(화장실/거실/주방/베란다) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <hr>
                        <br><br>
                        
                        
                        <div id="history">
                        <span><b>History</b></span>
                        <hr>
                        <textarea name="history" cols="50" rows="7" maxlength="499" name="history" style="resize: none; font-size: 1rem;" placeholder="경력사항을 작성해주세요. ex)0000년 우수방역업체 선정."></textarea>
                        <hr>
						</div>
						
						<div id="grade">
						    <span>등급결제</span>
						    <hr>
						    <input class="gradeChoice" type="checkbox" name="gradeType" value="choiceNo" checked="checked" /> 선택안함
						    <input class="gradeChoice" type="checkbox" name="gradeType" value="gold" /> gold (25,000원)
						    <input class="gradeChoice" type="checkbox" name="gradeType" value="vip" /> vip  (35,000원)
   						    <hr>
   						 	<span>영업시간, 상담시간 설정</span><br>
   						 	<hr>
							영업시간 : <input type="time" name="startTime"/><input type="time" name="endTime"/><br>
							상담시간 : <input type="time" name="startMeetTime"/><input type="time" name="endMeetTime"/>
							<hr>
						</div>
						
						<div id="checkArea">
						<input type="submit" id="submitBtn" value="회원정보 변경"/><input type="button" id="main" value="메인페이지" onclick="location.replace('/');"/> 
						  </div>

                    </div>
                </form>
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
    
	<%}else{ %>
		<a href="/views/commons/error.jsp"></a>
		
	<%} %>
	
       <script src="/assets/js/companyProfileUpdateScript.js"></script>
       

</body></html>

