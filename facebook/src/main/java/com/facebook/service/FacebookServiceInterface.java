package com.facebook.service;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);

	List<FacebookUser> viewAllProfileService();

	FacebookUser searchProfileService(FacebookUser fu);

	int editProfileService(FacebookUser f2);

	int deleteProfileService(FacebookUser fu);

	FacebookUser loginProfileService(FacebookUser fu);


}
