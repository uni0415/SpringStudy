package com.instagram.app.web.util.auth;

public class AuthResponseScript {
	public String signupScript(boolean result) {
		StringBuilder script = new StringBuilder();
		if(result) {
			script.append("<script>");
			script.append("alert(\"회원가입 완료.\");");
			//href: history를 가지고 있어서 정보를 가지고 뒤로가기가 가능
			//replace: redirect와 같이 새창으로 로드
			script.append("location.replace(\"/app/auth/signin\");");
			script.append("</script>");
		}else {
			script.append("<script>");
			script.append("alert(\"회원가입 실패.\");");
			script.append("history.back();");
			script.append("</script>");
		}
		return script.toString();
	}
	
	public String signinValidScript(String msg) {
		StringBuilder script = new StringBuilder();
			script.append("<script>");
			script.append("alert(\""+ msg +"\");");
			//href: history를 가지고 있어서 정보를 가지고 뒤로가기가 가능
			//replace: redirect와 같이 새창으로 로드
			script.append("location.replace(\"/app/auth/signin\");");
			script.append("</script>");
			
			return script.toString();
	}
}
