package com.example.mylibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.mylibrary.Book;

public class BookTest {

	// testing the creator of the book
	@Test
	public void testBook() {
		Book book = new Book("Lalka", "Boles³aw Prus", 1890);
		assertEquals("Lalka", book.title);
		assertEquals("Boles³aw Prus", book.author);
		assertEquals(Integer.valueOf(1890), book.year);
		// newly created book should be available and not lent to anyone
		assertEquals(null, book.reader);
	}

}
