package org.example.service;

import org.example.libraryEntity.magazine;

import java.time.LocalDate;

public class magazineService implements Service {

    public static final int MAX_CAPACITY = 100;
    private magazine[] magazines = new magazine[MAX_CAPACITY];

    private int count =0;

    @Override
    public void add(String title, String author, String publicationYear) {
        magazines[count] = new magazine(title, author, publicationYear);
        count = count+1;

    }

    @Override
    public void update(int id ,String title, String author, String publicationYear) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else magazines[id] = new magazine(title, author, publicationYear);

    }

    @Override
    public void delete(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else magazines[id]= null;
    }

    @Override
    public void displayAll(){
        System.out.println("Displaying all magazines");
        for (int i = 0; i < count ; i++) {
            if(magazines[i] == null) continue;
            System.out.println(magazines[i]);
        }
    }
    @Override
    public String  availability(int id) {
        return (magazines[id] != null )? "available":"not available";
    }

    @Override
    public void displayById(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else System.out.println(magazines[id].toString());
    }
}
