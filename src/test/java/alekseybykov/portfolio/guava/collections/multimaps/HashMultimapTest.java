package alekseybykov.portfolio.guava.collections.multimaps;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.HashMultimap;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Aleksey Bykov
 * @since 31.03.2020
 */
public class HashMultimapTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static HashMultimap<String, Integer> multimap = HashMultimap.create();

	@BeforeClass
	public static void setup() {
		multimap.put("key1", 0);
		multimap.put("key1", 1);
		multimap.put("key1", 1);
		multimap.put("key1", 1);
		multimap.put("key1", 2);
		multimap.put("key2", 2);
		multimap.put("key2", 2);
	}

	@Test
	public void test() {
		assertThat(multimap.get("key1"), hasItems(0, 1, 2));
		assertThat(multimap.get("key2"), hasItems(2));
		assertEquals(multimap.size(), 4);
	}
}
