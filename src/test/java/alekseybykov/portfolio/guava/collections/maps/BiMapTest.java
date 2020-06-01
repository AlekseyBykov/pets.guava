package alekseybykov.portfolio.guava.collections.maps;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksey Bykov
 * @since 31.03.2020
 */
public class BiMapTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	@Test(expected = IllegalArgumentException.class)
	public void testAttemptToPutTheSameValue() {
		BiMap<String, Integer> biMap = HashBiMap.create();
		biMap.put("key1", 0);

		// values also should be unique for invert supporting
		biMap.put("key2", 0);
	}

	@Test
	public void testForcePutTheSameValue() {
		BiMap<String, Integer> biMap = HashBiMap.create();
		biMap.put("key1", 0);

		// will remove entry with the same value
		biMap.forcePut("key2", 0);

		assertThat(biMap.containsKey("key2"), is(true));
		assertThat(biMap.containsKey("key1"), is(false));
	}

	@Test
	public void testInverse() {
		BiMap<String, Integer> biMap = HashBiMap.create();
		biMap.put("key1", 0);
		biMap.put("key2", 1);

		assertThat(biMap.get("key1"), is(0));
		assertThat(biMap.get("key2"), is(1));

		BiMap<Integer, String> inverseBiMap = biMap.inverse();

		assertThat(inverseBiMap.get(0), is("key1"));
		assertThat(inverseBiMap.get(1), is("key2"));
	}
}
