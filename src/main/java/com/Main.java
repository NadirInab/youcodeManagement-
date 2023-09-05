package main.java.com;



import main.java.com.Author.AuthorController;
import main.java.com.Book.Book;
import main.java.com.Book.BookController;
import main.java.com.User.User;

public class Main {

    public static void main(String[] args) {
        Book book = new Book() ;
        BookController bookController = new BookController() ;
        bookController.save(book);
    }
}
