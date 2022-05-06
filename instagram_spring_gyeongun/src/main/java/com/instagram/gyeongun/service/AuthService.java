package com.instagram.gyeongun.service;

import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
import com.instagram.gyeongun.web.dto.auth.FindPasswordReqDto;
import com.instagram.gyeongun.web.dto.auth.SignupRequestDto;

public interface AuthService {
	public boolean signup(SignupRequestDto signupRequestDto);
	public boolean checkUsername(String username);
	public User signin(String username, String password);
	
}
