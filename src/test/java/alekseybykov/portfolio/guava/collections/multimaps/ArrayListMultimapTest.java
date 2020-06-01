package alekseybykov.portfolio.guava.collections.multimaps;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksey Bykov
 * @since 31.03.2020
 */
public class ArrayListMultimapTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();

	@BeforeClass
	public static void setup() {
		multimap.put("key1", 0);
		multimap.put("key1", 1);
		multimap.put("key1", 2);
		multimap.put("key1", 2);
		multimap.put("key1", 2);
		multimap.put("key2", 2);
		multimap.put("key2", 2);
		multimap.put("key2", 1);
	}

	@Test
	public void test() {
		assertEquals(multimap.get("key1"), Lists.newArrayList(0, 1, 2, 2, 2));
		assertEquals(multimap.get("key2"), Lists.newArrayList(2, 2, 1));
		assertEquals(multimap.size(), 8);
	}
}
