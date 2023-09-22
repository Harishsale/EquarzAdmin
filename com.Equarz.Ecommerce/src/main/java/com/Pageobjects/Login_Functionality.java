package com.Pageobjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;


public class Login_Functionality extends Testbase {
	
	@FindBy(id="si-email")
	WebElement User;
	
	@FindBy(id="si-password")
	WebElement pass;
	
	//String str=JOptionPane.showInputDialog("enter captcha");
	@FindBy(xpath="//input[@placeholder='Enter captcha value']")
	WebElement captch;
	
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signnbtn;
	
	public Login_Functionality (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public Homepage validateLogin() throws InterruptedException  {
		User.sendKeys(props.getProperty("username"));
		pass.sendKeys(props.getProperty("password"));
		Thread.sleep(15000);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signnbtn.click();
		return new Homepage();
				
	}
	
	

	

	
}
