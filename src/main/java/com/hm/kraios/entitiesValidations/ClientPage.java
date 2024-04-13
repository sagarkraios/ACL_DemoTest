package com.hm.kraios.entitiesValidations;

import java.util.Hashtable;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ClientPage {

	public int getClientId(Hashtable<String, Object> data) {
		String payLoad = "{\"pageNumber\":1,\"pageSize\":1000,\"sortOrder\":\"as\",\"alpha\":\"\",\"clientNameSort\":true,\"clientName\":\""
				+ data.get("ClientGroup").toString() + "\"}";

		Response response = RestAssured.given()
				.baseUri(data.get("apiBaseUrl").toString() + "/cms/api/v1/clients/filterClientList")
				.header("Authorization", data.get("UserIdToken").toString()).header("Content-Type", "application/json")
				.when().body(payLoad).post();
	
		return Integer.parseInt(response.then().extract().path("data.content.clientId[0]").toString());
	}

}
