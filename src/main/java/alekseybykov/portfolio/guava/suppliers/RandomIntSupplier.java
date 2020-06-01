package alekseybykov.portfolio.guava.suppliers;

import com.google.common.base.Supplier;

import java.util.Random;

/**
 * @author Aleksey Bykov
 * @since 30.03.2020
 */
public class RandomIntSupplier implements Supplier<Integer> {

	@Override
	public Integer get() {
		return new Random().nextInt();
	}
}
