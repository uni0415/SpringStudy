package com.instagram.gyeongun.web.dto.auth;

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
}
