package com.softwaretestingo.differentwaytopassbody;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PassBodyAsStringInPostRequest 
{
	/*
	 * If you mention .header("Content-Type", "application/json") then you will get
	 * 400 Error Because Here we are passing data as String inside the body
	 * Note: Don't Mention .header("Content-Type", "application/json")
	 * 
	 * Here In Body We Pass the Data as
	 * 
	 * "name": "morpheus",
	 * "job": "leader"
	 * 
	 */
	
	@Test
	public void passBodyAsStringInPostRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
				.body(" \"name\": \"SoftwareTestingo\",\r\n"
						+ "    \"job\": \"Admin\"")
					.post("/api/users")
						.then().log().all()
							.assertThat()
								.statusCode(201)
									.and()
										.contentType(ContentType.JSON);
	}
}
