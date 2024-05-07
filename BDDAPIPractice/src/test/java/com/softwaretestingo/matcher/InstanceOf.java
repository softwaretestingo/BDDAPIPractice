package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class InstanceOf 
{
	InstanceOf obj=new InstanceOf();

	@Test
    public void isInstanceOfMatcherTest() {
        assertThat(obj, instanceOf(InstanceOf.class));
    }
}
