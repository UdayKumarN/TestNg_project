package com.inetbanking.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import com.inetbanking.pageobj.login;

public class TC_Login_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseUrl);
		logger.info("URL opened");
		//we have to call the page object class i.e login class so create object to login class
		login l=new login(driver);	//creating the object for login.java file page object model for accesing the parametrs
		l.setusername(username);
		logger.info("username entered");
		l.setpwd(passwd);
		logger.info("password entered");
		Thread.sleep(3000);
		l.submit();
		logger.info("login success");
		String title = driver.getTitle();
		System.out.println("title: "+title);
		if (driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			capturescreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
	}

}
