package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageobj.login;

import java.io.IOException;

import org.testng.Assert;

public class test_Login_001 extends test_BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseUrl);
		//logger.info("URL opened");
		//we have to call the page object class i.e login class so create object to login class
		login l=new login(driver);	//creating the object for login.java file page object model for accesing the parametrs
		l.setusername(username);
		//logger.info("username entered");
		l.setpwd(passwd);
		//logger.info("password entered");
		Thread.sleep(3000);
		l.submit();
		//logger.info("login success");
		String title = driver.getTitle();
		System.out.println("title: "+title);
		if (driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			test = report.createTest("Test Case 1", "The loginTest has passed");
		}
		else {
			capturescreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
	}

}
