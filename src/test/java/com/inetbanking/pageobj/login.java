package com.inetbanking.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver = new ChromeDriver();
	//create a constructor, this will call first or this will invoke first
	public login(WebDriver driver2){
		 driver= driver2;
		 //this.driver=driver
		PageFactory.initElements(driver2, this);
	}
	@FindBy(name="uid")
	WebElement user;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement btn;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	WebElement logout;
	
	
	public void setusername(String name) {
		user.sendKeys(name);
		
	}
	public void setpwd(String pwd) {
		password.sendKeys(pwd);
		
	}
	public void submit() {
		btn.click();
		
	}
	public void logout(){
		logout.click();
		
	}
	
	
	 

}
