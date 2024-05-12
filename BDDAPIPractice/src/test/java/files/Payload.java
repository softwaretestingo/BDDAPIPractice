package files;

import utils.ReusableMethods;

public class Payload 
{
	public static String payloadForAddingItems()
	{
		return "{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2024,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}";
	}
	
	public static String payloadForAddingReqresUser()
	{
		return "{\r\n"
				+ "    \"name\": \"SoftwareTestingo\",\r\n"
				+ "    \"job\": \"Admin\"\r\n"
				+ "}";
	}
	
	public static String payloadforUpdateReqresUser()
	{
		return "{\r\n"
				+ "    \"name\": \"SoftwareTestingo Blog\",\r\n"
				+ "    \"job\": \"Admin\"\r\n"
				+ "}";
	}
	
	public static String payloadforCourse()
	{
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"softwaretestingo.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	public static String payloadForAddingGoRESTUser()
	{
		String payload= "{\r\n"
				+ "\"email\": \"testab0585@gmail.com\",\r\n"
				+ "\"name\": \"softwaretestingo\",\r\n"
				+ "\"gender\": \"Male\",\r\n"
				+ "\"status\": \"Active\"\r\n"
				+ "}";
		return payload;
	}
	
	public static String payloadForAddingGoRESTUser(String email)
	{
		String payload= "{\r\n"
				+ "\"email\": \""+email+"\",\r\n"
				+ "\"name\": \"softwaretestingo\",\r\n"
				+ "\"gender\": \"Male\",\r\n"
				+ "\"status\": \"Active\"\r\n"
				+ "}";
		return payload;
	}
	
	public static String payloadForAddingRandomEmailInGoRESTUser()
	{
		String email="SoftwareTestingo"+ReusableMethods.getRandomNumber(1, 10000)+"@test.com";
		String payload= "{\r\n"
				+ "\"email\": \""+email+"\",\r\n"
				+ "\"name\": \"softwaretestingo\",\r\n"
				+ "\"gender\": \"Male\",\r\n"
				+ "\"status\": \"Active\"\r\n"
				+ "}";
		return payload;
	}
}
