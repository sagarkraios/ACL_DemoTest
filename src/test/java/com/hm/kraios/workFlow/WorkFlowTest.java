package com.hm.kraios.workFlow;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.kraios.workflowValidations.ValidateActions;
import com.hm.kraios.workflowValidations.ValidateActvities;
import com.hm.kraios.workflowValidations.ValidateRequests;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class WorkFlowTest extends BaseTest {
	
	ValidateActvities actvities=new ValidateActvities();
	ValidateActions action=new ValidateActions();
	ValidateRequests request=new ValidateRequests();	

	
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyActivitiesExport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		actvities.validateActivitiesExport(data);
	
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyActivitiesManage(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		actvities.validateActivitiesManage(data);
	
	}
	
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyActionsExport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		action.validateActionsExport(data);
		
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyActionsAssign(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		action.validateActionsAssign(data);
		
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyReviewActions(Hashtable<String, Object> data) throws InterruptedException {
	
		KraiosLogin.login(data);
		action.validateReviewActions(data);
	
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyCollectActions(Hashtable<String, Object> data) throws InterruptedException {
	
		KraiosLogin.login(data);
		action.validateCollectactions(data);
	}
	
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyRequestsExport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		request.validateRequestsExport(data);
	
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyViewManageOtherServiceRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		request.validateMyActivitiesViewManageOtherServiceRequests(data);
	
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyViewManageOtherSupportRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		request.validateMyActivitiesViewManageOtherSupportRequests(data);
		
	}
	
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyViewManageOwnServiceRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		request.validateMyActivitiesViewManageOwnServiceRequests(data);
	
	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyViewManageOwnSupportRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		request.validateMyActivitiesViewManageOwnSupportRequests(data);
	
	}
}