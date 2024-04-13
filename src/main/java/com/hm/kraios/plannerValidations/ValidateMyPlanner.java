package com.hm.kraios.plannerValidations;

import java.util.Hashtable;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.PlannerPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;

public class ValidateMyPlanner {
	
	public boolean verifyIsUserHavingAaccesToPlanner(Hashtable<String, Object> data) {
		
		boolean result = false;		
		if (BaseTest.seleniumWrapperManager.get().isVisible(PlannerPage.entityName(data),"ENTITY_NAME")) {
			result = true;
		}
		return result;
	}
	
	
	
	public boolean ValidateMyPlannerExport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Planner_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToPlannerPage(data);
 
				if (data.get("Planner_export_link").equals("Y")) {
 
					result = WorkFlowPage.Export.verifyIsUserHavingAccesToExport();
					if (result == true) {
 
						BaseTest.passTest("User has access To My Planner Export and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To My Planner Export, Actual: User  doesn't has the  access To My Planner Export",data);
					}
 
				} else if (data.get("Planner_export_link").equals("N")) {
 
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.Export.EXPORT_THREE_DOTS_ICON_LOCATOR,"EXPORT_THREE_DOTS_ICON_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To My Planner Export and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To My Planner Export, Actual: User has access To My Planner Export",data);
					}
				}
 
		} else if (data.get("Planner_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.MY_PLANNER_LOCATOR, "MY_PLANNER_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To My Planner Menu and Validation got passed");
			} else {

				BaseTest.failTest("Expected: User shoud not have access To My Planner Menu, Actual: User has access To My Planner Menu",data);
			}		}
		return result;
 
	}
	
	public boolean ValidateMyPlannerMeetings(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Planner_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToPlannerPage(data);
 
				if (data.get("Planner_Meetings_link").equals("Y")) {
			
					if (data.get("Planner_Meetings_View").equals("Y")) {

					PlannerPage.isVisibleMeetings();
					PlannerPage.PlannerDropDown.clickOnDropdown();
					PlannerPage.PlannerDropDown.clickOnQuarterly();
					WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
					
					if(PlannerPage.PlannerQuarterlyPopup.isVisibleQuaterlyCalendar()){
					PlannerPage.PlannerQuarterlyPopup.clickOnQuaterlyCalendar();
					PlannerPage.PlannerQuarterlyPopup.clickOnMeetingsCount();
					
					result = verifyIsUserHavingAaccesToPlanner(data);
					if (result == true) {
 
						BaseTest.passTest("User has access To My Planner Meetings and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To My Planner Meetings, Actual: User  doesn't has the  access To My Planner Meetings",data);
					}
					}
					else
					{
						BaseTest.failTest("failing the validation of this Test Case , Since not showning the Entity data",data);
					}
					
				} 
					else if (data.get("Planner_Meetings_View").equals("N")) {
						PlannerPage.isVisibleMeetings();
						PlannerPage.PlannerDropDown.clickOnDropdown();
						PlannerPage.PlannerDropDown.clickOnQuarterly();
						WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
						result=PlannerPage.PlannerQuarterlyPopup.isNotVisibleQuaterlyCalendar();
						if (result == true) {
							 
							BaseTest.passTest("User shoud not have access To Planner Meetings View  and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Planner Meetings View , Actual: User has access To Planner Meetings View ",data);
						}
						
					}
				
				}else if (data.get("Planner_Meetings_link").equals("N")) {
 
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(PlannerPage.PLANNER_MEETINGS_LOCATOR,"PLANNER_MEETINGS_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To My Planner Meetings and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To My Planner Meetings, Actual: User has access To My Planner Meetings",data);
					}
				}
 
		} else if (data.get("Planner_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.MY_PLANNER_LOCATOR, "MY_PLANNER_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To My Planner Menu and Validation got passed");
			} else {

				BaseTest.failTest("Expected: User shoud not have access To My Planner Menu, Actual: User has access To My Planner Menu",data);
			}
		}
		return result;
 
	}
	
	public boolean ValidateMyPlannerFilings(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Planner_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToPlannerPage(data);
 
				if (data.get("Planner_Filings_link").equals("Y")) {
					
					if (data.get("Planner_Filings_View").equals("Y")) {

					PlannerPage.isVisibleFilings();
					PlannerPage.PlannerDropDown.clickOnDropdown();
					PlannerPage.PlannerDropDown.clickOnQuarterly();
					WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
					PlannerPage.PlannerQuarterlyPopup.isVisibleQuaterlyCalendar();
					PlannerPage.PlannerQuarterlyPopup.clickOnQuaterlyCalendar();
					PlannerPage.PlannerQuarterlyPopup.clickOnFilingsCount();
					
					result = verifyIsUserHavingAaccesToPlanner(data);
					if (result == true) {
 
						BaseTest.passTest("User has access To My Planner Filings and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To My Planner Filings, Actual: User  doesn't has the  access To My Planner Filings",data);
					}
					
					
 
				} 
					else if (data.get("Planner_Filings_View").equals("N")) {
						PlannerPage.isVisibleMeetings();
						PlannerPage.PlannerDropDown.clickOnDropdown();
						PlannerPage.PlannerDropDown.clickOnQuarterly();
						WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
						result=PlannerPage.PlannerQuarterlyPopup.isNotVisibleQuaterlyCalendar();
						if (result == true) {
							 
							BaseTest.passTest("User shoud not have access To Planner Filings View and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Planner Filings View, Actual: User has access To Planner Filings View",data);
						}
						
					}
				
				}else if (data.get("Planner_Filings_link").equals("N")) {
 
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(PlannerPage.PLANNER_FILINGS_LOCATOR,"PLANNER_FILINGS_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To My Planner Filings and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To My Planner Filings, Actual: User has access To My Planner Filings",data);
					}
				}
				
 
		} else if (data.get("Planner_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.MY_PLANNER_LOCATOR, "MY_PLANNER_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To My Planner Menu and Validation got passed");
			} else {

				BaseTest.failTest("Expected: User shoud not have access To My Planner Menu, Actual: User has access To My Planner Menu",data);
			}
		}
		return result;
 
	}
	
	public boolean ValidateMyPlannerScheduleEvents(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Planner_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToPlannerPage(data);
 
				if (data.get("Planner_SheduleEvents_link").equals("Y")) {
 
					if (data.get("Planner_ScheduledEvents_View").equals("Y")) {

					PlannerPage.isVisibleScheduleEvents();
					PlannerPage.PlannerDropDown.clickOnDropdown();
					PlannerPage.PlannerDropDown.clickOnQuarterly();
					WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
					PlannerPage.PlannerQuarterlyPopup.isVisibleQuaterlyCalendar();
						PlannerPage.PlannerQuarterlyPopup.clickOnQuaterlyCalendar();
						PlannerPage.PlannerQuarterlyPopup.clickOnScheduleCount();
						
						result = verifyIsUserHavingAaccesToPlanner(data);
						
						if (result == true) {
	 
							BaseTest.passTest("User has access To My Planner Schedule Events and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User has access To My Planner Schedule Events, Actual: User  doesn't has the  access To My Planner Schedule Events",data);
						}
					}
					else if (data.get("Planner_ScheduledEvents_View").equals("N")) {
						PlannerPage.isVisibleMeetings();
						PlannerPage.PlannerDropDown.clickOnDropdown();
						PlannerPage.PlannerDropDown.clickOnQuarterly();
						WorkFlowPage.GlobalFilter.applyEntityFilterData(data);
						result=PlannerPage.PlannerQuarterlyPopup.isNotVisibleQuaterlyCalendar();
						if (result == true) {
							 
							BaseTest.passTest("User shoud not have access To Planner Scheduled Events View and Validation got passed");
	 
						} else {
	 
							BaseTest.failTest("Expected: User shoud not have access To Planner Scheduled Events View, Actual: User has access To Planner Scheduled Events View",data);
						}
						
					}
					else if (data.get("Planner_ScheduledEvents_View").equals("NA")) {
						
						BaseTest.passTest("Passing the Testcase, since this user is belongs to GEM Services so User don't have Access for Planner ScheduledEvents View");
					}
				}else if (data.get("Planner_SheduleEvents_link").equals("N")) {
 
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(PlannerPage.PLANNER_SCHEDULE_EVENTS_LOCATOR,"PLANNER_SCHEDULE_EVENTS_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To My Planner Schedule Events and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To My Planner Schedule Events, Actual: User has access To My Planner Schedule Events",data);
					}
				}
 
		} else if (data.get("Planner_Menu").equals("N")) {
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.MY_PLANNER_LOCATOR, "MY_PLANNER_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To My Planner Menu and Validation got passed");
			} else {

				BaseTest.failTest("Expected: User shoud not have access To My Planner Menu, Actual: User has access To My Planner Menu",data);
			}
		}
		return result;
 
	}

}
