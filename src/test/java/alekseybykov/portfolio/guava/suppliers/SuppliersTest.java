package alekseybykov.portfolio.guava.suppliers;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SuppliersTest {

	@Test
	public void testMemoizeMethodCallWithoutExpiration() {
		RandomIntSupplier randomIntSupplier = new RandomIntSupplier();
		Supplier<Integer> memoizedSupplier = Suppliers.memoize(randomIntSupplier);

		// result is persisted (memoized) in memory
		Integer randomInt = memoizedSupplier.get();

		assertEquals(randomInt, memoizedSupplier.get());
		assertEquals(randomInt, memoizedSupplier.get());
		assertEquals(randomInt, memoizedSupplier.get());
		assertEquals(randomInt, memoizedSupplier.get());
	}

	@Test
	public void testMemoizeMethodCallWithExpiration() throws InterruptedException {
		RandomIntSupplier randomIntSupplier = new RandomIntSupplier();
		Supplier<Integer> memoizedSupplier = Suppliers.memoizeWithExpiration(randomIntSupplier, 10, TimeUnit.SECONDS);

		// result is persisted (memoized) in memory for 10 seconds
		Integer randomInt = memoizedSupplier.get();

		assertEquals(randomInt, memoizedSupplier.get());

		Thread.sleep(15000);

		// re-generate new random int
		assertNotEquals(randomInt, memoizedSupplier.get());
		assertNotEquals(randomInt, memoizedSupplier.get());
	}
}
