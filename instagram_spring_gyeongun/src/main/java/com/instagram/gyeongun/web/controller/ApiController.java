package com.instagram.gyeongun.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.gyeongun.auth.PrincipalService;
import com.instagram.gyeongun.config.FileConfig;
import com.instagram.gyeongun.domain.user.User;

@Controller
public class ApiController {
	@Autowired
	private PrincipalService principalService;

	@ResponseBody
	@RequestMapping(value="/api/principal", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public User getPrincipal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (User)session.getAttribute("principal");
	}
	
	@ResponseBody
	@RequestMapping(value="/api/profile/img", method=RequestMethod.GET)
	public String getProfileImg(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "/gyeongun/static/fileupload/" + principalService.getProfileImg(((User)session.getAttribute("principal")).getUsercode()).getImg_url();
	}
}
