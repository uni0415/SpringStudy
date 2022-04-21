package com.spring.study.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthServiceImpl implements AuthService {
	@Autowired
	@Qualifier("authDao1")
	private AuthDao authDao;
	
	@Override
	public void signin(String username, String password) {
		System.out.println("로그인 아이디: " + username);		
		System.out.println("로그인 비밀번호: " + password);
		authDao.signin(username, password);
	}
}
