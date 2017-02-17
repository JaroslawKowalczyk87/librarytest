package com.example.client;

import com.example.mylibrary.BookPrinter;
import com.example.mylibrary.IdGenerator;
import com.example.mylibrary.Library;
import jdk.nashorn.internal.ir.RuntimeNode;

/**
 * Created by a591566 on 2017-02-10.
 */
public class Client {
    public static void main(String[] args) {
        // we'll show how the program works
        // creating a library
        int id;
        Library library = new Library(new IdGenerator());
        BookPrinter bookPrinter = new BookPrinter();
        // adding a few books
        id = library.addBook("Lalka", "Boleslaw Prus", 1890);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        id = library.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        id = library.addBook("Nad Niemnem", "Eliza Orzeszkowa", 1895);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        bookPrinter.printAllBooks(library.getBooks());
        id = library.addBook("Morfina", "Szczepan Twardoch", 2015);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        id = library.addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        id = library.addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        // and now
        bookPrinter.printAllBooks(library.getBooks());
        try{
            library.lendBook(3, "Pawel");
            System.out.println("Paweł has borrowed a book with id 3.");
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
        // now it will not lend it
        try{
            library.lendBook(3, "Tomek");
            System.out.println("Tomek has borrowed a book with id 3.");
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
        try{
            library.lendBook(13, "Tomek");
            System.out.println("Tomek has borrowed a book with id 13.");
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
        // info about the book
        bookPrinter.printBook(library.getBook(3));
        // info has changed
        bookPrinter.printAllBooks(library.getBooks());
        // removing a book
        try{
            library.removeBook(14);
            System.out.println("You have removed a book with id 4");
        }
        catch(RuntimeException exception){
            System.out.println(exception.getMessage());
        }
        bookPrinter.printAllBooks(library.getBooks());
        // all the books by Adam Mickiewicz
        System.out.println("Books that meet the criteria:");
        bookPrinter.printBooks(library.searchBooks("*", "Adam Mickiewicz", "*"));
        id = library.addBook("Dziennik 1954", "Leopold Tyrmand", 1990);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
        bookPrinter.printAllBooks(library.getBooks());

    }
}
