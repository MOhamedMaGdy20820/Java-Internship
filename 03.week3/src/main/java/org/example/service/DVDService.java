package org.example.service;

import org.example.libraryEntity.dvd;


public class DVDService implements Service {

    public static final int MAX_CAPACITY = 100;
    private dvd[] dvds = new dvd[MAX_CAPACITY];

    private int count =0;

    @Override
    public void add(String title, String author, String publicationYear) {
        dvds[count] = new dvd(title, author, publicationYear);
        count = count+1;

    }

    @Override
    public void update(int id ,String title, String author, String publicationYear) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else dvds[id] = new dvd(title, author, publicationYear);

    }

    @Override
    public void delete(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else dvds[id]= null;
    }

    @Override
    public void displayAll(){
        System.out.println("Displaying all dvds");
        for (int i = 0; i < count ; i++) {
            if(dvds[i] == null) continue;
            System.out.println(dvds[i]);

        }
    }

    @Override
    public String availability(int id) {
        return (dvds[id] != null)? "available":"not available";
    }

    @Override
    public void displayById(int id) {
        if (id > MAX_CAPACITY || id > count){
            System.out.println("Invalid index: "+ id);
        }
        else System.out.println(dvds[id].toString());
    }
}
