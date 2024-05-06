package com.softwaretestingo.extractfromresponse;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
public class ExtractResponse 
{
	@Test
	public void ExtractResponseTest()
	{
	RestAssured.baseURI="https://reqres.in/";
	Map<String, String> payload= new HashMap<String, String>();
	payload.put("name", "morpheus");
	payload.put("job", "leader");
	
	ResponseBody response= given().log().all()
			.contentType("application/json")
				.body(payload)
					.post("/api/users")
						.then().log().body()
							.contentType(ContentType.JSON)
								.extract()
									.response();
	}
}
