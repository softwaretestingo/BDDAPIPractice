package com.softwaretestingo.matcher;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class EitherOr 
{
	//Matcher which, when used in combination with it’s combinable matcher .or() 
	//will match when either if the specified matchers match.
	@Test
    public void test_either() throws Exception 
	{
		String test = "Hello, world!";
        assertThat(test, either(startsWith("Hello")).or(endsWith("universe!")));
    }
}
