<%@page import="kr.or.iei.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>게시글</title>

    <link rel="stylesheet" href="/assets/css/theme.min.css">
    <link rel="stylesheet" href="/assets/css/docs.min.css">
<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
</head>
<body>
   <%
       Board board = (Board)request.getAttribute("board");
       int currentPage = (int)request.getAttribute("currentPage");
       
    %>

   <section class="pagination justify-content-center">
        <div style=" width: 50%; margin-top: 2%;">
            <div class="pagination justify-content-center display-4 ">
                <p style="text-decoration-line: underline; color: #555">공지사항</p>
            </div>

            <div class="container content-space-2 content-space-b-lg-3">
                <div class="w-lg-75 mx-auto">
                  

                    <div class="card card-lg">
                    <%if(board!=null){ %>
                        <div class="card-body">

                            <div class="row justify-content-sm-between align-items-sm-center mb-5">
                                <div class="col-sm mb-3 mb-sm-0">
                                    <h1 class="card-title h2"><%=board.getSubject() %></h1>
                                    <p class="card-text">작성일 : <%=board.getRegDate() %></p>
                                    <p class="card-text">작성자 : <%=board.getWriter() %></p>
                                </div>

                                <div class="col-sm-auto">
                                </div>
                            </div>

                            <div class="mb-5">
                                <p><%=board.getContent() %></p>
                            </div>
                            <form action="/board/boardView.do" method="post" id="textUpdateForm">
                            <textarea rows="20" cols="50" name="content" disabled='true' style='resize:none;' id="contentArea"><%=board.getContent() %></textarea><br>
                            <input type="hidden" name="boardNo" value="<%=board.getBoardNo() %>"/>
                            <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
                            </form>

                        </div>
                         <%}else{ %>
                           <div class="mb-5">
                              <a class="link" href="/board/boardAllSelect.do?currentPage=<%=currentPage%>">
                            <i class="bi-chevron-left small ms-1"></i> 목록으로
                              </a>
                           </div>
           
                          <%} %>
                    </div>
                    <button class="btn btn-light">수정하기</button>
                    <button class="btn btn-light">삭제하기</button>

                </div>


            </div>                       
        </div>
    </section>
</body>
</html>