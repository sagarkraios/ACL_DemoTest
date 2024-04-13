package com.hm.kraios.entitiesValidations;


import java.util.Hashtable;
import com.hm.kraios.pages.EntityDetailsPage;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;


public class ValidateEntities {

	public boolean verifyIsUserHavingAccesToNonRestricteddocuments() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.BANKING_TYPE_LOCATOR,"BANKING_TYPE_LOCATOR")) {
			BaseTest.seleniumWrapperManager.get().forceClick(EntityDetailsPage.BANKING_TYPE_LOCATOR,"BANKING_TYPE_LOCATOR");
			String ExpectedNotRestrictedLevel="Not Restricted";
			String ActualNotRestrictedLevel = BaseTest.seleniumWrapperManager.get().getText(EntityDetailsPage.RESTRICTION_LEVEL_LOCATOR, "RESTRICTION_LEVEL_LOCATOR");
			
			if (ExpectedNotRestrictedLevel.equals(ActualNotRestrictedLevel)) {
			
			if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR");						
				
				BaseTest.seleniumWrapperManager.get().wait(3000);
				if (BaseTest.seleniumWrapperManager.get().isNotVisible(EntityDetailsPage.DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR,"DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR")) {
					
				
				
			result = true;
 
		}}}		}
		return result;
	}
	
	public boolean verifyIsUserNotHavingAccesToNonRestricteddocuments() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.BANKING_TYPE_LOCATOR,"BANKING_TYPE_LOCATOR")) {
			BaseTest.seleniumWrapperManager.get().forceClick(EntityDetailsPage.BANKING_TYPE_LOCATOR,"BANKING_TYPE_LOCATOR");
			String ExpectedNotRestrictedLevel="Not Restricted";
			String ActualNotRestrictedLevel = BaseTest.seleniumWrapperManager.get().getText(EntityDetailsPage.RESTRICTION_LEVEL_LOCATOR, "RESTRICTION_LEVEL_LOCATOR");
			
			if (ExpectedNotRestrictedLevel.equals(ActualNotRestrictedLevel)) {			
			if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR");						
				
				BaseTest.seleniumWrapperManager.get().wait(3000);
				if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR,"DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR")) {
					
				
				
			result = true;
 
		}}}}
		return result;
	}
	public boolean verifyIsUserHavingAccesToRestricteddocuments() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.COMPLIANCE_TYPE_LOCATOR,"COMPLIANCE_TYPE_LOCATOR")) {
			BaseTest.seleniumWrapperManager.get().forceClick(EntityDetailsPage.COMPLIANCE_TYPE_LOCATOR,"COMPLIANCE_TYPE_LOCATOR");
			String ExpectedRestrictedLevel="Restricted";
			String ActualRestrictedLevel = BaseTest.seleniumWrapperManager.get().getText(EntityDetailsPage.RESTRICTION_LEVEL_LOCATOR, "RESTRICTION_LEVEL_LOCATOR");
			
			if (ExpectedRestrictedLevel.equals(ActualRestrictedLevel)) {			
			if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR");						
				
				BaseTest.seleniumWrapperManager.get().wait(3000);
				if (BaseTest.seleniumWrapperManager.get().isNotVisible(EntityDetailsPage.DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR,"DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR")) {
						
			result = true;
 
		}}}		}
		return result;
	}
	
	public boolean verifyIsUserNotHavingAccesToRestricteddocuments() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.COMPLIANCE_TYPE_LOCATOR,"COMPLIANCE_TYPE_LOCATOR")) {
			BaseTest.seleniumWrapperManager.get().forceClick(EntityDetailsPage.COMPLIANCE_TYPE_LOCATOR,"COMPLIANCE_TYPE_LOCATOR");
			String ExpectedRestrictedLevel="Restricted";
			String ActualRestrictedLevel = BaseTest.seleniumWrapperManager.get().getText(EntityDetailsPage.RESTRICTION_LEVEL_LOCATOR, "RESTRICTION_LEVEL_LOCATOR");
			
			if (ExpectedRestrictedLevel.equals(ActualRestrictedLevel)) {
			
			if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR")) {
				BaseTest.seleniumWrapperManager.get().click(EntityDetailsPage.DOCUMENT_TYPE_LOCATOR,"DOCUMENT_TYPE_LOCATOR");						
				
				BaseTest.seleniumWrapperManager.get().wait(3000);
				if (BaseTest.seleniumWrapperManager.get().isVisible(EntityDetailsPage.DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR,"DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR")) {
					
				
				
			result = true;
 
		}}}}
		return result;
	}

	
	public boolean validateNonRestrictedDocuments(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
		 
		if (data.get("Entities_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToEntitiesPage(data);
			EntityDetailsPage.enterEntityNameInSearchbox(data);
			BaseTest.seleniumWrapperManager.get().wait(3000);
			WorkFlowPage.ActionsPage.clickOnFirstAction();
			if (data.get("Entity_Documents").equals("Y")) {
				EntityDetailsPage.clickonDocumentTab();

				if (data.get("Entities_NonRestrictedDoc").equals("Y")) {
 
					result = verifyIsUserHavingAccesToNonRestricteddocuments();
					if (result == true) {
 
						BaseTest.passTest("User has access To Non Restricted Documents and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Non Restricted Documents, Actual: User  doesn't has the  access To Non Restricted Documents",data);
					}
 
				} else if (data.get("Entities_NonRestrictedDoc").equals("N")) {
					
					result =verifyIsUserNotHavingAccesToNonRestricteddocuments();
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Non Restricted Documents and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Non Restricted Documents, Actual: User has access To Non Restricted Documents",data);
					}
				}
 
			} else if (data.get("Entity_Documents").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(EntityDetailsPage.ENTITIES_DOCUMENT_TAB_LOCATOR, "ENTITIES_DOCUMENT_TAB_LOCATOR");
				if (result == true) {
					 
					BaseTest.passTest("User shoud not have access To Entity Documents and Validation got passed");

				} else {

					BaseTest.failTest("Expected: User shoud not have access To Entity Documents, Actual: User has access To Entity Documents",data);
				}
			}
		} else if (data.get("Entities_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.ENTITIES_LOCATOR, "ENTITIES_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Entities Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Entities Menu, Actual: User has access To Entities Menu",data);
			}	
			}
		return result;
 
	}
	
	public boolean validateRestrictedDocuments(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
		 
		if (data.get("Entities_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToEntitiesPage(data);
			EntityDetailsPage.enterEntityNameInSearchbox(data);
			WorkFlowPage.ActionsPage.clickOnFirstAction();
			if (data.get("Entity_Documents").equals("Y")) {
				EntityDetailsPage.clickonDocumentTab();
				if (data.get("Entities_RestrictedDoc").equals("Y")) {
					
					
 
					result = verifyIsUserHavingAccesToRestricteddocuments();
					if (result == true) {
 
						BaseTest.passTest("User has access To Restricted Documents and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Restricted Documents, Actual: User  doesn't has the  access To Restricted Documents",data);
					}
 
				} else if (data.get("Entities_RestrictedDoc").equals("N")) {
					
					result =verifyIsUserNotHavingAccesToRestricteddocuments();
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Restricted Documents and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Restricted Documents, Actual: User has access To Restricted Documents",data);
					}
				}
 
			} else if (data.get("Entity_Documents").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(EntityDetailsPage.ENTITIES_DOCUMENT_TAB_LOCATOR, "ENTITIES_DOCUMENT_TAB_LOCATOR");
 
				if (result == true) {
					 
					BaseTest.passTest("User shoud not have access To Entity Documents and Validation got passed");

				} else {

					BaseTest.failTest("Expected: User shoud not have access To Entity Documents, Actual: User has access To Entity Documents",data);
				}
			}
		} else if (data.get("Entities_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.ENTITIES_LOCATOR, "ENTITIES_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Entities Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Entities Menu, Actual: User has access To Entities Menu",data);
			}
		}
		return result;
 
	}
	

}