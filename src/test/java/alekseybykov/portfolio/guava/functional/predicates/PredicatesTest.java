package alekseybykov.portfolio.guava.functional.predicates;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import alekseybykov.portfolio.guava.predicates.LowerCasePredicate;
import alekseybykov.portfolio.guava.predicates.UpperCasePredicate;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;

// Predicate interface is used for filtering
public class PredicatesTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static List<String> list;

	private final UpperCasePredicate upperCasePredicate = new UpperCasePredicate();
	private final LowerCasePredicate lowerCasePredicate = new LowerCasePredicate();

	@Before
	public void setup() {
		list = Lists.newArrayList("A", "B", "c", "a");
	}

	@Test
	public void testFilterStringsInUpperCase() {
		assertThat(Collections2.filter(list, upperCasePredicate), containsInAnyOrder("A", "B"));
		assertThat(Collections2.filter(list, Predicates.not(lowerCasePredicate)), containsInAnyOrder("A", "B"));
	}

	@Test
	public void testFilterStringsInLowerCase() {
		assertThat(Collections2.filter(list, lowerCasePredicate), contains("c", "a"));
		assertThat(Collections2.filter(list, Predicates.not(upperCasePredicate)), containsInAnyOrder("c", "a"));
	}

	@Test
	public void testFilterStringsInNoCases() {
		Predicate<String> noCases = Predicates.and(lowerCasePredicate, upperCasePredicate);
		assertThat(Collections2.filter(list, noCases), is(empty()));
	}

	@Test
	public void testFilterStringsInAllCases() {
		Predicate<String> allCases = Predicates.or(lowerCasePredicate, upperCasePredicate);
		assertThat(Collections2.filter(list, allCases), containsInAnyOrder("A", "B", "c", "a"));
	}

	@Test
	public void testFilterStringsUsingIterable() {
		Iterable<String> strings = Iterables.filter(list, Predicates.containsPattern("a"));
		assertThat(strings, contains("a"));
		assertThat(strings, not(contains("A")));

		// not a live view
		list.add("aa");
		assertThat(strings, not(contains("aa")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFilterStringsUsingCollections() {
		// returns live view of the list
		Collection<String> strings = Collections2.filter(list, Predicates.containsPattern("a"));
		assertThat(strings, contains("a"));
		assertThat(strings, not(contains("A")));

		assertThat(strings.size(), is(1));

		// changes in the original list will affects to filtered result
		list.add("aa");
		assertThat(strings.size(), is(2));

		// the restriction of predicate is preserved
		strings.add("aaa");
		strings.add("b");
	}
}
