package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Banner_Functionality {
	@FindBy(xpath = "//button[@class='close __close']")
	WebElement popup;
	   @FindBy(xpath="//img[@src='http://e-quarz.com/storage/app/public/banner/2023-07-21-64ba5d58940f6.png']")
	WebElement banner;
	   @FindBy(xpath="//a[@href='http://e-quarz.com/product/raymond-mens-flat-front-slim-fit-dark-grey-formal-trouser-a5Q5y1']")
	   WebElement product;
		@FindBy(xpath = "//span[text()='Add to cart']")
		WebElement cart;
		public Banner_Functionality(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public Homepage Banner_add(WebDriver driver) throws Exception {
			popup.click();
			banner.click();
			product.click();
			cart.click();
			return new Homepage();
		}
}