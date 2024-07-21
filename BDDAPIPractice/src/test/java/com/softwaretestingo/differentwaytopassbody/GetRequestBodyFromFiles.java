package com.softwaretestingo.differentwaytopassbody;
import org.testng.annotations.Test;
import files.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;
public class GetRequestBodyFromFiles 
{
	// Get The Payload From External File Method
	@Test
	public void HotelBookingTest()
	{
	RestAssured.baseURI="https://api.restful-api.dev";
	
	given()
		.body(Payload.payloadForAddingItems())
		.contentType("application/json")
			.when()
				.post("/objects")
				 	.then().log().body()
				 		.assertThat()
				 			.statusCode(200);
	}
	
	// Get The Payload From External File
	@Test
	public void GetBodyFromExternalFile()
	{
		String path=System.getProperty("user.dir")+"/src/test/java/files/userinfo.json";
		File file=new File(path);
		RestAssured.baseURI="https://reqres.in/";
		
		given()
		.body(file)
		.contentType("application/json")
			.when()
				.post("/api/users")
				 	.then().log().body()
				 		.assertThat()
				 			.statusCode(201);	
	}
}