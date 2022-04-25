package com.instagram.app.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.domain.user.User;
import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;
import com.instagram.app.web.util.auth.AuthResponseScript;
import com.instagram.app.web.validation.auth.AuthValidation;

@Controller
public class AuthController {
	@Autowired
	private AuthService authService;
	
	
	@RequestMapping(value="/auth/signin", method=RequestMethod.POST)
	public String signinSubmit(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException {
		AuthValidation authValidation = new AuthValidation();
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username", username);
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password", password);
		if(usernameIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true), "UTF-8");
		}
		if(passwordIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true), "UTF-8");
		}
		
		User user = authService.signin(username, password);
		if(user != null) {
			//session
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
		}else {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode("로그인 정보를 확인해주세요", "UTF-8");
		}
		
		return "redirect: /app/";
	}
	
	@ResponseBody
	@RequestMapping(value="/auth/signup", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		boolean result = authService.signup(signupRequestDto);
		AuthResponseScript script = new AuthResponseScript();
		return script.signupScript(result);
	}
	
	@ResponseBody
	@RequestMapping(value ="/auth/username/check", method=RequestMethod.GET)
	public String usernameCheck(String username) {
		return Boolean.toString(authService.checkUsername(username));
	}
	
	@ResponseBody
	@RequestMapping(value="/auth/name/check", method=RequestMethod.GET)
	public String nameCheck(String name) {
		System.out.println(name);
		return Integer.toString(authService.checkName(name));
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String signout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect: /app/auth/signin";
	}
}
