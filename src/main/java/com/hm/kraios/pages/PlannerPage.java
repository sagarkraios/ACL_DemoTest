package com.hm.kraios.pages;

import java.util.Hashtable;
import org.openqa.selenium.By;

import com.hm.seleniumFactory.BaseTest;

public class PlannerPage {

	public static By PLANNER_SCHEDULE_EVENTS_LOCATOR = By.xpath("//a[text()='Scheduled Events']");
	public static By PLANNER_MEETINGS_LOCATOR = By.xpath("//a[@title='Meetings']");
	public static By PLANNER_FILINGS_LOCATOR = By.xpath("//a[text()='Filings']");

	
	public static  By entityName(Hashtable<String, Object> data) {
		By ENTITY_NAME = By.xpath("//*[@class='planner-list']//span[contains(text(),'"+(data.get("EntityName").toString().split("\\|"))[0]+"')]");
		return ENTITY_NAME;
	}
	
	public static void clickOnScheduleEvents() {
		BaseTest.seleniumWrapperManager.get().click(PLANNER_SCHEDULE_EVENTS_LOCATOR,"PLANNER_SCHEDULE_EVENTS_LOCATOR");
	}
	public static void clickOnMeetings() {
		BaseTest.seleniumWrapperManager.get().click(PLANNER_MEETINGS_LOCATOR,"PLANNER_MEETINGS_LOCATOR");
	}
	public static void clickOnFilings() {
		BaseTest.seleniumWrapperManager.get().click(PLANNER_FILINGS_LOCATOR,"PLANNER_FILINGS_LOCATOR");
	}
	public static boolean isVisibleScheduleEvents() {
	return	BaseTest.seleniumWrapperManager.get().isVisible(PLANNER_SCHEDULE_EVENTS_LOCATOR,"PLANNER_SCHEDULE_EVENTS_LOCATOR");
	}
	public static boolean isVisibleMeetings() {
	return	BaseTest.seleniumWrapperManager.get().isVisible(PLANNER_MEETINGS_LOCATOR,"PLANNER_MEETINGS_LOCATOR");
	}
	public static boolean isVisibleFilings() {
	return	BaseTest.seleniumWrapperManager.get().isVisible(PLANNER_FILINGS_LOCATOR,"PLANNER_FILINGS_LOCATOR");
	}
	
	
	
	
	public static class PlannerDropDown {		
		
		public static By MY_PLANNER_DROPDOWN_lOCATOR = By.xpath("//span[@class='down-arrow']");
		public static By DAILY_FROM_DROPDOWN_lOCATOR = By.xpath("//a[text()='Daily']");
		public static By WEEKLY_FROM_DROPDOWN_lOCATOR = By.xpath("//a[text()='Weekly']");
		public static By MONTHLY_FROM_DROPDOWN_lOCATOR = By.xpath("//a[text()='Monthly']");
		public static By QUARTERLY_FROM_DROPDOWN_lOCATOR = By.xpath("//a[text()='Quarterly']");

		public static void clickOnDropdown() {
			BaseTest.seleniumWrapperManager.get().click(MY_PLANNER_DROPDOWN_lOCATOR,"MY_PLANNER_DROPDOWN_lOCATOR");
		}
		public static void clickOnQuarterly() {
			BaseTest.seleniumWrapperManager.get().click(QUARTERLY_FROM_DROPDOWN_lOCATOR,"QUARTERLY_FROM_DROPDOWN_lOCATOR");
		}
		

	}
	public static class PlannerQuarterlyPopup {	
		
		public static By SCHEDULE_EVENTS_VERIFY_COUNT_LOCATOR = By.xpath("//ul//li[text()=' Scheduled Events']");
		public static By MEETINGS_VERIFY_COUNT_LOCATOR= By.xpath("//li[contains(text(),' Meetings')]");
		public static By FILINGS_VERIFY_COUNT_LOCATOR = By.xpath("//li[contains(text(),' Filings')]");
		public static By QUARTERLY_CALENDAR_LOCATOR = By.xpath("//*[contains(@class,'period') and contains(text(),'March')]/..//div[contains(text(),'31')]/../div[@class='circle filled active']");

		public static void clickOnQuaterlyCalendar() {
			BaseTest.seleniumWrapperManager.get().click(QUARTERLY_CALENDAR_LOCATOR,"QUARTERLY_CALENDAR_LOCATOR");
		}
		public static boolean isVisibleQuaterlyCalendar() {
		return	BaseTest.seleniumWrapperManager.get().isVisible(QUARTERLY_CALENDAR_LOCATOR,"QUARTERLY_CALENDAR_LOCATOR");
		}
		public static boolean isNotVisibleQuaterlyCalendar() {
		return	BaseTest.seleniumWrapperManager.get().isNotVisible(QUARTERLY_CALENDAR_LOCATOR,"QUARTERLY_CALENDAR_LOCATOR");
		}
		public static void clickOnMeetingsCount() {
			BaseTest.seleniumWrapperManager.get().click(MEETINGS_VERIFY_COUNT_LOCATOR,"MEETINGS_VERIFY_COUNT_LOCATOR");
		}
		public static void clickOnFilingsCount() {
			BaseTest.seleniumWrapperManager.get().click(FILINGS_VERIFY_COUNT_LOCATOR,"FILINGS_VERIFY_COUNT_LOCATOR");
		}
		public static void clickOnScheduleCount() {
			BaseTest.seleniumWrapperManager.get().click(SCHEDULE_EVENTS_VERIFY_COUNT_LOCATOR,"SCHEDULE_EVENTS_VERIFY_COUNT_LOCATOR");
		}
		
	}
}
