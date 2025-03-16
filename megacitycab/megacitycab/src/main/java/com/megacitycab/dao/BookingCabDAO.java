/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.dao;

import com.megacitycab.model.BookingCab;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sumedh Adhikari
 */
public class BookingCabDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cab_service?deregisterDriversOnClose=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Change to your MySQL password

    static {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    // Add a new booking
    public void addBooking(BookingCab booking) throws SQLException {
        String query = "INSERT INTO tblbooking (bk_us_user_id, bk_v_id, bk_from_date, bk_to_date, bk_pickup_location, bk_dropoff_location, passengers, cab_type, trip_type, bk_driver_us_UserID, bk_created_by, bk_modified_by) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, booking.getBkUsUserId());
            statement.setInt(2, booking.getBkVId());
            statement.setString(3, booking.getBkFromDate());
            statement.setString(4, booking.getBkToDate());
            statement.setString(5, booking.getBkPickupLocation());
            statement.setString(6, booking.getBkDropoffLocation());
            statement.setInt(7, booking.getPassengers());
            statement.setString(8, booking.getCabType());
            statement.setString(9, booking.getTripType());
            statement.setInt(10, booking.getBkDriverUsUserID());
            statement.setInt(11, booking.getBkCreatedBy());
            statement.setInt(12, booking.getBkModifiedBy());

            statement.executeUpdate();
            System.out.println("Booking added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Retrieve all bookings
    public List<BookingCab> getAllBookings() throws SQLException {
        List<BookingCab> bookings = new ArrayList<>();
        String query = "SELECT * FROM tblbooking";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                BookingCab booking = new BookingCab();
                booking.setBkUsUserId(resultSet.getInt("bk_us_user_id"));
                booking.setBkVId(resultSet.getInt("bk_v_id"));
                booking.setBkFromDate(resultSet.getString("bk_from_date"));
                booking.setBkToDate(resultSet.getString("bk_to_date"));
                booking.setBkPickupLocation(resultSet.getString("bk_pickup_location"));
                booking.setBkDropoffLocation(resultSet.getString("bk_dropoff_location"));
                booking.setPassengers(resultSet.getInt("passengers"));
                booking.setCabType(resultSet.getString("cab_type"));
                booking.setTripType(resultSet.getString("trip_type"));
                booking.setBkDriverUsUserID(resultSet.getInt("bk_driver_us_UserID"));
                booking.setBkCreatedBy(resultSet.getInt("bk_created_by"));
                booking.setBkModifiedBy(resultSet.getInt("bk_modified_by"));

                bookings.add(booking);
            }
        }
        return bookings;
    }

    // Retrieve a single booking by ID
    public BookingCab getBookingById(int bookingId) throws SQLException {
        BookingCab booking = null;
        String query = "SELECT * FROM tblbooking WHERE bk_us_user_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, bookingId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    booking = new BookingCab();
                    booking.setBkUsUserId(resultSet.getInt("bk_us_user_id"));
                    booking.setBkVId(resultSet.getInt("bk_v_id"));
                    booking.setBkFromDate(resultSet.getString("bk_from_date"));
                    booking.setBkToDate(resultSet.getString("bk_to_date"));
                    booking.setBkPickupLocation(resultSet.getString("bk_pickup_location"));
                    booking.setBkDropoffLocation(resultSet.getString("bk_dropoff_location"));
                    booking.setPassengers(resultSet.getInt("passengers"));
                    booking.setCabType(resultSet.getString("cab_type"));
                    booking.setTripType(resultSet.getString("trip_type"));
                    booking.setBkDriverUsUserID(resultSet.getInt("bk_driver_us_UserID"));
                    booking.setBkCreatedBy(resultSet.getInt("bk_created_by"));
                    booking.setBkModifiedBy(resultSet.getInt("bk_modified_by"));
                }
            }
        }
        return booking;
    }

    // Update a booking
    public void updateBooking(BookingCab booking) throws SQLException {
        String query = "UPDATE tblbooking SET bk_v_id = ?, bk_from_date = ?, bk_to_date = ?, bk_pickup_location = ?, bk_dropoff_location = ?, passengers = ?, cab_type = ?, trip_type = ?, bk_driver_us_UserID = ?, bk_modified_by = ? WHERE bk_us_user_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, booking.getBkVId());
            statement.setString(2, booking.getBkFromDate());
            statement.setString(3, booking.getBkToDate());
            statement.setString(4, booking.getBkPickupLocation());
            statement.setString(5, booking.getBkDropoffLocation());
            statement.setInt(6, booking.getPassengers());
            statement.setString(7, booking.getCabType());
            statement.setString(8, booking.getTripType());
            statement.setInt(9, booking.getBkDriverUsUserID());
            statement.setInt(10, booking.getBkModifiedBy());
            statement.setInt(11, booking.getBkUsUserId());

            statement.executeUpdate();
            System.out.println("Booking updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Delete a booking by ID
    public void deleteBooking(int bookingId) throws SQLException {
        String query = "DELETE FROM tblbooking WHERE bk_us_user_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, bookingId);
            statement.executeUpdate();
            System.out.println("Booking deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Assign a driver to a booking
    public String assignDriver(int driverId, int bookingId) throws SQLException {
        String query = "UPDATE tblbooking SET bk_driver_us_UserID = ? WHERE bk_us_user_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, driverId);
            statement.setInt(2, bookingId);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return "Driver assigned successfully!";
            } else {
                return "No booking found with the provided ID.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}