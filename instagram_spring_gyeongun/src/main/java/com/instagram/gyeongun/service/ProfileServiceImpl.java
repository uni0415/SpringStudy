package com.instagram.gyeongun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.gyeongun.domain.profile.ProfileRepository;
import com.instagram.gyeongun.domain.user.UserRepository;
import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public AccountResponseDto getProfile(int usercode) {
		return profileRepository.getAccountProfileByUsercode(usercode).toDto();
	}
	
	@Override
	public boolean updateProfile(AccountUpdateReqDto accountUpdateReqDto) {
		if(userRepository.checkUsername(accountUpdateReqDto.getUsername())!=0) {
			return false;
		}
		profileRepository.updateUserMst(accountUpdateReqDto.toEntity());
		profileRepository.updateUserDtl(accountUpdateReqDto.toEntity());
		return true;
	}
}
