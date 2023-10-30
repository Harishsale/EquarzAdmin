package com.Equarz.Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.Address_functionality;
import com.Pageobjects.Login_Functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class AddressTest extends Testbase{
	Login_Functionality Login;
	Address_functionality Af;
	Utils uts;
	private final String sheetname="Address";
	private final String sheetname1="EditAddress";
	public AddressTest()
	{
		super();
	}
	@DataProvider
	public String[][] setdata1() throws Throwable {
return uts.setdata(sheetname);
	}
	@DataProvider
	public String[][] setdata2() throws Throwable {
return uts.setdata(sheetname1);
}
	@BeforeClass
	public void initialise() throws Throwable
	{
	Setup();
	Login= new Login_Functionality(driver);
	Af=new Address_functionality(driver);
	Login.validateLogin();
	}
	
	@Test(priority = 1,dataProvider = "setdata1",dataProviderClass = AddressTest.class)
	public void address1(String personname1,String phonenumber1,String cityname1,
			String pincode1,String addressofperson1) throws Throwable
	{
		Af.Addressselection(personname1,phonenumber1,cityname1,
				pincode1,addressofperson1);	
	}
	@Test(priority = 2,dataProvider = "setdata2",dataProviderClass = AddressTest.class)
	public void editing(String personname2,String phonenumber2,String cityname2,
			String pincode2,String addressofperson2) throws Throwable
{
Af.editaddress(personname2,phonenumber2,cityname2,
		pincode2,addressofperson2);	
}
@Test(priority = 3)
	public void del() throws Throwable
{
Af.deleteaddress();	
}
@AfterClass
public void shutdown()
{
driver.close();	
}
}
