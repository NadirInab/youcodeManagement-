package main.java.com.Book;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


import main.java.com.DB.DatabaseConnection;

public class BookController {

    Connection connection ;
    BookService bookService = new BookService() ;

    public BookController() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    public void index(){
        this.bookService.getBooks();
    }

    public void add(Book book){
        this.bookService.addBook(book);
    }

    public void searchForBook(String title) throws SQLException {
        this.bookService.searchForBook(title);
    }


    public void upDate(Book book, int isbn){
        this.bookService.upDateBook(book,isbn); ;
    }

    public void delete(int isbn){
        this.bookService.delete(isbn);
    }


}
