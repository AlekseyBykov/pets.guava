package alekseybykov.portfolio.guava.preconditions;

import com.google.common.base.Preconditions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreconditionsTest {

	@Test(expected = NullPointerException.class)
	public void testCheckNotNull() {
		assertEquals(Preconditions.checkNotNull("string", "NPE message"), "string");
		Preconditions.checkNotNull(null, "NPE message");
	}
}
