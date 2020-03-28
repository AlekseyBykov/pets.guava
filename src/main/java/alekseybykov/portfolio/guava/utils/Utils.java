package alekseybykov.portfolio.guava.utils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

public class Utils {
	public static ImmutableMap<String, String> mergeMaps(Map<String, String> leftMap, Map<String, String> rightMap) {
		MapDifference<String, String> diff = Maps.difference(leftMap, rightMap);
		return ImmutableMap.<String, String>builder()
				.putAll(diff.entriesOnlyOnLeft())
				.putAll(rightMap)
				.build();
	}
}
