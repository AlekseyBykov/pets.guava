package alekseybykov.portfolio.guava.model;

import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 29.03.2020
 */
public class Library {

	private String name;
	private List<Book> books;

	public Library(String name) {
		this.name = name;
	}

	public Library(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
