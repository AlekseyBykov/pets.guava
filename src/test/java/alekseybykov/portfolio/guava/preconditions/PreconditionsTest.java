package alekseybykov.portfolio.guava.preconditions;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.base.Preconditions;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksey Bykov
 * @since 28.03.2020
 */
public class PreconditionsTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	@Test(expected = NullPointerException.class)
	public void testCheckNotNull() {
		assertEquals(Preconditions.checkNotNull("string", "NPE message"), "string");
		Preconditions.checkNotNull(null, "NPE message");
	}
}
