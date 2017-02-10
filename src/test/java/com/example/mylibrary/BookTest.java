package com.example.mylibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.mylibrary.Book;

public class BookTest {

	// testing the creator of the book
	@Test
	public void testBook() {
		Book book = new Book("Lalka", "Boleslaw Prus", 1890);
		assertEquals("Lalka", book.getTitle());
		assertEquals("Boleslaw Prus", book.getAuthor());
		assertEquals(Integer.valueOf(1890), book.getYear());
		// newly created book should be available and not lent to anyone
		assertEquals(null, book.getReader());
	}

}
