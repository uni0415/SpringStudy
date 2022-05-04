package com.instagram.gyeongun.domain.user;

public interface UserRepository {
	public int signup(User user);
	public int checkUsername(String username);
	public User getUserByUsername(String username);
	public String getPassword(String username);
	public int getPhoneByUsername(String username);
}
