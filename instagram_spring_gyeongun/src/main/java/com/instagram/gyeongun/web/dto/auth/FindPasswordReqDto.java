package com.instagram.gyeongun.web.dto.auth;

import com.instagram.gyeongun.domain.profile.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindPasswordReqDto {
	private String username;
	private String emailOrPhone;
	
	public Account toPhoneEntity() {
		String email = null;
		String phone = null;
		
		if(emailOrPhone.contains("@")) {
			email = emailOrPhone;
		}else {
			phone = emailOrPhone;
		}
		
		return Account.builder()
				.username(username)
				.email(email)
				.phone(phone)
				.build();
	}
}
