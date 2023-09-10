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

    public void add(Book book){
        String query = "INSERT INTO book(title,authorId,isbn,status) values(?,?,?,?)";

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

    public void searchForBook(String title) throws SQLException {

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


    public void upDate(Book book, int isbn){
        this.bookService.upDateBook(book,isbn); ;
    }

    public void delete(int isbn){
        this.bookService(isbn) ;
    }


}
