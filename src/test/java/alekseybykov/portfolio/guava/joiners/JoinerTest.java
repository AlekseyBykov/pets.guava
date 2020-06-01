package alekseybykov.portfolio.guava.joiners;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksey Bykov
 * @since 19.03.2020
 */
public class JoinerTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static List<String> strings;

	@BeforeClass
	public static void setup() {
		strings = Lists.newArrayList(Arrays.asList("string 1", "string 2", "string 3", null, "string 4"));
	}

	@Test
	public void testJoinStringsFromListWithSkipNulls() {
		String expectedString = "string 1|string 2|string 3|string 4";

		Joiner joiner = Joiner.on("|").skipNulls();
		String actualString = joiner.join(strings);

		assertThat(actualString, is(expectedString));
	}

	@Test
	public void testJoinStringsFromListWithReplacementForNulls() {
		String expectedString = "string 1|string 2|string 3|EMPTY|string 4";

		Joiner joiner = Joiner.on("|").useForNull("EMPTY");
		String actualString = joiner.join(strings);

		assertThat(actualString, is(expectedString));
	}

	@Test
	public  void testJoinStringsFromListAndAppendToStringBuilder() {
		String expectedString = "string 1|string 2|string 3|NO VALUE|string 4";

		StringBuilder stringBuilder = new StringBuilder();
		Joiner joiner = Joiner.on("|").useForNull("NO VALUE");
		String actualString = joiner.appendTo(stringBuilder, strings).toString();

		assertThat(actualString, is(expectedString));
	}
}
