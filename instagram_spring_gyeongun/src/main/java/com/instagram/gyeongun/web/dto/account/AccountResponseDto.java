package com.instagram.gyeongun.web.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountResponseDto {
	
	private int usercode;
	private String phone;
	private String email;
	private String name;
	private String username;
	private String imgUrl;
	private String website;
	private String introduce;
	private int gender;
	
}
