package com.example.mylibrary;

class Book {
	private Integer id;
	private String title;
	private String author;
	private Integer year;
	private String lendTo;



	Book(String title, String author, Integer year) {
		this.id = Library.getUniqueID();
		this.title = title;
		this.author = author;
		this.year = year;
		// when book is created, it's not lent to anyone
		this.lendTo = null;
	}

	String isAvailable() {
		if (this.lendTo == null) {
			return "available";
		}
		else {
			return "lent to " + this.lendTo;
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

	String getLendTo() {
		return lendTo;
	}

	void setLendTo(String reader) {
		this.lendTo = reader;
	}
}
