package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Profile_functionality extends Testbase {
	Actions act = new Actions(driver);
	Utils uts=new Utils();
	
	@FindBy(xpath = "//small[text()='Hello, Niharika']")
	WebElement dashboard;
	@FindBy(xpath = "//a[text()=' My profile']")
	WebElement profile;
	@FindBy(id = "f_name")
	WebElement firstname;
	@FindBy(id = "l_name")
	WebElement lastname;
	@FindBy(id = "phone")
	WebElement number;
	@FindBy(xpath = "//button[text()='Update   ']")
	WebElement update;
	@FindBy(id = "password")
	WebElement newpassword;
	@FindBy(id = "confirm_password")
	WebElement confirmpassword;
	@FindBy(xpath = "//label[@class='spandHeadO m-0']")
	WebElement image;
	@FindBy(xpath="//div[text()='Updated successfully']")
	WebElement success;
public Profile_functionality(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
public void profileedit(String name1, String last, String num, String password1,
		String password2) throws Throwable
{
	act.moveToElement(dashboard).build().perform();
	Thread.sleep(2000);
	profile.click();
	firstname.clear();
firstname.sendKeys(name1);
lastname.clear();
lastname.sendKeys(last);
number.clear();
number.sendKeys(num);
newpassword.sendKeys(password1);
confirmpassword.sendKeys(password2);
image.click();
uts.robo();
update.click();
String str=success.getText();
assertEquals(str, "Updated successfully");
}

}
