package com.instagram.app.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class userRepositoryImpl implements UserRepository {
	@Autowired
	private SqlSession session;
	
	@Override
	public int checkUsername(String username) {
		return session.selectOne("com.instagram.app.domain.user.UserRepository.checkUsername", username);
	}
	
	@Override
	public int checkName(String name) {
		return session.selectOne("com.instagram.app.domain.user.userRepository.checkName", name);
		
	}
}
