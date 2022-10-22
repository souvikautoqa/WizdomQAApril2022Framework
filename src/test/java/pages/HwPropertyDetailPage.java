package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwPropertyDetailPage extends BasePage{

	@FindBy(xpath="((.//div[@class='room-container desktop'])[1]//div[@class='dropdown-wrapper'])[1]")
	private WebElement chooseBed;
	
	@FindBy(xpath=".//div[@class='menu']//li[contains(text(),'1 Bed')]")
	private WebElement oneBedItem;
	
	@FindBy(id="summary-n-nights")
	private WebElement nights;
	
	@FindBy(xpath="((.//div[@class='room-container desktop'])[1]//div[@class='rate-price-line'])[1]//div[@id]")
	private WebElement bedPrice;
		
	@FindBy(id="book-now-button")
	private WebElement bookNowBtn;
	
	public HwPropertyDetailPage(WebDriver driver) {
		super(driver);		
	}

	public void chooseBed() {
		chooseBed.click();
		oneBedItem.click();
		setRecord("nights",nights.getText());
		setRecord("bedPrice",bedPrice.getText().replace("€",""));
	}
	
	
	

}
