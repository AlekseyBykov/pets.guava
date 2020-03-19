package alekseybykov.portfolio.guava.joiners;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapJoinerTest {

	private Map<String, String> map;

	@Before
	public void setup() {
		map = Maps.newLinkedHashMap();
	}

	@Test
	public void testFilterWhitePapers() {
		map = Maps.newLinkedHashMap();
		map.put("key 1", "value 1");
		map.put("key 2", "value 2");
		map.put("key 3", "value 3");

		String expectedString = "key 1=value 1#key 2=value 2#key 3=value 3";
		Joiner.MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");

		String actualString = mapJoiner.join(map);

		assertThat(actualString, is(expectedString));
	}
}
