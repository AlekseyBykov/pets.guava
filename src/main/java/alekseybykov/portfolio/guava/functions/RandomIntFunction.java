package alekseybykov.portfolio.guava.functions;

import com.google.common.base.Function;

import java.util.Random;

/**
 * @author Aleksey Bykov
 * @since 30.03.2020
 */
public class RandomIntFunction implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer integer) {
		return new Random().nextInt(integer) + integer;
	}
}
