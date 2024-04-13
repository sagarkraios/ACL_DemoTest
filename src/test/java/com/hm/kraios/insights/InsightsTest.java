package com.hm.kraios.insights;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.insightsValidations.ValidateCompliance;
import com.hm.kraios.insightsValidations.ValidateInsightsWorkflow;
import com.hm.kraios.insightsValidations.ValidateMarketExplorer;
import com.hm.kraios.insightsValidations.ValidateRegulatory;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class InsightsTest extends BaseTest {

	
	ValidateInsightsWorkflow insightsWorkFlow=new ValidateInsightsWorkflow();
	ValidateCompliance compliance=new ValidateCompliance();
	ValidateRegulatory regulatory=new ValidateRegulatory();
	ValidateMarketExplorer marketExplorer=new ValidateMarketExplorer();


	
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsActivitiesDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		insightsWorkFlow.validateInsightsActivitiesDownloadReport(data);
		
	}
	
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsRequestsDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		insightsWorkFlow.validateInsightsRequestsDownloadReport(data);
		
	}
	
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsTaxFilingsDownloadReport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		compliance.validateInsightsTaxFilingsDownloadReport(data);
		
	}
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsCorporateIncomeTaxExport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		compliance.validateInsightsCorporateIncomeTaxExport(data);
		
	}	
	
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsRegulatoryEntityData(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		regulatory.validateInsightsEntityData(data);
		
	}
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsRegulatoryUpdates(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		regulatory.validateInsightsRegulatoryUpdates(data);
		
	}
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsregulatoryStructureChart(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		regulatory.validateInsightsStructureChart(data);
		
	}
		
	@FrameworkAnnotation(dataSheetName = "Insights")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyInsightsMarketExplorerView(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		marketExplorer.validateInsightsMarketExplorerView(data);
		
	}
	
	
	
	
	
	
	
	
	
}
