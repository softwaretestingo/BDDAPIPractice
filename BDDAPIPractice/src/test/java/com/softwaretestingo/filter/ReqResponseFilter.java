package com.softwaretestingo.filter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class ReqResponseFilter 
{
	@Test
	public void logFilter()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
		
		// This Will Treat As Log().all()
		given().
			filter(new RequestLoggingFilter()).
			filter(new ResponseLoggingFilter()).
			when().
				get().
					then().
						assertThat().
							statusCode(200);
							

	}
}
