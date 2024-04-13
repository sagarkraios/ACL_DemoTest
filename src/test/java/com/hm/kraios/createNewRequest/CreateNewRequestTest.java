package com.hm.kraios.createNewRequest;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.kraios.workflowValidations.ValidateCreateNewRequests;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class CreateNewRequestTest extends BaseTest {
	
	

	ValidateCreateNewRequests newRequest=new ValidateCreateNewRequests();
	
//	@FrameworkAnnotation(dataSheetName = "WorkFlow")
//	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class,enabled =true)
//	public void verifyCreateNewServiceRequests(Hashtable<String, Object> data) throws InterruptedException {
//		
//		KraiosLogin.login(data);
//		newRequest.ValidateCreateNewServiceRequests(data);
//	}
	
	@FrameworkAnnotation(dataSheetName = "WorkFlow")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyCreateNewSupportRequests(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		newRequest.validateCreateNewSupportRequests(data);
	}

	
}