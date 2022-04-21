package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
	public String signin() {
		return "auth/signin";
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String signup() {
		return "auth/signup";
	}
	
	@ResponseBody
	@RequestMapping(value="/auth/signin/data", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String signinData() {
		return "일반 텍스트 데이터를 응답합니다.";
	}
}
