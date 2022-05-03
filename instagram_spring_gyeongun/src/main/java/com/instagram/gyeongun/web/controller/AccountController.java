package com.instagram.gyeongun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.gyeongun.auth.PrincipalService;
import com.instagram.gyeongun.service.ProfileService;
import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;

@Controller
public class AccountController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private PrincipalService principalService;
	
	
	@ResponseBody
	@RequestMapping(value="/profile/account/user", method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public AccountResponseDto getProfile(int usercode) {
		return profileService.getProfile(usercode);
	}
	
	@ResponseBody
	@RequestMapping(value="/profile/account/update", method=RequestMethod.PUT, produces="application/json;charset=utf-8")
	public String updateAccount(@RequestBody AccountUpdateReqDto accountUpdateReqDto, HttpServletRequest request) {
		boolean result = profileService.updateProfile(accountUpdateReqDto);
		if(result == true) {
			request.getSession().setAttribute("principal", principalService.getUserByUsername(accountUpdateReqDto.getUsername()));
		}
		return Boolean.toString(result);
	}
	
}
