package com.facebook.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.facebook.entity.FacebookUser;
import com.facebook.utility.FacebookServiceFactory;

public class FacebookServiceTest {
	private FacebookServiceInterface fs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		fs = FacebookServiceFactory.createObject("user");
		
	}

	@After
	public void tearDown() throws Exception {
		fs = null;
	}

	@Test
	public void testCreateProfileService() {
		FacebookUser fu = new FacebookUser();
		fu.setName("Deepti");
		fu.setPwd("dee");
		fu.setEmail("dee@gmail.com");
		fu.setAddress("bangalore");
		
		int i = fs.createProfileService(fu);
		
		assert i>0 : "profile not created";
		//assert if_condition : else_messege;
		
	}

	@Test
	public void testViewProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testViewAllProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testSearchProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testEditProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testLoginProfileService() {
		System.out.println("Not yet implemented");
	}

}
