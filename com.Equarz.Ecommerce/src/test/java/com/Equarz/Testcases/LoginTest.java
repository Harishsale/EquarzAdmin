package com.Equarz.Testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class LoginTest extends Testbase{
Login_Functionality lg;
	
	public LoginTest() {
		super();
		
	}
	@BeforeMethod
	
	public void initialize() {
		Setup();
		lg=new Login_Functionality(driver);
	}
	@Test
	public void verifylog() throws Throwable {
		lg.validateLogin();
		
	}
	@AfterMethod
	public void shutdown() 
	{
		driver.close();
	}
	


}
