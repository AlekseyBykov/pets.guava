package alekseybykov.portfolio.guava.strings;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;

import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Strings.nullToEmpty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StringsTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private String string = "string";

	@Test
	public void testNullToEmpty() {
		assertEquals(StringUtils.EMPTY, nullToEmpty(StringUtils.EMPTY));
		assertEquals(StringUtils.EMPTY, nullToEmpty(null));

		assertEquals(string, nullToEmpty(string));
	}

	@Test
	public void testEmptyToNull() {
		assertNull(emptyToNull(null));
		assertNull(emptyToNull(StringUtils.EMPTY));

		assertEquals(string, emptyToNull(string));
	}

	@Test
	public void testIsNullOrEmpty() {
		assertTrue(isNullOrEmpty(null));
		assertTrue(isNullOrEmpty(StringUtils.EMPTY));

		assertFalse(isNullOrEmpty(string));
	}
}
