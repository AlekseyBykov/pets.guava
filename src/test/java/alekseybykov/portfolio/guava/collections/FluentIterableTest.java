package alekseybykov.portfolio.guava.collections;

import alekseybykov.portfolio.guava.model.Book;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FluentIterableTest {

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
	public void testChainFilterWithFrom() {
		Iterable<Book> booksFilteredByPages = FluentIterable
			.from(bookList)
			.filter(new Predicate<Book>() {
				@Override
				public boolean apply(Book book) {
					return book.getPages() > 5;
				}
			});

		assertThat(Iterables.contains(booksFilteredByPages, books[0]), is(true));
		assertThat(Iterables.contains(booksFilteredByPages, books[2]), is(true));
	}
}
