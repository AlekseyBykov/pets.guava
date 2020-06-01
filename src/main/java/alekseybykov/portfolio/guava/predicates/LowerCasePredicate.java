package alekseybykov.portfolio.guava.predicates;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;

/**
 * @author Aleksey Bykov
 * @since 30.03.2020
 */
public class LowerCasePredicate implements Predicate<String> {

	@Override
	public boolean apply(String string) {
		return CharMatcher.JAVA_LOWER_CASE.matchesAllOf(string);
	}
}
