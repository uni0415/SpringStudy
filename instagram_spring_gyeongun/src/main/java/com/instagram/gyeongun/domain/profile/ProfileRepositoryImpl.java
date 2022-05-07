package com.instagram.gyeongun.domain.profile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.gyeongun.domain.user.User;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	@Autowired
	private SqlSession session;
	private final String NAME_SPACE = "com.instagram.gyeongun.domain.profile.ProfileRepository.";
	
	@Override
	public Account getAccountProfileByUsercode(int usercode) {
		return session.selectOne(NAME_SPACE + "getAccountProfileByUsercode", usercode);
	}
	
	@Override
	public int updateUserMst(Account account) {
		return session.update(NAME_SPACE + "updateUserMst", account);
	}
	
	@Override
	public int updateUserDtl(Account account) {
		return session.update(NAME_SPACE + "updateUserDtl", account);
	}
	
	@Override
	public int profileUpdateImg(ProfileImg profileImg) {
		return session.update(NAME_SPACE + "profileUpdateImg", profileImg);
	}
	
	@Override
	public ProfileImg getProfileImg(int usercode) {
		return session.selectOne(NAME_SPACE + "getProfileImg", usercode);
	}
	
	@Override
	public int updatePassword(User user) {
		return session.update(NAME_SPACE + "updatePassword", user);
	}
	
	@Override
	public User getUserByEmailOrPhone(Account account) {
		return session.selectOne(NAME_SPACE + "getUserByEmailOrPhone", account);
	}
}
