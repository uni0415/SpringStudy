package com.instagram.gyeongun.service;

import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;

public interface ProfileService {
	public AccountResponseDto getProfile(int usercode);
	public boolean updateProfile(AccountUpdateReqDto accountUpdateReqDto);
}
