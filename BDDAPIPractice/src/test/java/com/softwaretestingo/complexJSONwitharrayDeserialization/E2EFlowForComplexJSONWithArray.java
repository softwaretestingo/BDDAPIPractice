package com.softwaretestingo.complexJSONwitharrayDeserialization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.List;
public class E2EFlowForComplexJSONWithArray 
{
	@Test
	public void e2EFlowForComplexJSONWithArrayTest()
	{
		RestAssured.baseURI= "https://fakestoreapi.in";
		
		ParentPOJOClass response = given()
								.queryParam("limit", 10)
									.when()
										.get("/api/users")
											.then().log().body()
												.assertThat()
													.statusCode(200)
														.and()
															.extract()
																.as(ParentPOJOClass.class);
	
		System.out.println("--------------------------------------------");
		System.out.println("              PRINT RESULT                  ");
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println("Status: "+response.getStatus());
		System.out.println("Message: "+ response.getMessage());
		
		System.out.println();
		
		//Print First User Email ID
		System.out.println("Email Id: "+ response.getUsers().get(0).getEmail());
		System.out.println("--------------------------------------------");
		//Find the Username and password of the user whose email id is kevin@gamble.com
		//Get all the users
		List<NestedUserPOJOClass> alluser = response.getUsers();
		
		System.out.println("Printing the Username and password of the user whose email id is: kevin@gamble.com");
		//Use Loop to get the expected result
		for(int i=0; i<alluser.size();i++)
		{
			if(alluser.get(i).getEmail().equalsIgnoreCase("kevin@gamble.com"))
			{
				System.out.println("User Name Is: "+alluser.get(i).getUsername());
				System.out.println("Password Is: "+alluser.get(i).getPassword());
			}
		}
		
		System.out.println("--------------------------------------------");
		//Print All The Users Email ID
		for(int i=0; i<alluser.size();i++)
		{
			System.out.println("Users "+ i +" Email id" + alluser.get(i).getEmail());
		}
		
	}
}