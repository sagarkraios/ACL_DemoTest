package com.hm.kraios.insightsValidations;


import java.util.Hashtable;

import com.hm.kraios.pages.InsightsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;


public class ValidateCompliance {
	
	public boolean verifyIsUserHavingAccesToInsightsTaxFilingsDownloadReport() {
		boolean result = false;
 
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.Compliance.INSIGHTS_TAX_FILINGS_DOWNLOAD_REPORT_LOCATOR,
				"INSIGHTS_TAX_FILINGS_DOWNLOAD_REPORT_LOCATOR")) {
			result = true;
		}
		return result;
	}
	
	
	
	public boolean validateInsightsTaxFilingsDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Compliance_Menu").equals("Y")) {
				InsightsPage.clickOnCompliance();

				if (data.get("Insights_Tax_Filings_Tab").equals("Y")) {
					InsightsPage.Compliance.clickOnInsightsTaxFilingsAndReports();
					if (data.get("InsightsTax_View").equals("Y")) {
					
					if (data.get("Insights_Tax_Filings_Reports_Link").equals("Y")) {
						InsightsPage.clickOnInsightsViewDetails();
						result=verifyIsUserHavingAccesToInsightsTaxFilingsDownloadReport();
						
						if (result == true) {
							BaseTest.passTest("User has access To Insights Tax Filings Download Report and Validation got passed");
						}
						else {
							BaseTest.failTest("Expected: User has access To Insights Tax Filings Download Report, Actual: User  doesn't has the  access To Insights Tax Filings Download Report",data);
						}
						
						
					} else if (data.get("Insights_Tax_Filings_Reports_Link").equals("N")) {
						InsightsPage.clickOnInsightsViewDetails();
						result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Compliance.INSIGHTS_TAX_FILINGS_DOWNLOAD_REPORT_LOCATOR,
								"INSIGHTS_TAX_FILINGS_DOWNLOAD_REPORT_LOCATOR");
						 
						if (result == true) {
	 
							BaseTest.passTest("User shoud not have access To Insights Tax Filings Download Report and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Insights Tax Filings Download Report, Actual: User has access To Insights Tax Filings Download Report",data);
						}		
						}			
					}
					else if (data.get("InsightsTax_View").equals("N")) {
						BaseTest.passTest("Passing the validation of this Test Case , Since user is not having Acces to Insights Tax View");
					}
					
				} else if (data.get("Insights_Tax_Filings_Tab").equals("N")) {
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Compliance.INSIGHTS_TAX_FILINGS_REPORTS_LOCATOR,"INSIGHTS_TAX_FILINGS_REPORTS_LOCATOR");
					
					if (result == true) {
						BaseTest.passTest("User shoud not have access To Insights Tax Filings Tab and Validation got passed");
					} else {
						BaseTest.failTest("Expected: User shoud not have access To Insights Tax Filings Tab, Actual: User has access To Insights Tax Filings Tab",data);
					}
				}
				 
			} else if (data.get("Insights_Compliance_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_COMPLIANCE_TAB_LOCATOR,"INSIGHTS_COMPLIANCE_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Compliance Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Compliance Menu, Actual: User has access To Insights Compliance Menu",data);
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
	
	public boolean validateInsightsCorporateIncomeTaxExport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();	
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Compliance_Menu").equals("Y")) {
				InsightsPage.clickOnCompliance();

				if (data.get("Insights_CIT_Tab").equals("Y")) {
					InsightsPage.Compliance.clickOnInsightsCorporateIncomeTax();
	 
					if (data.get("Insights_Complaince_CIT_View").equals("Y")) {

					if (data.get("Insights_CIT_Export_Link").equals("Y")) {
						WorkFlowPage.Export.clickOnExportThreeDots();
						result=WorkFlowPage.Export.verifyIsUserHavingAccesToExport();
						
						if (result == true) {
							BaseTest.passTest("User has access To Insights Corporate Income Tax Export and Validation got passed");
						}
						else {
							BaseTest.failTest("Expected: User has access To Insights Corporate Income Tax Export, Actual: User  doesn't has the  access To Insights Corporate Income Tax Export",data);
						}
						
						
					} else if (data.get("Insights_CIT_Export_Link").equals("N")) {
						result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.Export.EXPORT_THREE_DOTS_ICON_LOCATOR,"EXPORT_THREE_DOTS_ICON_LOCATOR");
						 
						if (result == true) {
	 
							BaseTest.passTest("User shoud not have access To Insights Corporate Income Tax Export and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Insights Corporate Income Tax Export, Actual: User has access To Insights Corporate Income Tax Export",data);
						}	
						}
					}
					else if (data.get("Insights_Complaince_CIT_View").equals("N")) {
						BaseTest.passTest("Passing the validation of this Test Case , Since user is not having Acces to Insights Corporate Income Tax View");
					}
					
				} else if (data.get("Insights_CIT_Tab").equals("N")) {
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.Compliance.INSIGHTS_CORPORATE_INCOME_TAX_LOCATOR,"INSIGHTS_CORPORATE_INCOME_TAX_LOCATOR");
					if (result == true) {
						BaseTest.passTest("User shoud not have access To Insights CIT Tab and Validation got passed");
					} else {
						BaseTest.failTest("Expected: User shoud not have access To Insights CIT Tab, Actual: User has access To Insights CIT Tab",data);
					}	
				}
				 
			} else if (data.get("Insights_Compliance_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_COMPLIANCE_TAB_LOCATOR,"INSIGHTS_COMPLIANCE_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Compliance Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Compliance Menu, Actual: User has access To Insights Compliance Menu",data);
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