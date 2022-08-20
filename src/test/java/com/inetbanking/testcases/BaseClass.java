package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
ReadConfig readconfig=new ReadConfig();	//object created for readconfig.java class to invoke the ReadConfig() constructor
public String baseUrl=readconfig.getApplicationUrl(); //calling the readconfig for url
public String username=readconfig.getusername();
public String passwd=readconfig.getpassword();
public static WebDriver driver;
public static Logger logger;
@BeforeClass
public void setup() {
	//System.setProperty("webdriver.chrome.driver" ,"./Drivers\\chromedriver.exe" );
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j2.xml");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseUrl);
}
@AfterClass
public void teardown() throws InterruptedException {
	Thread.sleep(3000);
	//driver.close();
	driver.quit();
}
public void capturescreen(WebDriver driver, String testname) throws IOException {
    TakesScreenshot ts=(TakesScreenshot) driver;
	File sc = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/Screenshots/"+testname+".png");
	FileUtils.copyFile(sc, target);
	System.out.println("screenshot taken");

}

}
