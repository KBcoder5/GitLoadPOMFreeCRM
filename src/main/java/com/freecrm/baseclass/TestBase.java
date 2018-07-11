package com.freecrm.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.util.Testutil;

public class TestBase {

	public static WebDriver driver; //reason for static 
	public static Properties prop;
	
	public TestBase()  
	{
		try {
			//create properties object 
			prop = new Properties();
			
			//fetch data from cofig.properties file 
			FileInputStream fi = new FileInputStream("C:\\Users\\Beriwal\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\"
					+ "com\\freecrm\\config\\config.properties");
			prop.load(fi);
		} 
		//File not found catch block
		catch (FileNotFoundException  e) {
			System.out.println(e.getMessage());
		}
		//Input Output exception catch block
		catch (IOException  e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Beriwal\\Downloads\\Selenium Jars\\chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.geco.driver", "C:\\Users\\Beriwal\\Downloads\\Selenium Jars\\gecodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	}
	
	
	
}
