package com.instagram.gyeongun.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.gyeongun.config.FileConfig;
import com.instagram.gyeongun.domain.profile.ProfileImg;
import com.instagram.gyeongun.domain.profile.ProfileRepository;
import com.instagram.gyeongun.domain.user.User;
import com.instagram.gyeongun.domain.user.UserRepository;
import com.instagram.gyeongun.web.dto.account.AccountResponseDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateImgReqDto;
import com.instagram.gyeongun.web.dto.account.AccountUpdateReqDto;
import com.instagram.gyeongun.web.dto.account.PasswordUpdateReqDto;
import com.instagram.gyeongun.web.dto.auth.FindPasswordReqDto;

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
		if (userRepository.checkUsername(accountUpdateReqDto.getUsername()) != 0) {
			return false;
		}
		profileRepository.updateUserMst(accountUpdateReqDto.toEntity());
		profileRepository.updateUserDtl(accountUpdateReqDto.toEntity());
		return true;
	}

	@Override
	public boolean updateProfileImg(User user, AccountUpdateImgReqDto accountUpdateImgReqDto) {
		if (accountUpdateImgReqDto.getFile() != null) {
			String imgFileName = accountUpdateImgReqDto.getFile().getOriginalFilename();
			String tempImgFileName = UUID.randomUUID().toString().replace("-", "") + "-" + imgFileName;
			String path = FileConfig.profileImgPath;
			Path imgFilePath = Paths.get(path + "/" + tempImgFileName);

			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				Files.write(imgFilePath, accountUpdateImgReqDto.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			ProfileImg profileImg = ProfileImg.builder().usercode(user.getUsercode()).img_url(tempImgFileName).build();
			return profileRepository.profileUpdateImg(profileImg) != 0;
		}
		return false;
	}

	@Override
	public boolean updatePassword(PasswordUpdateReqDto passwordUpdateReqDto, User user) {
		user.setPassword(BCrypt.hashpw(passwordUpdateReqDto.getNewPassword(), BCrypt.gensalt()));
		return profileRepository.updatePassword(user) != 0;
	}
	
	@Override
	public boolean checkPassword(PasswordUpdateReqDto passwordUpdateReqDto, User user) {
		if(BCrypt.checkpw(passwordUpdateReqDto.getNewPassword(), user.getPassword())) {
			return false;
		}
		return true;
	}
	
	@Override
	public User findPassword(FindPasswordReqDto findPasswordReqDto) {
		if(userRepository.checkUsername(findPasswordReqDto.getUsername())!=0) {
			User user = profileRepository.getUserByEmailOrPhone(findPasswordReqDto.toPhoneEntity());
				return user;
			}
		return null;
	}
	
}
