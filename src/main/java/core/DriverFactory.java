package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private WebDriver driver;
	
	public WebDriver getDriver(String name) {
		switch(name.toLowerCase()) {
		case "chrome" : WebDriverManager.chromedriver().setup(); driver =  new ChromeDriver(); break;
		case "firefox": WebDriverManager.firefoxdriver().setup(); driver =  new FirefoxDriver(); break;
		case "edge" : WebDriverManager.edgedriver().setup(); driver =  new EdgeDriver(); break;
		default : 	WebDriverManager.chromedriver().setup(); driver =  new ChromeDriver(); break;
		}
		driver.manage().window().maximize();
		
		// To support syncing mechanism 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(Config.getProperty("pageLoadTimeout"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Config.getProperty("implicitWait"))));	
		return driver;
	}
	
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	

}
