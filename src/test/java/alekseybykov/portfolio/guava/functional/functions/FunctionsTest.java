package alekseybykov.portfolio.guava.functional.functions;

import alekseybykov.portfolio.guava.model.Library;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class FunctionsTest {

	private static Map map;

	@BeforeClass
	public static void setup() {
		map = new HashMap<String, Library>() {{
			put("LIB1", new Library("Library 1"));
			put("LIB2", new Library("Library 2"));
			put("LIB3", new Library("Library 3"));
			put("LIBN", new Library("Library N"));
		}};
	}

	@Test
	public void testLookupByKey() {
		Function<String, Library> lookup = Functions.forMap(map);
		assertEquals("Library N", Objects.requireNonNull(lookup.apply("LIBN")).getName());
	}
}
