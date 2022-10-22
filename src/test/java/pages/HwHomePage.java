package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.Config;

public class HwHomePage extends BasePage{
	
	@FindBy(id="truste-consent-button")
	private WebElement cookies;
	
	@FindBy(id="location-text-input-field")
	private WebElement location;
	
	@FindBy(id="search-input-field")
	private WebElement citySearchText;
	
	@FindBy(xpath=".//ul[@id='predicted-search-results']//li/div")
	private List<WebElement> searchResults;
	
	@FindBy(id="search-button")
	private WebElement searchBtn;
	
	public HwHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean launchApp() {
		driver.get(Config.getProperty("baseURL")); // PROD : hosterlworld.com DEV : dev.hostelworld.com
		try {
			cookies.click();
		}catch(Exception e) {}
		return location.isDisplayed();
	}
	
	
	public void citySearch(String cityName) {
		location.click();
		citySearchText.sendKeys(cityName);
		searchResults.get(0).click();
		searchBtn.click();
	}
	
	
	

}
