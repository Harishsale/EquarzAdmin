package com.Equarz.Testcases;

	import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	import com.Pageobjects.Buynow_Functionality;
	import com.Pageobjects.Login_Functionality;
	import com.Pageobjects.Wishlist_Functionality;
import com.Utils.Utils;
import com.base.Testbase;

	public class BuynowTest  extends Testbase {
		Buynow_Functionality bf;
		Login_Functionality lg;
		Utils uts;
		private final String sheetname="prodaddress";
		public BuynowTest() {
			super();
		}
		@DataProvider
		public String[][] setdata3() throws Throwable {
	return uts.setdata(sheetname);
		}
		@BeforeMethod
		public void initialize() throws Throwable {
			
			Setup();
			lg= new Login_Functionality(driver);
			lg.validateLogin();
			bf = new Buynow_Functionality(driver);
		}
		@Test
		public void Buynow(String personname3,String phonenumber3,String cityname3,
				String pincode3,String addressofperson3) throws Throwable
		{
			 bf.cartBuynow (personname3,phonenumber3,cityname3,
						pincode3,addressofperson3);
		}
		@Test
		public void Buynow1() throws Throwable
		{
			
			
			bf.Directbuynow ();
		}
		@Test
		public void Buynow2() throws Throwable
		{
			 bf.Homecartbuynow ();
		}
	@AfterMethod
	public void shutdown()
	{
		driver.close();
	}
	}


