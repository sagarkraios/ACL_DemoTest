package com.hm.kraios.insightsValidations;


import java.util.Hashtable;
import com.hm.kraios.pages.InsightsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.seleniumFactory.BaseTest;


public class ValidateMarketExplorer {
	
	public boolean verifyIsUserHavingAccesToInsightsMarketExplorerTab() {
		boolean result = false;
 
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR,
				"INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR")) {
			BaseTest.seleniumWrapperManager.get().click(InsightsPage.INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR,
					"INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR");
			result = true;
		}
		return result;
	}
	
	
	public boolean validateInsightsMarketExplorerView(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();	
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_MarketExplorer_Tab").equals("Y")) {
				result=verifyIsUserHavingAccesToInsightsMarketExplorerTab();
				if (result == true) {
					BaseTest.passTest("User has access To Insights Market Explorer View and Validation got passed");
				}
				else {
					BaseTest.failTest("Expected: User has access To Insights Market Explorer View, Actual: User  doesn't has the  access To Insights Market Explorer View",data);
				}
				 
			} else if (data.get("Insights_MarketExplorer_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR,
						"INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR");

				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Market Explorer View and Validation got passed");
				} else 
				{
					BaseTest.failTest("Expected: User shoud not have access To Insights Market Explorer View, Actual: User has access To Insights Market Explorer View",data);
				}
			
			}
		} else if (data.get("Insights_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Insights Menu and Validation got passed");
			} else {
				BaseTest.failTest("Expected: User shoud not have access To Insights Menu, Actual: User has access To Insights Menu",data);
			}
		}
		return result;
 
	
	}
	

}