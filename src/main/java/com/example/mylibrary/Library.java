package com.example.mylibrary;

import java.util.List;
import java.util.ArrayList;

public class Library {

	// "books" field is the list of all the books in our library
	private List<Book> books = new ArrayList<>();
	private final IdGenerator idGenerator;

	public Library(IdGenerator idGenerator){
		this.idGenerator = idGenerator;
	}

	public Integer addBook(String title, String author, Integer year) {
		int id = idGenerator.getUniqueId();
		books.add(new Book(title, author, year, id));
		return id;
	}

	public void removeBook(Integer id){
		Book bookToRemove = null;
		for (Book book : books) {
			if (book.getId().equals(id)){
				bookToRemove = book;
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		if (bookToRemove == null){
			throw new RuntimeException("Removal not possible, no book with such ID.");
		}
		books.remove(bookToRemove);
	}
	
	public void lendBook(Integer id, String p){
		// the tick value will change, if there is a book with this id
		int tick = 0;
		for (Book book : books) {
			if (book.getId().equals(id)){
				if (book.getLentTo() == null){
					book.lendTo(p);
					tick = 1;
				}
				else {
					tick = 1;
					throw new RuntimeException("Sorry, the book is already lent to "
				+ book.getLentTo() +".");
				}
			}
		}
		// if the tick value is the same as in the beginning, 
		// then there was no book with such ID, and that's the message I'm giving
		if (tick == 0){
			throw new RuntimeException("Lending not possible, there is no book with such ID.");
		}
	}
	
	public List<Book> searchBooks(String title, String author, String year) {
		List<Book> matchingBooks = new ArrayList<>(this.books);
		List<Book> notMatchingBooks = new ArrayList<>();


		// a star is given as an argument, when the user doesn't want to search
		// using that field (e.g. is interested only in year, not in the author
		if (!(title.equals("*"))) {
			for (Book book : matchingBooks) {
				if (!(book.getTitle().equals(title))) {
					notMatchingBooks.add(book);
				}
			}
			matchingBooks.removeAll(notMatchingBooks);
		}

		if (!(author.equals("*"))) {
			for (Book book : matchingBooks) {
				if (!(book.getAuthor().equals(author))) {
					notMatchingBooks.add(book);
				}
			}
			// I'm removing the books three times, because that saves us from
			// going through the whole list few times
			matchingBooks.removeAll(notMatchingBooks);
		}

		if (!(year.equals("*"))) {
			for (Book book : matchingBooks) {
				// I have to take the argument as a string, so the star can be used
				if (!(book.getYear().equals(Integer.parseInt(year)))) {
					notMatchingBooks.add(book);
				}
			}
			matchingBooks.removeAll(notMatchingBooks);
		}
		return matchingBooks;
	}

	public Book getBook (Integer id){
		Book specificBook = null;
		for (Book book : this.books) {
			if (book.getId().equals(id)){
				specificBook = book;
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		return specificBook;
	}

	public List<Book> getBooks() {
		return books;
	}
}
