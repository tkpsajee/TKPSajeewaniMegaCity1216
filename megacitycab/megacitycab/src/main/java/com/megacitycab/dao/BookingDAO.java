/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.dao;

import com.megacitycab.model.Booking;
import com.megacitycab.model.Customer;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Sumedh Adhikari
 */
public class BookingDAO {
    //String DB_URL = "jdbc:mysql://localhost:3306/megacitycab?deregisterDriversOnClose=true";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cab_service?deregisterDriversOnClose=true";

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
            String customerQuery = "INSERT INTO customers (name, address, nic, contact_no) VALUES (?, ?, ?, ?)";
            try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS)) {
                customerStatement.setString(1, customer.getName());
                customerStatement.setString(2, customer.getAddress());
                customerStatement.setString(3, customer.getNic());
                customerStatement.setString(4, customer.getContact_no());
                customerStatement.executeUpdate();

                // Get the generated customer ID
                ResultSet generatedKeys = customerStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    booking.setCustomerId(generatedKeys.getInt(1));
                }
            }

            // Insert booking
            String bookingQuery = "INSERT INTO tblbooking (bk_pickup_location, bk_dropoff_location, bk_from_date, bk_to_date,passengers,cab_type,trip_type) VALUES (?, ?, ?, ?,?,?,?)";
            try (PreparedStatement bookingStatement = connection.prepareStatement(bookingQuery)) {
                bookingStatement.setString(1, booking.getBk_pickup_location());
                bookingStatement.setString(2, booking.getBk_dropoff_location());
                bookingStatement.setString(3, booking.getBk_from_date());
                bookingStatement.setString(4, booking.getBk_to_date());
                bookingStatement.setString(5, booking.getPassengers());
                bookingStatement.setString(6, booking.getCab_type());
                bookingStatement.setString(7, booking.getTrip_type());
                bookingStatement.executeUpdate();
                
                bookingStatement.executeUpdate();
    System.out.println("Booking inserted successfully!");
} catch (SQLException e) {
    e.printStackTrace(); // Print error details

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

    // Get a single booking by booking ID
    public Booking getABooking(int bookingId) throws SQLException {
        Booking booking = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM bookings WHERE booking_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookingId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        booking = new Booking();
                        booking.setBookingId(resultSet.getInt("booking_id"));
                        booking.setCustomerId(resultSet.getInt("customer_id"));
                        booking.setDestination(resultSet.getString("destination"));
                        booking.setDistance(resultSet.getDouble("distance"));
                        booking.setTotalFare(resultSet.getDouble("total_fare"));
                    }
                }
            }
        }
        return booking;
    }

    // Update a booking
    public void updateBooking(Booking booking) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE bookings SET destination = ?, distance = ?, total_fare = ? WHERE booking_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, booking.getDestination());
                statement.setDouble(2, booking.getDistance());
                statement.setDouble(3, booking.getTotalFare());
                statement.setInt(4, booking.getBookingId());
                statement.executeUpdate();
            }
        }
    }

    // Delete a booking by booking ID
    public void deleteBooking(int bookingId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM bookings WHERE booking_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookingId);
                statement.executeUpdate();
            }
        }
    }
    /*public String AssignDriver(int Driver_id, int bookingId) throws SQLException {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String query = "UPDATE `bookings` SET `driver_id`=? WHERE `booking_id`=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Driver_id);
            statement.setInt(2, bookingId);
            int rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0) {
                return "Driver assigned successfully!";
            } else {
                return "No booking found with the provided ID.";
            }
        }
    }
}*/
}