package com.hm.kraios.planner;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.hm.annotations.FrameworkAnnotation;
import com.hm.kraios.pages.KraiosLogin;
import com.hm.kraios.plannerValidations.ValidateMyPlanner;
import com.hm.seleniumFactory.BaseTest;
import com.hm.utilities.DataUtil;

public class MyPlannerTest extends BaseTest {
	
	

	ValidateMyPlanner planner=new ValidateMyPlanner();
	
	@FrameworkAnnotation(dataSheetName = "Planner")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyMyPlannerExport(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		planner.ValidateMyPlannerExport(data);
	}
	
	@FrameworkAnnotation(dataSheetName = "Planner")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyMyPlannerMeetings(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		planner.ValidateMyPlannerMeetings(data);
	}
	
	@FrameworkAnnotation(dataSheetName = "Planner")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyMyPlannerFilings(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		planner.ValidateMyPlannerFilings(data);
	}
	@FrameworkAnnotation(dataSheetName = "Planner")
	@Test(dataProvider = "Data", dataProviderClass = DataUtil.class)
	public void verifyMyPlannerScheduleEvents(Hashtable<String, Object> data) throws InterruptedException {
		
		KraiosLogin.login(data);
		planner.ValidateMyPlannerScheduleEvents(data);
	}
}