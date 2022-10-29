package tests;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.ExcelDataProvider;
import core.JSONDataProvider;
import pages.HwCheckOutPage;
import pages.HwHomePage;
import pages.HwPropertyDetailPage;
import pages.HwPropertyListPage;

public class HostelWorldTests extends TestBase{
	
	HwHomePage home;
	HwPropertyListPage propertyList;
	HwPropertyDetailPage propertyDetail;
	HwCheckOutPage checkout;
	
	@Test(dataProvider="getJsonData")
	public void verifyBedPriceAtCheckout(Map<String,String> data) throws Exception {
		home = new HwHomePage(driver());
		Assert.assertEquals(home.launchApp(), true);
		home.citySearch(data.get("destination"));
		
		propertyList = new HwPropertyListPage(driver());
		
		propertyDetail = new HwPropertyDetailPage(driver());
		propertyDetail.chooseBed();	
	}
	
	@Test(dataProvider="getJsonData")
	public void verifyRoomNumberAtCheckout(Map<String,String> data) throws Exception {
		home = new HwHomePage(driver());
		Assert.assertEquals(home.launchApp(), true);
		home.citySearch(data.get("destination"));
		
		propertyList = new HwPropertyListPage(driver());
		propertyList.chooseFirstProperty();
		
		propertyDetail = new HwPropertyDetailPage(driver());
		propertyDetail.chooseBed();	
	}

}
