package StockExchange;

import org.testng.annotations.Test;

public class BaseExchange extends BaseStock  {
	
   HomePage HPR=new HomePage();
	@Test(priority=1)
	public void openingAboutNSE() {
		driver.get("https://www.nseindia.com/");
		driver.manage().window().maximize();
		HPR.closeNotifyWindow();
		HPR.openAboutNSE();

	}

	@Test(priority=2)
	public void openingList() {

		HPR.openingList();

	}

	@Test(priority=3)
	public void openingInvest() {

		HPR.openingInvest();

	}
	
	@Test(priority=4)
	public void testFailExample() {
		HPR.failTest();
	}

}
