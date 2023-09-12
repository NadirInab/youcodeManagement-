package main.java.com.User;

import main.java.com.Book.Book;
import main.java.com.DB.DatabaseConnection;

import java.sql.*;

public class UserService {

    Connection connection;

    public UserService() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = DatabaseConnection.getConnection();
    }

    public User getUser(String name) throws SQLException {
        if (this.connection != null) {
            String query = "SELECT * FROM user WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query) ;
            preparedStatement.setString(1, name);
            ResultSet data = preparedStatement.executeQuery();
            if(!data.isBeforeFirst()){
                System.out.println("User doesn't exist !!");
            }
            User user = null;
            if (data.next()) {
                String userName = data.getString("name");
                int membershipNumber = data.getInt("membershipNumber");
                user = new User(userName, membershipNumber);
                user.setId(data.getInt("id"));
            }
            return user;
        }
        return  null ;
    }

    public void addUser(User user) {
        String query = "INSERT INTO user(name,membershipNumber) values(?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, user.getName());
            pstm.setInt(2, user.getMemberShipNumber());
            int count = pstm.executeUpdate();
            if (count != 0)
                System.out.println("user Inserted successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void findByMemberShipNumber(int memberShipNumber) throws SQLException {
        if (this.connection != null) {
            String query = "SELECT * FROM user WHERE membershipNumber = ?";
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, memberShipNumber);
            ResultSet data = pstm.executeQuery();
            while (data.next()) {
                System.out.format("%d\t%s\t%d\t\n\n\n\n",
                        data.getInt(1),
                        data.getString(2),
                        data.getInt(3));
            }
        }
    }

    public void delete(int memberShipNumber) throws SQLException {
        if(this.connection != null){
            String query = "DELETE FROM user WHERE membershipNumber = ?" ;
            PreparedStatement pstm = connection.prepareStatement(query) ;
            pstm.setInt(1, memberShipNumber);

            int count = pstm.executeUpdate();
            if(count != 0){
                System.out.println("user deleted successfully !!");
            }else{
                System.out.println("Error !!");
            }
        }
    }

    public int getNumberOfUsers() throws SQLException {
        if(this.connection != null){
            String query = "SELECT COUNT(*) FROM user LIMIT 1" ;
            PreparedStatement preparedStatement = connection.prepareStatement(query) ;
            ResultSet data = preparedStatement.executeQuery() ;
            if(data.next()) {
                int count = data.getInt(1);
                return count;
            }
        }
        return -1 ;
    }
}
