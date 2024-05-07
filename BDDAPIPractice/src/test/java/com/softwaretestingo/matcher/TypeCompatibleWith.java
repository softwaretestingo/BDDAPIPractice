package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class TypeCompatibleWith 
{
	//Matcher which matches when objects of the input Type can be assigned to references of the specified base Type.
	@Test
    public void test_typeCompatibleWith()
	{
        Integer integer = 3;
        assertThat(integer.getClass(), typeCompatibleWith(Number.class));
    }
}
