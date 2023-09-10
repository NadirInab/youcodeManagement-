package main.java.com.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.Author.Author;
import main.java.com.DB.DatabaseConnection;

public class AuthorService {
    private List<Author> authors;
    Connection connection;

    public AuthorService() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    // get list of all authors
    public List<Author> getAllAuthors() {
        if (this.connection != null) {
            String query = "SELECT * FROM author";
            System.out.println("Books Details : ");
            System.out.format("%s\t%s", "Id", "name");
            try {
                Statement stmt = connection.createStatement();
                ResultSet data = stmt.executeQuery(query);
                while (data.next()) {
                    System.out.format("%d\t%s\\n\n\n\n",
                            data.getInt(1),
                            data.getString(2)
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return authors;
    }

    // Method to get an author by ID
    public Author getAuthorById(int authorId) {
        if (this.connection != null) {
            String query = "SELECT * FROM author WHERE author.id = authorId";
            System.out.println("Books Details : ");
            System.out.format("%s\t%s", "Id", "name");
            try {
                Statement stmt = connection.createStatement();
                ResultSet data = stmt.executeQuery(query);
                while (data.next()) {
                    System.out.format("%d\t%s\\n\n\n\n",
                            data.getInt(1),
                            data.getString(2)
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    // add a new author
    public Author addAuthor(Author author) {
            String query = "INSERT INTO author(name) values(?)" ;
            try {
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setString(1, author.getName());
                int count = pstm.executeUpdate();
                if (count != 0)
                    System.out.println("author added successfully.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    // Method to update an existing author
    public Author updateAuthor(int authorId, Author updatedAuthor) {
        return null;
    }

    // delete author by ID
    public boolean deleteAuthor(int authorId) {
            String query = "DELETE FROM author WHERE id = authorId" ;
            try {
                PreparedStatement pstm = connection.prepareStatement(query);
                int count = pstm.executeUpdate();
                if (count != 0)
                    System.out.println("author added successfully.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
}
