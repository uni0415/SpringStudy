package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private PrincipalService principalService;
	
	@Override
	public boolean checkUsername(String username) {
		return userRepository.checkUsername(username) !=0 ? true: false;
	}
	
	
	@Override
	public int checkName(String name) {
		return userRepository.checkName(name);
	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		int result = userRepository.signup(signupRequestDto.toEntity());
		return result != 0;
	}
	
	@Override
	public User signin(String username, String password) {
		User user = principalService.loadUserByUsername(username);
		if(!principalService.passwordCheck(password, user)) {
			return null;
		}
		return user;
	}

}
