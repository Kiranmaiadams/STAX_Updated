package com.STAX_Objects;

import org.openqa.selenium.By;

public class staxHomepage {

	public static final By Signinbutton = By.xpath("//li[@class='account nav-dropdown']");
	public static final By AcceptCookies = By.xpath("//button[@id='sta-cookie-save-all-button']");
	public static final By registerwithemailaddress = By.xpath("//i[@class='mysta-Icon-email']");
	public static final By emailaddress = By.xpath("//input[@class='mysta-Form-input js-emailLookup']");
	public static final By Continuebutton = By
			.xpath("//div[@class='mysta-Form-row mysta-Form-row--continue js-emailHideIfSuccess']");
	public static final By Firstname = By.xpath("//input[@id='FirstName']");
	public static final By Lastname = By.xpath("//input[@id='LastName']");
	public static final By Password = By.xpath("//input[@id='Password']");
	public static final By ConfirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	public static final By Signupbutton = By.xpath("//button[@class='mysta-Button mysta-Button--full']");

	
	
}
