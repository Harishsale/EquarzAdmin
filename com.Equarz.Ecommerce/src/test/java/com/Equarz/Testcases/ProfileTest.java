package com.Equarz.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Profile_functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class ProfileTest extends Testbase{
	Login_Functionality Login;
	Profile_functionality Pf;
	Utils uts;
	private final String sheetname="Profile";
	public ProfileTest()
	{
		super();
	}
	@DataProvider
	public String[][] setdata1() throws Throwable {
return uts.setdata(sheetname);
}
	@BeforeMethod
	public void initialise() throws Throwable
	{
	Setup();
	Login= new Login_Functionality(driver);
	Pf=new Profile_functionality(driver);
	Login.validateLogin();
	}
	@Test(priority = 1,dataProvider = "setdata1",dataProviderClass = ProfileTest.class)
	public void edit(String name2, String last2, String num2, String password12,
			String password22) throws Throwable
	{
		Pf.profileedit(name2,last2,num2,
				password12,password22);	
	}
}