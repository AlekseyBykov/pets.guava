package alekseybykov.portfolio.guava.charmatcher;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharMatcherTest {

	@Test
	public void testCollapseMultipleTabsAndSpaceAndTrim() {
		String expectedString = "string string";
		String actualString = CharMatcher.WHITESPACE
				.trimAndCollapseFrom("  string\n\n \t string\n", ' ');

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testRetainMatchingCharacters() {
		String expectedString = "1234";

		String actualString = CharMatcher.JAVA_DIGIT
				.retainFrom("  string\n\n \t stri1234ng\n");

		assertEquals(expectedString, actualString);
	}
}
