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
        Library library = new Library(new IdGenerator(), new BookPrinter());
        // adding a few books
        library.addBook("Lalka", "Boleslaw Prus", 1890);
        library.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
        library.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
        // showing how it looks
        library.bookPrinter.printAllBooks(library);
        library.addBook("Morfina", "Szczepan Twardoch", 2015);
        library.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
        library.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
        // and now
        library.bookPrinter.printAllBooks(library);
        library.lendBook(3, "Pawel");
        // now it will not lend it
        library.lendBook(3, "Tomek");
        // info about the book
        library.bookPrinter.printBookInformation(library, 3);
        // info has changed
        library.bookPrinter.printAllBooks(library);
        // removing a book
        library.removeBook(4);
        library.bookPrinter.printAllBooks(library);
        // all the books by Adam Mickiewicz
        System.out.println("Books that meet the criteria:");
        library.bookPrinter.printBooks(library.searchBooks("*", "Adam Mickiewicz", "*"));
        library.addBook("Dziennik 1954", "Leopold Tyrmand", 1990);
        library.bookPrinter.printAllBooks(library);

    }
}
