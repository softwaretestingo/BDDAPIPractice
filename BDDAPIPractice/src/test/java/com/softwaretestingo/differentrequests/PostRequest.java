package com.softwaretestingo.differentrequests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class PostRequest 
{
	//Given - All Input Details Mentioned Here
	//When - Submit The API Here Means What Methods You Want to Call (Resources & http Method)
	//Then - Validate The Response Here
	//And - For Assertion
	
	//1. Set The BaseURI & BasePath 
	@Test
	public void postRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
				.and()
					.body("{\r\n"
							+ "    \"name\": \"morpheus\",\r\n"
							+ "    \"job\": \"leader\"\r\n"
							+ "}")
					.when()
						.post("/api/users")
							.then().log().all()
								.assertThat()
									.statusCode(201)
										.and()
											.contentType(ContentType.JSON);
	}
}
