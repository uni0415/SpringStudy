package com.instagram.gyeongun.domain.profile;

import com.instagram.gyeongun.domain.user.User;

public interface ProfileRepository {
	public Account getAccountProfileByUsercode(int usercode);
	public int updateUserMst(Account account);
	public int updateUserDtl(Account account);
	public int profileUpdateImg(ProfileImg profileImg);
	public ProfileImg getProfileImg(int usercode);
	public int updatePassword(User user);
	public User getPhoneByUsername(Account account);
}
