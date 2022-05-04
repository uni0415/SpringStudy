package com.instagram.gyeongun.service;

import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateImgReqDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
import com.instagram.gyeongun.web.dto.account.PasswordUpdateReqDto;

public interface ProfileService {
	public AccountResponseDto getProfile(int usercode);
	public boolean updateProfile(AccountUpdateReqDto accountUpdateReqDto);
	public boolean updateProfileImg(User user, AccountUpdateImgReqDto accountUpdateImgReqDto);
	public boolean updatePassword(PasswordUpdateReqDto passwordUpdateReqDto, User user);
}
