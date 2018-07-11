package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.baseclass.TestBase;
import com.freecrm.pages.Home;
import com.freecrm.pages.Loginpage;

public class LoginPageTest extends TestBase {
	
	Loginpage loginpage;
	Home homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		TestBase.initialization();
		 loginpage = new Loginpage();
	}

	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String logintitle = loginpage.validatePageTitle();
		Assert.assertEquals(logintitle,"Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test(priority=2)
	public void crmLogoValidate()
	{
		Boolean logocheck= loginpage.ValidateCRMimg();
		Assert.assertTrue(logocheck);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
