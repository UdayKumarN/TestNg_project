package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.inetbanking.testcases.BaseClass;

public class ReadConfig {
	Properties pro;	//creating object to properties class i.e config.properties class
	
	public ReadConfig()	//invoking the constructor to execute this methods first
	{
		File src=new File("./configurations/config.properties");// Specify the file location I used . operation here because
		//we have properties inside project directory only
		try {
			FileInputStream fis=new FileInputStream(src);// Create FileInputStream object
			pro=new Properties(); // Create Properties class object to read properties file
			pro.load(fis);	//loading the properties
		}catch (Exception e) {
			System.out.println("exception is="+ e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseUrl");	//loading the URL
		return url;
	}
	public String getusername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password=pro.getProperty("passwd");
		return password;
	}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
}
