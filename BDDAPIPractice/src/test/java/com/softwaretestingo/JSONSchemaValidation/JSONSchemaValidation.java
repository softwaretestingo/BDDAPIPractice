package com.softwaretestingo.JSONSchemaValidation;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;

import java.io.File;

public class JSONSchemaValidation 
{
	@Test
	public void SchemaValidation()
	{
		RestAssured.baseURI="https://reqres.in/";
		given()
			.baseUri(baseURI)
		.when()
			.get("/api/users/2")
		.then()
			.assertThat()
				.statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\marana\\git\\BDDAPIPractice\\BDDAPIPractice\\src\\test\\java\\files\\ReqResGetResponseSchema.json")));
	}

}
