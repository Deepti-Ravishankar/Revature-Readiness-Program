package com.facebook.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.facebook.entity.FacebookUser;
import com.facebook.exception.ProfileNotFoundException;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;
import com.facebook.utility.FacebookServiceFactory;
import com.facebook.view.FacebookView;
import com.facebook.utility.SortByName;
import com.facebook.utility.SortByMail;
import com.facebook.utility.SortByAddress;

public class FacebookController implements FacebookControllerInterface {
	Logger log=Logger.getLogger("FacebookController");
	
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
		String address = sc.next();

		FacebookUser fu = new FacebookUser();

		fu.setName(name);
		fu.setPwd(pwd);
		fu.setEmail(mail);
		fu.setAddress(address);

		FacebookServiceInterface fs = FacebookServiceFactory.createObject("user");
		int i = fs.createProfileService(fu);

		if (i > 0) {
			log.info("profile created at "+LocalDateTime.now());
		} else {
			log.info("could not create");
		}

	}

	@Override
	public void viewProfileController() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email to view profile");
		String email = sc.next();
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);

		FacebookServiceInterface fs = new FacebookService();
		FacebookUser f2 = fs.viewProfileService(fu);

		try {
			if (f2 != null) {
				System.out.println("Your profile detailes are");
				System.out.println("Name is :" + f2.getName());
				System.out.println("Email is :" + f2.getEmail());
				System.out.println("Password is :" + f2.getPwd());
				System.out.println("Address is :" + f2.getAddress());
			} else {
				throw new ProfileNotFoundException("Profile not found for the email" + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProfileController() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter email to delete profile");
			String email = sc.next();
			FacebookUser fu = new FacebookUser();
			fu.setEmail(email);

			FacebookServiceInterface fs = new FacebookService();
			int ll = fs.deleteProfileService(fu);

			if (ll > 0) {
				System.out.println("Profile deleted");

			} else {
				throw new ProfileNotFoundException("Profile not found for the email" + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editProfileController() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter email to edit profile");
		String email = sc.next();

		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);

		FacebookServiceInterface fs = new FacebookService();
		FacebookUser ff = fs.viewProfileService(fu);
		try {
			if (ff != null) {
				System.out.println("Your old profile is ");
				System.out.println("Name is -->" + ff.getName());
				System.out.println("Password is -->" + ff.getPwd());
				System.out.println("Email is --> " + ff.getEmail());
				System.out.println("Address is -->" + ff.getAddress());

				System.out.println("press 1 to change password");
				System.out.println("press 2 to change address");

				System.out.println("enter choice");
				int c = sc.nextInt();

				switch (c) {
				case 1:
					System.out.println("enter new password ");
					String npassword = sc.next();
					ff.setPwd(npassword);
					int i = fs.editProfileService(ff);

					if (i > 0) {
						System.out.println("password changed");
					}

					break;
				case 2:
					System.out.println("enter new address ");
					String naddress = sc.next();

					ff.setAddress(naddress);
					int i1 = fs.editProfileService(ff);

					if (i1 > 0) {
						System.out.println("Address changed");
					}
					break;
				default:
					System.out.println("wrong choice");
				}
			} else {

				throw new ProfileNotFoundException("Profile Not Found for given mail id " + email);

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void searchProfileController() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email id to search the profile");
		String email = sc.next();

		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);

		FacebookServiceInterface fs = new FacebookService();
		FacebookUser f2 = fs.searchProfileService(fu);

		try {
			if (f2 != null) {
				System.out.println("Your profile exists");
				System.out.println("The profile details are");
				System.out.println("Name is :" + f2.getName());
				System.out.println("Email is :" + f2.getEmail());
				System.out.println("Password is :" + f2.getPwd());
				System.out.println("Address is :" + f2.getAddress());
			} else {
				throw new ProfileNotFoundException("Profile not found for the email" + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void viewAllProfileController() {
		// TODO Auto-generated method stub
		FacebookServiceInterface fs = new FacebookService(); // low coupling
		List<FacebookUser> ls = fs.viewAllProfileService(); // contains only facebook user objects and operators
		
		System.out.println("unsorted collection");

		for (FacebookUser fu : ls) {
			System.out.println("***********************************************************");
			System.out.println("Name is :" + fu.getName());
			System.out.println("Email is :" + fu.getEmail());
			System.out.println("Password is :" + fu.getPwd());
			System.out.println("Address is :" + fu.getAddress());
		}
		Collections.sort(ls,new SortByName());
		System.out.println("                             ");
		System.out.println("SORTED RESULT BASED ON NAME");
		for(FacebookUser fu:ls)
		{
			System.out.println("***********************************************************");
			System.out.println("Name is :" + fu.getName());
			System.out.println("Email is :" + fu.getEmail());
			System.out.println("Password is :" + fu.getPwd());
			System.out.println("Address is :" + fu.getAddress());
		}
		
        Collections.sort(ls,new SortByMail());
        System.out.println("                             ");
		System.out.println("SORTED RESULT BASED ON MAIL");
//		for(FacebookUser fu:ls)
//		{
//			System.out.println("***********************************************************");
//			System.out.println("Name is :" + fu.getName());
//			System.out.println("Email is :" + fu.getEmail());
//			System.out.println("Password is :" + fu.getPwd());
//			System.out.println("Address is :" + fu.getAddress());
//		}
		
		Iterator<FacebookUser> fi = ls.iterator();
		while(fi.hasNext()) {
			FacebookUser f = fi.next();
			System.out.println("*********************************");
			System.out.println("Name is :"+f.getName());
			System.out.println("Email is :"+f.getEmail());
			System.out.println("Password is :"+f.getPwd());
			System.out.println("Address is : "+f.getAddress());
		}
		
        Collections.sort(ls,new SortByAddress());
        System.out.println("                             ");
		System.out.println("SORTED RESULT BASED ON ADDRESS");
		for(FacebookUser fu:ls)
		{
			System.out.println("***********************************************************");
			System.out.println("Name is :" + fu.getName());
			System.out.println("Email is :" + fu.getEmail());
			System.out.println("Password is :" + fu.getPwd());
			System.out.println("Address is :" + fu.getAddress());
		}
		

	}

	@Override
	public void loginProfileController() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter email");
			String email = sc.next();

			System.out.println("Enter password");
			String pwd = sc.next();

			FacebookUser fu = new FacebookUser();
			fu.setName(email);
			fu.setPwd(pwd);

			FacebookServiceInterface fs = new FacebookService();
			FacebookUser f2 = fs.loginProfileService(fu);

			if (f2 != null) {
				System.out.println("Profile logged");
				System.out.println("The profile details are");
				System.out.println("Name is :" + f2.getName());
				System.out.println("Email is :" + f2.getEmail());
				System.out.println("Password is :" + f2.getPwd());
				System.out.println("Address is :" + f2.getAddress());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
