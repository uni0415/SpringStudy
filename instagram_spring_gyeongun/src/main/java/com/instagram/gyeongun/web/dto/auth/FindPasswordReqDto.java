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
	private String phone;
	
	public Account toPhoneEntity() {
		return Account.builder()
				.username(username)
				.phone(phone)
				.build();
	}
}
