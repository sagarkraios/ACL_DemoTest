package com.hm.kraios.workflowValidations;


import java.util.Hashtable;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;




public class ValidateCreateNewRequests {
	
	
	
public boolean ValidateCreateNewServiceRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		
		boolean result = false;
		 
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
			
			if (data.get("Request_Tab").equals("Y")) {	
				WorkFlowPage.RequestsPage.clickOnRequestsTab();
					
				WorkFlowPage.RequestsPage.CreateNewRequest.clickOnCreateNewRequest();					
					if(WorkFlowPage.RequestsPage.CreateNewRequest.isVisibleServiceLine(data))
					{
						WorkFlowPage.RequestsPage.CreateNewRequest.clickOnServiceLine(data);
					}
					else {
						 
						BaseTest.failTest("Expected:User should have access to serviceline, Actual: User Not have access to serviceline",data);
					}
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnSelectEntityNameDropdown();
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnSelectEntityNameCheckbox(data);
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnEntityNameTitle();
					WorkFlowPage.RequestsPage.CreateNewRequest.EnterServiceRequestsTitle();
					WorkFlowPage.RequestsPage.CreateNewRequest.EnterRequestsDescription();
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestSubmitButton();
					
	
			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR, "REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",data);
				}	
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}	
		}
		return result;	
		
	}
		
		
public boolean validateCreateNewSupportRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		
		boolean result = false;
		 
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
			
			if (data.get("Request_Tab").equals("Y")) {	
				WorkFlowPage.RequestsPage.clickOnRequestsTab();
					
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnCreateNewRequest();

					if(WorkFlowPage.RequestsPage.CreateNewRequest.isVisibleNewRequestKraiosSupport())
					{
						WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestKraiosSupport();
					}
					else {
						 
						BaseTest.failTest("Expected: User should have access to Create New Kraios Support Request, Actual: User not have access to Create New Kraios Support Request",data);
					}
					WorkFlowPage.RequestsPage.CreateNewRequest.EnterSupportRequestsTitle();
					WorkFlowPage.RequestsPage.CreateNewRequest.EnterRequestsDescription();
					WorkFlowPage.RequestsPage.CreateNewRequest.clickOnNewRequestSubmitButton();
 
			} else if (data.get("Request_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.RequestsPage.REQUESTS_TAB_LOCATOR, "REQUESTS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Request Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To Request Tab, Actual: User has access To Request Tab",data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}
		}
		return result;	
		
	}
	
	
	

}