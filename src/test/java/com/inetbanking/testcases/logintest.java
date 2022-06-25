package com.inetbanking.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class logintest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver" ,"./Drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		//logintest("mngr416902","ujUruqA");
	}
	
	@Test(priority=1)
	
	public void dropdown() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Yahoo']")).click();
		Thread.sleep(2);
	}
	
	@Test(priority=2)
	
	public void tootip() throws InterruptedException{
		WebElement s= driver.findElement(By.xpath("//a[text()='Tooltip']"));
		Actions action = new Actions(driver);
		WebElement d= driver.findElement(By.id("download_now"));
		action.clickAndHold().moveToElement(d).build().perform();
		Thread.sleep(2);
		
		WebElement tooltip = driver.findElement(By.xpath("//*[@class='tooltip']"));
		String title= tooltip.getText();
		System.out.println(title);		
	}
	
	public void logintest(String user,String pw) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr416902");
		Thread.sleep(2);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("ujUruqA");
		WebElement button= driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor jk = (JavascriptExecutor)driver;
		jk.executeScript("arguments[0].click()", button);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
