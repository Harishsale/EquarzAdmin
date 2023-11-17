package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;

public class Buynow_Functionality extends Testbase {
	
	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement elec;
	
	@FindBy(xpath = "//span[text()='Mobile Accessoires']")
	WebElement elec2;
	
	@FindBy(xpath = "//a[text()='Cases And Covers']")
	WebElement elec3;
	
	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/cosmus-webstar-45-cm-laptop-backpack-35-ltrs-large-school-bagtravel-bagpack-grey-9yAcYd']")
	WebElement prodt;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement cart;
	
	@FindBy(xpath = "//i[@class='navbar-tool-icon czi-cart']")
	WebElement cartarrow;
	
	@FindBy(xpath = "//a[@href='http://e-quarz.com/checkout-details']")
	WebElement checkout;
	
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement shipping;
	
	@FindBy(xpath = "//a[@class='btn btn--primary pull-right']")
	WebElement checkout2;
	
	@FindBy(id  = "same_as_shipping_address")
	WebElement sameadress;
	
	@FindBy(xpath = "//span[text()='Proceed payment']")
	WebElement payment;
	
	@FindBy(xpath = "//h5[@class='font-black __text-20px']")
	WebElement orderplaced;
	
	@FindBy(xpath  ="(//button[@class='btn btn-block click-if-alone'])[1]")
	WebElement COD;
	
	@FindBy(xpath ="//input[@placeholder='Search here ...']")
	WebElement searchbox;
	
	@FindBy(xpath="//i[@class='czi-search text-white']")
	WebElement searchbutton;
	
	@FindBy(xpath ="(//a[@href='http://e-quarz.com/product/dark-horse-30-l-casual-laptop-bagbackpack-office-bagschool-bagcollege-bagbusiness-bagunisex-travel-backpack-for-men-wome'])[1]")
	WebElement prod;
		@FindBy(xpath ="(//a[@href='http://e-quarz.com/product/hp-247-g8-laptop-amd-athlon-p-3045b-hd-14-inches355cm-hd-8gb-ram-ddr4-1tb-hddwindows-11-home-w11-sl-one-year-warranty-bl'])[1]")
	WebElement prod1;
		@FindBy(xpath = "//span[text()='Buy now']")
	WebElement Buynowbutton;
	@FindBy(xpath="//input[@name='contact_person_name']")
			WebElement name;
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath="//select[@name='address_type']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	@FindBy(xpath="//input[@name='zip']")
	WebElement Zipcode;
	@FindBy(xpath="//button[@class='btn dropdown-toggle btn-light']")
	WebElement Countrysel;
	@FindBy(xpath="//input[@aria-label='Search']")
	WebElement addsearchbox;
	@FindBy(xpath = "//span[text()='India']")
	WebElement countryname;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressbox;
	@FindBy(xpath="//input[@name='save_address']")
	WebElement savaddress;
	public  Buynow_Functionality (WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void cartBuynow (String personname, String phonenumber, String cityname, String pincode,
			String addressofperson) throws Exception {
		
		Actions ac= new Actions(driver);
		 ac.moveToElement(elec).build().perform();
		 ac.moveToElement(elec2).build().perform();
		 elec3.click();
		 prodt.click();
		 cart.click();
		 Thread.sleep(2000);
		 ac.moveToElement(cartarrow).build().perform();
		 checkout.click();
		 Select sc = new Select(shipping);
		 sc.selectByIndex(1);
		 Thread.sleep(2000);
		 checkout2.click();
		 name.sendKeys(personname);
		 phone.sendKeys(phonenumber);
			City.sendKeys(cityname);
			Zipcode.sendKeys(pincode);
			Countrysel.click();
			addsearchbox.sendKeys(props.getProperty("Country"));
			countryname.click();
			addressbox.sendKeys(addressofperson);
			savaddress.click();
		 sameadress.click();
		 payment.click();
		 Thread.sleep(3000);
		 COD.click();
		 wait= new WebDriverWait(null, Duration.ofSeconds(15));
		 String msg=wait.until(ExpectedConditions.visibilityOf(orderplaced)).getText();
	 	assertEquals(msg, "Your order has been placed successfully! !");
		 

		}
	
	public void Directbuynow () throws Exception {
		searchbox.sendKeys(props.getProperty("searchboxtext"));
		searchbutton.click();
		Thread.sleep(3000);
		prod.click();
		Buynowbutton.click();
//		Select sc = new Select(shipping);
//		 sc.selectByIndex(1);
//		 checkout2.click();
		name.sendKeys("niharika");
		 phone.sendKeys("6300313272");
			City.sendKeys("vinukonda");
			Zipcode.sendKeys("522547");
			Countrysel.click();
			addsearchbox.sendKeys(props.getProperty("Country"));
			countryname.click();
			addressbox.sendKeys("main bazar, vinukonda");
			savaddress.click();
		sameadress.click();
		payment.click();
		COD.click();
		
		}
	public void Homecartbuynow() throws Exception {
		Actions ac= new Actions(driver);
		ac.moveToElement(cartarrow).build().perform();
		 checkout.click();
		 Select sc = new Select(shipping);
		 sc.selectByIndex(1);
		 Thread.sleep(2000);
		 checkout2.click();
		 sameadress.click();
		 payment.click();
		 Thread.sleep(3000);
		 COD.click();
		
	}      
}
