package alekseybykov.portfolio.guava.suppliers;

import com.google.common.base.Supplier;

import java.util.Random;

public class RandomIntSupplier implements Supplier<Integer> {

	@Override
	public Integer get() {
		return new Random().nextInt();
	}
}
