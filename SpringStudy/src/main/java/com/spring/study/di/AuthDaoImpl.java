package com.spring.study.di;

import org.springframework.beans.factory.annotation.Value;
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
//@Component("authDao1")
public class AuthDaoImpl implements AuthDao {
	
	@Value("마리아디비")
	private String DB;
	@Value("gyeongun")
	private String username;
	@Value("1234")
	private String password;
	
	@Override
	public boolean signin(String username, String password) {
		System.out.println(DB + "데이터 베이스에 연결합니다.");
		if(this.username.equals(username) && this.password.equals(password)) {
			System.out.println("로그인 성공.");
			return true;
		}
		return false;
		
	}
}
