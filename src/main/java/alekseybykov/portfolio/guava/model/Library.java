package alekseybykov.portfolio.guava.model;

import java.util.HashSet;
import java.util.Set;

public class Library {

	private String name;
	private Set<Book> books = new HashSet<>();

	public Library(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
