package com.instagram.app.web.dto.account;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountUpdateImgReqDto {
	private MultipartFile file;
}
