package com.hm.kraios.workflowValidations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import com.hm.kraios.pages.KraiosMyWorkSpaceMenuPage;
import com.hm.kraios.pages.WorkFlowPage;
import com.hm.seleniumFactory.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateActvities {

	public boolean verifyIsUserHavingAccesToManageActivities() {
		boolean result = false;

		if (BaseTest.seleniumWrapperManager.get().isVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_LOCATOR,
				"COMMENT_BOX_LOCATOR")) {
			result = true;

		}
		return result;
	}

	public boolean validateActivitiesExport(Hashtable<String, Object> data) throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Activities_Tab").equals("Y")) {
				WorkFlowPage.ActivitiesPage.clickOnActivitiesTab();

				if (data.get("Workflow_Activities_Export_Link").equals("Y")) {

					result = WorkFlowPage.Export.verifyIsUserHavingAccesToExport();
					if (result == true) {

						BaseTest.passTest("User has access To Activities Export and Validation got passed");

					} else {

						BaseTest.failTest(
								"Expected: User has access To Activities Export, Actual: User  doesn't has the  access To Activities Export",
								data);
					}

				} else if (data.get("Workflow_Activities_Export_Link").equals("N")) {

					result = BaseTest.seleniumWrapperManager.get().isNotVisible(
							WorkFlowPage.Export.EXPORT_THREE_DOTS_ICON_LOCATOR, "EXPORT_THREE_DOTS_ICON_LOCATOR");

					if (result == true) {

						BaseTest.passTest("User shoud not have access To Activities Export and Validation got passed");

					} else {

						BaseTest.failTest(
								"Expected: User shoud not have access To Activities Export, Actual: User has access To Activities Export",
								data);
					}
				}

			} else if (data.get("Activities_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get()
						.isNotVisible(WorkFlowPage.ActivitiesPage.ACTIVITIES_TAB_LOCATOR, "ACTIVITIES_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Activities Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Activities Tab, Actual: User has access To Activities Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}

	public boolean validateActivitiesManage(Hashtable<String, Object> data) throws InterruptedException {

		boolean result = false;

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("Activities_Tab").equals("Y")) {

				if (data.get("MyActivities_View").equals("Y")) {

					if (data.get("MyActivities_Manage").equals("Y")) {

						WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
						WorkFlowPage.ActionsPage.clickOnFirstAction();
						result = verifyIsUserHavingAccesToManageActivities();

						if (result == true) {
							BaseTest.passTest("User has access To Activities Manage and Validation got passed");
						} else {
							BaseTest.failTest(
									"Expected: User has access To Activities Manage, Actual: User  doesn't has the  access To Activities Manage ",
									data);
						}
					} else if (data.get("MyActivities_Manage").equals("N")) {
						WorkFlowPage.GlobalFilter.applyEntityAndServiceLineFilterData(data);
						WorkFlowPage.ActionsPage.clickOnFirstAction();
						result = BaseTest.seleniumWrapperManager.get()
								.isNotVisible(WorkFlowPage.ActionsPage.COMMENT_BOX_LOCATOR, "COMMENT_BOX_LOCATOR");

						if (result == true) {

							BaseTest.passTest(
									"User shoud not have access To Activities View and Validation got passed");
						} else {
							BaseTest.failTest(
									"Expected: User shoud not have access To Activities Manage, Actual: User has access To Activities Manage",
									data);
						}
					}

				} else if (data.get("MyActivities_View").equals("N")) {
					BaseTest.passTest(
							"Passing the validation of this Test Case , Since user is not having Acces to Activities View");
				}
			} else if (data.get("Activities_Tab").equals("N")) {
				result = BaseTest.seleniumWrapperManager.get()
						.isNotVisible(WorkFlowPage.ActivitiesPage.ACTIVITIES_TAB_LOCATOR, "ACTIVITIES_TAB_LOCATOR");
				if (result == true) {
					BaseTest.passTest("User shoud not have access To Activities Tab and Validation got passed");
				} else {
					BaseTest.failTest(
							"Expected: User shoud not have access To Activities Tab, Actual: User has access To Activities Tab",
							data);
				}
			}
		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		}
		return result;

	}

	public Response getActivitiesDetails(Hashtable<String, Object> data) {
		String payLoad = "{\"pageNumber\":1,\"pageSize\":10000,\"taskStatus\":[],\"sortOrder\":\"desc\",\"sortByField\":\"ActivityId\",\"actionCategory\":\"allActions\",\"taskType\":\"\",\"searchText\":\"\",\"updated\":false}";

		return RestAssured.given().baseUri(data.get("apiBaseUrl").toString() + "/core/api/v1/activities/getActivities")
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
				result = "<b>Additional Actual Entities</b> :" + additionalActualEntities + "<br/>"
						+ "<b>Missing Entities InExpected</b> :" + missingEntitiesInExpected;

			}
			if (result instanceof Boolean) {
				BaseTest.passTest("Validation of Entities data in Activities screen Passed");
			} else {

				BaseTest.failTest(
						"Validation of Entities data in Activities screen is Failed" + "<br/>" + result.toString(),
						data);

			}
		} else {
			BaseTest.failTest("<b>API is down</b>Validation of Entities data in Activities screen is Failed" + "<br/>"
					+ result.toString(), data);
		}

		return result;

	}

	public void verifyIsUserHavingRegionAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedRegionList = Arrays.asList(data.get("RegionName").toString().split("\\|"));
		List<String> ExpectedCountryList = Arrays.asList(data.get("CountryName").toString().split("\\|"));
		List<String> activityId = response.then().extract().path("data.content.activityId");
		List<Integer> caseIdList = response.then().extract().path("data.content.caseId");
		List<String> resultList = new ArrayList();

		for (int i = 0; i < caseIdList.size(); i++) {
			Response caseDetailsResponse = getCaseDetails(caseIdList.get(i), data);

			String actualRegion = getCaseRegionDetail(caseDetailsResponse);
			String actualCountry = getCaseCountryDetail(caseDetailsResponse);

			if (!(ExpectedRegionList.contains(actualRegion) & ExpectedCountryList.contains(actualCountry))) {

				resultList.add("Region & Country Discrepency is found for the" + "<br/>" + "<b>Activity ID: <\b>"
						+ activityId.get(i) + "<br/>" + "<b>Actual Region: <\b> " + actualRegion + "<br/>"
						+ "<b>Expected Region: <\b> " + ExpectedRegionList + "<br/>" + "<b>Actual Country: <\b>"
						+ actualCountry + "<br/>" + "<b>Expected Country: <\b>" + ExpectedCountryList + "<br/>");

			}
		}
		if (resultList.isEmpty()) {
			BaseTest.passTest("Validation of Region and Country Access data in Activities screen Passed");

		} else {

			BaseTest.failTest(
					"Validation of Region and Country Access data in Activities screen Failed" + "<br/>" + resultList,
					data);

		}

	}

	public void verifyIsUserNotHavingRegionAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;

		List<String> ExpectedRegionList = Arrays.asList(data.get("RegionName").toString().split("\\|"));
		List<String> ExpectedCountryList = Arrays.asList(data.get("CountryName").toString().split("\\|"));
		List<String> activityId = response.then().extract().path("data.content.activityId");
		List<Integer> caseIdList = response.then().extract().path("data.content.caseId");
		List<String> resultList = new ArrayList();

		for (int i = 0; i < caseIdList.size(); i++) {
			Response caseDetailsResponse = getCaseDetails(caseIdList.get(i), data);

			String actualRegion = getCaseRegionDetail(caseDetailsResponse);
			String actualCountry = getCaseCountryDetail(caseDetailsResponse);

			if (!(ExpectedRegionList.contains(actualRegion) & ExpectedCountryList.contains(actualCountry))) {

				resultList.add("Region & Country Discrepency is found for the" + "<br/>" + "<b>Activity ID: <\b>"
						+ activityId.get(i) + "<br/>" + "<b>Actual Region: <\b> " + actualRegion + "<br/>"
						+ "<b>Expected Region: <\b> " + ExpectedRegionList + "<br/>" + "<b>Actual Country: <\b>"
						+ actualCountry + "<br/>" + "<b>Expected Country: <\b>" + ExpectedCountryList + "<br/>");
			}

		}

		if (resultList.isEmpty()) {
			BaseTest.passTest("Validation of Region and Access data in Activities screen Passed");

		} else {

			BaseTest.failTest(
					"Validation of Region and Access data in Activities screen Failed : User is not having access to Beloe Region or Country"
							+ "<br/>" + resultList,
					data);

		}
	}

	private String getCaseCountryDetail(Response caseDetailsResponse) {
		String countryName = caseDetailsResponse.then().extract().path("data.countryName");
		return countryName;

	}

	private String getCaseRegionDetail(Response caseDetailsResponse) {
		String regionName = caseDetailsResponse.then().extract().path("data.regionName");
		return regionName;

	}

	private Response getCaseDetails(Integer caseID, Hashtable<String, Object> data) {

		String payLoad = "{\"keyId\":" + caseID + ",\"activityType\":\"Case\"}";

		return RestAssured.given()
				.baseUri(data.get("apiBaseUrl").toString() + "/core/api/v1/activities/getActivityDetails")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();

	}

	public Object verifyIsUserNotHavingEntitiesAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedEntityList = Arrays.asList(data.get("EntityName").toString().split("\\|"));

		if (response.getStatusCode() == 200) {
			List<String> actualEntityNames = response.then().extract().path("data.content.entityName");
			List<String> entitiesWithoutUserAceess = ExpectedEntityList.stream()
					.filter(e -> actualEntityNames.contains(e)).collect(Collectors.toList());

			if (entitiesWithoutUserAceess.isEmpty()) {
				BaseTest.passTest("Validation of Entities data in Activities screen Passed");

			} else {

				BaseTest.failTest("User should not have access to Below Entities: " + entitiesWithoutUserAceess, data);

			}
		} else {
			BaseTest.failTest("<b>API is down</b>Validation of Entities data in Activities screen is Failed: "
					+ result.toString(), data);
		}

		return result;

	}

	public Object verifyIsUserNotHavingL2ServiceAccess(Hashtable<String, Object> data, Response response) {
		Object result = true;
		if (!data.get("L2Servicename").toString().equals("N/A")) {
			List<String> ExpectedL2Services = Arrays.asList(data.get("L2Servicename").toString().split("\\|"));
			if (response.getStatusCode() == 200) {
				List<String> actualL2ServiceNames = response.then().extract().path("data.content.activityType");

				List<String> l2ServiceNoAceess = ExpectedL2Services.stream()
						.filter(e -> actualL2ServiceNames.contains(e)).collect(Collectors.toList());

				if (l2ServiceNoAceess.isEmpty()) {

					result = "User should not have access to Below L2Services: " + l2ServiceNoAceess;

				}
			} else {
				BaseTest.failTest("<b>API is down</b>Validation of L2Services data in Activities screen is Failed"
						+ result.toString(), data);
			}
		} else {
			result = true;
		}

		if (result instanceof Boolean) {
			BaseTest.passTest("Validation of L2Services data in Activities screen Passed");
		} else {

			BaseTest.failTest("Validation of L2Services data in Activities screen is Failed" + result.toString(), data);

		}

		return result;

	}

	public Object verifyisUserHavingL2ServiceAccess(Hashtable<String, Object> data, Response response) {
		Object result = false;
		List<String> ExpectedL2Services = Arrays.asList(data.get("L2Servicename").toString().split("\\|"));
		if (response.getStatusCode() == 200) {
			List<String> actualL2ServiceNames = response.then().extract().path("data.content.activityType");
			List<String> additionalL2Services = actualL2ServiceNames.stream().distinct()
					.filter(e -> !ExpectedL2Services.contains(e)).collect(Collectors.toList());

			List<String> missingL2ServicesInExpected = ExpectedL2Services.stream()
					.filter(e -> !actualL2ServiceNames.contains(e)).collect(Collectors.toList());

			if (!(additionalL2Services.isEmpty() & missingL2ServicesInExpected.isEmpty())) {

				result = "<b>Additional L2 Services In Actual</b> :" + additionalL2Services + "<br/>"
						+ "<b>Missing L2 Services In Expected</b> :" + missingL2ServicesInExpected;

			}
		} else {
			BaseTest.failTest("<b>API is down</b>Validation of L2Services data in Activities screen is Failed" + "<br/>"
					+ result.toString(), data);
		}
		if (result instanceof Boolean) {
			BaseTest.passTest("Validation of L2Services data in Activities screen Passed");
		} else {

			BaseTest.failTest(
					"Validation of L2Services data in Activities screen is Failed" + "<br/>" + result.toString(), data);

		}
		return result;

	}

	public Object verifyIsUserNotHavingAccesToActivitiesView(Hashtable<String, Object> data) {
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

			List<String> entitiesNoAceess = ExpectedEntityList.stream().filter(e -> actualEntityNames.contains(e))
					.collect(Collectors.toList());

			List<String> l2ServiceNoAceess = ExpectedL2Services.stream().filter(e -> actualL2ServiceNames.contains(e))
					.collect(Collectors.toList());

			if (entitiesNoAceess.isEmpty() & l2ServiceNoAceess.isEmpty()) {
				result = true;

			} else {

				result = "User should not have access to Below Entities  :" + entitiesNoAceess
						+ "User should not have access to Below L2Services  :" + l2ServiceNoAceess;

			}

		} else {
			result = "API is Down";
		}

		return result;
	}

	public boolean validateActivitiesView(Hashtable<String, Object> data) throws InterruptedException {
		boolean result = false;
		Response response = getActivitiesDetails(data);

		if (data.get("Workflow_Menu").equals("Y")) {

			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			KraiosMyWorkSpaceMenuPage.navigateToWorkflowPage(data);

			if (data.get("MyActivities_View").equals("Y")) {

				verifyIsUserHavingEntitiesAccess(data, response);
				verifyisUserHavingL2ServiceAccess(data, response);
				verifyIsUserHavingRegionAccess(data, response);
			} else {
				verifyIsUserNotHavingEntitiesAccess(data, response);
				verifyIsUserNotHavingL2ServiceAccess(data, response);
				verifyIsUserNotHavingRegionAccess(data, response);
			}

		} else if (data.get("Workflow_Menu").equals("N")) {
			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
			result = BaseTest.seleniumWrapperManager.get().isNotVisible(KraiosMyWorkSpaceMenuPage.WORKFLOW_LOCATOR,
					"WORKFLOW_LOCATOR");
			if (result == true) {
				BaseTest.passTest("User shoud not have access To Workflow Menu and Validation got passed");
			} else {
				BaseTest.failTest(
						"Expected: User shoud not have access To Workflow Menu, Actual: User has access To Workflow Menu",
						data);
			}
		} else if (data.get("Workflow_Menu").equals("N/A")) {
			BaseTest.passTest("Non Enate User shoud not have access To Activities Tab and Validation got passed");

		}
		return result;

	}
}