package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Search_functionality extends Testbase{
	
//@FindBy(xpath="//button[@class='close __close']")
//WebElement popup;
	@FindBy(xpath = "//input[@class='form-control appended-form-control search-bar-input']")
	WebElement searchbox;
	@FindBy(xpath="//button[@class='input-group-append-overlay search_button']")
	WebElement searchbutton;
	@FindBy(xpath="//img[@src='http://e-quarz.com/storage/app/public/product/thumbnail/2023-06-22-6494250a4b39a.png']")
	WebElement selection;
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement cart;
	public Search_functionality (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public Homepage Search_product()
{
	//popup.click();
	searchbox.sendKeys(props.getProperty("searchbox1"));
	searchbutton.click();
	selection.click();
	cart.click();
	return new Homepage();
}
}
