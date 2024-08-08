package com.facebook.utility;

import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookServiceFactory {
	private static FacebookServiceInterface fi = null;
	
	private FacebookServiceFactory()
	{
		
	}

	public static FacebookServiceInterface createObject(String n) {
		// TODO Auto-generated method stub
		if(n.equals("user"))
		{
			if(fi==null)
			{
				fi = new FacebookService();
			}
		}
		return fi;
	}

}
