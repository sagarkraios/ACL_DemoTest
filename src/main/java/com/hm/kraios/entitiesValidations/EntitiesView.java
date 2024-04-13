package com.hm.kraios.entitiesValidations;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import com.hm.seleniumFactory.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EntitiesView {

	public List<String> getCountryDetail(Response caseDetailsResponse) {
//		String countryName = caseDetailsResponse.then().extract().path("data.content.countryName").toString();
		List<String> countryName =  caseDetailsResponse.then().extract().path("data.content.countryName");
		return countryName;

	}

	public List<String> getRegion(Response caseDetailsResponse) {
//		String regionName = caseDetailsResponse.then().extract().path("data.content.regionName").toString();
		List<String> regionName =  caseDetailsResponse.then().extract().path("data.content.regionName");
		return regionName;

	}

	public Response getEntityDetails(String entityName, Hashtable<String, Object> data) {

		String payLoad = "{\"pageNumber\":1,\"pageSize\":1000,\"alpha\":\"\",\"regionId\":[],\"countryId\":[],\"entityName\":\""
				+ entityName + "\",\"sortOrder\":\"asc\",\"entityNameSort\":true,\"clientId\":"
				+ new ClientPage().getClientId(data) + ",\"isNonEnateEntities\":false,\"status\":\"Active\"}";		
		
		return RestAssured.given().baseUri(data.get("apiBaseUrl").toString() + "/cms/api/v1/entities/filterEntityList")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();

	}

	public Response getAllEntityDetails(Hashtable<String, Object> data) {

		String payLoad = "{\"pageNumber\":1,\"pageSize\":1000,\"alpha\":\"\",\"regionId\":[],\"countryId\":[],\"entityName\":\"\",\"sortOrder\":\"asc\",\"entityNameSort\":true,\"clientId\":"
				+ new ClientPage().getClientId(data) + ",\"isNonEnateEntities\":false,\"status\":\"Active\"}";
		return RestAssured.given().baseUri(data.get("apiBaseUrl").toString() + "/cms/api/v1/entities/filterEntityList")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();

	}

	public void verifyEntityAccess(Hashtable<String, Object> data) {

		Response response = getAllEntityDetails(data);
		List<String> actualEntityList = response.then().extract().path("data.content.entityName");
		List<String> ExpectedEntityList = Arrays.asList(data.get("EntityName").toString().split("\\|"));
		;

		if (ExpectedEntityList.stream().allMatch(actualEntityList::contains)
				&& actualEntityList.stream().allMatch(ExpectedEntityList::contains))

		{
			BaseTest.passTest("Validation of verify Entity Access is Passed");

		} else {
			BaseTest.failTest("Validation of verify Is User Having Entity Access Failed"+ "<br/>"
					+ "<b>Actual Entity: <\b> "  + actualEntityList +"<br/>"+ "<b>Expected Entity: <\b> "
					+ ExpectedEntityList, data);
		}

	}

	public void verifyCountryAccess(Hashtable<String, Object> data) {

		Response response = getAllEntityDetails(data);
		List<String> actualCountryList = response.then().extract().path("data.content.countryName");
		List<String> ExpectedCountryList = Arrays.asList(data.get("CountryName").toString().split("\\|"));
		;

		if (ExpectedCountryList.stream().allMatch(actualCountryList::contains)
				&& actualCountryList.stream().allMatch(ExpectedCountryList::contains))

		{
			BaseTest.passTest("Validation of verify Country Access is Passed");

		} else {
			BaseTest.failTest("Validation of verify Is User Having Country Access Failed"+ "<br/>"
					+ "<b>Actual Country: <\b> "  + actualCountryList +"<br/>"+ "<b>Expected Country: <\b> "
					+ ExpectedCountryList, data );
		}

	}

	public void verifyRegionAccess(Hashtable<String, Object> data) {

		Response response = getAllEntityDetails(data);
		List<String> actualRegionList = response.then().extract().path("data.content.regionName");
		List<String> ExpectedRegionList = Arrays.asList(data.get("RegionName").toString().split("\\|"));
		;

		if (ExpectedRegionList.stream().allMatch(actualRegionList::contains)
				&& actualRegionList.stream().allMatch(ExpectedRegionList::contains))

		{
			BaseTest.passTest("Validation of verify Region Access is Passed");

		} else {
			BaseTest.failTest("Validation of verify Is User Having Region Access Failed"+ "<br/>"
					+ "<b>Actual Region: <\b> "  + actualRegionList +"<br/>"+ "<b>Expected Region: <\b> "
					+ ExpectedRegionList, data );
		}

	}
		
	public boolean validateEntitiesScreenValidationView(Hashtable<String, Object> data) throws InterruptedException {
		boolean result = false;

		if (data.get("Entities_Menu").equals("Y")) {

//			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
//			KraiosMyWorkSpaceMenuPage.navigateToEntitiesPage(data);

				if (data.get("Entities_View").equals("Y")) {
					
					verifyEntityAccess(data);
					verifyCountryAccess(data);
					verifyRegionAccess(data);
				
				}
				else if (data.get("Entities_View").equals("N")) {
					BaseTest.passTest("User not have access To Entities View and Validation got passed");
				}

		} else if (data.get("Entities_Menu").equals("N")) {
//			KraiosMyWorkSpaceMenuPage.clickOnWorkSpaceMenu();
//			result = SeleniumWrapper.isNotVisible(KraiosMyWorkSpaceMenuPage.ENTITIES_LOCATOR, "ENTITIES_LOCATOR");
//			if (result == true) {
//				BaseTest.passTest("User shoud not have access To Entities Menu and Validation got passed");
//			} 
//			else {
//				BaseTest.failTest("Expected: User shoud not have access To Entities Menu, Actual: User has access To Entities Menu",data);
//			}
	}
		return result;
	}
}
