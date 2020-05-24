package alekseybykov.portfolio.guava.splitters;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapSplitterTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private Map<String, String> map;

	@Before
	public void setup() {
		map = Maps.newLinkedHashMap();
	}

	@Test
	public void testSplitStringByKeyValuePairsToMap() {
		map = Maps.newLinkedHashMap();
		map.put("key 1", "value 1");
		map.put("key 2", "value 2");
		map.put("key 3", "value 3");

		String string = "key 1=value 1#key 2=value 2#key 3=value 3";
		Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");

		Map<String, String> actualMap = mapSplitter.split(string);

		assertThat(actualMap, is(map));
	}
}
