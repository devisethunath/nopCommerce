package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameters;
import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();

	public String baseURL= readconfig.getApplicationURL()    ;// "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public String username= readconfig.getUseremail()   ;//    "admin@yourstore.com";
	public String password= readconfig.getPassword();//"admin";

	public static WebDriver driver;


	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("C:\\Users\\sethu\\eclipse-workspace\\nopCommerce\\target\\classes\\Log4jproperties");//put this log4j properties file under target folder in classes
		
		
		if (br.equals("chrome"))
			
		{		
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32New/chromedriver.exe");//opens browser
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver=new FirefoxDriver();}
		}
		

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
