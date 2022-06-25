package com.inetbanking.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_Sample_Verify {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver" ,"./Drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void testVerifyTitle() {
		String title= driver.getTitle();
		Assert.assertEquals(title, "GTPL Bank Home Page");
		System.out.println("page title is:"+title);
		
	}
	@Test(priority=2)
	public void testLogo() {
		Boolean logo=driver.findElement(By.xpath("//img[@src='/logo.png']")).isDisplayed();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/");
		System.out.print("Screenshot is captured");
		System.out.println(sc);
		Assert.assertTrue(logo);
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
