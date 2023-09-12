package main.java.com.User;

import main.java.com.Book.Book;
import main.java.com.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    Connection connection ;
    UserService userService = new UserService() ;

    public UserController() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    public void index(){
        //this.userService.getUser();
    }

    public void add(User user){
        this.userService.addUser(user);
    }

    public void searchForUser(int memberShipNumber) throws SQLException {
        this.userService.findByMemberShipNumber(memberShipNumber);
    }


    public void upDate(User user, int isbn){
       // this.userService.upDateUser(user,isbn); ;
    }

    public void delete(int membershipNumber) throws SQLException {
        this.userService.delete(membershipNumber);
    }

}
