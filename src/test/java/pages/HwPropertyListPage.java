package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwPropertyListPage extends BasePage{
	
	@FindBy(xpath=".//div[@class='property-card']//button[text()='View']")
	private List<WebElement> propertyViewBtns;
	
	public HwPropertyListPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseFirstProperty() throws Exception {
		Thread.sleep(5000);
		
		//List<WebElement> items = driver.findElements(By.xpath(".//div[@class='property-card']//div[@class='prices-col']"));
		
		//scrollToView(items.get(2));
		
		//moveToElement(propertyViewBtns.get(1));
		//propertyViewBtns.get(0).click();
		
		clickElement(propertyViewBtns.get(0));
	}
	
	
	
	
}
