package com.instagram.gyeongun.web.util.auth;

public class AuthResponseScript {
	public String signinValidScript(String msg) {
		StringBuilder builder = new StringBuilder();
		builder.append("<script>");
		builder.append("alert(\""+msg+"\");");
		builder.append("location.replace(\"/gyeongun/auth/signin\");");
		builder.append("</script>");
		return builder.toString();
	}
}
