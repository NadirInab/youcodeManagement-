package main.java.com.Book;

import main.java.com.DB.DatabaseConnection;
import java.sql.*;

public class BookService {

    Connection connection;

    public BookService() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    public void getBooks(){
        if (this.connection != null) {
            String query = "SELECT * FROM book";
            System.out.println("Books Details : ");
            System.out.format("%s\t%s\t%s\t%s\t%s\n", "Id", "Title", "Author", "Isbn","Status");
            try {
                Statement stmt = connection.createStatement();
                ResultSet data = stmt.executeQuery(query);
                while (data.next()) {
                    System.out.format("%d\t%s\t%s\t%s\t%s\n\n\n\n",
                            data.getInt(1),
                            data.getString(2),
                            data.getString(3),
                            data.getString(4),
                            data.getString(5));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void addBook(Book book){
        String query = "INSERT INTO book(title,authorId,isbn,status) values(?,?,?,?)" ;
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, book.getTitle());
            pstm.setInt(2, book.getAuthor());
            pstm.setInt(3, book.getIsbn());
            pstm.setString(4, book.getStatus());

            int count = pstm.executeUpdate();
            if (count != 0)
                System.out.println("Book Inserted successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public void searchForBook(String title){

        if (connection != null) {
            String query = "select * from book where book.title LIKE ?";
            try {
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setString(1, "%"+title+"%");

                ResultSet result = pstm.executeQuery();
                if (!result.isBeforeFirst()) {
                    System.out.println("No book found with this word : " + title + "!");
                }else {
                    System.out.println("Result : ");
                    System.out.format("%s\t%s\t%s\t%s\t%s\n", "Id", "Title", "Status", "Author","Isbn");
                    while (result.next()){
                        System.out.format("%d\t%s\t\t%s\t%s\t%s\n\n\n\n",
                                result.getInt(1),
                                result.getString(2),
                                result.getString(3),
                                result.getString(4),
                                result.getString(5));

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
        String query = "DELETE FROM book WHERE `isbn`=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, isbn);

            int count = preparedStatement.executeUpdate();
            if (count != 0) {
                System.out.println("Book deleted Successfully");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}