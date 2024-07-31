package com.facebook.controller;

import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface {

	@Override
	public void createProfileController() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter password");
		String pwd = sc.next();
		
		System.out.println("Enter email");
		String mail = sc.next();
		
		System.out.println("Enter address");
		String address=sc.next();
		
		FacebookUser fu = new FacebookUser();
		
		fu.setName(name);
		fu.setPwd(pwd);
		fu.setEmail(mail);
		fu.setAddress(address);
		
		FacebookServiceInterface fs = new FacebookService();
		int i = fs.createProfileService(fu);
		
		if(i>0)
		{
			System.out.println("Profile created");
		}
		else
		{
			System.out.println("profile rejected");
		}
		
		
	}

	@Override
	public void viewProfileController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProfileController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editProfileController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchProfileController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewAllProfileController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginProfileController() {
		// TODO Auto-generated method stub

	}

}
