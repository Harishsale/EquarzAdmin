package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Homepagelinks extends Testbase{
@FindBy(xpath="//a[text()='Featured Products']")
WebElement Featured;
@FindBy(xpath="//a[text()='Latest Products']")
WebElement Latest;
@FindBy(xpath="//a[text()='Best Selling Products']")
WebElement Bestselling;
@FindBy(xpath="//a[text()='Top Rated Products']")
WebElement Toprated;
@FindBy(xpath="//a[text()='Profile Info']")
WebElement Profile;
@FindBy(xpath="Track Order")
WebElement Tracking;
@FindBy(xpath="//a[text()='Refund policy']")
WebElement Refund;
@FindBy(xpath="//a[text()='Return policy']")
WebElement Return;
@FindBy(xpath="//a[text()='Cancellation policy']")
WebElement Cancel;
@FindBy(xpath="//img[@src='http://e-quarz.com/public/assets/front-end/png/about company.png']")
WebElement Aboutcmpny;
@FindBy(xpath="//img[@src='http://e-quarz.com/public/assets/front-end/png/contact us.png']")
WebElement Contact;
@FindBy(xpath="//img[@src='http://e-quarz.com/public/assets/front-end/png/faq.png']")
WebElement FAQ;
@FindBy(xpath="//a[@href='http://e-quarz.com/account-tickets']")
WebElement Support;
@FindBy(xpath="//a[text()='Terms & Conditions']")
WebElement Condition;
@FindBy(xpath="//a[@href='http://e-quarz.com/privacy-policy']")
WebElement Privacy;
@FindBy(xpath="//i[@class='fa fa-twitter']")
WebElement Twitter;
@FindBy(xpath="//i[@class='fa fa-linkedin']")
WebElement Linkedin;
@FindBy(xpath="//i[@class='fa fa-google-plus-square']")
WebElement Googleplus;
@FindBy(xpath="//i[@class='fa fa-pinterest']")
WebElement Pinterest;
@FindBy(xpath="//i[@class='fa fa-instagram']")
WebElement Instagram;
@FindBy(xpath="//i[@class='fa fa-facebook']")
WebElement Facebook;
public Homepagelinks(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
public void feature()
{
	Featured.click();	
	String str=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/products?data_from=featured&page=1", str);
}
public void latest()
{
	Latest.click();
	String str1=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/products?data_from=latest&page=1", str1);
}
public void bestsell()
{
	Bestselling.click();
	String str2=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/products?data_from=best-selling&page=1", str2);
}
public void topprod()
{
	Toprated.click();
	String str3=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/products?data_from=top-rated&page=1", str3);
}
public void profile()
{
Profile.click();
String str4=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/user-account", str4);
}
public void track()
{
	Tracking.click();
	String str5=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/track-order", str5);	
}
public void refund()
{
	Refund.click();
	String str6=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/refund-policy", str6);
}
public void return1()
{
	Return.click();
	String str7=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/return-policy", str7);
}
public void cancel()
{
Cancel.click();
String str8=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/cancellation-policy", str8);
}
public void cmpny()
{
	Aboutcmpny.click();
	String str9=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/about-us", str9);
}
public void contact()
{
	Contact.click();
	String str10=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/contacts", str10);
}
public void question()
{
FAQ.click();
String str11=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/helpTopic", str11);
}
public void ticket()
{
Support.click();
String str12=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/account-tickets", str12);
}
public void condition()
{
Condition.click();
String str13=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/terms", str13);
}
public void policy()
{
Privacy.click();
String str14=driver.getCurrentUrl();
assertEquals("http://e-quarz.com/privacy-policy", str14);
}
public void tweet() throws Throwable
{
	
	String window1=driver.getWindowHandle();
	System.out.println(window1);
	Twitter.click();
	Thread.sleep(2000);
	Set<String> handles=driver.getWindowHandles();
			for(String handle:handles)
			{
				//System.out.println(handle);
				if(!window1.equals(handle)) 
				{
					driver.switchTo().window(handle);
					driver.manage().window().maximize();
					String str15=driver.getCurrentUrl();
					assertEquals("https://twitter.com/i/flow/login?redirect_after_login=%2F%3Flang%3Den-in", str15);
				}
			}
}
			public void insta() throws Throwable
			{
				
				String window1=driver.getWindowHandle();
				System.out.println(window1);
				Instagram.click();
				Thread.sleep(2000);
				Set<String> handles=driver.getWindowHandles();
						for(String handle:handles)
						{
							//System.out.println(handle);
							if(!window1.equals(handle)) 
							{
								driver.switchTo().window(handle);
								driver.manage().window().maximize();
								
							}
						}

}
}
