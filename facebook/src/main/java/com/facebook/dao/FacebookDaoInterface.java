package com.facebook.dao;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookDaoInterface {

	int createProfileDao(FacebookUser fu);

	FacebookUser viewProfileDao(FacebookUser fu);

	List<FacebookUser> viewAllProfileDao();

	FacebookUser searchProfileDao(FacebookUser fu);

	int editProfileDao(FacebookUser fu);

	int deleteProfileDao(FacebookUser fu);

	FacebookUser loginProfileDao(FacebookUser fu);


}
