package com.listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.swagBaseClass.BaseClass;

public class ITestListenerClass extends BaseClass implements ITestListener {

	public String testName;
	public String methodName;

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		try {
			ExtentReport_Test.extenttest.pass(result.getMethod().getMethodName() + " : " + "Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			ExtentReport_Test.extenttest.fail(result.getMethod().getMethodName() + " : " + "Test Fail",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}