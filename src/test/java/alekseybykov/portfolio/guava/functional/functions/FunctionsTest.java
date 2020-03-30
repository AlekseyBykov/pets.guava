package alekseybykov.portfolio.guava.functional.functions;

import alekseybykov.portfolio.guava.model.Book;
import alekseybykov.portfolio.guava.model.Library;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

// Function interface is used for transformations
public class FunctionsTest {

	private static Map libraries;

	@BeforeClass
	public static void setup() {
		final List<Book> books = new ArrayList<Book>() {{
			add(new Book("book1", "isbn1"));
			add(new Book("book2", "isbn2"));
		}};

		libraries = new HashMap<String, Library>() {{
			put("LIB1", new Library("Library 01", books));
			put("LIBN", new Library("Library N", books));
		}};
	}

	@Test
	public void testLookupByKey() {
		Function<String, Library> lookupLibraryByKey = Functions.forMap(libraries);
		assertEquals("Library N", lookupLibraryByKey.apply("LIBN").getName());
	}

	@Test
	public void testComposeTwoFunctions() {
		Function<String, Library> lookupLibraryByKey = Functions.forMap(libraries);
		Function<Library, String> joinBookNames = new Function<Library, String>() {
			@Override
			public String apply(Library library) {
				Joiner joiner = Joiner.on(StringUtils.SPACE);
				List<String> names = new ArrayList<>();
				for (Book book : library.getBooks()) {
					names.add(book.getName());
				}
				return joiner.join(names);
			}
		};

		Function<String, String> composed = Functions.compose(joinBookNames, lookupLibraryByKey);

		// the same
		assertEquals("book1 book2", composed.apply("LIB1"));
		assertEquals("book1 book2", joinBookNames.apply(lookupLibraryByKey.apply("LIB1")));
	}
}
