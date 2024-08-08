package com.facebook.view;

import java.util.Scanner;
import java.util.logging.Logger;
import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;
import com.facebook.utility.FacebookControllerFactory;

public class FacebookView {
	private static Logger log = Logger.getLogger("FacebookView");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); // sc is reference data type stored in heap memory
		String ss = "y";

		while (ss.equals("y")) {
			log.info("                              MAIN MENU");
			log.info("Select an option\n" + "1.create profile\n" + "2.view profile\n" + "3.delete profile\n"
					+ "4.edit profile\n" + "5.search profile\n" + "6.view all profile\n" + "7.login profile\n");

			log.info("Enter your choice");
			int c = sc.nextInt(); // c is local memory stored in stack segment

			FacebookControllerInterface fc = FacebookControllerFactory.createObject("user");

			switch (c) {
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
			default:
				System.out.println("                              wrong choice");
			}
			System.out.println("                             press y to continue");
			ss = sc.next();

		}

	}

}
