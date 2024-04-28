package org.example.service;

import org.example.libraryEntity.book;

import java.time.LocalDate;

public class bookService implements Service {

    public static final int MAX_CAPACITY = 100;
    private book[] books = new book[MAX_CAPACITY];

    private int count;

    public bookService() {
        this.count=0;
    }

    @Override
    public void add(String title, String author, String publicationYear) {
        books[count] = new book(title, author, publicationYear);
        count = count+1;

    }

    @Override
    public void update(int id ,String title, String author, String publicationYear) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else books[id] = new book(title, author, publicationYear);

    }

    @Override
    public void delete(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else books[id]= null;
    }

    @Override
    public void displayAll(){
        System.out.println("Displaying all books");
        for (int i = 0; i < count ; i++) {
            if(books[i] == null) continue;
            System.out.println(books[i]);
        }
    }

    @Override
    public void displayById(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else System.out.println(books[id].toString());
    }

    @Override
    public String availability(int id) {
        return (books[id] != null )? "available":"not available";
    }

}
