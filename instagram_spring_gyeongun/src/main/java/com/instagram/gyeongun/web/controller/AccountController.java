package com.instagram.gyeongun.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.gyeongun.auth.PrincipalService;
import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.service.ProfileService;
import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateImgReqDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
import com.instagram.gyeongun.web.dto.account.PasswordUpdateReqDto;
import com.instagram.gyeongun.web.dto.auth.FindPasswordReqDto;

@Controller
public class AccountController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private PrincipalService principalService;

	@ResponseBody
	@RequestMapping(value = "/profile/account/user", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public AccountResponseDto getProfile(int usercode) {
		return profileService.getProfile(usercode);
	}

	@ResponseBody
	@RequestMapping(value = "/profile/account/update", method = RequestMethod.PUT)
	public String updateAccount(@RequestBody AccountUpdateReqDto accountUpdateReqDto, HttpServletRequest request) {
		boolean result = profileService.updateProfile(accountUpdateReqDto);
		if (result == true) {
			request.getSession().setAttribute("principal",
					principalService.getUserByUsername(accountUpdateReqDto.getUsername()));
		}
		return Boolean.toString(result);
	}

	@ResponseBody
	@RequestMapping(value = "/profile/account/update/img", method = RequestMethod.POST)
	public String updateProfileImg(HttpServletRequest request, AccountUpdateImgReqDto accountUpdateImgReqDto) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("principal");
		boolean result = profileService.updateProfileImg(user, accountUpdateImgReqDto);
		return Boolean.toString(result);
	}

	@ResponseBody
	@RequestMapping(value = "/profile/account/password/update", method = RequestMethod.PUT)
	public String updatePassword(@RequestBody PasswordUpdateReqDto passwordUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("principal");
		if (!BCrypt.checkpw(passwordUpdateReqDto.getOriginPassword(), user.getPassword())) {
			return "false";
		}
		return Boolean.toString(profileService.updatePassword(passwordUpdateReqDto, user));
	}

	@ResponseBody
	@RequestMapping(value = "/profile/find_password", method = RequestMethod.POST)
	public String findPassword(FindPasswordReqDto findPasswordReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = profileService.findPassword(findPasswordReqDto);
		if (user != null) {
			session.setAttribute("change_pw", user);
			return "true";
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = "/profile/checkPassword", method = RequestMethod.POST)
	public String checkPassword(@RequestBody PasswordUpdateReqDto passwordUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("change_pw");
		return Boolean.toString(profileService.checkPassword(passwordUpdateReqDto, user));
	}
	
	@ResponseBody
	@RequestMapping(value="/profile/change_password", method=RequestMethod.POST)
	public String changePassword(PasswordUpdateReqDto passwordUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("change_pw");
		boolean result = profileService.updatePassword(passwordUpdateReqDto, user);
		if(result) {
			session.invalidate();
			return "true";
		}else {
			return "false";
		}
	}
}
