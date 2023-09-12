package main.java.com.Statistics;

import main.java.com.Book.BookService;
import main.java.com.DB.DatabaseConnection;
import main.java.com.User.UserService;

import java.sql.SQLException;

public class Statistics {

    BookService bookService ;

    UserService userService ;

    public Statistics() throws SQLException {
        this.bookService = new BookService() ;
        this.userService = new UserService() ;
    }

    public int getNumberOfUsers() throws SQLException {
        return this.userService.getNumberOfUsers() ;
    }
    public int getNumberOfBooks() throws SQLException {
        return this.bookService.getNumberOfBooks() ;
    }
}
