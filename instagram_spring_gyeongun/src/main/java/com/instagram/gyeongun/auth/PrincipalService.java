package com.instagram.gyeongun.auth;

import com.instagram.gyeongun.domain.profile.ProfileImg;
import com.instagram.gyeongun.domain.user.User;

public interface PrincipalService {
	
	public User getUserByUsername(String username);
	public ProfileImg getProfileImg(int usercode);
}
