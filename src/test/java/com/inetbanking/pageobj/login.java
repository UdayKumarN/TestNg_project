package com.inetbanking.pageobj;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class login {
	WebDriverManager driver= new ChromeDriverManager();
	//create a constructor, this will call first or this will invoke first
	public login(WebDriverManager driver2){
		 //driver= driver2;
		 this.driver=driver2;
		PageFactory.initElements((SearchContext) driver2, this);
	}
	//WebElement user=driver.findElemnert(By.name("uid"));
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
