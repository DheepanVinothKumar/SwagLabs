package com.swagInterface;

public interface LoginElements {

	String user_xpath = "//input[@placeholder='Username']";
	String pass_xpath = "//input[@placeholder='Password']";
	String login_id = "login-button";
	String error_xpath = "//*[@id='login_button_container']/div/form/div[3]/h3";
	String prod1_xpath = "(//div[@data-test='inventory-item-name'])[1]";
	String prod2_xpath = "(//div[@data-test='inventory-item-name'])[2]";
	String prod3_xpath = "(//div[@data-test='inventory-item-name'])[3]";
	String prod4_xpath = "(//div[@data-test='inventory-item-name'])[4]";
	String prod5_xpath = "(//div[@data-test='inventory-item-name'])[5]";
	String prod_xpath = "//div[@class='inventory_details_name large_size']";
	String addcart_id = "add-to-cart";
	String cart_xpath = "//*[@class='shopping_cart_link']";
	String checkout_id = "checkout";
	String firstname_id = "first-name";
	String lastname_id = "last-name";
	String postal_id = "postal-code";
	String contine_xpath = "//input[@type='submit']";
	String finish_id = "finish";
	String success_xpath = "//*[@data-test='complete-header']";
	String backhome_id = "back-to-products";

}