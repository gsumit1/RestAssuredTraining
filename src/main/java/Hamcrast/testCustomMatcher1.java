package Hamcrast;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static Hamcrast.IsNotANumber.notANumber;

public class testCustomMatcher1 {
	@SuppressWarnings("unchecked")
	@Test
	public void example1() {
		assertThat(Math.sqrt(-1), is(notANumber()));
	}
	
	
	//@Test
	@SuppressWarnings("unchecked")
	public void example2() {
		assertThat(1, is(notANumber()));
	}
	
	
	
	
}