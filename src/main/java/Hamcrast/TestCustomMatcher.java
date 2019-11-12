package Hamcrast;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
public class TestCustomMatcher {
	    @Test
	    public void testRegularExpressionMatcher() throws Exception {
	        //String s ="aaabbbaaaa";
	        String s ="xxxxxxxxxxxxxxxxxxxxx";
	        assertThat(s, RegexMatcher.matchesRegex("a*b*a*"));
	    }
}


