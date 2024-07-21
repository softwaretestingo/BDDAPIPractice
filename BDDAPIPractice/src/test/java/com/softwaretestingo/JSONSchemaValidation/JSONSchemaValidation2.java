package com.softwaretestingo.JSONSchemaValidation;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
public class JSONSchemaValidation2 
{
	/**
	 * JSON Schema Validation With "matchesJsonSchemaInClasspath"
	 * The JSON File Should be placed in \src\test\resources
	 * Otherwise You Will get IllegalArgumentException: Schema to use cannot be null
	 */
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
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ReqResGetResponseSchema.json"));
	}

}
