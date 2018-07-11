package com.freecrm.util;

import com.freecrm.baseclass.TestBase;

public class Testutil extends TestBase {
	
	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_TIMEOUT = 20;
	
	public void switchtoframe(String FrameName)
	{
		driver.switchTo().frame(FrameName);
	}
	

}
