package alekseybykov.portfolio.guava.collections.sets;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.Sets;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class SetsTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static final Set<Integer> firstSet = Sets.newHashSet(1, 2, 3, 4, 5);
	private static final Set<Integer> secondSet = Sets.newHashSet(3, 4, 5, 6, 7);

	@Test
	public void testDifference() {
		assertThat(Sets.difference(firstSet, secondSet), hasItems(1, 2));
		assertThat(Sets.difference(secondSet, firstSet), hasItems(6, 7));
	}

	@Test
	public void testSymmetricDifference() {
		assertThat(Sets.symmetricDifference(firstSet, secondSet), hasItems(1, 2, 6, 7));
		assertThat(Sets.symmetricDifference(secondSet, firstSet), hasItems(1, 2, 6, 7));
	}

	@Test
	public void testIntersection() {
		assertThat(Sets.intersection(firstSet, secondSet), hasItems(3, 4, 5));
		assertThat(Sets.intersection(secondSet, firstSet), hasItems(3, 4, 5));
	}

	@Test
	public void testUnion() {
		assertThat(Sets.union(firstSet, secondSet), hasItems(1, 2, 3, 4, 5, 6, 7));
		assertThat(Sets.union(secondSet, firstSet), hasItems(1, 2, 3, 4, 5, 6, 7));
	}
}
