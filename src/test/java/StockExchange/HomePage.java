package StockExchange;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action=new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement closeDialogBox;
	@FindBy(xpath = "(//a[normalize-space()='About'])[1]")
	WebElement about;
	@FindBy(xpath = "//a[contains(@class,'nav-link')][normalize-space()='About Us']")
	WebElement aboutNSE;
	@FindBy(xpath = "//a[@id='link_2']")
	WebElement marketData;
	@FindBy(xpath = "//a[normalize-space()='New Listings']")
	WebElement newList;
	
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
	}
	
	public void waitSomeTime(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitElementShow(WebElement ele1) {
		wait.until(ExpectedConditions.visibilityOf(ele1));
	}

}
