package com.facebook.service;

import java.util.List;

import com.facebook.dao.FacebookDao;
import com.facebook.dao.FacebookDaoInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	@Override
	public int createProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		int i = fd.createProfileDao(fu);
		return i;
	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		FacebookUser f2 = fd.viewProfileDao(fu);  
		return f2;
	}

	@Override
	public List<FacebookUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		return fd.viewAllProfileDao();
	}

	@Override
	public FacebookUser searchProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		FacebookUser f2 = fd.searchProfileDao(fu);
		return f2;
	}

	@Override
	public int editProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		return fd.editProfileDao(fu); 
		
	}

	@Override
	public int deleteProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
		return fd.deleteProfileDao(fu);
	}

	@Override
	public FacebookUser loginProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookDaoInterface fd = new FacebookDao();
	    FacebookUser f2 = fd.loginProfileDao(fu);
	    return f2;
	}

}
