package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwCheckOutPage {

	@FindBy(xpath=".//span[@class='total-price']")
	private WebElement totalPrice;
	
	
}
