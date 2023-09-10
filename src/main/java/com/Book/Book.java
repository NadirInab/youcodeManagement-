package main.java.com.Book;

import main.java.com.Author.Author;
import java.util.Date;
import java.util.Scanner;


public class Book {
    private int isbn ;
    private String title ;
    private String status ;

    private int authorId ;


    public Book(int isbn, String title, int authorId) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
    }

    public Book(){

    }

    public void setisbn(int isbn) {
        this.isbn = isbn;
    }
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }


    public String getStatus() {
        return status;
    }

    public int getAuthor() {
        return authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }
}