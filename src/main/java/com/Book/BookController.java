package main.java.com.Book;

import main.java.com.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookController {

    public void save(Book book) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO books (title, publicationDate, status, authorId, borrowerId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
