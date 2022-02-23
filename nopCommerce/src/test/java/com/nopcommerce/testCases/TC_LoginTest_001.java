package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPge;

public class TC_LoginTest_001 extends BaseClass {


	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		
		logger.info("URL is open");
		
		
		LoginPge lp = new LoginPge(driver);
		//lp.setUsername(username);
		
		logger.info("user is provided");
		//lp.setPassword(password);
		logger.info("password is provided");
		lp.clickLogin();
		
		Thread.sleep(5000);

		if 

		(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
			lp.clickLogout();
			logger.info("login passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login failed");
		}
	}
	
}
