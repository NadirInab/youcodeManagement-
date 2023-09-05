package main.java.com.Author;

import main.java.com.DB.DatabaseConnection;
import main.java.com.Book.Book ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorController {

        public void save(Book book) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO books (title, author_id) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, book.getTitle());
                statement.setInt(2, book.getAuthor().getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }