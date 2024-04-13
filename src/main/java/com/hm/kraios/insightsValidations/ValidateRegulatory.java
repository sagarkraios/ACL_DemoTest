package com.hm.kraios.insightsValidations;


import java.util.Hashtable;

import com.hm.kraios.pages.InsightsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.seleniumFactory.BaseTest;


public class ValidateRegulatory {
	
	public boolean verifyIsUserHavingAccesToInsightsEntityDataTab() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_ENTITY_DATA_TAB,"INSIGHTS_REGULATORY_ENTITY_DATA_TAB")) {
			BaseTest.seleniumWrapperManager.get().forceClick(InsightsPage.Regulatory.INSIGHTS_REGULATORY_ENTITY_DATA_TAB,"INSIGHTS_REGULATORY_ENTITY_DATA_TAB");
		
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_ENTITIES_BOARD,
				"INSIGHTS_REGULATORY_ENTITIES_BOARD")
				&& BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_JURISDICTIONS_BOARD,
						"INSIGHTS_REGULATORY_JURISDICTIONS_BOARD")
				&& BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_ENTITY_DATA_STRUCTURE,
						"INSIGHTS_REGULATORY_ENTITY_DATA_STRUCTURE")) {
			result = true;
 
		}}
		return result;
	}
	

	public  static boolean verifyIsUserHavingAccesToInsightsRegulatoryUpdatesTab() {
		boolean result = false;
 
			if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_UPDATES_TAB,"INSIGHTS_REGULATORY_UPDATES")) {
				BaseTest.seleniumWrapperManager.get().forceClick(InsightsPage.Regulatory.INSIGHTS_REGULATORY_UPDATES_TAB,"INSIGHTS_REGULATORY_UPDATES_TAB");
			
				if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_UPDATES_SUMMARY,
						"INSIGHTS_REGULATORY_UPDATES_SUMMARY")
						&& BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_BULLETIN_FILTER_CONTAINER,
								"INSIGHTS_REGULATORY_BULLETIN_FILTER_CONTAINER")) 
				{			
					result = true;
			}}

		return result;
	}
	
	public  static boolean verifyIsUserHavingAccesToInsightsTMFArticlesTab() {
		boolean result = false;
 
			if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_TMFARTICLES_TAB,"INSIGHTS_REGULATORY_TMFARTICLES_TAB")) {
				BaseTest.seleniumWrapperManager.get().forceClick(InsightsPage.Regulatory.INSIGHTS_REGULATORY_TMFARTICLES_TAB,"INSIGHTS_REGULATORY_TMFARTICLES_TAB");
			
				if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_TMF_ARTICLE_SUMMARY,
						"INSIGHTS_TMF_ARTICLE_SUMMARY")
						&& BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_BULLETIN_FILTER_CONTAINER,
								"INSIGHTS_REGULATORY_BULLETIN_FILTER_CONTAINER")) 
				{			
					result = true;
			}}

		return result;
	}
	public static boolean verifyIsUserHavingAccesToInsightsStructureChartTab() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB,"INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB")) {
			BaseTest.seleniumWrapperManager.get().forceClick(InsightsPage.Regulatory.INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB,"INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB");
		
			if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_STRUCTURE_CHART_NETWORK,
					"INSIGHTS_REGULATORY_STRUCTURE_CHART_NETWORK")) {
				result = true;
		}}

		return result;
	}
	
	
	public boolean validateInsightsEntityData(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();	
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Regulatory_Menu").equals("Y")) {
				InsightsPage.clickOnRegulatory();

				if (data.get("Insights_Entity_Data_Tab").equals("Y")) {					
					
					
					result=verifyIsUserHavingAccesToInsightsEntityDataTab();
					
					if (result == true) {
						BaseTest.passTest("User has access To Insights Regulatory Entity Data Tab and Validation got passed");
					}
					else {
						BaseTest.failTest("Expected: User has access To Insights Regulatory Entity Data Tab, Actual: User  doesn't has the  access To Insights Regulatory Entity Data Tab",data);
					}
			
				} else if (data.get("Insights_Entity_Data_Tab").equals("N")) {
					result =BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_ENTITY_DATA_TAB,"INSIGHTS_REGULATORY_ENTITY_DATA_TAB");
					if (result == true) {
						 
						BaseTest.passTest("User shoud not have access To Insights Regulatory Entity Data Tab and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Entity Data Tab, Actual: User has access To Insights Regulatory Entity Data Tab",data);
					}}
	 
			} else if (data.get("Insights_Regulatory_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_REGULATORY_TAB_LOCATOR,"INSIGHTS_REGULATORY_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Regulatory Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Menu, Actual: User has access To Insights Regulatory Menu",data);
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
	
	public boolean validateInsightsRegulatoryUpdates(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;	
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Regulatory_Menu").equals("Y")) {
				InsightsPage.clickOnRegulatory();

				if (data.get("Insights_RegulatoryUpdates_Tab").equals("Y")) {
				
					boolean regulatoryupdates=verifyIsUserHavingAccesToInsightsRegulatoryUpdatesTab();
					boolean tmfarticles=verifyIsUserHavingAccesToInsightsTMFArticlesTab();
					
					if (regulatoryupdates == true & tmfarticles== true) {
						BaseTest.passTest("User has access To Insights Regulatory Updates Tab and Validation got passed");
					}
					else {
						BaseTest.failTest("Expected: User has access To Insights Regulatory Updates Tab, Actual: User  doesn't has the  access To Insights Regulatory Updates Tab",data);
					}
	
					
				} else if (data.get("Insights_RegulatoryUpdates_Tab").equals("N")) {
				
					result=BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_UPDATES_TAB,"INSIGHTS_REGULATORY_UPDATES");
					
					if (result == true) {
						 
						BaseTest.passTest("User shoud not have access To Insights Regulatory Updates Tab and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Updates Tab, Actual: User has access To Insights Regulatory Updates Tab",data);
					}}
				
			} else if (data.get("Insights_Regulatory_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_REGULATORY_TAB_LOCATOR,"INSIGHTS_REGULATORY_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Regulatory Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Menu, Actual: User has access To Insights Regulatory Menu",data);
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
	
	public boolean validateInsightsStructureChart(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();			
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Regulatory_Menu").equals("Y")) {
				InsightsPage.clickOnRegulatory();

				if (data.get("Insights_StructureChart_Tab").equals("Y")) {
					result=verifyIsUserHavingAccesToInsightsStructureChartTab();
					
					if (result == true) {
						BaseTest.passTest("User has access To Insights Regulatory Structure Chart Tab and Validation got passed");
					}
					else {
						BaseTest.failTest("Expected: User has access To Insights Regulatory Structure Chart Tab, Actual: User  doesn't has the  access To Insights Regulatory Structure Chart Tab",data);
					}
	
					
				} else if (data.get("Insights_StructureChart_Tab").equals("N")) {
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Regulatory.INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB,"INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB");
					if (result == true) {
						 
						BaseTest.passTest("User shoud not have access To Insights Regulatory Structure Chart Tab and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Structure Chart Tab, Actual: User has access To Insights Regulatory Structure Chart Tab",data);
					}
				}
				
			} else if (data.get("Insights_Regulatory_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_REGULATORY_TAB_LOCATOR,"INSIGHTS_REGULATORY_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Regulatory Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Regulatory Menu, Actual: User has access To Insights Regulatory Menu",data);
				}			}
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