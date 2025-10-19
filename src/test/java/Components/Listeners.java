package Components;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import StockExchange.BaseStock;

public class Listeners implements ITestListener{
	ExtentTest test;
	com.aventstack.extentreports.ExtentReports extent=BaseStock.gettingreports();
	 public  void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());

		
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 System.out.println("This time successfully run test cases");
		 test.log(Status.PASS, "Test Passed");
	  }
	 
	 public void onTestFailure(ITestResult result) {
		    test.fail(result.getThrowable());
		    String filepath = null;
		    try {
		    	
				filepath=BaseStock.getScreenShot(result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	  }
	 
	 public void onFinish(ITestContext context) {
		    extent.flush();
		  }
	 
	 

}
