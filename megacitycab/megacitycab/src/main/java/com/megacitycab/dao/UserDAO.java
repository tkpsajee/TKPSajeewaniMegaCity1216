package com.megacitycab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cab_service";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    static {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    public List<String> getAllUsernames() throws SQLException {
        List<String> usernames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT us_loginusername FROM users")) {

            while (resultSet.next()) {
                String username = resultSet.getString("us_loginusername");
                usernames.add(username);
            }
        }

        return usernames;
    }

    public boolean createUser(String us_loginusername, String us_Password, String us_Email,String us_fullname, String us_Contact_No, String  us_NIC, String us_Address) throws SQLException {
        String sql = "INSERT INTO users (us_loginusername, us_Password, us_Email, us_fullname,  us_Contact_No, us_NIC, us_Address ) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, us_loginusername);
            preparedStatement.setString(2, us_Password);
            preparedStatement.setString(3, us_Email);
            preparedStatement.setString(4, us_fullname);
            preparedStatement.setString(5, us_Contact_No);
            preparedStatement.setString(6,  us_NIC);
            preparedStatement.setString(7,  us_Address );
            

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public boolean updateUser(String username, String newPassword, String newEmail) throws SQLException {
        String sql = "UPDATE users SET us_Password = ?, us_Email = ? WHERE us_loginusername = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setString(3, username);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public boolean deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM users WHERE us_loginusername = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
    
      /**
     * Authenticates a user by checking if the username and password match a record in the database.
     *
     * @param username The username to authenticate.
     * @param password The password to authenticate.
     * @return true if authentication is successful, false otherwise.
     * @throws SQLException If a database error occurs.
     */
    public Map <String, String> authenticateUser(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE us_loginusername = ? AND us_Password = ?";
        Map<String, String> userDetails = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    userDetails.put("username",resultSet.getString("us_loginusername"));
                    userDetails.put("usertype",resultSet.getString("us_Usertype"));
                }
                return userDetails; // Returns true if a matching record is found
            }
        }
    }
}