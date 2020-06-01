package alekseybykov.portfolio.guava.collections.maps;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import alekseybykov.portfolio.guava.model.Book;
import alekseybykov.portfolio.guava.utils.Utils;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 30.03.2020
 */
public class MapsTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static final ImmutableMap<String, String> firstMap = new ImmutableMap.Builder<String, String>()
		.put("key 1", "value 1")
		.put("key 2", "value 2")
		.put("key 3", "value 3")
		.build();

	private static final ImmutableMap<String, String> secondMap = new ImmutableMap.Builder<String, String>()
		.put("key 1", "value 0")
		.put("key 2", "value 2")
		.put("key 3", "value 3")
		.put("key 4", "value 4")
		.build();

	private static List<Book> bookList;
	private static Book[] books;

	@BeforeClass
	public static void setup() {
		books = new Book[3];

		books[0] = new Book("book 1", "isbn 1");
		books[1] = new Book("book 2", "isbn 2");
		books[2] = new Book("book 3", "isbn 3");

		bookList = newArrayList(Arrays.asList(books));
	}

	@Test
	public void testObtainCommonEntriesForTwoMaps() {
		MapDifference<String, String> mapDifference = Maps.difference(firstMap, secondMap);
		Map<String, String> commonEntries = mapDifference.entriesInCommon();

		assertTrue(commonEntries.get("key 2").equals("value 2")
		            && commonEntries.get("key 3").equals("value 3")
					&& commonEntries.size() == 2);
	}

	@Test
	public void testObtainValuesWithSameKeyFromTwoMaps() {
		MapDifference<String, String> mapDifference = Maps.difference(firstMap, secondMap);
		Map<String, MapDifference.ValueDifference<String>> commonEntries = mapDifference.entriesDiffering();

		assertTrue(commonEntries.get("key 1").leftValue().equals("value 1")
		           && commonEntries.get("key 1").rightValue().equals("value 0")
		           && commonEntries.size() == 1);
	}


	@Test(expected = UnsupportedOperationException.class)
	public void testTransformList2ImmutableMapUsingKeysGenerator() {
		Map<String, Book> bookMap = Maps.uniqueIndex(bookList.iterator(),
			new Function<Book, String>() {
				@Override
				public String apply(Book book) {
					return book.getIsbn(); // ISBN as key
				}
			}
		);

		assertThat(bookMap,
			Matchers.<Map<String, Book>>equalTo(ImmutableMap.of(
				"isbn 1", books[0],
				"isbn 2", books[1],
				"isbn 3", books[2]
			))
		);

		Book book4 = new Book("book 4", "isbn 4");

		bookMap.put("isbn 4", book4);
		assertTrue( bookMap.get("isbn 4") == null && bookMap.size() == 3);
	}

	@Test
	public void testTransformList2ImmutableMapUsingValuesGenerator() {
		ImmutableMap<Book, String> bookMap = Maps.toMap(bookList.iterator(),
			new Function<Book, String>() {
				@Override
				public String apply(Book book) {
					return book.getIsbn(); // ISBN as value
				}
			}
		);

		assertTrue( bookMap.get(books[0]).equals("isbn 1")
					&& bookMap.get(books[1]).equals("isbn 2")
					&& bookMap.get(books[2]).equals("isbn 3")
		            && bookMap.size() == 3);
	}

	@Test
	public void testTransformSet2MapUsingValuesGenerator() {
		Map<Book, String> bookMap = Maps.asMap(new HashSet<>(bookList),
			new Function<Book, String>() {
				@Override
				public String apply(Book book) {
					return book.getIsbn(); // ISBN as value
				}
			}
		);

		assertTrue( bookMap.get(books[0]).equals("isbn 1")
		            && bookMap.get(books[1]).equals("isbn 2")
		            && bookMap.get(books[2]).equals("isbn 3")
		            && bookMap.size() == 3);
	}

	@Test
	public void testMergeTwoMaps() {
		final ImmutableMap<String, String> secondMap = Utils.mergeMaps(firstMap, new HashMap<String, String>() {{
			put("key 1", "11");
			put("key 2", "22");
			put("key 4", "4");
		}});

		assertThat(secondMap,
			Matchers.<Map<String, String>>equalTo(ImmutableMap.of(
				"key 1", "11",
				"key 2", "22",
				"key 3", "value 3",
				"key 4", "4"
			))
		);
	}
}
