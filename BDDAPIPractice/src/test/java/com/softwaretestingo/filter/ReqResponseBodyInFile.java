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

public class ReqResponseBodyInFile 
{
	@Test
	public void logFilter() throws FileNotFoundException 
	{
		PrintStream fileOutputStream=new PrintStream(new File("restassured.log"));
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/2";

		// This Will Treat As Log().body()
		given()
			.filter(new RequestLoggingFilter(fileOutputStream))
			.filter(new ResponseLoggingFilter(fileOutputStream))
		.when()
			.get()
		.then()
			.assertThat()
			.statusCode(200);

	}
}
