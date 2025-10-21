package Learn;

import org.testng.annotations.*;

import StockExchange.BaseStock;

public class BestLearn extends BaseStock {
	RahulHomePage RH=new RahulHomePage(driver);
	
	@Ignore
	@BeforeMethod
	public void initial() {
		RH=new RahulHomePage(driver);
	}
	
	@Test(priority=1)
	public void checkRadioButton() {
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		RH.checkRadioButton();
	}
	
	@Test(priority=2)
	public void checkAuto() throws InterruptedException {
		RH.checkAutoSuggest();
	}

}
