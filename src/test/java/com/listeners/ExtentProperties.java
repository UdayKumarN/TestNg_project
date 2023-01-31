package com.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum ExtentProperties {

	INSTANCE;
	private String reportpath;
	private String extentSeverUrl;
	private String projectname;
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String userDir=System.getProperty("user.dir");
	ExtentProperties()
	{
		this.reportpath="TestResults"+File.separator+""+timestamp.replace(":", "").replace(".", "_")
				+File.separator+"TestReport.html";
		this.projectname="default";
		
	}
	public String getReportPath() {
		return reportpath;
	}
	public void setReportPath(String reportpath) {
		 this.reportpath=reportpath;
	}
	public String getExtentXServerUrl() {
		return extentSeverUrl;
	}
	public void setExtentXServerUrl(String extentSeverUrl) {
		 this.extentSeverUrl=extentSeverUrl;
	}
	public String getProjectName() {
		return projectname;
	}
	public void setProjectName(String projectname) {
		 this.projectname=projectname;
	}
}
