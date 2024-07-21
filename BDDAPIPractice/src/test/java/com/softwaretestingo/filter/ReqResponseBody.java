package com.softwaretestingo.filter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ReqResponseBody 
{
	@Test
	public void logFilter() 
	{
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/2";

		// This Will Treat As Log().body()
		given()
			.filter(new RequestLoggingFilter(LogDetail.BODY))
			.filter(new ResponseLoggingFilter(LogDetail.BODY))
		.when()
			.get()
		.then()
			.assertThat()
			.statusCode(200);

	}
}
