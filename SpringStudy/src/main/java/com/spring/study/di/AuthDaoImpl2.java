package com.spring.study.di;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Component("authDao2")
public class AuthDaoImpl2 implements AuthDao {
	
	private String DB;
	private String username;
	private String password;
	
	@Override
	public boolean signin(String username, String password) {
		System.out.println("DAO2 구현");
		
		return false;
		
	}
}
