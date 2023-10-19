package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Buynow_Functionality;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Logout_Functionality;
import com.base.Testbase;

public class Logouttest extends Testbase{
	Logout_Functionality lf;
	Login_Functionality lg;
    
	public Logouttest() {
		super();
	}
	@BeforeMethod
	public void initialize() throws Throwable {
		
		Setup();
		lg= new Login_Functionality(driver);
		lg.validateLogin();
		lf = new Logout_Functionality(driver);
	}
	@Test(priority = 1)
	public void signout() throws Throwable
	{
		 lf.logou();
	}
	@Test(priority = 2)
	public void ref() throws Throwable
	{
		 lf.refresh();
	}
	@Test(priority = 3)
	public void bac() throws Throwable
	{
		 lf.navback();
	}
	@Test(priority = 4)
	public void forw() throws Throwable
	{
		 lf.navfor();
	}
	@AfterMethod
	public void shutdown() throws Throwable {
		
		driver.close();
	}
}

