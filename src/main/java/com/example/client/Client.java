package com.example.client;

import com.example.mylibrary.BookPrinter;
import com.example.mylibrary.IdGenerator;
import com.example.mylibrary.Library;

/**
 * Created by a591566 on 2017-02-10.
 */
public class Client {
    public static void main(String[] args) {
        // we'll show how the program works
        // creating a library
        Library library = new Library(new IdGenerator());
        BookPrinter bookPrinter = new BookPrinter();
        // adding a few books
        library.addBook("Lalka", "Boleslaw Prus", 1890);
        library.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
        library.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
        // showing how it looks
        bookPrinter.printAllBooks(library.getBooks());
        library.addBook("Morfina", "Szczepan Twardoch", 2015);
        library.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
        library.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
        // and now
        bookPrinter.printAllBooks(library.getBooks());
        library.lendBook(3, "Pawel");
        // now it will not lend it
        library.lendBook(3, "Tomek");
        // info about the book
        bookPrinter.printBook(library.getBook(3));
        // info has changed
        bookPrinter.printAllBooks(library.getBooks());
        // removing a book
        library.removeBook(4);
        bookPrinter.printAllBooks(library.getBooks());
        // all the books by Adam Mickiewicz
        System.out.println("Books that meet the criteria:");
        bookPrinter.printBooks(library.searchBooks("*", "Adam Mickiewicz", "*"));
        library.addBook("Dziennik 1954", "Leopold Tyrmand", 1990);
        bookPrinter.printAllBooks(library.getBooks());

    }
}
