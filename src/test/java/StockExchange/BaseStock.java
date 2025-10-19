/**
 * 
 */
package StockExchange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Ravikumar 14/10/2025 Implementing the base class and home page
 */
public class BaseStock {
	
	WebDriver driver;
	HomePage hp;
	ExtentReports extent;
	ExtentSparkReporter reporter;
	
	@BeforeTest
	public void initialization() {
		driver=new ChromeDriver();
		hp=new HomePage(driver);
		String path=System.getProperty("user.dir")+"\\Reports\\AutomationResult.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("National Stock Exchange Results");
		reporter.config().setDocumentTitle("WebAutomation");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ravikumar");
		driver.get("https://www.nseindia.com/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void openingAboutNSE() {
		extent.createTest("openingAboutNSE");
		hp.closeNotifyWindow();
		hp.openAboutNSE();
		extent.flush();
		
	}
	
	@Test
	public void openingList() {
		extent.createTest("openingList");
		hp.openingList();
		extent.flush();
	}
	
	@Test
	public void openingInvest() {
		extent.createTest("openingInvest");
		hp.openingInvest();
		extent.flush();
	}

}
