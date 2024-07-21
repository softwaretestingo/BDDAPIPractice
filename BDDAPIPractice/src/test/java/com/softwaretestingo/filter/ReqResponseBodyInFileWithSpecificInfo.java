package com.softwaretestingo.filter;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ReqResponseBodyInFileWithSpecificInfo 
{
	@Test
	public void logFilter() throws FileNotFoundException 
	{
		PrintStream fileOutputStream=new PrintStream(new File("restassuredSpecific.log"));
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/2";

		// For Print Specific Information You need to Pass LogDetail along with PrintStream Object
		given()
			.filter(new RequestLoggingFilter(LogDetail.BODY, fileOutputStream))
			.filter(new ResponseLoggingFilter(LogDetail.STATUS, fileOutputStream))
		.when()
			.get()
		.then()
			.assertThat()
			.statusCode(200);

	}
}
