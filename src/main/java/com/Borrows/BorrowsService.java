package main.java.com.Borrows;

import main.java.com.Book.BookService;
import main.java.com.DB.DatabaseConnection;
import main.java.com.User.User;
import main.java.com.User.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class BorrowsService {

    Connection connection;
    BookService bookService ;

    UserService userService ;

    public BorrowsService() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
        this.bookService = new BookService() ;
        this.userService = new UserService() ;
    }

    public void borrowBook(int bookIsbn) throws SQLException {
        Scanner scanner = new Scanner(System.in) ;
        if(this.connection != null){
            if(!this.bookService.findByIsbn(bookIsbn)){
                System.out.println("Fortunately book doesn't exist !!");
                return;
            }
            try{
                System.out.print("Enter Member Name : ");
                String userName = scanner.next() ;
                System.out.print("Enter User memberShip number : ");
                int membershipNumber = scanner.nextInt() ;
                User user = new User(userName, membershipNumber);
                this.userService.addUser(user);
                int userId = this.userService.getUser(userName).getId() ;
                int bookId = this.bookService.getBook(bookIsbn).getId() ;
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                Borrows borrows = new Borrows(userId, bookId,sqlDate) ;
                String query = "INSERT INTO borrows(borrowerId, bookId, borrowDate) VALUES(?,?,?)" ;
                PreparedStatement preparedStatement = connection.prepareStatement(query) ;
                preparedStatement.setInt(1, borrows.getBorrowerId());
                preparedStatement.setInt(2, borrows.getBookId());
                preparedStatement.setDate(3, sqlDate);
                int count = preparedStatement.executeUpdate();
                if (count != 0)
                    System.out.println("book borrowed successfully.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void index(){


    }

    public void upDate(){
        System.out.println("add service");
    }

    public void delete(){
        System.out.println("add service");
    }
}
