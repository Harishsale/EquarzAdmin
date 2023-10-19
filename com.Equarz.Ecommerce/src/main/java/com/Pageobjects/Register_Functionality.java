package com.Pageobjects;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

	public class Register_Functionality extends Testbase{
		Utils uts=new Utils();
		@FindBy(xpath = "//input[@name='f_name']")
		WebElement firstname;
		
		@FindBy(xpath = "//input[@name='l_name']")
		WebElement lastname;
		
		@FindBy(xpath = "//input[@name='email']")
		WebElement email;
		
		@FindBy(xpath = "//input[@name='phone']")
		WebElement phone;
		
		@FindBy(id = "si-password")
		WebElement password;
		
		@FindBy(name = "con_password")
		WebElement confirm_password;
		
		@FindBy(id = "inputCheckd")
		WebElement checkbox;
		
		@FindBy(id = "sign-up")
		WebElement signup;
		
		public Register_Functionality(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public Homepage Regdetails(String first,String last,String emailid,
				String Phonenum,String Password1,String Confirmpassword) throws Throwable 
		{
			//System.out.println(first+last+emailid+Phonenum+Password1+Confirmpassword);
			firstname.sendKeys(first);
			lastname.sendKeys(last);
			email.sendKeys(emailid);
			phone.sendKeys(Phonenum);
			password.sendKeys(Password1);
			confirm_password.sendKeys(Confirmpassword);
			checkbox.click();
			Thread.sleep(15000);
			//Thread.sleep(2000);
			signup.click();
			Thread.sleep(2000);
			return new Homepage();
		}
	}


