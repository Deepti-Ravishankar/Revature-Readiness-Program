package com.facebook.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.facebook.entity.FacebookUser;
import com.facebook.utility.FacebookControllerFactory;

public class FacebookControllerTest {
	private FacebookControllerInterface fc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("loading global resources");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("unloading global resources");
	}

	@Before
	public void setUp() throws Exception {
		fc = FacebookControllerFactory.createObject("user");
		
	}

	@After
	public void tearDown() throws Exception {
		fc = null;
	}

	@Test
	public void testCreateProfileController() {
		fc.createProfileController();
	}

	@Test
	public void testViewProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testEditProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testSearchProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testViewAllProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testLoginProfileController() {
		System.out.println("Not yet implemented");
	}

}
