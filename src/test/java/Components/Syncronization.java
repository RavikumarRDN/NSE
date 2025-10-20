package Components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StockExchange.BaseStock;

public class Syncronization extends BaseStock {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public void waitSomeTime(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitElementShow(WebElement ele1) {
		wait.until(ExpectedConditions.visibilityOf(ele1));
	}
	
	public void waitSomeTime(List<WebElement> suggestList) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) suggestList));
	}

}
