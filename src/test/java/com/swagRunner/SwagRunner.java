package com.swagRunner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listner.ExtentReport_Test;
import com.listner.ITestListenerClass;
import com.swagBaseClass.BaseClass;
import com.swagPOM.SwagLoginPage;
import com.swagPOM_Manager.Frm;

@Listeners(ITestListenerClass.class)
public class SwagRunner extends BaseClass {

	@BeforeTest
	public void setUp() {
		browser(Frm.getInstancefrm().getInstanceConfigurationReader().getbrowser());
	}

	@Test(priority = -1)
	public void LoginTest() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid EmailId with Valid Password");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.validLogIn(ExtentReport_Test.extenttest));

	}

	@Test(priority = -5)
	public void emptyUserEmptyPass() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty EmailId with Empty Password");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.emptyUserEmptyPass(ExtentReport_Test.extenttest));

	}

	@Test(priority = -4)
	public void validUserEmptyPass() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("valid EmailId with Empty Password");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.validUserEmptyPass(ExtentReport_Test.extenttest));

	}

	@Test(priority = -3)
	public void validUserInvalidPass() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("valid EmailId with invalid Password");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.validUserInvalidPass(ExtentReport_Test.extenttest));

	}

	@Test(priority = -2)
	public void invalidUserValidPass() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("invalid EmailId with Valid Password");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.invalidUserValidPass(ExtentReport_Test.extenttest));

	}

	@Test(priority = 0)
	public void order1() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("Order1" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Purchased Successfully");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.order1(ExtentReport_Test.extenttest));
	}

	@Test(priority = 1)
	public void order2() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("Order2" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Purchased Successfully");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.order2(ExtentReport_Test.extenttest));
	}

	@Test(priority = 2)
	public void order3() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("Order3" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Purchased Successfully");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.order3(ExtentReport_Test.extenttest));
	}

	@Test(priority = 3)
	public void order4() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("Order4" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Purchased Successfully");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.order4(ExtentReport_Test.extenttest));
	}

	@Test(priority = 4)
	public void order5() {
		ExtentReport_Test.extenttest = extentreports
				.createTest("Order5" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Purchased Successfully");
		SwagLoginPage lp = new SwagLoginPage();
		Assert.assertTrue(lp.order5(ExtentReport_Test.extenttest));
	}

	@AfterTest
	public void closeBrowser() {
		close(driver);
	}

	@BeforeSuite
	public void startTest() {
		extentReportStart("C:\\Users\\mvion\\eclipse-workspace\\SwagLabs\\Reports");
	}

	@AfterSuite
	public void endTest() throws IOException {
		extentReportTearDown("C:\\Users\\mvion\\eclipse-workspace\\SwagLabs\\Reports\\index.html");
	}

}
