package StockExchange;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	String titleHome=" Ravikumar NSE - National Stock Exchange of India Ltd: Live Share/Stock Market News &amp; Updates, Quotes- Nseindia.com";
	String titleNSE="NSE - National Stock Exchange of India Ltd.";
	String titleList="Overview";
	String titleInvest="Stamp Duty, Compliance for Trading Members - NSE India";
	SoftAssert softassert;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action=new Actions(driver);
		softassert=new SoftAssert();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement closeDialogBox;
	@FindBy(xpath = "(//a[normalize-space()='About'])[1]")
	WebElement about;
	@FindBy(xpath = "//a[contains(@class,'nav-link')][normalize-space()='About Us']")
	WebElement aboutNSE;
	@FindBy(xpath = "//a[@id='link_4']")
	WebElement list;
	@FindBy(xpath = "//a[normalize-space()='On-boarding Process']")
	WebElement onBoarding;
	@FindBy(xpath = "//a[normalize-space()='New Listings']")
	WebElement newList;
	@FindBy(xpath = "//a[@id='link_3']")
	WebElement invest;
	@FindBy(xpath = "//a[normalize-space()='Charges and Taxes']")
	WebElement ChargesandTaxes;
	
	public void closeNotifyWindow() {
		waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
	}
	
	public void openAboutNSE() {
		waitSomeTime(about);
		System.out.println("Displayed the about" + about.isDisplayed());
		action.moveToElement(about).click().build().perform();
		waitSomeTime(aboutNSE);
		System.out.println("Displayed the About US" + aboutNSE.isDisplayed());
		action.moveToElement(aboutNSE).click().build().perform();
		softassert.assertEquals(titleNSE, driver.getTitle());
		//assert.assertTrue(driver.getTitle(), titleNSE);
		System.out.println("Successfully executed first Test Case");
	}
	
	public void openingList() {
		driver.manage().deleteAllCookies();
		driver.get("https://www.nseindia.com/");
		waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
		waitElementShow(list);
		waitSomeTime(list);
		action.moveToElement(list).click().build().perform();
		waitSomeTime(onBoarding);
		action.click(onBoarding);
		softassert.assertEquals(titleList, driver.getTitle());
		System.out.println("Successfully executed second Test Case");
	}
	
	public void openingInvest() {
		driver.manage().deleteAllCookies();
		driver.get("https://www.nseindia.com/");
		waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
		waitElementShow(invest);
		waitSomeTime(invest);
		action.moveToElement(invest).click().build().perform();
		waitSomeTime(ChargesandTaxes);
		action.click(ChargesandTaxes);
		softassert.assertEquals(titleInvest, driver.getTitle());
		softassert.assertAll();
		System.out.println("Successfully executed third Test Case");

	}
	
	public void failTest() {
		driver.navigate().back();
		action.moveToElement(about).click().build().perform();
		System.out.println("Test case is failed due to the requirement and understand purpose");
		
	}
	
	public void waitSomeTime(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitElementShow(WebElement ele1) {
		wait.until(ExpectedConditions.visibilityOf(ele1));
	}
	

}
