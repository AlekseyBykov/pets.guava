package alekseybykov.portfolio.guava.functional.predicates;

import alekseybykov.portfolio.guava.predicates.LowerCasePredicate;
import alekseybykov.portfolio.guava.predicates.UpperCasePredicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

// Predicate interface is used for filtering
public class PredicatesTest {

	private static List<String> list = Lists.newArrayList("A", "B", "c");

	@BeforeClass
	public static void setup() {
		list = Lists.newArrayList("A", "B", "c");
	}

	@Test
	public void testFilterStringsInUpperCase() {
		UpperCasePredicate predicate = new UpperCasePredicate();
		assertThat(Collections2.filter(list, predicate), contains("A", "B"));
	}

	@Test
	public void testFilterStringsInLowerCase() {
		LowerCasePredicate predicate = new LowerCasePredicate();
		assertThat(Collections2.filter(list, predicate), contains("c"));
	}
}
