package com.example.mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a591566 on 2017-02-16.
 */
public class BookPrinter {

    // this function can print out the details of books on any book list
    // we'll use it in few further functions
    public void printBooks(List<Book> books){
        for (Book book: books){
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Year: " + book.getYear() + ", Availability: " + book.availability());
        }
    }

    // printing info about one book
    private void printBooks(Book book){
        List<Book> booksToPrint = new ArrayList<>();
        booksToPrint.add(book);
        printBooks(booksToPrint);
    }

    public void printBookInformation(Library library, Integer id){
        Book bookToPrint = null;
        for (Book book : library.books) {
            if (book.getId().equals(id)){
                bookToPrint = book;
                // ID is distinct, so we can break the loop,
                // because the list will always have no more than one element
                break;
            }
        }
        System.out.println("Info about a book with id " + id);
        printBooks(bookToPrint);
    }

    public void printAllBooks(Library library){
        List<Book> availableBooks = new ArrayList<>();
        List<Book> lentBooks = new ArrayList<>();
        for (Book book : library.books) {
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
