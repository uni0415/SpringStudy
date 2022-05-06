package com.instagram.gyeongun.web.dto.account;

import com.instagram.gyeongun.domain.profile.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountUpdateReqDto {
	private int usercode;
	private String phone;
	private String email;
	private String name;
	private String username;
	private String website;
	private String introduce;
	private int gender;
	
	public Account toEntity() {
		return Account.builder()
				.usercode(usercode)
				.phone(phone)
				.email(email)
				.name(name)
				.username(username)
				.website(website)
				.introduce(introduce)
				.gender(gender)
				.build();
	}
	
}
