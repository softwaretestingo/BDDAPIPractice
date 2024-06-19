package com.softwaretestingo.specbuilders;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuildersExample 
{
	ResponseSpecification respspec=null;
	
	@Test
	public void ResponseSpecBuildersExampleTest()
	{
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();
		
		respBuilder.expectContentType(ContentType.JSON); // You Can mention "application/json" Also
		respBuilder.expectStatusCode(200);
		respBuilder.expectStatusLine("HTTP/1.1 200 OK");
		
		respspec=respBuilder.build();
		
		given()
			.baseUri("https://reqres.in")
				.basePath("/api/users/2")
					.when()
						.get()
							.then().log().body()
								.assertThat()
									.spec(respspec);
	}
}