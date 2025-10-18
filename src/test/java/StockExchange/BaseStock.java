/**
 * 
 */
package StockExchange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Ravikumar 14/10/2025 Implementing the base class and home page
 */
public class BaseStock {
	
	WebDriver driver;
	HomePage hp;
	
	@Test
	public void openingAboutNSE() {
		driver=new ChromeDriver();
		hp=new HomePage(driver);
		driver.get("https://www.nseindia.com/");
		driver.manage().window().maximize();
		hp.closeNotifyWindow();
		hp.openAboutNSE();
		
	}
	
	@Test
	public void openingList() {
		hp.openingList();
	}
	
	@Test
	public void openingInvest() {
		hp.openingInvest();
		//Based on the web hook checking going to changes the code
	}

}
