package com.example.mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a591566 on 2017-02-16.
 */
public class BookPrinter {

    public void printBooks(List<Book> books){
        for (Book book: books){
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Year: " + book.getYear() + ", Availability: " + book.availability());
        }
    }

    public void printBook(Book book){
        List<Book> bookToPrint = new ArrayList<>();
        bookToPrint.add(book);
        printBooks(bookToPrint);
    }

    public void printAllBooks(List<Book> books){
        List<Book> availableBooks = new ArrayList<>();
        List<Book> lentBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getLentTo() == null){
                availableBooks.add(book);
            }
            else{
                lentBooks.add(book);
            }
        }
        System.out.println((availableBooks.size() + " book(s) available:"));
        printBooks(availableBooks);

        System.out.println((lentBooks.size() + " book(s) lent:"));
        printBooks(lentBooks);
    }
}
