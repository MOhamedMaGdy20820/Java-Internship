package org.example.service;

import java.time.LocalDate;

public  interface Service {
      void add(String title, String author, String publicationYear);
      void update (int id ,String title, String author, String publicationYear);
      void delete  (int id);
      void displayAll();
      void displayById(int id);
      String availability(int id);

}
