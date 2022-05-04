package com.instagram.gyeongun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "/index";
	}
	
	@RequestMapping(value="/auth/signin", method=RequestMethod.GET)
	public String signin() {
		return "/auth/signin";
	}
	
	@RequestMapping(value="/auth/signup", method=RequestMethod.GET)
	public String signup() {
		return "/auth/signup";
	}
	
	@RequestMapping(value="/profile/account", method=RequestMethod.GET)
	public String account() {
		return "/profile/account/account";
	}
	
	@RequestMapping(value="/profile/account/password", method=RequestMethod.GET)
	public String changePassword() {
		return "/profile/account/account_password";
	}
	
	@RequestMapping(value="/auth/find_password", method=RequestMethod.GET)
	public String findPassword() {
		return "/auth/find_password";
	}
	
}
