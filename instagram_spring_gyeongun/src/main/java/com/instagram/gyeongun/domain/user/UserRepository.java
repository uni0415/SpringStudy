package com.instagram.gyeongun.domain.user;

import com.instagram.gyeongun.domain.profile.Account;

public interface UserRepository {
	public int signup(User user);
	public int checkUsername(String username);
	public User getUserByUsername(String username);
	public String getPassword(String username);
	
}
