package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Address_functionality extends Testbase {
	Utils uts = new Utils();
	Actions act = new Actions(driver);
	int i;
	@FindBy(xpath = "//small[text()='Hello, Niharika']")
	WebElement dashboard;
	@FindBy(xpath = "//a[text()=' My profile']")
	WebElement profile;
	@FindBy(xpath = "//a[text()='Address '] ")
	WebElement address;
	@FindBy(xpath = "//label[text()='Permanent']")
	WebElement type;
	@FindBy(id = "add_new_address")
	WebElement newaddress;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(id = "person_name")
	WebElement personna;
	@FindBy(id = "phone")
	WebElement number;
	@FindBy(id = "own_phone")
	WebElement editnumber;
	@FindBy(id = "address-city")
	WebElement city;
	@FindBy(xpath = "//select[@name='country']")
	WebElement drop1;
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement box;
	@FindBy(id = "zip")
	WebElement zipcode;
	@FindBy(id = "zip_code")
	WebElement editzip;
	@FindBy(xpath = "//input[@name='city']")
	WebElement editcity;
	@FindBy(xpath = "//button[@class='btn dropdown-toggle btn-light']")
	WebElement button;
	@FindBy(xpath = "//span[text()='India']")
	WebElement countryname;
	@FindBy(id = "address")
	WebElement ouraddress;
	@FindBy(xpath = "//button[text()='Add Informations  ']")
	WebElement submit;
	@FindBy(xpath = "(//i[@class='fa fa-trash fa-lg'])[6]")
	WebElement delete;
	@FindBy(xpath = "//section[@class='col-lg-6 col-md-6']")
	List<WebElement> addresssel;
	@FindBy(xpath = "//button[text()='Update  ']")
	WebElement update;
	@FindBy(xpath = "//div[text()='Data updated successfully!']")
	WebElement success;
	@FindBy(id="edit")
	WebElement editin;

	public Address_functionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Addressselection(String personname, String phonenumber, String cityname, String pincode,
			String addressofperson) throws Throwable {
		act.moveToElement(dashboard).build().perform();
		Thread.sleep(2000);
		profile.click();
		address.click();
		int beforeaddressadd = addresssel.size();
		beforeaddressadd += 1;

		newaddress.click();
		type.click();
		name.sendKeys(personname);
		number.sendKeys(phonenumber);
		city.sendKeys(cityname);
		zipcode.sendKeys(pincode);
		button.click();
		box.sendKeys(props.getProperty("Country"));
		countryname.click();
//uts.dropdown(address, "India");
		ouraddress.sendKeys(addressofperson);
		submit.click();
		int afteraddressadd = addresssel.size();
		assertEquals(beforeaddressadd, afteraddressadd);
	}

	public void editaddress(String personname, String phonenumber, String cityname, String pincode,
			String addressofperson) throws Throwable {
		act.moveToElement(dashboard).build().perform();
		Thread.sleep(2000);
		profile.click();
		address.click();
		int addresssize = addresssel.size();
		String beforeXpathaddress = "//section[@class='col-lg-6 col-md-6'][";
		String afterXpathaddress = "]";
		String beforeXpathremove = "(//a[@title='Edit Address'])[";
		String afterXpathremove = "]";

		for (i = 1; i <= addresssize; i++) {
			String ActualXpath = beforeXpathaddress + i + afterXpathaddress;
			WebElement element = driver.findElement(By.xpath(ActualXpath));

			if (element.getText().contains("niharika")) {
				String actualremove = beforeXpathremove + i + afterXpathremove;
				WebElement remove = driver.findElement(By.xpath(actualremove));
				remove.click();
				Thread.sleep(2000);
				personna.clear();
				personna.sendKeys(personname);
				editnumber.clear();
				editnumber.sendKeys(phonenumber);
				editcity.clear();
				editcity.sendKeys(cityname);
				editzip.clear();
				editzip.sendKeys(pincode);
				button.click();
				box.sendKeys(props.getProperty("Country"));
				countryname.click();
				ouraddress.clear();
				ouraddress.sendKeys(addressofperson);
				update.click();
				String str = success.getText();
				assertEquals(str, "Data updated successfully!");
	}
}	
		}

	public void deleteaddress() throws Throwable {
		act.moveToElement(dashboard).build().perform();
		Thread.sleep(2000);
		profile.click();
		address.click();
		int beforeaddressadd = addresssel.size();
		beforeaddressadd -= 1;
		int addresssize = addresssel.size();
		String beforeXpathaddress = "//section[@class='col-lg-6 col-md-6'][";
		String afterXpathaddress = "]";
		String beforeXpathremove = "(//i[@class='fa fa-trash fa-lg'])[";
		String afterXpathremove = "]";

		for (i = 1; i <= addresssize; i++) {
			String ActualXpath = beforeXpathaddress + i + afterXpathaddress;
			WebElement element = driver.findElement(By.xpath(ActualXpath));

			if (element.getText().contains("niharika")) {
				String actualremove = beforeXpathremove + i + afterXpathremove;
				WebElement remove = driver.findElement(By.xpath(actualremove));
				remove.click();
				Thread.sleep(2000);
				Alert al = driver.switchTo().alert();
				al.accept();
				int afteraddressadd = addresssel.size();
				assertEquals(beforeaddressadd, afteraddressadd);
			}

		}
	}
}