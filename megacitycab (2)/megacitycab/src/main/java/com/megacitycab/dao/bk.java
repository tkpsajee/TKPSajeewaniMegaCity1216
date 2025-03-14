/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.dao;

/**
 *
 * @author Sumedh Adhikari
 */
public class bk {
    
}


/*
package com.megacitycab.dao;

import com.megacitycab.model.Booking;
import com.megacitycab.model.Customer;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;



public class BookingDAO {
    //String DB_URL = "jdbc:mysql://localhost:3306/megacitycab?deregisterDriversOnClose=true";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/megacitycab?deregisterDriversOnClose=true";

//"jdbc:mysql://localhost:3306/megacitycab";
    
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Change to your MySQL password
    
      static {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register the driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }
    
    
    public void addBooking(Customer customer, Booking booking) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Insert customer
            String customerQuery = "INSERT INTO customers (name, address, nic, phone) VALUES (?, ?, ?, ?)";
            try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS)) {
                customerStatement.setString(1, customer.getName());
                customerStatement.setString(2, customer.getAddress());
                customerStatement.setString(3, customer.getNic());
                customerStatement.setString(4, customer.getPhone());
                customerStatement.executeUpdate();

                // Get the generated customer ID
                ResultSet generatedKeys = customerStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    booking.setCustomerId(generatedKeys.getInt(1));
                }
            }

            // Insert booking
            String bookingQuery = "INSERT INTO bookings (customer_id, destination, distance, total_fare) VALUES (?, ?, ?, ?)";
            try (PreparedStatement bookingStatement = connection.prepareStatement(bookingQuery)) {
                bookingStatement.setInt(1, booking.getCustomerId());
                bookingStatement.setString(2, booking.getDestination());
                bookingStatement.setDouble(3, booking.getDistance());
                bookingStatement.setDouble(4, booking.getTotalFare());
                bookingStatement.executeUpdate();
            }
        }
    }
    
    
    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM bookings";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Booking booking = new Booking();
                    booking.setBookingId(resultSet.getInt("booking_id"));
                    booking.setCustomerId(resultSet.getInt("customer_id"));
                    booking.setDestination(resultSet.getString("destination"));
                    booking.setDistance(resultSet.getDouble("distance"));
                    booking.setTotalFare(resultSet.getDouble("total_fare"));
                    bookings.add(booking);
                }
            }
        }
        return bookings;
    }
    
    
    
    
}
*/
