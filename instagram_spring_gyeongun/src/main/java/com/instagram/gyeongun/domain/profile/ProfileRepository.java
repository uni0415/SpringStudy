package com.instagram.gyeongun.domain.profile;

public interface ProfileRepository {
	public Account getAccountProfileByUsercode(int usercode);
	public int updateUserMst(Account account);
	public int updateUserDtl(Account accout);
}
