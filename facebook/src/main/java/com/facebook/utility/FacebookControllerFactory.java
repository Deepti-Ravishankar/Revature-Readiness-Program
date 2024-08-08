package com.facebook.utility;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class FacebookControllerFactory {
	private FacebookControllerFactory()
	{
		
	}

	public static FacebookControllerInterface createObject(String n) {
		// TODO Auto-generated method stub
		if(n.equals("user"))
		{
			return new FacebookController();
		}
		return null;
	}

}
