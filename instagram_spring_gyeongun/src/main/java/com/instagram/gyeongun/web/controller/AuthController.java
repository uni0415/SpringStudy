package com.instagram.gyeongun.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.service.AuthService;
import com.instagram.gyeongun.web.dto.auth.SignupRequestDto;

@Controller
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@ResponseBody
	@RequestMapping(value="/auth/signup", method=RequestMethod.POST)
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		if(authService.signup(signupRequestDto)) {
			return "true";
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/auth/username/check", method=RequestMethod.GET)
	public String checkUsername(String username) {
		return Boolean.toString(authService.checkUsername(username)); 
	}
	
	@RequestMapping(value="/auth/signin", method=RequestMethod.POST)
	public String signin(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException {
		User user = authService.signin(username, password);
		if(user!=null) {
			request.getSession().setAttribute("principal", user);
			
		}else {
			return "redirect: /gyeongun/auth/signin/error?msg=" + URLEncoder.encode("로그인 정보를 확인해주세요", "UTF-8");
		}
		return "redirect: /gyeongun/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String signout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect: /gyeongun/auth/signin";
	}
	
	
}
