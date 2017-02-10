package com.example.mylibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.mylibrary.Library;

public class LibraryTest {

	void setup(Library l1){
		// adding few books to the library so we can test it
		l1.addBook("Lalka", "Boleslaw Prus", 1890);
		l1.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
		l1.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
		l1.addBook("Morfina", "Szczepan Twardoch", 2015);
		l1.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
		l1.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
	}
	
	@Test
	public void testLibrary() {
		Library l1 = new Library();
		// testing if the new Library has no books in it
		assertEquals(l1.books.size(),0);
	}


	@Test
	public void testAddBook() {
		Library l1 = new Library();
		setup(l1);
		assertEquals(6,l1.books.size());
		l1.addBook("Dziennik 1954", "Leopold Tyrmand", 1989);
		// after adding a book the size of the library should be bigger by one
		assertEquals(7,l1.books.size());
	}

	@Test
	public void testRemoveBook() {
		Library l1 = new Library();
		setup(l1);
		assertEquals(6,l1.books.size());
		l1.removeBook(l1.books.get(4).getId());
		// after removing a book the size of the library should be smaller by one
		assertEquals(5,l1.books.size());	
	}


}
