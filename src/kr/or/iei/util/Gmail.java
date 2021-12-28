package kr.or.iei.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		
		// 메일을 보내는 자신의 계정 입력
		return new PasswordAuthentication("kshlove735","Kkjj159159!!");
	}
	
	
}
