package com.hm.kraios.insightsValidations;


import java.util.Hashtable;
import com.hm.kraios.pages.InsightsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.seleniumFactory.BaseTest;


public class ValidateInsightsWorkflow {
	public boolean verifyIsUserHavingAccesToInsightsActivitiesDownloadReport() {
		boolean result = false;
 
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.WorkFlow.INSIGHTS_ACTIVITIES_DOWNLOAD_REPORT_LOCATOR,
				"INSIGHTS_ACTIVITIES_DOWNLOAD_REPORT_LOCATOR")) {
			result = true;
 
		}
		return result;
	}
	public boolean verifyIsUserHavingAccesToInsightsRequestsDownloadReport() {
		boolean result = false;
 
		if (BaseTest.seleniumWrapperManager.get().isVisible(InsightsPage.WorkFlow.INSIGHTS_REQUESTS_DOWNLOAD_REPORT_LOCATOR,
				"INSIGHTS_REQUESTS_DOWNLOAD_REPORT_LOCATOR")) {
			result = true;
 
		}
		return result;
	}
	
	public boolean validateInsightsActivitiesDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();	
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.INSIGHTS_LOCATOR, "INSIGHTS_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Workflow_Menu").equals("Y")) {
				InsightsPage.clickOnWorkFlow();

				if (data.get("Insights_Activities_Tab").equals("Y")) {
					InsightsPage.WorkFlow.clickOnInsightsActivities();
	 
					if (data.get("InsightsActivity_View").equals("Y")) {

					if (data.get("Insights_Activities_Report_link").equals("Y")) {
						InsightsPage.clickOnInsightsViewDetails();
						result=verifyIsUserHavingAccesToInsightsActivitiesDownloadReport();
						
						if (result == true) {
							BaseTest.passTest("User has access To Insights Activities Download Report and Validation got passed");
						}
						else {
							BaseTest.failTest("Expected: User has access To Insights Activities Download Report, Actual: User  doesn't has the  access To Insights Activities Download Report",data);
						}
						
						
					} else if (data.get("Insights_Activities_Report_link").equals("N")) {
						InsightsPage.clickOnInsightsViewDetails();
						result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.WorkFlow.INSIGHTS_ACTIVITIES_DOWNLOAD_REPORT_LOCATOR,"INSIGHTS_ACTIVITIES_DOWNLOAD_REPORT_LOCATOR");
						 
						if (result == true) {
	 
							BaseTest.passTest("User shoud not have access To Insights Activities Download Report and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Insights Activities Download Report, Actual: User has access To Insights Activities Download Report",data);
						}
						}
					}
					
					else if (data.get("InsightsActivity_View").equals("N")) {
						BaseTest.passTest("Passing the validation of this Test Case , Since user is not having Acces to Insights Activities View");
					}
						
				} else if (data.get("Insights_Activities_Tab").equals("N")) {
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.WorkFlow.INSIGHTS_ACTIVITIES_LOCATOR,"INSIGHTS_ACTIVITIES_LOCATOR");
					if (result == true) {
						BaseTest.passTest("User shoud not have access To Insights Activities Tab and Validation got passed");
					} else {
						BaseTest.failTest("Expected: User shoud not have access To Insights Activities Tab, Actual: User has access To Insights Activities Tab",data);
					}		
				}
				 
			} else if (data.get("Insights_Workflow_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_WORKFLOW_TAB_LOCATOR,"INSIGHTS_WORKFLOW_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Workflow Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Workflow Menu, Actual: User has access To Insights Workflow Menu",data);
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
	
	public boolean validateInsightsRequestsDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Insights_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();			
			KraiosMyWorkSpaceMenuPage.navigateToInsightsPage(data);
 
			if (data.get("Insights_Workflow_Menu").equals("Y")) {
				InsightsPage.clickOnWorkFlow();

				if (data.get("Insights_Requests_Tab").equals("Y")) {
					InsightsPage.WorkFlow.clickOnInsightsRequests();
	 
					if (data.get("InsightsRequest_View").equals("Y")) {

					if (data.get("Insights_Request_Report_Link").equals("Y")) {
						InsightsPage.clickOnInsightsViewDetails();
						result=verifyIsUserHavingAccesToInsightsRequestsDownloadReport();
						
						if (result == true) {
							BaseTest.passTest("User has access To Insights Requests Download Report and Validation got passed");
						}
						else {
							BaseTest.failTest("Expected: User has access To Insights Requests Download Report, Actual: User  doesn't has the  access To Insights Requests Download Report",data);
						}
						
						
					} else if (data.get("Insights_Request_Report_Link").equals("N")) {
						InsightsPage.clickOnInsightsViewDetails();
						result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.WorkFlow.INSIGHTS_REQUESTS_DOWNLOAD_REPORT_LOCATOR,"INSIGHTS_REQUESTS_DOWNLOAD_REPORT_LOCATOR");
						 
						if (result == true) {
	 
							BaseTest.passTest("User shoud not have access To Insights Requests Download Report and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Insights Requests Download Report, Actual: User has access To Insights Requests Download Report",data);
						}	
						}				}
					
					else if (data.get("InsightsRequest_View").equals("N")) {
						BaseTest.passTest("Passing the validation of this Test Case , Since user is not having Acces to Insights Requests View");
					}
					
					
				} else if (data.get("Insights_Requests_Tab").equals("N")) {
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.WorkFlow.INSIGHTS_REQUESTS_LOCATOR,"INSIGHTS_REQUESTS_LOCATOR");
					if (result == true) {
						BaseTest.passTest("User shoud not have access To Insights Requests Tab and Validation got passed");
					} else {
						BaseTest.failTest("Expected: User shoud not have access To Insights Requests Tab, Actual: User has access To Insights Requests Tab",data);
					}	
				}
				 
			} else if (data.get("Insights_Workflow_Menu").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(InsightsPage.INSIGHTS_WORKFLOW_TAB_LOCATOR,"INSIGHTS_WORKFLOW_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Insights Workflow Menu and Validation got passed");
				} else {
					BaseTest.failTest("Expected: User shoud not have access To Insights Workflow Menu, Actual: User has access To Insights Workflow Menu",data);
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