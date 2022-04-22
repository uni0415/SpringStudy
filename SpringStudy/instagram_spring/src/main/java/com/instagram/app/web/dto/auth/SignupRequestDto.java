package com.instagram.app.web.dto.auth;

import org.mindrot.jbcrypt.BCrypt;

import com.instagram.app.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequestDto {
	private String phoneOrEmail;
	private String name;
	private String username;
	private String password;
	
	public User toEntity() {
		String phone = null;
		String email = null;
		if(phoneOrEmail.contains("@")) {
			email = phoneOrEmail;
		}else {
			phone = phoneOrEmail;
		}
		return User.builder()
				.phone(phone)
				.email(email)
				.name(name)
				.username(username)
				.password(BCrypt.hashpw(password, BCrypt.gensalt()))
				.build();
	}
}
