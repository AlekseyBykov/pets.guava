package alekseybykov.portfolio.guava.model;

/**
 * @author Aleksey Bykov
 * @since 29.03.2020
 */
public class Book {

	private String name;
	private String isbn;
	private int pages;
	private double price;

	public Book(int pages, double price) {
		this.pages = pages;
		this.price = price;
	}

	public Book(String name, String isbn) {
		this.name = name;
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
