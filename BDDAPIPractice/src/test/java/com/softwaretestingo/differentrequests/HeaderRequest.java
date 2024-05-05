package com.softwaretestingo.differentrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
public class HeaderRequest 
{
	@Test
	public void headerRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Headers headers = given().log().all()
							.when()
								.get("/api/users?page=2")
									.headers();
		
		System.out.println("------------------------------");
		for(Header header:headers)
		{
			System.out.println(header.getName()+"-->"+header.getValue());
		}
	}
}
