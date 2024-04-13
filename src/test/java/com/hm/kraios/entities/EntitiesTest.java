package com.hm.kraios.entities;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.entitiesValidations.ValidateEntities;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.kraios.workflowValidations.ValidateCreateNewRequests;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class EntitiesTest extends BaseTest {
	
	

	ValidateEntities entities=new ValidateEntities();
	
	
	@FrameworkAnnotation(dataSheetName = "Entities")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyNonRestrictedDocuments(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		entities.validateNonRestrictedDocuments(data);
	}
	
	@FrameworkAnnotation(dataSheetName = "Entities")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyRestrictedDocuments(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		entities.validateRestrictedDocuments(data);
	}


	
}