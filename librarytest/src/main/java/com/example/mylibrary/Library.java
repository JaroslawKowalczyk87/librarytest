package com.example.mylibrary;

import java.util.ArrayList;

public class Library {

	// "books" field is the list of all the books in our library
	public ArrayList<Book> books;
	static int idCounter = 0;
	
	public Library() {
		// creating an empty library, with no books
		books = new ArrayList<Book>();
	}
	
	// incrementing counter and giving the incremented value as an ID
	public static Integer getNewID() {
		idCounter++;
		return idCounter;
	}
	
	// adding a book to the books list
	public void addBook(String title, String author, Integer year) {
		Book b1 = new Book(title, author, year);
		books.add(b1);
		System.out.println("You have added a book: " + title + " by " + author);
	}
	
	// removing a book given its id
	public void removeBook(Integer id){
		// I cannot remove the elements of the list I'm iterating through
		// so I'm creating a list of the elements to remove
		ArrayList<Book> books2 = new ArrayList<Book>();
		for (Book book : books) {
			if (book.id == id){
				books2.add(book);
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		books.removeAll(books2);
		System.out.println("You have removed a book with id" + id);
	}
	
	public void lendBook(Integer id, String p){
		// the tick value will change, if there is a book with this id
		int tick = 0;
		for (Book book : books) {
			if (book.id == id){
				if (book.reader == null){
					book.reader = p;
					System.out.println(book.reader + " has borrowed the book with id" + id);
					tick = 1;
				}
				// if the book is already lent to someone, the message is shown
				else {
					tick = 1;
					System.out.println("Sorry, the book is already lent to " 
				+ book.reader);
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
	public void printBookList(ArrayList<Book> list){
		for (Book book: list){
			System.out.println("Title: " + book.title + ", Author: " + book.author +
			", Year: " + book.year + ", Availability: " + book.isAvailable());
		}
	}	
	
	// function that displays the details of a book given its id
	public void printInformation (Integer id){
		ArrayList<Book> books2 = new ArrayList<Book>();
		for (Book book : books) {
			if (book.id == id){
				books2.add(book);
				// ID is distinct, so we can break the loop,
				// because the list will always have no more than one element
				break;
			}
		}
		System.out.println("Info about a book with id " + id);
		printBookList(books2);
	}
	
	// function that displays the details of all the books in the library
	public void printAllBooks (){
		// we'll have two lists: available books and the books that are lent
		ArrayList<Book> booksaval = new ArrayList<Book>();
		ArrayList<Book> bookslent = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.reader == null){
				booksaval.add(book);
			}
			else{
				bookslent.add(book);
			}
		}
		// printing out the available books
		System.out.println((booksaval.size() + " book(s) available:"));
		printBookList(booksaval);
		// Printing out the lent books
		System.out.println((bookslent.size() + " book(s) lent:"));
		printBookList(bookslent);
	}
	
	public void searchBooks (String title, String author, String year){
		ArrayList<Book> books2 = new ArrayList<Book>();
		// creating a list on which we'll gather all the books that fail to meet
		// at least one search criterium
		ArrayList<Book> bookstoremove = new ArrayList<Book>();
		//copying a list of all books from which we'll delete the books that
		//don't match the search criteria
		books2 = this.books;
		
		// a star is given as an argument, when the user doesn't want to search
		// using that field (e.g. is interested only in year, not in the author
		if (title != "*"){
			// we're searching thorugh the books to see, if there are any that
			// fail to meet the criteria
			for (Book book : books2) {
				if (book.title != title){
					bookstoremove.add(book);
				}
			}
			books2.removeAll(bookstoremove);
		}

		if (author != "*"){
			for (Book book : books2) {
				if (book.author != author){
					bookstoremove.add(book);			}
			}
			// I'm removing the books three times, because that saves us from
			// going through the whole list few times
			books2.removeAll(bookstoremove);
		}

		if (year != "*"){
			for (Book book : books2) {
				// I have to take the argument as a string, so the star can be used
				if (book.year != Integer.parseInt(year)){
					bookstoremove.add(book);			}
			}
			books2.removeAll(bookstoremove);
		}				
		// printing out the books that meet the search criteria
		// or displaying appropriate message, when no books where found
		if (books2.size()==0){
			System.out.println("No books that meet the criteria.");
		}
		else{
		System.out.println("Books that meet the criteria:");
		printBookList(books2);
		}
	}
	
public static void main(String[] args) {
	// we'll show how the program works
	// creating a library
	Library l1 = new Library();
	// adding a few books
	l1.addBook("Lalka", "Boleslaw Prus", 1890);
	l1.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
	l1.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
	// showing how it looks
	l1.printAllBooks();
	l1.addBook("Morfina", "Szczepan Twardoch", 2015);
	l1.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
	l1.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
	// and now
	l1.printAllBooks();
	l1.lendBook(3, "Pawe�");
	// now it will not lend it
	l1.lendBook(3, "Tomek");
	// info about the book
	l1.printInformation(3);
	// info has changed
	l1.printAllBooks();
	// removing a book
	l1.removeBook(4);
	l1.printAllBooks();
	// all the books by Adam Mickiewicz
	l1.searchBooks("*", "Adam Mickiewicz", "*");
	l1.addBook("Dziennik 1954", "Leopold Tyrmand", 1990);
	
}
	
}
