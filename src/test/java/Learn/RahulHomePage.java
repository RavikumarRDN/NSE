package Learn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.Syncronization;
import StockExchange.BaseStock;

public class RahulHomePage extends BaseStock {
	
	WebDriver driver;
	Syncronization sc = new Syncronization();
	
	public RahulHomePage() {
		// TODO Auto-generated constructor stub
	}

	public RahulHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//label[normalize-space()='Radio1']")
	WebElement RadioButton;
	@FindBy(xpath="//input[@id='autocomplete']")
	WebElement Autosuggest;
	@FindBy(xpath="//ul[@id='ui-id-1']/li[@class='ui-menu-item']")
	List<WebElement> suggestList;
	
	public void checkRadioButton() {
		RadioButton.click();
		System.out.println("Radio button = "  + RadioButton.isEnabled());
	}
	
	public void checkAutoSuggest() throws InterruptedException {
		Autosuggest.sendKeys("Ind");
		//sc.waitSomeTime(suggestList);
		Thread.sleep(5000);
		//System.out.println(suggestList);
		for(WebElement option : suggestList) {
			System.out.println(option.getText());
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
	}

}
