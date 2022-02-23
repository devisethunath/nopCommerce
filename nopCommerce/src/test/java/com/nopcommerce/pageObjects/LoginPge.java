package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPge {


	public WebDriver ldriver;

	public LoginPge(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//input[@id='Email']")
	WebElement txtemail;

	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpassword;

	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement lnklogout;
	
	
	public void setUsername(String uname)
	{
		txtemail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnSubmit.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}

}
