<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<!--JQuery CDM-->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- css -->
<link href="/assets/css/memberJoin.css?afeter" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="wrap">
        <div id="header"></div>
        <div id="content">
            <div id="content_inner">
                <div id="join_form">
                    <div id="join_title">
                        <h2>회원가입</h2>
                        <span>필수입력사항</span><span class="ico">*</span>
                    </div>
                    <form action="/member/memberJoin.do" method="post" id=memberJoin>
	                    <table id="join_table">
	                   
	                        <tr>
	                            <th>아이디<span class="ico">*</span></th>
	                            <td>
	                                <input type="text" name="userId" class="input_txt" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합">
	                                <p class="txt_guide">
	                                 	<span id="idCheck1">* 최소 6~20자 입력</span><br>
	                                    <span id="idCheck2">* 영문으로 시작하여 영문 또는 숫자를 조합</span><br>
	                                    <span id="idCheck3">* 아이디 중복확인</span>
	                                </p>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>비밀번호<span class="ico">*</span></th>
	                            <td>
	                                <input type="password" name="userPwd" class="input_txt" placeholder="비밀번호를 입력해주세요">
	                                <p class="txt_guide">
	                                    <span id="pwCheck1">* 최소 8~16자 입력</span><br>
	                                    <span id="pwCheck2">* 영문/숫자/특수문자(공백 제외)를 하나 이상 포함하여 조합</span><br>
	                                </p>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>비밀번호확인<span class="ico">*</span></th>
	                            <td>
	                                <input type="password" name="userPwd_re" class="input_txt" placeholder="비밀번호를 한번 더 입력해주세요">
	                                <p class="txt_guide">
	                                    <span id="pwReCheck1">* 동일한 비밀번호를 입력해주세요</span>
	                                </p>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이름<span class="ico">*</span></th>
	                            <td>
	                                <input type="text" name="userName" class="input_txt" placeholder="이름을 입력해주세요">
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이메일<span class="ico">*</span></th>
	                            <td>
	                                <input type="email" name="email" class="input_txt" placeholder="예: clean@clicknclean.com">
	                                <input type="button" value="인증번호 받기" id='getCode'><input type="button" id="verification_number_btn" value="재발송" style='display: none'>
	                                <br>
	
	                                <div id="checkCode" style='display: none'>
	                                   <br>
	                                    <input type="text" placeholder="인증코드 10자리" id="verification_number" class="input_txt" name="verificationNumber">
	                                    
	                                    <input type="button" value="확인" id="send_text" class="input">
	                                    <input type="hidden" name="code1">
	                                    <input type="hidden" name="code">
	                                </div>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>휴대폰<span class="ico">*</span></th>
	                            <td>
	                                <input type="text" name="phone" class="input_txt" placeholder="숫자만 입력해주세요" numberOnly>
	                                <p class="txt_guide">
	                                    <span id="phoneCheck1">* 숫자만 입력</span><br>
	                                </p>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이용약관동의<span class="ico">*</span></th>
	                            <td>
	
	                                <label><input type='checkbox' class='check' id="checkAll"> 전체 동의합니다.</label><br>
	
	                                <label><input type='checkbox' class='check'> 이용약관 동의 <span class="ico">(필수)</span><a href="" class="check_agree">이용약관 보기></a></label><br>
	
	                                <label><input type='checkbox' class='check' > 개인정보 수집, 이용 동의 <span class="ico">(필수)</span><a href="" class="check_agree">이용약관 보기></a></label>
	                            </td>
	                        </tr>
	
	                    </table>
	                    <div id="form_submit">
	                        <input type="submit" value="가입하기">
	                    </div>
                    </form>
                    
                    
                    <script>
                    	<%-- 전체 체크--%>
                    	$('#checkAll').click(function(){
                    		
                    		
                    		if($(this).prop("checked")==true){
                    			$('.check').prop("checked",true);
                    			
                    		}else{
                    			$('.check').prop("checked",false);
                    			consol.log($('.check').prop("checked"));
                    		} 
                    	});
                    
                    	<%-- 이메일 인증 창 생성 및 인증 코드 보내기--%>
                    	$('#getCode').click(function(){
                    		var email = $('input[name=email]').val();
                        	if(email!=''){
                        		$(this).css('display','none');
                        		$('#verification_number_btn').css('display','inline-block');
                        		$('#checkCode').css('display','block');
                        		sendEmail();	
                        	}else{
                        		alert('이메일을 입력해 주세요.');
                        	}
                    	});
                    	
                    	$('#verification_number_btn').click(function(){
                    		sendEmail();
                    	});
                    
                        <%--  인증 코드 메일로 보내는 로직 실행  --%>
                        function sendEmail() {
                        	
                        	var email = $('input[name=email]').val();
                        	if(email!=''){
                        		$.ajax({
                                 	url: "/member/memberCompanySendEmailCode.do",
                                 	type:"post",
                                 	data: {"email":email},
                                 	success: function(data){
                                 		if(data!="null"){
                                 			$('input[name=code1]').val(data);
                                            alert('인증코드를 이메일로 보냈습니다.');
                                 			
                                 		}else{
                                 			alert('이메일 발송에 실패하였습니다.\r\n지속적인 문제 발생시 관리자에게 문의해주세요.');
                                 		}
                                 	},
                                 	error: function(){
                                 		console.log('ajax 통신 실패');
                                 	}
                                 	
                                 }) 
                        	}else{
                        		alert('이메일을 입력해 주세요.');
                        	}
                            
                        };
                        
                        <%-- 인증 코드 일치 여부 확인--%>               
                        $('#send_text').click(function(){
                        	var code=$('input[name=code1]').val();
	                    	var verificationNumber=$('#verification_number').val();
	                        if (code!=verificationNumber) {
	                        	alert('인증코드가 일치하지 않습니다.');
	                        }else{
	                        	alert('이메일 본인 인증이 되었습니다.');
	                        	$('input[name=code]').val(verificationNumber);
	                        }
                        });
                    
                    
                    
                    
                        <%-- 작성 가이드 오픈--%>
                    	$('.input_txt').focus(function(){
                    		
                    		$.each($(this),function(index,item){
                    			$.each($(item).siblings(),function(index,item){
                    				if($(item).attr('class')=='txt_guide'){
                    					$(this).css('display','block');
                    				}
                    			});
                    		});
                    		
                    	});
 					
                    	
                    	<%-- ID 유효성 검사 --%>
                    	$('input[name=userId]').keyup(function(){
                    		
                    		var data=$(this).val();
                    		
                    		<%--중복--%>
                    		$.ajax({
                    			url:"/member/checkDuplicateId.do",
                    			type:"post",
                    			data:{"data":data},
                    			success:function(result){
                    				if(result=='false'||result==""){
                    					$('#idCheck3').css('color','#0f851a');
                    				}else{
                    					$('#idCheck3').css('color','#b3130b');
                    				}
                    			},
                    			error:function(){
                    				
                    			}
                    		})
                    		
                    		<%--조합--%>
                    		var check=RegExp( /^[a-z]+[a-z0-9]{5,19}$/g);
                    		
                    		if(check.test(data)){
                    			$('#idCheck2').css('color','#0f851a');
                    			
                    			
                    		}else{
                    			$('#idCheck2').css('color','#b3130b');
                    			
                    		}
                    		
                    		<%--길이--%>
                    		if(data.length>=6 && data.length<=20){
                    			$('#idCheck1').css('color','#0f851a');
                    		}else{
                    			$('#idCheck1').css('color','#b3130b');
                    		}
                    		
                    		
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
                    	$('input[name=userPwd_re]').keyup(function(){
                    		var data=$(this).val();
                    		var pwd=$('input[name=userPwd]').val();
                    		
                    		if(data==pwd){
                    			$('#pwReCheck1').css('color','#0f851a');
                    		}else{
                    			$('#pwReCheck1').css('color','#b3130b');
                    		}
                    	});
                    	
                    	
                    	<%-- PHONE 숫자만 입력 가능 --%>
                    	$('input[name=phone]').keyup(function(){
                    		var data=$(this).val();
							var check=RegExp(/^01[0179][0-9]{7,8}$/);
                    		
                    		if(check.test(data)){
                    			$('#phoneCheck1').css('color','#0f851a');
                    			
                    			
                    		}else{
                    			$('#phoneCheck1').css('color','#b3130b');
                    			
                    		}
                    	});
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	<%-- 가입 전 전체 유효성 검사 --%>
                    	$('#memberJoin').submit(function(){
                    		
                    		
                    		
                    		var userId = $('input[name=userId]').val();
                    		var userPwd = $('input[name=userPwd]').val();
                    		var userPwd_re = $('input[name=userPwd_re]').val();
                    		var userName = $('input[name=userName]').val();
                    		var email = $('input[name=email]').val();
                    		var phone = $('input[name=phone]').val();
                    		var code=$('input[name=code]').val();
	                    	var verificationNumber=$('input[name=verificationNumber]').val();
                    		
	                    	
	                    	<%--공백--%>
                    		if(userId==""){
                    			alert('아이디를 입력해주세요.');
                    			return false;
                    		}
                    		if(userPwd==""){
                    			alert('비밀번호를 입력해주세요.');
                    			return false;
                    		}
                    		if(userPwd_re==""){
                    			alert('비밀번호를 한번 더 입력해주세요.');
                    			return false;
                    		}
                    		if(userName==""){
                    			alert('이름을 입력해주세요.');
                    			return false;
                    		}
                    		if(email==""){
                    			alert('이메일을 입력해주세요.');
                    			return false;
                    		}
                    		if(phone==""){
                    			alert('휴대폰 번호를 입력해주세요.');
                    			return false;
                    		}
                    		
                    		<%--아이디--%>
                    		$.ajax({
                    			url:"/member/checkDuplicateId.do",
                    			type:"post",
                    			data:{"data":userId},
                    			success:function(result){
                    				if(result=='true'){
                    					alert('아이디를 양식에 맞게 작성해주세요.');
                    					return false
                    				}
                    			},
                    			error:function(){
                    				
                    			}
                    		})
                    		
                    		var userIdCheck=RegExp( /^[a-z]+[a-z0-9]{5,19}$/g);
                    		
                    		if(!(userIdCheck.test(userId))){
                    			alert('아이디를 양식에 맞게 작성해주세요.');
                    			return false;
                    			
                    		}
                    		
                    		if(userId.length<=5 || userId.length>=20){
                    			alert('아이디를 양식에 맞게 작성해주세요.');
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
                    		if(userPwd!=userPwd_re){
                    			alert('비밀번호가 일치하지 않습니다.');
                    			return false;
                    		}
                    		
                    		<%--이메일--%>
                    		if(code=='' || verificationNumber==''){
                    			alert('이메일 인증을 해주세요.');
	                        	return false;
                    		}
                    		
                    		if(code!=verificationNumber){
                    			alert('이메일 인증을 해주세요.');
	                        	return false;
                    		}
                    		
                    		
                    		
                    		<%--핸드폰--%>
							var phoneCheck=RegExp(/^01[0179][0-9]{7,8}$/);
                    		
                    		if(!phoneCheck.test(phone)){
                    			alert('핸드폰 번호를 양식에 맞게 작성해주세요.');
                    			return false;
                    			
                    		}
                    		
                    		var result ='false';
                    		<%--이용약관--%>
							$.each($('input:checkbox'),function(index,item){
                				
                				if($(item).prop('checked')==false){
                					alert('이용약관에 동의 해주세요.');
                					result='false';
                					return false;
                				}else{
                					result='true';
                				}
                			});
							
							if(result=='false'){
								return false;
							}
                    		
                    		return true;
                    	});
                    	
                    
                    </script>
                </div>
            </div>
        </div>
        <div id="footer"></div>

    </div>
</body>
</html>