package com.example.mylibrary;

import java.util.ArrayList;

public class Library {

	// "books" field is the list of all the books in our library
	private ArrayList<Book> books;
	private static int idCounter = 0;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	static Integer getUniqueID() {
		idCounter++;
		return idCounter;
	}

	public void addBook(String title, String author, Integer year) {
		Book book = new Book(title, author, year);
		books.add(book);
		System.out.println("You have added a book: " + title + " by " + author);
	}

	public void removeBook(Integer id){
		// I cannot remove the elements of the list I'm iterating through
		// so I'm creating a list of the elements to remove
		ArrayList<Book> bookToRemove = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getId() == id){
				bookToRemove.add(book);
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		books.removeAll(bookToRemove);
		System.out.println("You have removed a book with id " + id);
	}
	
	public void lendBook(Integer id, String p){
		// the tick value will change, if there is a book with this id
		int tick = 0;
		for (Book book : books) {
			if (book.getId() == id){
				if (book.getBorrowedBy() == null){
					book.setBorrowedBy(p);
					System.out.println(book.getBorrowedBy() + " has borrowed the book with id" + id);
					tick = 1;
				}
				else {
					tick = 1;
					System.out.println("Sorry, the book is already lent to " 
				+ book.getBorrowedBy());
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
	private void printBookList(ArrayList<Book> list){
		for (Book book: list){
			System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
			", Year: " + book.getYear() + ", Availability: " + book.isAvailable());
		}
	}	

	public void printBookInformation(Integer id){
		ArrayList<Book> searchedBook = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getId() == id){
				searchedBook.add(book);
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		System.out.println("Info about a book with id " + id);
		printBookList(searchedBook);
	}

	public void printAllBooks(){
		ArrayList<Book> availableBooks = new ArrayList<Book>();
		ArrayList<Book> lentBooks = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getBorrowedBy() == null){
				availableBooks.add(book);
			}
			else{
				lentBooks.add(book);
			}
		}
		System.out.println((availableBooks.size() + " book(s) available:"));
		printBookList(availableBooks);

		System.out.println((lentBooks.size() + " book(s) lent:"));
		printBookList(lentBooks);
	}
	
	public void searchBooks(String title, String author, String year) {
		ArrayList<Book> matchingBooks = new ArrayList<Book>(this.books);
		ArrayList<Book> notMatchingBooks = new ArrayList<Book>();


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
			printBookList(matchingBooks);
		}
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
}
