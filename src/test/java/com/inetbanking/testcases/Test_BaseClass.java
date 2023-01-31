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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;
import com.listeners.ExtentProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test_BaseClass {
ReadConfig readconfig=new ReadConfig();	//object created for readconfig.java class to invoke the ReadConfig() constructor
public String baseUrl=readconfig.getApplicationUrl(); //calling the readconfig for url
public String username=readconfig.getusername();
public String passwd=readconfig.getpassword();
public static WebDriver driver;
public static Logger logger;

public static ExtentTest test;
public static ExtentReports report;
public static ExtentSparkReporter reporter;

@BeforeTest
public static ExtentReports startTest() {
	report=new ExtentReports();
	reporter = new ExtentSparkReporter(ExtentProperties.INSTANCE.getReportPath());
	report.attachReporter(reporter);
	 //reporter.config().setChartVisibilityOnOpen(true);
     reporter.config().setDocumentTitle("Automation Report");
     reporter.config().setReportName("Test Report");
    //reporter.config().setTestViewChartLocation(ChartLocation.TOP);
     reporter.config().setTheme(Theme.STANDARD);
     reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
     report.attachReporter(reporter);
     report.setSystemInfo("Author","Uday Kumar");
     report.setSystemInfo("Environment","QA");
     return report;
	
}
@BeforeClass
public void setup() {
	//System.setProperty("webdriver.chrome.driver" ,"./Drivers\\chromedriver.exe" );
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	//logger=Logger.getLogger("ebanking");
	//PropertyConfigurator.configure("log4j2.xml");
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

@AfterMethod
public void getResult(ITestResult result) {
    if(result.getStatus() == ITestResult.FAILURE) {
        test.log(Status.FAIL,result.getThrowable());
    }
    else if(result.getStatus() == ITestResult.SUCCESS) {
        test.log(Status.PASS, result.getTestName());
    }
    else {
        test.log(Status.SKIP, result.getTestName());
    }
} 
@AfterTest
public void close() {
    //to write or update test information to reporter
    report.flush();
}
}
