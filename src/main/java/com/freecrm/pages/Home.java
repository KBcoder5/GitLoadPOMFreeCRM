package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.baseclass.TestBase;

public class Home extends TestBase  {
	
	@FindBy(xpath ="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	WebElement loginName;
	
	//Initializing page abjects
	public Home()
	{
		PageFactory.initElements(driver, this);
	}

	public String ValidateTitleHomePage()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	public  boolean ValidateLoginName()
	{
		return loginName.isDisplayed();
	}
	
	
}
