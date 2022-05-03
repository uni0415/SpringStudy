package com.instagram.gyeongun.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.domain.user.UserRepository;
@Service
public class PrincipalServiceImpl implements PrincipalService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
}
