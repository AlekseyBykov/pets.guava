package alekseybykov.portfolio.guava.functional.predicates;

import alekseybykov.portfolio.guava.predicates.LowerCasePredicate;
import alekseybykov.portfolio.guava.predicates.UpperCasePredicate;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;

// Predicate interface is used for filtering
public class PredicatesTest {

	private static List<String> list = Lists.newArrayList("A", "B", "c");

	private static final UpperCasePredicate upperCasePredicate = new UpperCasePredicate();
	private static final LowerCasePredicate lowerCasePredicate = new LowerCasePredicate();

	@BeforeClass
	public static void setup() {
		list = Lists.newArrayList("A", "B", "c");
	}

	@Test
	public void testFilterStringsInUpperCase() {
		assertThat(Collections2.filter(list, upperCasePredicate), contains("A", "B"));
		assertThat(Collections2.filter(list, Predicates.not(lowerCasePredicate)), contains("A", "B"));
	}

	@Test
	public void testFilterStringsInLowerCase() {
		assertThat(Collections2.filter(list, lowerCasePredicate), contains("c"));
		assertThat(Collections2.filter(list, Predicates.not(upperCasePredicate)), contains("c"));
	}

	@Test
	public void testFilterStringsInNoCases() {
		Predicate<String> noCases = Predicates.and(lowerCasePredicate, upperCasePredicate);
		assertThat(Collections2.filter(list, noCases), is(empty()));
	}

	@Test
	public void testFilterStringsInAllCases() {
		Predicate<String> allCases = Predicates.or(lowerCasePredicate, upperCasePredicate);
		assertThat(Collections2.filter(list, allCases), containsInAnyOrder(list.toArray()));
	}
}
