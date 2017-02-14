package com.example.mylibrary;

import java.util.List;
import java.util.ArrayList;

public class Library {

	// "books" field is the list of all the books in our library
	private List<Book> books;
	private static int idCounter = 0;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	static Integer getUniqueID() {
		idCounter++;
		return idCounter;
	}

	public void addBook(String title, String author, Integer year) {
		books.add(new Book(title, author, year));
		System.out.println("You have added a book: " + title + " by " + author);
	}

	public void removeBook(Integer id){
		Book bookToRemove = null;
		for (Book book : books) {
			if (book.getId() == id){
				bookToRemove = book;
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		books.remove(bookToRemove);
		System.out.println("You have removed a book with id " + id);
	}
	
	public void lendBook(Integer id, String p){
		// the tick value will change, if there is a book with this id
		int tick = 0;
		for (Book book : books) {
			if (book.getId() == id){
				if (book.getLentTo() == null){
					book.setLentTo(p);
					System.out.println(book.getLentTo() + " has borrowed the book with id" + id);
					tick = 1;
				}
				else {
					tick = 1;
					System.out.println("Sorry, the book is already lent to " 
				+ book.getLentTo());
				}
			}
		}
		// if the tick value is the same as in the beginning, 
		// then there was no book with such ID, and that's the message I'm giving
		if (tick == 0){
			System.out.println("Sorry, there is no book with such ID!");
		}
	}

	// this function can print out the details of books on any book list
	// we'll use it in few further functions
	private void printBooks(List<Book> books){
		for (Book book: books){
			System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
			", Year: " + book.getYear() + ", Availability: " + book.isAvailable());
		}
	}

	// printing info about one book
	private void printBooks(Book book){
		List<Book> booksToPrint = new ArrayList<>();
		booksToPrint.add(book);
		printBooks(booksToPrint);
	}

	public void printBookInformation(Integer id){
		Book bookToPrint = null;
		for (Book book : books) {
			if (book.getId() == id){
				bookToPrint = book;
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		System.out.println("Info about a book with id " + id);
		printBooks(bookToPrint);
	}

	public void printAllBooks(){
		List<Book> availableBooks = new ArrayList<Book>();
		List<Book> lentBooks = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getLentTo() == null){
				availableBooks.add(book);
			}
			else{
				lentBooks.add(book);
			}
		}
		System.out.println((availableBooks.size() + " book(s) available:"));
		printBooks(availableBooks);

		System.out.println((lentBooks.size() + " book(s) lent:"));
		printBooks(lentBooks);
	}
	
	public void searchBooks(String title, String author, String year) {
		List<Book> matchingBooks = new ArrayList<Book>(this.books);
		List<Book> notMatchingBooks = new ArrayList<Book>();


		// a star is given as an argument, when the user doesn't want to search
		// using that field (e.g. is interested only in year, not in the author
		if (title != "*") {
			for (Book book : matchingBooks) {
				if (book.getTitle() != title) {
					notMatchingBooks.add(book);
				}
			}
			matchingBooks.removeAll(notMatchingBooks);
		}

		if (author != "*") {
			for (Book book : matchingBooks) {
				if (book.getAuthor() != author) {
					notMatchingBooks.add(book);
				}
			}
			// I'm removing the books three times, because that saves us from
			// going through the whole list few times
			matchingBooks.removeAll(notMatchingBooks);
		}

		if (year != "*") {
			for (Book book : matchingBooks) {
				// I have to take the argument as a string, so the star can be used
				if (book.getYear() != Integer.parseInt(year)) {
					notMatchingBooks.add(book);
				}
			}
			matchingBooks.removeAll(notMatchingBooks);
		}

		if (matchingBooks.size() == 0) {
			System.out.println("No books that meet the criteria.");
		} else {
			System.out.println("Books that meet the criteria:");
			printBooks(matchingBooks);
		}
	}

	public List<Book> getBooks() {
		return books;
	}
}
