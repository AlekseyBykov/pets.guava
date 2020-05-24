package alekseybykov.portfolio.guava.splitters;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class SplitterTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static String string;

	@BeforeClass
	public static void setup() {
		string = " string 1|string 2|string 3|string 4 ";
	}

	@Test
	public void testSplitStringToIterable() {
		Splitter splitter = Splitter.on("|").trimResults();
		Iterable<String> strings = splitter.split(string);

		assertThat(strings, Matchers.<String> iterableWithSize(4));
		assertThat(strings, everyItem(not(StringUtils.EMPTY)));

		assertThat(strings, hasItems("string 1", "string 2", "string 3", "string 4"));
	}
}
