package main.java.com.Book;

import main.java.com.DB.DatabaseConnection;
import java.sql.*;

public class BookService {

    Connection connection;

    public BookService() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean findByIsbn(int isbn) throws SQLException {
        if (this.connection != null) {
            String query = "SELECT * FROM book WHERE isbn = ?";
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, isbn);
            ResultSet data = pstm.executeQuery();

            if (!data.isBeforeFirst()) {
                return false;
            }
        }
        return true;
    }

    public void upDateBook(Book book, int isbn) {
        if (this.connection != null) {
            String query = "UPDATE `book` SET `title`=?, `authorId`=?, `status`=? WHERE `isbn`=? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setInt(2, book.getAuthor());
                preparedStatement.setString(3, book.getStatus());
                preparedStatement.setInt(4,isbn);

                int count = preparedStatement.executeUpdate();
                if (count != 0) {
                    System.out.println("Book Updated Successfully");
                } else {
                    System.out.println("Something went wrong");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int isbn){

    }
}