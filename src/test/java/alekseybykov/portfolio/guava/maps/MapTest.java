package alekseybykov.portfolio.guava.maps;

import alekseybykov.portfolio.guava.utils.Utils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class MapTest {

	private static final ImmutableMap<String, String> firstMap = new ImmutableMap.Builder<String, String>()
		.put("key 1", "value 1")
		.put("key 2", "value 2")
		.put("key 3", "value 3")
		.build();

	@Test
	public void testMergeTwoMaps() {
		final ImmutableMap<String, String> secondMap = Utils.mergeMaps(firstMap, new HashMap<String, String>() {{
			put("key 1", "11");
			put("key 2", "22");
			put("key 4", "4");
		}});

		assertThat(secondMap,
			Matchers.<Map<String, String>>equalTo(ImmutableMap.of(
				"key 1", "11",
				"key 2", "22",
				"key 3", "value 3",
				"key 4", "4"
			))
		);
	}
}
