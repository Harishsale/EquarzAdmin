package com.Pageobjects;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.Utils;
import com.base.Testbase;

public class AdminScenarios1BuyProduct extends Testbase {
	String ID="";
	String status="";
	Utils uts=new Utils();
	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement elec;
	
	@FindBy(xpath = "//span[text()='Mobile Accessoires']")
	WebElement elec2;
	
	@FindBy(xpath = "//a[text()='Cases And Covers']")
	WebElement elec3;
	
	@FindBy(xpath = "//img[@src='http://e-quarz.com/storage/app/public/product/thumbnail/2023-06-22-64945be4d2044.png']")
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
	
	@FindBy( xpath = "//a[@class='btn btn-secondary pull-right']")
	WebElement checkorders;
	
	@FindBy(xpath = "//*[@class='table __table text-center']/tbody/tr[1]/td[1]")
	WebElement OrderID;
	
	@FindBy(xpath ="//input[@placeholder='Search here ...']")
	WebElement searchbox;
	
	@FindBy(xpath="//i[@class='czi-search text-white']")
	WebElement searchbutton;
	
	@FindBy(name  = "//a[@href='http://e-quarz.com/product/hp-247-g8-laptop-amd-athlon-p-3045b-hd-14-inches355cm-hd-8gb-ram-ddr4-1tb-hddwindows-11-home-w11-sl-one-year-warranty-bl']")
	WebElement prod;
	
	@FindBy(xpath = "//span[text()='Buy now']")
	WebElement Buynowbutton;
	
	@FindBy(xpath = "//input[@placeholder='email@address.com']")
	WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='8+ characters required']")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement sign;
	
	@FindBy( xpath = "//a[@title='Orders']")
	WebElement orders;
	
	@FindBy( xpath = "//a[@title='Pending']")
	WebElement pending;
	@FindBy(id="datatableSearch_")
	WebElement pendingsearch;
	@FindBy(xpath="//button[text()='Search']")
	WebElement pendingsearchbutton;
	@FindBy(xpath = "//select[@name='order_status']")
	WebElement orderstatus;
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	WebElement statusconfirm_popup;
	@FindBy(xpath="//*[@class='table __table text-center']/tbody/tr")
	List<WebElement> listoforder;
	
	
	public  AdminScenarios1BuyProduct (WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void AdminProduct () throws Exception {
		
		Actions ac= new Actions(driver);
		 ac.moveToElement(elec).build().perform();
		 ac.moveToElement(elec2).build().perform();
		 elec3.click();
		 Thread.sleep(2000);
		 prodt.click();
		 cart.click();
		 Thread.sleep(2000);
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
		 checkorders.click();
		 String id= OrderID.getText();
		// System.out.println(id);
		 String[] idnum=id.split(" ");
		 for (int i=0; i < idnum.length; i++)
		    {
		      //System.out.println(idnum[i]);
		     ID =idnum[1];
		    }
		// System.out.println(ID);
		// Actions action = new Actions(driver);
		driver.switchTo().newWindow(WindowType.TAB);
		 //ac.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform(); 
		 driver.navigate().to("http://e-quarz.com/admin/auth/login");
		 username.sendKeys(props.getProperty("adminusername"));
		 password.sendKeys(props.getProperty("adminpassword"));
		 Thread.sleep(15000);
		 sign.click();
		 orders.click();
		 pending.click();
		 pendingsearch.sendKeys(ID);
		 pendingsearchbutton.click();
		 String beforexpath="//a[text()='";
		 String afterxpath="']";
		 String orderidxpath=beforexpath+ID+afterxpath;
		 driver.findElement(By.xpath(orderidxpath)).click();
		 uts.dropdown(orderstatus,"confirmed");
		 Thread.sleep(2000);
		 statusconfirm_popup.click();
		 String window1 = driver.getWindowHandle();
		 uts.Windowhandless(window1);
		 driver.navigate().refresh();
//for(WebElement lisorder:listoforder)
//{
//System.out.println(lisorder.getText());	
//
//}
int i,listsize=listoforder.size();
String beforexpathrow="//*[@class='table __table text-center']/tbody/tr[";
String afterxpathrow="]";
String beforexpathdata="//*[@class='table __table text-center']/tbody/tr[";
String afterxpathdata="]/td[3]";
for(i=1;i<=listsize;i++)
{
String xpathrow=beforexpathrow+i+afterxpathrow;
String xpathdata=beforexpathdata+i+afterxpathdata;
WebElement rowname=driver.findElement(By.xpath(xpathrow));
if(rowname.getText().contains(id))
{
WebElement dataform=driver.findElement(By.xpath(xpathdata))	;
status=dataform.getText();
}

}
System.out.println(status);
assertEquals("Confirmed", status);
	}
}
