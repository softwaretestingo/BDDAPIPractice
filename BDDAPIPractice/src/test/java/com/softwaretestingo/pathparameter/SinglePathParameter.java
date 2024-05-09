package com.softwaretestingo.pathparameter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class SinglePathParameter 
{
	@Test
	public void singlePathParameterTest()
	{
		RestAssured.baseURI="http://ergast.com";
		
		Response response= given().log().all()
								.pathParam("year", "2018")
									.when().log().all()
										.get("/api/f1/{year}/circuits.json");
							
		System.out.println(response.asPrettyString());
		//test abc
		System.out.println(response.asPrettyString());
	}
}
