package com.inetbanking.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobj.login;
import com.inetbanking.utilities.XLUtils;

public class TC_loginDatadriven_002 extends BaseClass{
	
	

	@Test(dataProvider = "logindata" )
	public void logindatadriven(String user,String pass) throws InterruptedException {
		login lp=new login(driver);
		lp.setusername(user);
		lp.setpwd(pass);
		lp.submit();
		if(isalertpresent()==true) {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			driver.quit();
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("You have succesfully logged in");
			lp.logout();
			System.out.println("You have succesfully logged out");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
	
	public boolean isalertpresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
		return false;
		}
	}
	@DataProvider(name="logindata")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/Testdata.xlsx";
		int rowno=XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rowno);
		int colno=XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(colno);
		String data[][]=new String[rowno][colno];
		//System.out.println(data);
		for(int i=1; i<=rowno;i++) {
			for(int j=0;j<colno;j++) {
				data[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
		
	}	

}
