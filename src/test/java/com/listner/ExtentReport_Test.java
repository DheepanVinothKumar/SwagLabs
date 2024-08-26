package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseClass;

public class ExtentReport_Test {
	
	public static ExtentTest extenttest;
	
	public void extentTestReportStartup() throws IOException{
		BaseClass base = new BaseClass();
		base.extentReportStart(null);
		
	}

	
	public void extentReportEnd() throws IOException {
		BaseClass base = new BaseClass();
		base.extentReportTearDown(null);
		
	}
	
}
