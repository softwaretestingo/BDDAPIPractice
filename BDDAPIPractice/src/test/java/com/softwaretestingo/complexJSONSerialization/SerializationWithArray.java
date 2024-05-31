package com.softwaretestingo.complexJSONSerialization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;
public class SerializationWithArray 
{
	@Test
	public void SerializationWithArrayTest()
	{
		ParentAddNewCartPOJOClass obj=new ParentAddNewCartPOJOClass();
		obj.setUserId(111);
		obj.setDate("2024-05-31");
		List<NestedProductsPOJOClass> myproduct=new ArrayList<>();
		
		// Create and add the first product
		NestedProductsPOJOClass product1=new NestedProductsPOJOClass();
		product1.setProductId(11);
		product1.setQuantity(100);
		myproduct.add(product1);
		
		// Create and add the Second product
		NestedProductsPOJOClass product2=new NestedProductsPOJOClass();
		product2.setProductId(22);
		product2.setQuantity(200);
		myproduct.add(product2);
		
		// Set the products list to the order
		obj.setProducts(myproduct);
		
		RestAssured.baseURI="https://fakestoreapi.com";
		
		Response response=given()
							.body(obj)
							.when()
								.post("/carts")
									.then().log().all()
										.assertThat()
											.statusCode(200)
												.and()
													.extract()
														.response();
		
		System.out.println("Response Is: "+response.asPrettyString());
	}
}
