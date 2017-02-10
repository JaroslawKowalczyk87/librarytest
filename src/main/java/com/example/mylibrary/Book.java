package com.example.mylibrary;

class Book {
	private Integer id;
	private String title;
	private String author;
	private Integer year;
	// person who has borrowed the book
	private String reader;



	Book(String title, String author, Integer year) {
		// id should be unique within the library
		this.id = Library.getNewID();
		this.title = title;
		this.author = author;
		this.year = year;
		// when book is created, it's not lent to anyone
		this.reader = null;
	}

	
	// giving the information, if the book is available or lent to somebody
	String isAvailable() {
		if (this.reader == null) {
			return "available";
		}
		else {
			return "lent to " + this.reader;
		}
	}

	Integer getId() {
		return id;
	}

	String getTitle() {
		return title;
	}

	String getAuthor() {
		return author;
	}

	Integer getYear() {
		return year;
	}

	String getReader() {
		return reader;
	}

	void setReader(String reader) {
		this.reader = reader;
	}
}
