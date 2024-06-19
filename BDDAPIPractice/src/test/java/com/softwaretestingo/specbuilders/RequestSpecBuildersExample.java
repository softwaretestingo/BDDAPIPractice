package com.softwaretestingo.specbuilders;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuildersExample 
{
	RequestSpecification reqspec=null;
	@Test
	public void RequestSpecBuildersTest()
	{
		RequestSpecBuilder reqSpecBuilder=new RequestSpecBuilder();
		
		reqSpecBuilder.setBaseUri("https://reqres.in");
		reqSpecBuilder.setBasePath("/api/users/2");
		reqspec=reqSpecBuilder.build();
		
		given()
			.contentType("application/json")
				.and()
					.spec(reqspec)
						.when()
							.get()
								.then().log().all()
									.assertThat()
										.statusCode(200);
	}
}