package com.hm.kraios.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;

import com.hm.seleniumFactory.BaseTest;

public class KraiosMyWorkSpaceMenuPage {
	
	public static By WORKSPACE_MENU_LOCATOR = By.xpath("//*[@class='workspace-group']");
	public static By ENTITIES_LOCATOR = By.xpath("//li[text()=' Entities ']");
	public static By WORKFLOW_LOCATOR = By.xpath("//*[@routerlink='/workflow']");
	public static By MY_PLANNER_LOCATOR = By.xpath("//*[@routerlink='/planner']");
	public static By INSIGHTS_LOCATOR = By.xpath("//li[text()=' Insights ']");
	
	
	public static void clickOnWorkSpaceMenu() {
			BaseTest.seleniumWrapperManager.get().forceClick(WORKSPACE_MENU_LOCATOR,"WORKSPACE_MENU_LOCATOR");		
		}
	
	
	
	public synchronized static void navigateToEntitiesPage(Hashtable<String, Object> data) throws InterruptedException {
		
	    BaseTest.seleniumWrapperManager.get().openWebsite("https://"+data.get("XL_ENV")+ "/entities", "NAVIGATE TO KRAIOS EntitiesPage");
		}

	public synchronized static void navigateToPlannerPage(Hashtable<String, Object> data) throws InterruptedException {
		
	    BaseTest.seleniumWrapperManager.get().openWebsite("https://"+data.get("XL_ENV")+ "/planner", "NAVIGATE TO KRAIOS PlannerPage");
		}
	

	public synchronized static void navigateToWorkflowPage(Hashtable<String, Object> data) throws InterruptedException {
		
        BaseTest.seleniumWrapperManager.get().openWebsite("https://"+data.get("XL_ENV")+ "/workflow", "NAVIGATE TO KRAIOS WorkflowPage");
		}

	public synchronized static void navigateToInsightsPage(Hashtable<String, Object> data) throws InterruptedException {
	
    BaseTest.seleniumWrapperManager.get().openWebsite("https://"+data.get("XL_ENV")+ "/insights", "NAVIGATE TO KRAIOS InsightsPage");
		}


	
}
