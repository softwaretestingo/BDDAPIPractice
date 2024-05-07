package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class IsNull 
{
	//IsNull creates a matcher that matches if examined object is null.
	String myStr1  = null;
    String myStr2 = "Testing";
    
    @Test
    public void isNullMatcherTest() 
    {
        assertThat(myStr1, is(nullValue()));
        assertThat(myStr2, is(notNullValue()));
    }

}
