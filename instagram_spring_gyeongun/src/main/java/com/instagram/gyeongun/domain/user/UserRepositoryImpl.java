package com.instagram.gyeongun.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SqlSession session;
	
	private final String NAME_SPACE = "com.instagram.gyeongun.domain.user.UserRepository.";
	@Override
	public int signup(User user) {
		return session.insert(NAME_SPACE + "signup" ,user);
	}
	
	@Override
	public int checkUsername(String username) {
		return session.selectOne(NAME_SPACE + "checkUsername", username);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return session.selectOne(NAME_SPACE + "getUserByUsername", username);
	}
	
	@Override
	public String getPassword(String username) {
		return session.selectOne(NAME_SPACE + "getPassword", username);
	}
	
}
