package com.instagram.gyeongun.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.gyeongun.auth.PrincipalService;
import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.domain.user.UserRepository;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
import com.instagram.gyeongun.web.dto.auth.SignupRequestDto;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PrincipalService principalService;

	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		if (userRepository.signup(signupRequestDto.toEntity()) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUsername(String username) {
		if (userRepository.checkUsername(username) != 0) {
			return true;
		}
		return false;
	}

	@Override
	public User signin(String username, String password) {
		if (userRepository.checkUsername(username) != 0) {
			String getPassword = userRepository.getPassword(username);
			if (BCrypt.checkpw(password, getPassword)) {
				return principalService.getUserByUsername(username);
			}else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public boolean findPassword(String username, String phone) {
		if(userRepository.checkUsername(username)!=0) {
			
		}
		return false;
	}

}
