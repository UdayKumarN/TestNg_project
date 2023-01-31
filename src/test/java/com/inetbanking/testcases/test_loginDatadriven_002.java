package com.inetbanking.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobj.login;
import com.inetbanking.utilities.XLUtils;

public class test_loginDatadriven_002 extends test_BaseClass
	
	{

		@Test(dataProvider="LoginData")
		public void loginDDT(String user,String pwd) throws InterruptedException
		{
			login lp=new login(driver);
			lp.setusername(user);
			//logger.info("user name provided");
			lp.setpwd(pwd);
			//logger.info("password provided");
			lp.submit();
			
			Thread.sleep(3000);
			
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				//logger.warn("Login failed");
				test = report.createTest("Test Case 2", "The loginTest has Failed");
			}
			else
			{
				Assert.assertTrue(true);
				//logger.info("Login passed");
				lp.logout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				test = report.createTest("Test Case 2", "The loginTest has passed");
				
			}
			
			
		}
		
		
		public boolean isAlertPresent() //user defined method created to check alert is present or not
		{
			try
			{
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
			
		}
		
		
		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Testdata.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
		
	}