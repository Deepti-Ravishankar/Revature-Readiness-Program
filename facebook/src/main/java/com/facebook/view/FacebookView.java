package com.facebook.view;

import java.util.Scanner;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("                   MAIN MENU");
		System.out.println("Select an option\n"+
		                   "1.create profile\n"+
		                   "2.view profile\n"+
				           "3.delete profile\n"+
		                   "4.edit profile\n"+
				           "5.search profile\n"+
		                   "6.view all profile\n"+
				           "7.login profile\n");
		
		Scanner sc = new Scanner(System.in); //sc is reference data type stored in heap memory
		System.out.println("Enter your choice");
		int c = sc.nextInt(); //c is local memory stored in stack segment
		
		FacebookControllerInterface fc = new FacebookController();
		
		switch(c)
		{
		case 1:
			fc.createProfileController();
			break;
		case 2:
			fc.viewProfileController();
			break;
		case 3:
			fc.deleteProfileController();
			break;
		case 4:
			fc.editProfileController();
			break;
		case 5:
			fc.searchProfileController();
			break;
		case 6:
			fc.viewAllProfileController();
			break;
		case 7:
			fc.loginProfileController();
			break;
		default:System.out.println("wrong choice");
		}

	}

}
