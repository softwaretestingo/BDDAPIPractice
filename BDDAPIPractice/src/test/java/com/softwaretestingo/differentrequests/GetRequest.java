package com.softwaretestingo.differentrequests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetRequest 
{
	//Given - All Input Details Mentioned Here
	//When - Submit The API Here Means What Methods You Want to Call
	//Then - Validate The Response Here
	//And - For Assertion
	
	//1. Set The BaseURI & BasePath 
	
	@Test
	public void getRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
		
		Response response=	given().
								when().
									get();
		
		System.out.println("The Response Body Is: ");
		System.out.println(response.asPrettyString());			
	}
}