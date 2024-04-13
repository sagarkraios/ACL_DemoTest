package com.hm.kraios.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;

import com.hm.seleniumFactory.BaseTest;


public class EntityDetailsPage {

	
    public static By ENTITY_SEARCHBOX_LOCATOR = By.xpath("//input[contains(@placeholder,'Search by Entity Name...')]");
    public static By ENTITIES_DOCUMENT_TAB_LOCATOR = By.xpath("//a[contains(text(),'Entity Documents')]");
    public static By BANKING_TYPE_LOCATOR = By.xpath("//a[contains(text(),'Banking')]");
    public static By COMPLIANCE_TYPE_LOCATOR = By.xpath("//a[contains(text(),'Compliance')]");
    public static By RESTRICTION_LEVEL_LOCATOR = By.xpath("(//tbody//tr)[2]//td[5]");
    public static By DOCUMENT_TYPE_LOCATOR = By.xpath("//app-entity-docs//tbody/tr[1]/td[1]");
    public static By DONT_HAVE_ACCESS_TO_DOWNLOAD_FILE_LOCATOR = By.xpath("//div[@role='alert']");

    
  
    public static void enterEntityNameInSearchbox(Hashtable<String, Object> data) throws InterruptedException {
		BaseTest.seleniumWrapperManager.get().enterText(ENTITY_SEARCHBOX_LOCATOR,
				(data.get("EntityName").toString().split("\\|"))[0], "ENTITY_SEARCHBOX_LOCATOR");
		BaseTest.seleniumWrapperManager.get().wait(3000);
    } 
    public static void clickonDocumentTab() {
		BaseTest.seleniumWrapperManager.get().click(ENTITIES_DOCUMENT_TAB_LOCATOR,"ENTITIES_DOCUMENT_TAB_LOCATOR");
	}
    public static void clickonBanking() {
		BaseTest.seleniumWrapperManager.get().click(BANKING_TYPE_LOCATOR,"BANKING_TYPE_LOCATOR");
	}
    public static void clickonCompliance() {
		BaseTest.seleniumWrapperManager.get().click(COMPLIANCE_TYPE_LOCATOR,"COMPLIANCE_TYPE_LOCATOR");
	}
 
	
	
	
}
