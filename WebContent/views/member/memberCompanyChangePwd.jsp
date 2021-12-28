<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 재설정</title>
<!--JQuery CDM-->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- css -->
<link href="/assets/css/memberCompanyChangePwd.css?afeter" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="wrap">
        <div id="header">

        </div>

        <div id="content">
            <div id="content_inner">
                <div id="ChangPwd_form">
                    <h2>비밀번호 재설정</h2>
                    
                    <div id="input_form">
                     	<div id="input_form_center_type1">
                       <!--  <form action="" method="post" id="input_form_center_type1"> -->
                            <input type="password" name="userPwd" class="input" placeholder="새 비밀번호를 입력해주세요.">
                            <p class="txt_guide">
	                        	<span id="pwCheck1">* 최소 8~16자 입력</span><br>
	                            <span id="pwCheck2">* 영문/숫자/특수문자(공백 제외)를 하나 이상 포함하여 조합</span><br>
	                        </p>
                            
                            <br>
                            
                            <input type="password" name="userPwdRe" class="input" placeholder="새 비밀번호를 한 번 더 입력해주세요.">
                            <p class="txt_guide"  >
                            		<span id="pwReCheck1">* 동일한 비밀번호를 입력해주세요.</span>
                            </p>
                            <br>
							<input type="hidden" name="roll" value="${requestScope.roll }">
							<input type="hidden" name="userId" value="${requestScope.userId }">
                            <input type="submit" value="확인" class="input"><br><br>
                            
                            
                        <!-- </form> -->
                       </div>
                       <script>
                       
		                       <%-- 작성 가이드 오픈--%>
		                   	$('.input').focus(function(){
		                   		
		                   		$(this).next().css('display','block');
		                   		
		                   	});
                       
                       
                       
                       
	                       		<%-- PWD 유효성 검사 --%>
	                   		$('input[name=userPwd]').keyup(function(){
	                   		
	                   		var data=$(this).val();
	                   		
	                   		<%--길이--%>
	                   		if(data.length>=8 && data.length<=16){
	                   			$('#pwCheck1').css('color','#0f851a');
	                   		}else{
	                   			$('#pwCheck1').css('color','#b3130b');
	                   		}
	                   		
	                   		<%--조합--%>
	                   		var check=RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/);
	                   		
	                   		if(check.test(data)){
	                   			$('#pwCheck2').css('color','#0f851a');
	                   			
	                   			
	                   		}else{
	                   			$('#pwCheck2').css('color','#b3130b');
	                   			
	                   		}
	                   		
	                   		
	                   	});
	                   	
	                   	<%-- PWD PWD_RE 동일 유효성 검사 --%>
	                   	$('input[name=userPwdRe]').keyup(function(){
	                   		var data=$(this).val();
	                   		var pwd=$('input[name=userPwd]').val();
	                   		
	                   		if(data==pwd){
	                   			$('#pwReCheck1').css('color','#0f851a');
	                   		}else{
	                   			$('#pwReCheck1').css('color','#b3130b');
	                   		}
	                   	});
	                       
	                    
                       
                       	$('input[type=submit]').click(function(){
                       		var userPwd=$('input[name=userPwd]').val();
                       		var userPwdRe=$('input[name=userPwdRe]').val()
                       		var roll=$('input[name=roll]').val();
                       		var userId=$('input[name=userId]').val();

                       		
                       		if(userPwd==""){
                    			alert('비밀번호를 입력해주세요.');
                    			return false;
                    		}
                    		if(userPwdRe==""){
                    			alert('비밀번호를 한번 더 입력해주세요.');
                    			return false;
                    		}
                       		
                    		<%--비밀번호 재확인--%>
                    		if(userPwd.length<=8 || userPwd.length>=16){
                    			alert('비밀번호를 양식에 맞게 작성해주세요.');
                    			return false;
                    		}
                       		
							var userPwdcheck=RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/);
                    		
                    		if(!userPwdcheck.test(userPwd)){
                    			alert('비밀번호를 양식에 맞게 작성해주세요.');
                    			return false;
                    			
                    		}
                    		
                    		<%--비밀번호 재확인--%>
                    		if(userPwd!=userPwdRe){
                    			alert('비밀번호가 일치하지 않습니다.');
                    			return false;
                    		}else{
                    		
                       			var changePwd={"userPwd":userPwd, "roll":roll,"userId":userId};
                           		
	                           	$.ajax({
	                           		url:"/member/memeberCompanyChangePwd.do",
	                           		type:"post",
	                           		data: changePwd,
	                           		success: function(data){
	                           			console.log(data)
	                           			if(data=='true'){
	                           				alert('비밀번호가 변경 되었습니다.');
	                           				location.replace('/views/member/loginMemberCompany.jsp');
	                           			}else{
											location.replace('/views/commons/error.jsp');                           				
	                           			}
	                           		},
	                          		error: function(){
	                        		console.log('ajax 통신 실패');
	                           		}
	                     
	                           			
	                           	});
                       		}
                       		
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