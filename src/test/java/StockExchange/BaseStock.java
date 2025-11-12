/**
 * 
 */
package StockExchange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Learn.RahulHomePage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Ravikumar 14/10/2025 Implementing the base class and home page
 * Due to the some of errors triggering in the jenkins that's why changing and updating in github
 */
public class BaseStock {

	public WebDriver driver;
	HomePage hp;
	static ExtentReports extent;
	static ExtentSparkReporter reporter;
	static TakesScreenshot ts;
	RahulHomePage RHP;

	@BeforeClass
	public void initialization() {
		driver = new ChromeDriver();
		hp = new HomePage(driver);
		RHP = new RahulHomePage(driver);
		ts = (TakesScreenshot) driver;
	}
   
	
	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
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
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/" + testCaseName + ".png"));
		return testCaseName;
	}

}
