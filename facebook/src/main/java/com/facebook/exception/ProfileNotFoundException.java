package com.facebook.exception;

public class ProfileNotFoundException extends Exception{
	
	String messege;
	public ProfileNotFoundException(String messege)
	{
		this.messege = messege;
	}
	
	public String toString()
	{
		return messege;
	}

}
