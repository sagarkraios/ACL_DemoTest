package com.hm.kraios.workflowValidations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import com.hm.kraios.entitiesValidations.EntitiesView;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;
import com.hm.seleniumFactory.SeleniumWrapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ValidateActions {
	
 
	public boolean verifyIsUserHavingAccesToReviewActions() {
		boolean result = false;
		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.REVIEW_ACTION_TYPE_TEXT_LOCATOR,
				"REVIEW_ACTION_TYPE_TEXT_LOCATOR")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.REVIEW_ACTION_APPROVE_BUTTON,
						"REVIEW_ACTION_APPROVE_BUTTON")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.REVIEW_ACTION_REJECT_BUTTON,
						"REVIEW_ACTION_REJECT_BUTTON")) {
			result = true;
		}
		return result;
	}
	
	public boolean verifyIsUserHavingAccesToCollectActions() {
		boolean result = false;
 
		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COLLECT_ACTION_TYPE_TEXT_LOCATOR,
				"COLLECT_ACTION_TYPE_TEXT_LOCATOR")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.SAVE_BUTTON_LOCATOR,
						"SAVE_BUTTON_LOCATOR")
				&& BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.SUBMIT_BUTTON_LOCATOR,
						"SUBMIT_BUTTON_LOCATOR")) {
			result = true;
 
		}
		return result;
	}
	
	public boolean verifyIsUserHavingAccesToActionsAssign() {
		boolean result = false;
 
			BaseTest.seleniumWrapperManager.get().click(WorkFlowPage.ActionsPage.ASSIGN_THREE_DOTS_ICON_LOCATOR,"ASSIGN_THREE_DOTS_ICON_LOCATOR");
			if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.ASSIGN_ICON_LOCATOR,"ASSIGN_ICON_LOCATOR")) {
		}
			result = true;

		return result;
	}
	
	
	public boolean validateReviewActions(Hashtable<String, Object> data) throws InterruptedException {
 
		boolean result = false;
 
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
 
			if (data.get("MyActions_Tab").equals("Y")) {
				WorkFlowPage.ActionsPage.clickOnActionsTab();
 
				if (data.get("MyActions_CompleteReviewAction").equals("Y")) {
					
					WorkFlowPage.ActionsPage.clickOnActionsDropdown();
					WorkFlowPage.ActionsPage.clickOnReviewValue();
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					WorkFlowPage.ActionsPage.searchforPresenceOfActionsID();
 
					result = verifyIsUserHavingAccesToReviewActions();
					if (result == true) {
 
						BaseTest.passTest("User has access To Review Action and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Review Action, Actual: User  doesn't has the  access To Approve Review action",data);
					}
 
				} else if (data.get("MyActions_CompleteReviewAction").equals("N")) {
					WorkFlowPage.ActionsPage.clickOnActionsDropdown();
					WorkFlowPage.ActionsPage.clickOnReviewValue();
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					WorkFlowPage.ActionsPage.clickOnFirstAction();
 
					result = BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.USER_NOT_ACCESS_LOCATOR,
							"USER_NOT_ACCESS_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Approve Review Action and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Approve Review Action, Actual: User has access To Review Action",data);
					}
				}
 
			} else if (data.get("MyActions_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.ActionsPage.ACTIONS_TAB_LOCATOR, "ACTIONS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To MyActions Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To MyActions Tab, Actual: User has access To MyActions Tab",data);
				}		
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}
		}
		return result;
 
	}

	public boolean validateCollectactions(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
 
			if (data.get("MyActions_Tab").equals("Y")) {
				WorkFlowPage.ActionsPage.clickOnActionsTab();
 
				if (data.get("MyActions_CompleteCollectAction").equals("Y")) {
					
					WorkFlowPage.ActionsPage.clickOnActionsDropdown();
					WorkFlowPage.ActionsPage.clickOnCollectValue();
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					WorkFlowPage.ActionsPage.clickOnFirstAction();
 
					result = verifyIsUserHavingAccesToCollectActions();
					if (result == true) {
 
						BaseTest.passTest("User has access To Collect Action and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Collect Action, Actual: User  doesn't has the  access To Collect Action",data);
					}
 
				} else if (data.get("MyActions_CompleteCollectAction").equals("N")) {
					WorkFlowPage.ActionsPage.clickOnActionsDropdown();
					WorkFlowPage.ActionsPage.clickOnCollectValue();
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					WorkFlowPage.ActionsPage.clickOnFirstAction();
 
 
					result = BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.USER_NOT_ACCESS_LOCATOR,
							"USER_NOT_ACCESS_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Save Collect Task and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Save Collect Action, Actual: User has access To Collect Action",data);
					}
				}
				else if (data.get("MyActions_CompleteCollectAction").equals("NA")) {
			
					BaseTest.passTest("Passing the Testcase, since this user is belongs to GEM Services so User don't have Access for Collect Action");
				}
				
			} else if (data.get("MyActions_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.ActionsPage.ACTIONS_TAB_LOCATOR, "ACTIONS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To MyActions Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To MyActions Tab, Actual: User has access To MyActions Tab",data);
				}		
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}
		}
		return result;
 
	}
	
	
	
	public boolean validateActionsAssign(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
 
			if (data.get("MyActions_Tab").equals("Y")) {
				WorkFlowPage.ActionsPage.clickOnActionsTab();
 
				if (data.get("MyActions_Assign").equals("Y")) {
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					result = verifyIsUserHavingAccesToActionsAssign();
					if (result == true) {
 
						BaseTest.passTest("User has access To Action Assign and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Action Assign, Actual: User  doesn't has the  access To Action Assign",data);
					}
 
				} else if (data.get("MyActions_Assign").equals("N")) {
					WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.ActionsPage.ASSIGN_THREE_DOTS_ICON_LOCATOR,"ASSIGN_THREE_DOTS_ICON_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Action Assign and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Action Assign, Actual: User has access To Action Assign",data);
					}
				}
 
			} else if (data.get("MyActions_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.ActionsPage.ACTIONS_TAB_LOCATOR, "ACTIONS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To MyActions Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To MyActions Tab, Actual: User has access To MyActions Tab",data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}
		}
		return result;
 
	}
	
	
	public boolean validateActionsExport(Hashtable<String, Object> data) throws InterruptedException {
		 
		boolean result = false;
 
		if (data.get("Workflow_Menu").equals("Y")) {
			
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);
 
			if (data.get("MyActions_Tab").equals("Y")) {
				WorkFlowPage.ActionsPage.clickOnActionsTab();
 
				if (data.get("Workflow_Actions_Export_Link").equals("Y")) {
 
					result = WorkFlowPage.Export.verifyIsUserHavingAccesToExport();
					if (result == true) {
 
						BaseTest.passTest("User has access To Action Export and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User has access To Action Export, Actual: User  doesn't has the  access To Action Export",data);
					}
 
				} else if (data.get("Workflow_Actions_Export_Link").equals("N")) {
 
					result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.Export.EXPORT_THREE_DOTS_ICON_LOCATOR,"EXPORT_THREE_DOTS_ICON_LOCATOR");
 
					if (result == true) {
 
						BaseTest.passTest("User shoud not have access To Action Export and Validation got passed");
 
					} else {
 
						BaseTest.failTest("Expected: User shoud not have access To Action Export, Actual: User has access To Action Export",data);
					}
				}
 
			} else if (data.get("MyActions_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get().isNotVisible(WorkFlowPage.ActionsPage.ACTIONS_TAB_LOCATOR, "ACTIONS_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To MyActions Tab and Validation got passed");
				} 
				else {
					BaseTest.failTest("Expected: User shoud not have access To MyActions Tab, Actual: User has access To MyActions Tab",data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} 
			else {
				BaseTest.failTest("Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",data);
			}
		}
		return result;
 
	}
	public Response getActionsDetails(Hashtable<String, Object> data) {
		String payLoad = "{\"pageNumber\":1,\"pageSize\":1000,\"taskStatus\":[],\"sortOrder\":\"desc\",\"sortByField\":\"ActivityId\",\"actionCategory\":\"\",\"taskType\":\"\",\"searchText\":\"\",\"updated\":false}";

		return RestAssured.given().baseUri(data.get("apiBaseUrl").toString() + "/core/api/v1/tasks/getTasks")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();
	}

	public Object verifyIsUserHavingEntitiesAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedEntityList = Arrays.asList(data.get("EntityName").toString().split("\\|"));

		if (response.getStatusCode() == 200) {
			List<String> actualEntityNames = response.then().extract().path("data.content.entityName");
			List<String> additionalActualEntities = actualEntityNames.stream().distinct()
					.filter(e -> !ExpectedEntityList.contains(e)).collect(Collectors.toList());
			List<String> missingEntitiesInExpected = ExpectedEntityList.stream()
					.filter(e -> !actualEntityNames.contains(e)).collect(Collectors.toList());

			if (additionalActualEntities.isEmpty() & missingEntitiesInExpected.isEmpty()) {

				result = true;
			} else {
				result = "<b>Additional Entities In Actual</b> :" + additionalActualEntities + "<br/>"
						+ "<b>Missing Entities In Expected</b> :" + missingEntitiesInExpected;

			}
			if (result instanceof Boolean) {
				BaseTest.passTest("Validation of Entities data in Actions screen Passed");
			} else {

				BaseTest.failTest("Validation of Entities data in Actions screen is Failed"+"<br/>"+ result.toString(), data);

			}
		} else {
			BaseTest.failTest(
					"<b>API is down</b>Validation of Entities data in Actions screen is Failed"+"<br/>"+ result.toString(),
					data);
		}
		

		return result;

	}

	public Object verifyIsUserNotHavingEntitiesAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedEntityList = Arrays.asList(data.get("EntityName").toString().split("\\|"));

		if (response.getStatusCode() == 200) {
			List<String> actualEntityNames = response.then().extract().path("data.content.entityName");
			List<String> entitiesWithoutUserAceess = ExpectedEntityList.stream()
					.filter(e -> actualEntityNames.contains(e)).collect(Collectors.toList());

			if (entitiesWithoutUserAceess.isEmpty()) {
				BaseTest.passTest("Validation of Entities data in Actions screen Passed");

			} else {

				BaseTest.failTest("User should not have access to Below Entities"+"<br/>"+ entitiesWithoutUserAceess, data);

			}
		} else {
			BaseTest.failTest("Validation of Entities data in Actions screen is Failed: "+"<br/>" + result.toString(), data);
		}

		return result;

	}

	public Object verifyIsUserNotHavingL2ServiceAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedL2Services = Arrays.asList(data.get("L2Servicename").toString().split("\\|"));
		if (response.getStatusCode() == 200) {
			List<String> actualL2ServiceNames = response.then().extract().path("data.content.l2ServiceName");

			List<String> l2ServiceNoAceess = ExpectedL2Services.stream().filter(e -> actualL2ServiceNames.contains(e))
					.collect(Collectors.toList());

			if (l2ServiceNoAceess.isEmpty()) {

				result = "User should not have access to Below L2Services: " + l2ServiceNoAceess;

			}
		}
		if (result instanceof Boolean) {
			BaseTest.passTest("Validation of L2Services data in Actions screen Passed");
		} else {

			BaseTest.failTest("Validation of L2Services data in Actions screen is Failed"+"<br/>"+ result.toString(), data);

		}
		return result;

	}

	public Object verifyisUserHavingL2ServiceAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedL2Services = Arrays.asList(data.get("L2Servicename").toString().split("\\|"));
		if (response.getStatusCode() == 200) {
			List<String> actualL2ServiceNames = response.then().extract().path("data.content.l2ServiceName");

			List<String> additionalL2Services = actualL2ServiceNames.stream().distinct()
					.filter(e -> !ExpectedL2Services.contains(e)).collect(Collectors.toList());

			List<String> missingL2ServicesInExpected = ExpectedL2Services.stream()
					.filter(e -> !actualL2ServiceNames.contains(e)).collect(Collectors.toList());

			if (!(additionalL2Services.isEmpty() & missingL2ServicesInExpected.isEmpty())) {

				result = "<b>Additional L2 Services In Actual</b> :" + additionalL2Services + "<br/>"+"<b>Missing L2 Services In Expected</b> :"
						+ missingL2ServicesInExpected;

			}
		}
		if (result instanceof Boolean) {
			BaseTest.passTest("Validation of L2Services data in Actions screen Passed");
		} else {

			BaseTest.failTest("Validation of L2Services data in Actions screen is Failed"+"<br/>" + result.toString(), data);

		}
		return result;

	}

	public Object verifyIsUserNotHavingAccesToActionsView(Hashtable<String, Object> data) {
		Object result = false;

		String payLoad = "{\"pageNumber\":1,\"pageSize\":10000,\"taskStatus\":[],\"sortOrder\":\"desc\",\"sortByField\":\"ActivityId\",\"actionCategory\":\"allActions\",\"taskType\":\"\",\"searchText\":\"\",\"updated\":false}";

		Response response = RestAssured.given()
				.baseUri(data.get("apiBaseUrl").toString() + "/core/api/v1/activities/getActivities")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();

		List<String> ExpectedEntityList = Arrays.asList(data.get("EntityName").toString().split("\\|"));
		List<String> ExpectedL2Services = Arrays.asList(data.get("L2Servicename").toString().split("\\|"));

		if (response.getStatusCode() == 200) {

			List<String> actualEntityNames = response.then().extract().path("data.content.entityName");

			List<String> actualL2ServiceNames = response.then().extract().path("data.content.activityType");

			List<String> entitiesNoAceess = ExpectedEntityList.stream().distinct()
					.filter(e -> actualEntityNames.contains(e)).collect(Collectors.toList());

			List<String> l2ServiceNoAceess = ExpectedL2Services.stream().filter(e -> actualL2ServiceNames.contains(e))
					.collect(Collectors.toList());

			if (entitiesNoAceess.isEmpty() & l2ServiceNoAceess.isEmpty()) {
				result = true;

			} else {

				result = "User should not have access to Below Entities  :" + entitiesNoAceess+"<br/>"
						+ "User should not have access to Below L2Services  :" + l2ServiceNoAceess;

			}

		}

		return result;
	}

	public void verifyIsUserHavingRegionCountryAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedRegionList = Arrays.asList(data.get("RegionName").toString().split("\\|"));
		List<String> ExpectedCountryList = Arrays.asList(data.get("CountryName").toString().split("\\|"));

		List<String> actualRegionList = new ArrayList<>();
		List<String> actualCountryList = new ArrayList<>();
		List<String> actualEntityNames = response.then().extract().path("data.content.entityName");

		List<String> distinctActualEntityNames = actualEntityNames.stream().distinct().collect(Collectors.toList());
		for (String entityName : distinctActualEntityNames) {
			EntitiesView entityPage = new EntitiesView();
			Response entityDetails = entityPage.getEntityDetails(entityName, data);
						
			actualRegionList.addAll(entityPage.getRegion(entityDetails));
			actualCountryList.addAll(entityPage.getCountryDetail(entityDetails));
		}
		if (ExpectedRegionList.stream().sorted().allMatch(actualRegionList::contains)) {

			BaseTest.passTest("Validation of Regions in Actions Screen Passed");

		} else {
			BaseTest.failTest("Validation of Regions in Actions Screen Failed"+"<br/>"+"<b>Expected Regions</b>"
					+ ExpectedRegionList +"<br/>"+"<b>Actual Regions</b>" + actualRegionList, data);
		}
		if (ExpectedCountryList.stream().sorted().allMatch(actualCountryList::contains)) {

			BaseTest.passTest("Validation of Countries in Actions Screen Passed");

		} else {
			BaseTest.failTest("Validation of Countries in Actions Screen Failed"+"<br/>"+"<b>Expected Countries: </b>"
					+ ExpectedCountryList + "<br/>"+"<b>Actual Countries: </b>" + actualCountryList, data);
		}

	}

	public void verifyIsUserNotHavingRegionCountryAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedRegionList = Arrays.asList(data.get("RegionName").toString().split("\\|"));
		List<String> ExpectedCountryList = Arrays.asList(data.get("CountryName").toString().split("\\|"));

		List<String> actualRegionList = new ArrayList<>();
		List<String> actualCountryList = new ArrayList<>();
		List<String> actualEntityNames = response.then().extract().path("data.content.entityName");

		List<String> distinctActualEntityNames = actualEntityNames.stream().distinct().collect(Collectors.toList());
		for (String entityName : distinctActualEntityNames) {
			EntitiesView entityPage = new EntitiesView();
			Response entityDetails = entityPage.getEntityDetails(entityName, data);
			actualRegionList.addAll(entityPage.getRegion(entityDetails));
			actualCountryList.addAll(entityPage.getCountryDetail(entityDetails));
		}

		List<String> dicrepencyRegions = actualRegionList.stream().distinct()
				.filter(actRegions -> ExpectedRegionList.contains(actRegions)).collect(Collectors.toList());

		List<String> dicrepencyCountries = actualCountryList.stream().distinct()
				.filter(actCountry -> ExpectedCountryList.contains(actCountry)).collect(Collectors.toList());

		if (dicrepencyRegions.isEmpty()) {

			BaseTest.passTest("Validation of Regions in Actions Screen Passed");

		} else {
			BaseTest.failTest(
					"Validation of Regions in Actions Screen Failed and We have found data of additional Regions is  Actions Screen"+"<br/>"
							+ dicrepencyRegions,
					data);
		}
		if (dicrepencyCountries.isEmpty()) {

			BaseTest.passTest("Validation of Countries in Actions Screen Passed");

		} else {
			BaseTest.failTest(
					"Validation of Countries in Actions Screen Failed and We have found data of additional Countries in  Actions Screen "+"<br/>"
							+ dicrepencyCountries,
					data);
		}

	}


	public boolean validateActionsView(Hashtable<String, Object> data) throws Exception {

		boolean result = false;
		Response response = getActionsDetails(data);

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

//			if (data.get("MyActions_Tab").equals("Y")) {
//				WorkFlowPage.ActionsPage.clickOnActionsTab();

				if (data.get("MyActions_View").equals("Y")) {
					verifyIsUserHavingEntitiesAccess(data, response);
					verifyisUserHavingL2ServiceAccess(data, response);
					verifyIsUserHavingRegionCountryAccess(data, response);
				} else {
					verifyIsUserNotHavingEntitiesAccess(data, response);
					verifyIsUserNotHavingL2ServiceAccess(data, response);
					verifyIsUserNotHavingRegionCountryAccess(data, response);
				}

//			} 
//			else if (data.get("MyActions_View").equals("N")) {
//				result = SeleniumWrapper.isNotVisible(WorkFlowPage.ActionsPage.ACTIONS_TAB_LOCATOR,
//						"ACTIONS_TAB_LOCATOR");
//				if (result == true) {
//					BaseTest.passTest("User shoud not have access To Actions Tab and Validation got passed");
//				} else {
//					BaseTest.failTest(
//							"Expected: User shoud not have access To Actions Tab, Actual: User has access To Actions Tab",
//							data);
//				}
//			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR, "WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		else if (data.get("Workflow_Menu").equals("N/A")) {
			BaseTest.passTest("Non Enate User shoud not have access To Workflow Menu and Validation got passed");
		}
		return result;
	}
}