package com.example.mylibrary;

class Book {
	private Integer id;
	private String title;
	private String author;
	private Integer year;
	private String lentTo;



	Book(String title, String author, Integer year) {
		this.id = Library.getUniqueID();
		this.title = title;
		this.author = author;
		this.year = year;
		// when book is created, it's not lent to anyone
		this.lentTo = null;
	}

	String isAvailable() {
		if (this.lentTo == null) {
			return "available";
		}
		else {
			return "lent to " + this.lentTo;
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

	String getLentTo() {
		return lentTo;
	}

	void setLentTo(String reader) {
		this.lentTo = reader;
	}
}
