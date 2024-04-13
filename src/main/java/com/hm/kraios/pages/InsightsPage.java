package com.hm.kraios.pages;

import org.openqa.selenium.By;

import com.hm.seleniumFactory.BaseTest;

public class InsightsPage {
	
	public static By INSIGHTS_WORKFLOW_TAB_LOCATOR= By.xpath("//li[contains(text(),' Workflow ')]");
	public static By INSIGHTS_COMPLIANCE_TAB_LOCATOR= By.xpath("//li[contains(text(),'Compliance')]");
	public static By INSIGHTS_REGULATORY_TAB_LOCATOR= By.xpath("//li[contains(text(),' Regulatory ')]");
	public static By INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR= By.xpath("//li[contains(text(),'Market Explorer')]");
	public static By INSIGHTS_VIEW_DETAILS_LOCATOR= By.xpath("//a[contains(text(),'View Details')]");

	
	
	
	public static void clickOnWorkFlow() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_WORKFLOW_TAB_LOCATOR,"INSIGHTS_WORKFLOW_TAB_LOCATOR");
	}
	public static void clickOnCompliance() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_COMPLIANCE_TAB_LOCATOR,"INSIGHTS_COMPLIANCE_TAB_LOCATOR");
	}
	public static void clickOnRegulatory() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REGULATORY_TAB_LOCATOR,"INSIGHTS_REGULATORY_TAB_LOCATOR");
	}
	public static void clickOnMarketExplorer() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR,"INSIGHTS_MARKET_EXPLORER_TAB_LOCATOR");
	}
	public static void clickOnInsightsViewDetails() throws InterruptedException {
		BaseTest.seleniumWrapperManager.get().click(INSIGHTS_VIEW_DETAILS_LOCATOR,"INSIGHTS_VIEW_DETAILS_LOCATOR");
	}
	
	
	public static class WorkFlow {
		
		public static By INSIGHTS_ACTIVITIES_LOCATOR= By.xpath("//span[contains(text(),'Activities')]");
		public static By INSIGHTS_REQUESTS_LOCATOR= By.xpath("//span[contains(text(),'Requests')]");
		public static By INSIGHTS_ACTIVITIES_DOWNLOAD_REPORT_LOCATOR= By.xpath("//div//a[contains(text(),'Download Activities Report')]");
		public static By INSIGHTS_REQUESTS_DOWNLOAD_REPORT_LOCATOR= By.xpath("//div//a[contains(text(),'Download Request Report')]");

		
		public static void clickOnInsightsActivities() {
			BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_ACTIVITIES_LOCATOR,"INSIGHTS_ACTIVITIES_LOCATOR");
		}
		public static void clickOnInsightsRequests() {
			BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REQUESTS_LOCATOR,"INSIGHTS_REQUESTS_LOCATOR");
		}

	}
	
	public static class Compliance{
		
		public static By INSIGHTS_TAX_FILINGS_REPORTS_LOCATOR= By.xpath("//span[contains(text(),'Tax Filings & Reports')]");
		public static By INSIGHTS_CORPORATE_INCOME_TAX_LOCATOR= By.xpath("//span[contains(text(),'Corporate Income Tax')]");
		public static By INSIGHTS_TAX_FILINGS_DOWNLOAD_REPORT_LOCATOR= By.xpath("//a[contains(text(),'Tax Filings & Reports')]");
		public static By INSIGHTS_CORPORATE_INCOME_TAX_EXPORT_LOCATOR= By.xpath("//a[text()='Export']");

		
		public static void clickOnInsightsTaxFilingsAndReports() {
			BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_TAX_FILINGS_REPORTS_LOCATOR,"INSIGHTS_TAX_FILINGS_REPORTS_LOCATOR");
		}
		public static void clickOnInsightsCorporateIncomeTax() {
			BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_CORPORATE_INCOME_TAX_LOCATOR,"INSIGHTS_CORPORATE_INCOME_TAX_LOCATOR");
		}

	}
	
	public static class  Regulatory  {
	
	public static By INSIGHTS_REGULATORY_ENTITY_DATA_TAB= By.xpath("//span[text()='Entity Data']");
	public static By INSIGHTS_REGULATORY_UPDATES_TAB= By.xpath("//span[text()='Regulatory Updates']");
	public static By INSIGHTS_REGULATORY_TMFARTICLES_TAB= By.xpath("//span[text()='TMF Articles']");
	public static By INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB= By.xpath("//span[text()='Structure Chart']");
	
	public static By INSIGHTS_REGULATORY_ENTITIES_BOARD= By.xpath("//span[text()='    Entities / Board']");
	public static By INSIGHTS_REGULATORY_JURISDICTIONS_BOARD= By.xpath("//span[text()='    Jurisdictions / Board']");
	public static By INSIGHTS_REGULATORY_ENTITY_DATA_STRUCTURE= By.xpath("//div[@class='DVSL-interaction']");
	
	public static By INSIGHTS_REGULATORY_UPDATES_SUMMARY= By.xpath("//section[contains(@class,'regulatoryBulletin-table-articles')]//tr/td/a");
	public static By INSIGHTS_REGULATORY_BULLETIN_FILTER_CONTAINER= By.xpath("//section[@id='regulatoryBulletin-filter-container']/form");
	public static By INSIGHTS_TMF_ARTICLE_SUMMARY= By.xpath("//section[@class='regulatoryBulletin-articles-container']/span/div");

	
	public static By INSIGHTS_REGULATORY_STRUCTURE_CHART_NETWORK= By.xpath("//div[@class='vis-network']");

	
	public static void clickOnInsightsEntityData() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REGULATORY_ENTITY_DATA_TAB,"INSIGHTS_REGULATORY_ENTITY_DATA_TAB");
	}
	public static void clickOnInsightsRegulatoryUpdatesTab() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REGULATORY_UPDATES_TAB,"INSIGHTS_REGULATORY_UPDATES_TAB");
	}
	public static void clickOnInsightsStructureChart() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB,"INSIGHTS_REGULATORY_STRUCTURE_CHART_TAB");
	}
	public static void clickOnInsightsTMFArticles() {
		BaseTest.seleniumWrapperManager.get().forceClick(INSIGHTS_REGULATORY_TMFARTICLES_TAB,"INSIGHTS_REGULATORY_TMFARTICLES_TAB");
	}
}
	
	
	
	
}
