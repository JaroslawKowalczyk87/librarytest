package com.example.mylibrary;

public class Book {
	Integer id;
	String title;
	String author;	
	Integer year;
	// person who has borrowed the book
	String reader;
	
	public Book(String title, String author, Integer year) {
		// id should be unique within the library
		this.id = Library.getNewID();
		this.title = title;
		this.author = author;
		this.year = year;
		// when book is created, it's not lent to anyone
		this.reader = null;
	}

	
	// giving the information, if the book is available or lent to somebody
	public String isAvailable() {
		if (this.reader == null) {
			return "available";
		}
		else {
			return "lent to " + this.reader;
		}
	}

}
