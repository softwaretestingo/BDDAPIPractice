package files;

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
}
