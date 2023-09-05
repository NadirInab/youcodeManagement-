package main.java.com.Book;

import main.java.com.Author.Author;
import java.time.LocalDate;
import java.util.Scanner;


public class Book {
    private int isbn ;
    private String title ;
    private LocalDate publicationDate ;
    private String status ;
    private Author author ;

    public Book(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a ISBN: ");
        int isbn = reader.nextInt();
        reader.nextLine() ;
        System.out.println("Enter a title: ");
        String title = reader.nextLine();
        System.out.println("Enter a status: ");
        String status = reader.nextLine();
        System.out.println("Enter a author: ");
        reader.nextLine() ;
        int author = reader.nextInt();
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getStatus() {
        return status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}