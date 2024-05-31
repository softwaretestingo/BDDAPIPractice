package com.softwaretestingo.simpleJSONSerialization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class SerializationWithOutArray 
{
	@Test
	public void SerializationWithOutArrayTest()
	{
		ParentAddComputerDetailsPOJOClass obj=new ParentAddComputerDetailsPOJOClass();
		obj.setName("Apple MacBook Pro 16");
		
		ParentAddComputerDetailsPOJOClass.Data data=new ParentAddComputerDetailsPOJOClass.Data();
		data.setYear(2024);
		data.setPrice(99999.99);
		data.setCPUmodel("Intel Core i9");
		data.setHarddisksize("3 TB");
		
		obj.setData(data);
		
		RestAssured.baseURI="https://api.restful-api.dev";
		Response response=given()
							.contentType("application/json")
							.body(obj)
								.when()
									.post("/objects")
										.then()
											.assertThat()
												.statusCode(200)
													.and()
														.extract()
															.response();
		
		System.out.println("The Rresponse is: ");
		System.out.println(response.asPrettyString());
	}
}
