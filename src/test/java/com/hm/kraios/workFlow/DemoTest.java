package com.hm.kraios.workFlow;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.kraios.workflowValidations.ValidateActions;
import com.hm.kraios.workflowValidations.ValidateActvities;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class DemoTest extends BaseTest {
	
	ValidateActvities actvities=new ValidateActvities();
	ValidateActions action=new ValidateActions();

	
	
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
	public void verifyActivitiesView(Hashtable<String, Object> data) throws Exception {
		KraiosLogin.login(data);
		actvities.validateActivitiesView(data);

	}
	@FrameworkAnnotation(dataSheetName = "Workflow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyActionsView(Hashtable<String, Object> data) throws Exception {
	
		KraiosLogin.login(data);
		action.validateActionsView(data);
	}
	
}