package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Logout_Functionality extends Testbase{
	Actions act = new Actions(driver);
	@FindBy(xpath="//a[text()='Logout']")
WebElement out;
	@FindBy(xpath = "//small[text()='Hello, Niharika']")
	WebElement dashboard;
	@FindBy(xpath="//div[text()='Come back soon, !']")
	WebElement success;
	public Logout_Functionality(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	public void logou() throws Throwable
	{
		act.moveToElement(dashboard).build().perform();
		Thread.sleep(2000);
		out.click();
		String msg=success.getText();
		assertEquals(msg, "Come back soon, !");
	}
	public void refresh() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		out.click();
		driver.navigate().refresh();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/", url);
	}	
	public void navback() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		out.click();
		driver.navigate().back();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/", url);
}
	public void navfor() throws InterruptedException 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(dashboard).build().perform();
		out.click();
		driver.navigate().back();
		driver.navigate().forward();
		String url=driver.getCurrentUrl();
		assertEquals("http://e-quarz.com/", url);
}
}
