package alekseybykov.portfolio.guava.collections.lists;

import alekseybykov.portfolio.guava.model.Book;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class ListsTest {

	private static List<Book> bookList;
	private static Book[] books;

	@BeforeClass
	public static void setup() {
		books = new Book[5];

		books[0] = new Book(10, 20.2);
		books[1] = new Book(5, 10.99);
		books[2] = new Book(11, 1.44);
		books[3] = new Book(3, 8.4);
		books[4] = new Book(1, 7.3);

		bookList = newArrayList(Arrays.asList(books));
	}

	@Test
	public void testPartitioning() {
		List<List<Book>> subList = Lists.partition(bookList, 3);
		assertThat(subList.get(0), hasItems(books[0], books[1], books[2]));
		assertThat(subList.get(1), hasItems(books[3], books[4]));
	}
}
