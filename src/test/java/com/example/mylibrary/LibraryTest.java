package com.example.mylibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

	private void setup(Library library){
		// adding few books to the library so we can test it
		library.addBook("Lalka", "Boleslaw Prus", 1890);
		library.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
		library.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
		library.addBook("Morfina", "Szczepan Twardoch", 2015);
		library.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
		library.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
	}
	
	@Test
	public void testLibrary() {
		Library library = new Library(new IdGenerator(), new BookPrinter());
		// testing if the new Library has no books in it
		assertEquals(0,library.getBooks().size());
	}


	@Test
	public void testAddBook() {
		Library library = new Library(new IdGenerator(), new BookPrinter());
		setup(library);
		assertEquals(6, library.getBooks().size());
		library.addBook("Dziennik 1954", "Leopold Tyrmand", 1989);
		// after adding a book the size of the library should be bigger by one
		assertEquals(7, library.getBooks().size());
	}

	@Test
	public void testRemoveBook() {
		Library library = new Library(new IdGenerator(), new BookPrinter());
		setup(library);
		assertEquals(6, library.getBooks().size());
		library.removeBook(library.getBooks().get(4).getId());
		// after removing a book the size of the library should be smaller by one
		assertEquals(5, library.getBooks().size());
	}


}
