package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.baseclass.TestBase;

public class Loginpage extends TestBase {

	
	//Page Factory setup 
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement submitBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/a[2]/button")
	WebElement signupBtn;

	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement imgcheck;
	
	//initializing page object
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCRMimg()
	{
		return imgcheck.isDisplayed();
	}
	
	public Home login(String user,String pass)
	{
		TestBase.initialization();
		username.sendKeys(user);
		password.sendKeys(pass);		
		submitBtn.click();
		
		return new Home();
	}


	
	
	
	
	
	
	
	
	
}
