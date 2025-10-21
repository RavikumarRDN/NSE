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

import Components.Syncronization;

public class HomePage {
	WebDriver driver1;
	WebDriverWait wait;
	Actions action;
	String titleHome = "NSE - National Stock Exchange of India Ltd: Live Share/Stock Market News &amp; Updates, Quotes- Nseindia.com";
	String titleNSE = "NSE - National Stock Exchange of India Ltd.";
	String titleList = "Overview";
	String titleInvest = "Stamp Duty, Compliance for Trading Members - NSE India";
	SoftAssert softassert;
	Syncronization sc1 = new Syncronization();

	public HomePage(WebDriver driver1) {
		this.driver1 = driver1;
		wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
		action = new Actions(driver1);
		softassert = new SoftAssert();
		PageFactory.initElements(driver1, this);
	}

	public HomePage() {
		// TODO Auto-generated constructor stub
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
		sc1.waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
	}

	public void openAboutNSE() {
		sc1.waitSomeTime(about);
		System.out.println("Displayed the about" + about.isDisplayed());
		action.moveToElement(about).click().build().perform();
		sc1.waitSomeTime(aboutNSE);
		System.out.println("Displayed the About US" + aboutNSE.isDisplayed());
		action.moveToElement(aboutNSE).click().build().perform();
		softassert.assertEquals(titleNSE, driver1.getTitle());
		System.out.println("Successfully executed first Test Case");
		softassert.assertAll();
	}

	public void openingList() {
		driver1.manage().deleteAllCookies();
		driver1.get("https://www.nseindia.com/");
		sc1.waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
		sc1.waitElementShow(list);
		sc1.waitSomeTime(list);
		action.moveToElement(list).click().build().perform();
		sc1.waitSomeTime(onBoarding);
		action.click(onBoarding).build().perform();
		softassert.assertEquals(titleList, driver1.getTitle());
		System.out.println(driver1.getTitle() + " EXPECTED" + titleList);
		System.out.println("Successfully executed second Test Case");
		softassert.assertAll();
	}

	public void openingInvest() {
		driver1.manage().deleteAllCookies();
		driver1.get("https://www.nseindia.com/");
		sc1.waitSomeTime(closeDialogBox);
		System.out.println("Displayed the dialogBox" + closeDialogBox.isDisplayed());
		closeDialogBox.click();
		sc1.waitElementShow(invest);
		sc1.waitSomeTime(invest);
		action.moveToElement(invest).click().build().perform();
		sc1.waitSomeTime(ChargesandTaxes);
		action.click(ChargesandTaxes).build().perform();
		System.out.println(driver1.getTitle() + " EXPECTED" + titleInvest);
		softassert.assertEquals(titleInvest, driver1.getTitle());
		softassert.assertAll();
		System.out.println("Successfully executed third Test Case");

	}

	public void failTest() {
		driver1.navigate().back();
		action.moveToElement(about).click().build().perform();
		System.out.println("Test case is failed due to the requirement and understand purpose");
		System.out.println(driver1.getTitle());

	}


}
