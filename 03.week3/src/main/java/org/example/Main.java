package org.example;

import org.example.service.*;

public class Main {
    public static void main(String[] args) {
        Service books = new bookService();
        Service DVDs = new  DVDService();
        Service Magazines = new magazineService();

        books.add("cook","MO","12/5/2009");
        books.add("cook","MO","12/5/2009");
        books.add("cook","MO","12/5/2009");
        books.displayAll();

        books.delete(1);
        System.out.println(books.availability(1));

        books.update(0,"action","Mg","12/8/2014");
        books.displayById(0);

        // dvd and Magazines the same thing

    }
}
