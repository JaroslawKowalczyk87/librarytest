package com.example.client;

import com.example.mylibrary.BookPrinter;
import com.example.mylibrary.IdGenerator;
import com.example.mylibrary.Library;
import com.example.mylibrary.ApplicationException;

/**
 * Created by a591566 on 2017-02-10.
 */
public class Client {
    static Library library= new Library(new IdGenerator());
    static BookPrinter bookPrinter = new BookPrinter();


    public static void main(String[] args) {
        addBook("Lalka", "Boleslaw Prus", 1890);
        addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1900);
        addBook( "Nad Niemnem", "Eliza Orzeszkowa", 1895);

        bookPrinter.printAllBooks(library.getBooks());

        addBook("Morfina", "Szczepan Twardoch", 2015);
        addBook("Ballady i Romanse", "Adam Mickiewicz", 1822);
        addBook("Pan Tadeusz", "Adam Mickiewicz", 1830);

        bookPrinter.printAllBooks(library.getBooks());
        try{
            library.lendBook(3, "Pawel");
            System.out.println("Paweł has borrowed a book with id 3.");
        }
        catch (ApplicationException exception){
            System.out.println(exception.getMessage());
        }
        try{
            library.lendBook(3, "Tomek");
            System.out.println("Tomek has borrowed a book with id 3.");
        }
        catch (ApplicationException exception) {
            System.out.println(exception.getMessage());
        }
        try{
            library.lendBook(13, "Tomek");
            System.out.println("Tomek has borrowed a book with id 13.");
        }
        catch (ApplicationException exception) {
            System.out.println(exception.getMessage());
        }        
        // now it will not lend it
        // info about the book
        bookPrinter.printBook(library.getBook(3));
        // info has changed
        bookPrinter.printAllBooks(library.getBooks());
        // removing a book
        try{
            library.removeBook(14);
            System.out.println("You have removed a book with id 4");
        }
        catch(ApplicationException exception){
            System.out.println(exception.getMessage());
        }
        bookPrinter.printAllBooks(library.getBooks());
        // all the books by Adam Mickiewicz
        System.out.println("Books that meet the criteria:");
        bookPrinter.printBooks(library.searchBooks("*", "Adam Mickiewicz", "*"));
        addBook("Dziennik 1954", "Leopold Tyrmand", 1990);
        bookPrinter.printAllBooks(library.getBooks());



    }

    static private void addBook(String title, String author, Integer year){
        int id;
        id = library.addBook(title, author, year);
        System.out.println("You have added a book:");
        bookPrinter.printBook(library.getBook(id));
    }

}
