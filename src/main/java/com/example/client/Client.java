package com.example.client;

import com.example.mylibrary.Library;

/**
 * Created by a591566 on 2017-02-10.
 */
public class Client {
    public static void main(String[] args) {
        // we'll show how the program works
        // creating a library
        Library l1 = new Library();
        // adding a few books
        l1.addBook("Lalka", "Boleslaw Prus", 1890);
        l1.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
        l1.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
        // showing how it looks
        l1.printAllBooks();
        l1.addBook("Morfina", "Szczepan Twardoch", 2015);
        l1.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
        l1.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
        // and now
        l1.printAllBooks();
        l1.lendBook(3, "Pawel");
        // now it will not lend it
        l1.lendBook(3, "Tomek");
        // info about the book
        l1.printInformation(3);
        // info has changed
        l1.printAllBooks();
        // removing a book
        l1.removeBook(4);
        l1.printAllBooks();
        // all the books by Adam Mickiewicz
        l1.searchBooks("*", "Adam Mickiewicz", "*");
        l1.addBook("Dziennik 1954", "Leopold Tyrmand", 1990);

    }
}
