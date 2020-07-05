package alekseybykov.portfolio.guava.collections.multimaps;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 31.03.2020
 */
public class HashMultimapTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static final Multimap<String, Integer> multimap = ImmutableMultimap.<String, Integer>builder()
			.put("key1", 0)
			.put("key1", 1)
			.put("key1", 1)
			.put("key1", 1)
			.put("key1", 2)
			.put("key2", 2)
			.put("key2", 2)
			.build();

	@Test
	public void test() {
		assertThat(multimap.get("key1"), hasItems(0, 1, 2));
		assertThat(multimap.get("key2"), hasItems(2));
		assertEquals(multimap.size(), 7);

		assertTrue(multimap.get("key1").contains(0));
		assertTrue(multimap.get("key1").contains(1));
		assertFalse(multimap.get(null).contains(1));
	}
}
