package myLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

	public void setup(Library l1){
		// adding few books to the library so we can test it
		l1.addBook("Lalka", "Boles³aw Prus", 1890);
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
		assertEquals(l1.books.size(),6);
		l1.addBook("Dziennik 1954", "Leopold Tyrmand", 1989);
		// after adding a book the size of the library should be bigger by one
		assertEquals(l1.books.size(),7);
	}

	@Test
	public void testRemoveBook() {
		Library l1 = new Library();
		setup(l1);
		assertEquals(l1.books.size(),6);
		l1.removeBook(3);
		// after removing a book the size of the library should be smaller by one
		assertEquals(l1.books.size(),5);	
	}


}
