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
	
	@Test
	public void checkRadioButton() {
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		RH.checkRadioButton();
	}
	
	@Test
	public void checkAuto() throws InterruptedException {
		RH.checkAutoSuggest();
	}

}
