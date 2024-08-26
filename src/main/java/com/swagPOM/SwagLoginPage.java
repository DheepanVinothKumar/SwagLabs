package com.swagPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.swagBaseClass.BaseClass;
import com.swagInterface.LoginElements;
import com.swagPOM_Manager.Frm;

public class SwagLoginPage extends BaseClass implements LoginElements {

	@FindBy(xpath = user_xpath)
	private WebElement username;

	@FindBy(xpath = pass_xpath)
	private WebElement password;

	@FindBy(id = login_id)
	private WebElement login;

	@FindBy(xpath = user_xpath)
	private WebElement username2;

	@FindBy(xpath = pass_xpath)
	private WebElement password2;

	@FindBy(xpath = error_xpath)
	private WebElement error;

	@FindBy(xpath = prod1_xpath)
	private WebElement product1;

	@FindBy(xpath = prod_xpath)
	private WebElement producttext;

	@FindBy(xpath = prod2_xpath)
	private WebElement product2;

	@FindBy(xpath = prod3_xpath)
	private WebElement product3;

	@FindBy(xpath = prod4_xpath)
	private WebElement product4;

	@FindBy(xpath = prod5_xpath)
	private WebElement product5;

	@FindBy(id = addcart_id)
	private WebElement addcart;

	@FindBy(xpath = cart_xpath)
	private WebElement cart;

	@FindBy(id = checkout_id)
	private WebElement checkout;

	@FindBy(id = firstname_id)
	private WebElement firstname;

	@FindBy(id = lastname_id)
	private WebElement lastname;

	@FindBy(id = postal_id)
	private WebElement zipcode;

	@FindBy(xpath = contine_xpath)
	private WebElement contine;

	@FindBy(id = finish_id)
	private WebElement finish;

	@FindBy(xpath = success_xpath)
	private WebElement success;

	@FindBy(id = backhome_id)
	private WebElement backhome;

	public SwagLoginPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean order1(ExtentTest extenttest) {
		clickOnElement(driver, product1);
		expliciWaitVisible(driver, producttext);
		Assert.assertEquals(producttext.getText(), "Sauce Labs Backpack");
		clickOnElement(driver, addcart);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		clickOnElement(driver, cart);
		clickOnElement(driver, checkout);
		passInput(driver, firstname, Frm.getInstancefrm().getInstanceConfigurationReader().getfirstname1());
		passInput(driver, lastname, Frm.getInstancefrm().getInstanceConfigurationReader().getlastname1());
		passInput(driver, zipcode, Frm.getInstancefrm().getInstanceConfigurationReader().getpostalcode1());
		clickOnElement(driver, contine);
		clickOnElement(driver, finish);
		expliciWaitVisible(driver, success);
		Assert.assertEquals(success.getText(), "Thank you for your order!");
		extenttest.log(Status.PASS, "Thank you for your order!");
		clickOnElement(driver, backhome);
		return false;
	}

	public boolean order2(ExtentTest extenttest) {
		clickOnElement(driver, product2);
		expliciWaitVisible(driver, producttext);
		Assert.assertEquals(producttext.getText(), "Sauce Labs Bike Light");
		clickOnElement(driver, addcart);
		clickOnElement(driver, cart);
		clickOnElement(driver, checkout);
		passInput(driver, firstname, Frm.getInstancefrm().getInstanceConfigurationReader().getfirstname2());
		passInput(driver, lastname, Frm.getInstancefrm().getInstanceConfigurationReader().getlastname2());
		passInput(driver, zipcode, Frm.getInstancefrm().getInstanceConfigurationReader().getpostalcode2());
		clickOnElement(driver, contine);
		clickOnElement(driver, finish);
		expliciWaitVisible(driver, success);
		Assert.assertEquals(success.getText(), "Thank you for your order!");
		clickOnElement(driver, backhome);
		return false;
	}

	public boolean order3(ExtentTest extenttest) {
		clickOnElement(driver, product3);
		expliciWaitVisible(driver, producttext);
		Assert.assertEquals(producttext.getText(), "Sauce Labs Bolt T-Shirt");
		clickOnElement(driver, addcart);
		clickOnElement(driver, cart);
		clickOnElement(driver, checkout);
		passInput(driver, firstname, Frm.getInstancefrm().getInstanceConfigurationReader().getfirstname3());
		passInput(driver, lastname, Frm.getInstancefrm().getInstanceConfigurationReader().getlastname3());
		passInput(driver, zipcode, Frm.getInstancefrm().getInstanceConfigurationReader().getpostalcode3());
		clickOnElement(driver, contine);
		clickOnElement(driver, finish);
		expliciWaitVisible(driver, success);
		Assert.assertEquals(success.getText(), "Thank you for your order!");
		clickOnElement(driver, backhome);
		return false;
	}

	public boolean order4(ExtentTest extenttest) {
		clickOnElement(driver, product4);
		expliciWaitVisible(driver, producttext);
		Assert.assertEquals(producttext.getText(), "Sauce Labs Fleece Jacket");
		clickOnElement(driver, addcart);
		clickOnElement(driver, cart);
		clickOnElement(driver, checkout);
		passInput(driver, firstname, Frm.getInstancefrm().getInstanceConfigurationReader().getfirstname4());
		passInput(driver, lastname, Frm.getInstancefrm().getInstanceConfigurationReader().getlastname4());
		passInput(driver, zipcode, Frm.getInstancefrm().getInstanceConfigurationReader().getpostalcode4());
		clickOnElement(driver, contine);
		clickOnElement(driver, finish);
		expliciWaitVisible(driver, success);
		Assert.assertEquals(success.getText(), "Thank you for your order!");
		clickOnElement(driver, backhome);
		return false;
	}

	public boolean order5(ExtentTest extenttest) {
		clickOnElement(driver, product5);
		expliciWaitVisible(driver, producttext);
		Assert.assertEquals(producttext.getText(), "Sauce Labs Onesie");
		clickOnElement(driver, addcart);
		clickOnElement(driver, cart);
		clickOnElement(driver, checkout);
		passInput(driver, firstname, Frm.getInstancefrm().getInstanceConfigurationReader().getfirstname5());
		passInput(driver, lastname, Frm.getInstancefrm().getInstanceConfigurationReader().getlastname5());
		passInput(driver, zipcode, Frm.getInstancefrm().getInstanceConfigurationReader().getpostalcode5());
		clickOnElement(driver, contine);
		clickOnElement(driver, finish);
		expliciWaitVisible(driver, success);
		Assert.assertEquals(success.getText(), "Thank you for your order!");
		clickOnElement(driver, backhome);
		return false;
	}

	public boolean validLogIn(ExtentTest extenttest) {

		try {
			url(Frm.getInstancefrm().getInstanceConfigurationReader().geturl());
			passInput(driver, username, Frm.getInstancefrm().getInstanceConfigurationReader().getusername());
			passInput(driver, password, Frm.getInstancefrm().getInstanceConfigurationReader().getpassword());
			clickOnElement(driver, login);
			validationtitle(driver, Frm.getInstancefrm().getInstanceConfigurationReader().gethome());
			extenttest.log(Status.PASS, "Login SuccessFull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extenttest.log(Status.FAIL, "Login Failed" + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean emptyUserEmptyPass(ExtentTest extenttest) {

		url(Frm.getInstancefrm().getInstanceConfigurationReader().geturl());
		clickOnElement(driver, login);
		expliciWaitVisible(driver, error);
		Assert.assertEquals(error.getText(), "Epic sadface: Username is required");

		return true;
	}

	public boolean validUserEmptyPass(ExtentTest extenttest) {
		url(Frm.getInstancefrm().getInstanceConfigurationReader().geturl());
		passInput(driver, username, Frm.getInstancefrm().getInstanceConfigurationReader().getusername());
		clickOnElement(driver, login);
		expliciWaitVisible(driver, error);
		Assert.assertEquals(error.getText(), "Epic sadface: Password is required");

		return true;
	}

	public boolean validUserInvalidPass(ExtentTest extenttest) {

		url(Frm.getInstancefrm().getInstanceConfigurationReader().geturl());
		passInput(driver, username, Frm.getInstancefrm().getInstanceConfigurationReader().getusername());
		passInput(driver, password2, Frm.getInstancefrm().getInstanceConfigurationReader().getpassword2());
		clickOnElement(driver, login);
		expliciWaitVisible(driver, error);
		Assert.assertEquals(error.getText(),
				"Epic sadface: Username and password do not match any user in this service");

		return true;
	}

	public boolean invalidUserValidPass(ExtentTest extenttest) {

		url(Frm.getInstancefrm().getInstanceConfigurationReader().geturl());
		passInput(driver, username2, Frm.getInstancefrm().getInstanceConfigurationReader().getusername2());
		passInput(driver, password2, Frm.getInstancefrm().getInstanceConfigurationReader().getpassword2());
		clickOnElement(driver, login);
		expliciWaitVisible(driver, error);
		Assert.assertEquals(error.getText(),
				"Epic sadface: Username and password do not match any user in this service");

		return true;
	}

}
