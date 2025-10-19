/**
 * 
 */
package StockExchange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



/**
 * Ravikumar 14/10/2025 Implementing the base class and home page
 */
public class BaseStock {

	WebDriver driver;
	HomePage hp;
	static ExtentReports extent;
	static ExtentSparkReporter reporter;
	static TakesScreenshot ts;

	@BeforeTest
	public void initialization() {
		driver = new ChromeDriver();
		hp = new HomePage(driver);
		ts=(TakesScreenshot) driver;
		driver.get("https://www.nseindia.com/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}

	@Test(priority=1)
	public void openingAboutNSE() {

		hp.closeNotifyWindow();
		hp.openAboutNSE();

	}

	@Test(priority=2)
	public void openingList() {

		hp.openingList();

	}

	@Test(priority=3)
	public void openingInvest() {

		hp.openingInvest();

	}
	
	@Test(priority=4)
	public void testFailExample() {
		hp.failTest();
	}
	

	public static ExtentReports gettingreports() {
		String path = System.getProperty("user.dir") + "\\Reports\\AutomationResult.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("National Stock Exchange Results");
		reporter.config().setDocumentTitle("WebAutomation");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ravikumar");
		return extent;

	}
	
	public static String getScreenShot(String testCaseName) throws IOException {
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/" + testCaseName +".png"));
		return testCaseName;
	}

}
