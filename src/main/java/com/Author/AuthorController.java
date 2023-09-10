package main.java.com.Author;


import main.java.com.DB.DatabaseConnection;
import main.java.com.Book.Book ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.java.com.Author.AuthorService ;

public class AuthorController {

    Connection connection ;

    AuthorService authorService = new AuthorService() ;
    public AuthorController() throws Exception{
        DatabaseConnection databaseConnection = new DatabaseConnection() ;
        this.connection = DatabaseConnection.getConnection() ;
    }

    public void add(Author author){
        this.authorService.addAuthor(author) ;
    }
}