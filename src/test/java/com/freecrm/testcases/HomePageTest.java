package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.baseclass.TestBase;
import com.freecrm.pages.Home;
import com.freecrm.pages.Loginpage;
import com.freecrm.util.Testutil;

public class HomePageTest extends TestBase {
	
	Home homepage;
	Loginpage loginpage;
	Testutil testutil;
	
	public HomePageTest()
	{
		super();
	}
		
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String homepagetitle = homepage.ValidateTitleHomePage();
		Assert.assertEquals(homepagetitle,"CRMPRO","Home page title doesnt match");
	}
	
	@Test(priority=2)
	public void UsernameTest()
	{
		testutil.switchtoframe(prop.getProperty("usernameframe"));
		Assert.assertTrue(homepage.ValidateLoginName());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
