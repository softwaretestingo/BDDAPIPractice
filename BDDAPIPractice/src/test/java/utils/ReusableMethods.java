package utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class ReusableMethods 
{
	public static JsonPath responseToJSON(Response response)
	{
		JsonPath js=response.jsonPath();
		return js;
	}
	
	public static JsonPath stringToJSON(String response)
	{
		JsonPath js= new JsonPath(response);
		return js;
	}
	
	public static double getRandomNumber(int minValue, int maxValue)
	{
		return Math.floor(Math.random() * (maxValue-minValue)+minValue);
	}
}
