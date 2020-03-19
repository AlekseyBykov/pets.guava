package alekseybykov.portfolio.guava.joiners;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JoinerTest {

	private List<String> strings;

	@Before
	public void setup() {
		strings = Lists.newArrayList();
	}

	@Test
	public void testJoinStringsFromListWithSkipNulls() {
		strings.addAll(Arrays.asList("string 1", "string 2", "string 3", null, "string 4"));
		String expectedString = "string 1|string 2|string 3|string 4";

		Joiner joiner = Joiner.on("|").skipNulls();
		String actualString = joiner.join(strings);

		assertThat(actualString, is(expectedString));
	}
}
