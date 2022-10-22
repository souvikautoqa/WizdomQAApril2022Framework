package tests;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import core.Config;
import core.DriverFactory;
import core.ExcelDataProvider;
import core.ITestData;
import core.JSONDataProvider;

public class TestBase {
	
	private DriverFactory df;
	private WebDriver driver;
	
	@BeforeSuite
	public void initSuite() {
		Config.loadProperty(System.getenv("env"));
	}
		
	@BeforeClass(alwaysRun=true)
	public void initDriver() {
		df = new DriverFactory();
		driver =  df.getDriver(System.getenv("browser"));
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		df.tearDown();
	}
	
	public WebDriver driver() {
		return driver;
	}
	
	@DataProvider
	public Object[][] getData(Method method){
		ITestData data = null;
		String dataSource =  System.getenv("data").toLowerCase();
		try {			
			if(dataSource.equals("excel")) {
				String filePath =  System.getProperty("user.dir")+"//src//test//resources//data//TestData.xlsx";
				data = new ExcelDataProvider(filePath,System.getenv("env"));
			}else if(dataSource.equals("json")) {
				String filePath =  System.getProperty("user.dir")+"//src//test//resources//data//"+System.getenv("env").toLowerCase()+"_data.json";
				data = new JSONDataProvider(filePath);
			}
			List<Map<String,String>> extractedData = data.getAllData(method.getName());
			Object[][] dp = new Object[extractedData.size()][1];
			for(int i=0;i<extractedData.size();i++) {
				dp[i][0] = extractedData.get(i);
			}
			return dp;
		}catch(Exception e) {}
		return null;	
	}
	
	@DataProvider
	public Object[][] getJsonData(Method method) throws Exception{
		String filePath =  System.getProperty("user.dir")+"//src//test//resources//data//dev_data.json";
		JSONDataProvider json =  new JSONDataProvider(filePath);
		List<Map<String,String>> extractedData  = json.getAllData(method.getName());
		
		Object[][] data = new Object[extractedData.size()][1];
		
		for(int i=0;i<extractedData.size();i++) {
			data[i][0] = extractedData.get(i);
		}
		
		return data;
	}


}
