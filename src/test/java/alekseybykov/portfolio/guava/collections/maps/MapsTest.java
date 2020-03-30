package alekseybykov.portfolio.guava.collections.maps;

import alekseybykov.portfolio.guava.model.Book;
import alekseybykov.portfolio.guava.utils.Utils;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapsTest {

	private static final ImmutableMap<String, String> firstMap = new ImmutableMap.Builder<String, String>()
		.put("key 1", "value 1")
		.put("key 2", "value 2")
		.put("key 3", "value 3")
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
	public void testTransformList2Map() {
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
