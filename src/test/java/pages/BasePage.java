package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	protected WebDriver driver;
	private static Map<String,String> record = new HashMap<String,String>();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);			
	}
	
	public String getRecord(String key) {
		if(record.containsKey(key)) {
			record.get(key);
		}
		return  null;
	}

	public void setRecord(String key, String val) {
		if(!record.containsKey(key)) {
			record.put(key, val);
		}
	}
	
	public void clickElement(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
	}
	
	
	public void scrollToView(WebElement ele) {
		
		((JavascriptExecutor)driver)
		.executeScript(String.format("window.scrollTo(%s,%s)", ele.getLocation().x, ele.getLocation().y));
		
		
//		int tries = 10;
//		for(int i =0; i < tries; i++) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", ele);
//			
//			try {
//				ele.isDisplayed();
//				break;
//			}catch(Exception e) {}
//		}
	
	}
	
	public void scrollToView(int height) {
		String javascript = "window.scrollBy(0,"+height+")";  
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript(javascript);  
	}
	
	public void moveToElement(WebElement ele) {
		Actions act  = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	
	
	

}
