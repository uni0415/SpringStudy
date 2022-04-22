package com.instagram.app.domain.user;

public interface UserRepository {
	public int checkUsername(String username);
	public int checkName(String name);
	public int signup(User user);
	public User getUserByUsername(String username);
}


