package main.java.com.Borrows;

import main.java.com.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class BorrowsController {

    Connection connection ;
    BorrowsService borrowsService = new BorrowsService();

    public BorrowsController() throws Exception{
        DatabaseConnection databaseConnection = new DatabaseConnection() ;
        this.connection = DatabaseConnection.getConnection() ;
    }

    public void index(){
        this.borrowsService.index();
    }
    public void addBorrow(int bookId) throws SQLException {
        this.borrowsService.borrowBook(bookId)  ;
    }

    public void delete(){
       this.borrowsService.delete() ;
    }

    public void upDate(){
        this.borrowsService.upDate();
    }
}
