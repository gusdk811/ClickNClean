<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
	<!--bootstap-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<!--JQuery CDM-->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<!--아이콘-->
	<script src="https://kit.fontawesome.com/edadbd266e.js" crossorigin="anonymous"></script>
	<!-- css -->
 	<link href="/assets/css/loginMemberCompany.css" rel="stylesheet" type="text/css" />
</head>
<body>
 
    <div id="wrap">
        <div id="header">

        </div>

        <div id="content">
            <div id="content_inner">
                <div id="login_form">
                    <h2>로그인</h2>
                    <ul>
                        <li class="ur">개인 회원</li>
                        <li class="co">사업자 회원 </li>
                    </ul>
                    <div id="input_form">
                       
                       <!--개인 회원 로그인-->
                        <form action="/member/loginMember.do" method="post" id="input_form_center_type1">
                        
                            <input type="text" name="userId" class="input" placeholder="아이디를 입력해주세요."/><br><br>
                            <input type="password" name="userPwd" class="input" placeholder="비밀번호를 입력해주세요."/><br>
                            <div id="checkbox_search">
                                <div id="checkbox">
                                    <input type="checkbox" name="secureConnect" id="cb1"> <label for="cb1">보안접속</label>
                                </div>
                                <div id="login_search">
                                    <a href="/views/member/MemberCompanyFindId.jsp">아이디 찾기</a><span> | </span><a href="/views/member/MemberCompanyFindPwd.jsp">비밀번호 찾기</a>
                                </div>
                            </div>
                            <input type="submit" value="로그인" class="input"><br><br>
                            <input type="button" value="회원가입" class="input">
                            
                        </form>
                        
                        <!--사업자 회원 로그인-->
                        <form action="/company/loginCompany.do" method="post" id="input_form_center_type2" style="display: none;">
                            
                            <input type="text" name="coId" class="input" placeholder="아이디를 입력해주세요."><br><br>
                            <input type="password" name="coPwd" class="input" placeholder="비밀번호를 입력해주세요."><br>
                            <div id="checkbox_search">
                                <div id="checkbox">
                                    <input type="checkbox" name="secureConnect" id="cb2"> <label for="cb2">보안접속</label>
                                </div>
                                <div id="login_search">
                                    <a href="/views/member/MemberCompanyFindId.jsp">아이디 찾기</a><span> | </span><a href="/views/member/MemberCompanyFindPwd.jsp">비밀번호 찾기</a>
                                </div>
                            </div>
                            <input type="submit" value="로그인" class="input"><br><br>
                            <input type="button" value="입점신청" class="input" >
                        </form>
                        

                        <script>
                            $('.ur').click(function() {
                                $(this).attr('class', 'ur');
                                $(this).next().attr('class', 'co');
                                $('#input_form_center_type2').css('display', 'none');
                                $('#input_form_center_type1').css('display', 'block');
                            });

                            $('.co').click(function() {
                                $(this).attr('class', 'ur');
                                $(this).prev().attr('class', 'co');
                                $('#input_form_center_type1').css('display', 'none');
                                $('#input_form_center_type2').css('display', 'block');
                            });
                            
                            $('input[value=회원가입]').click(function(){
                            	location.replace('/views/member/memberJoin.jsp');
                            });
                            $('input[value=입점신청]').click(function(){
                            	location.replace('/views/company/companyJoin.jsp');
                            });
                        </script>

                    </div>
                </div>
            </div>
        </div>

        <div id="footer">

        </div>

    </div>

</body>
</html>