package com.Equarz.Testcases;

	import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.Register_Functionality;
import com.Utils.Utils;
import com.base.Testbase;

	public class SignupTest extends Testbase {
		Register_Functionality reg;
		Utils uts;
		private final String sheetname="Register"; 
		public SignupTest()
		{
			super();
		}
		@DataProvider
		public String[][] setdata1() throws Throwable {
	return uts.setdata(sheetname);
		}
		@BeforeMethod
		public void initialization()
		{
			Setup();
			reg=new Register_Functionality(driver);
		}
		@Test(priority = 1)
		public void Givenurl() 
		{
			String givenurl = driver.getCurrentUrl();
			Assert.assertEquals("http://e-quarz.com/customer/auth/sign-up", givenurl);
		}
		@Test(priority = 2,dataProvider = "setdata1",dataProviderClass = SignupTest.class)
		public void Registration(String first,String last,String emailid,
				String Phonenum,String Password1,String Confirmpassword) throws Throwable
		{
			reg.Regdetails(first, last, emailid, Phonenum, Password1, Confirmpassword);
			
			
		}
		
@AfterMethod
public void shutdown() {
	driver.close();
}
	}

