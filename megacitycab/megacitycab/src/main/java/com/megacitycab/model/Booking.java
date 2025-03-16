/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.model;

/**
 *
 * @author Sumedh Adhikari
 */
public class Booking {
    
    private int bookingId;
    private int customerId;
    private String destination;
    private double distance;
    private double totalFare;

    /**
     * @return the bookingId
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return the totalFare
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     * @param totalFare the totalFare to set
     */
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
//
//    public int getbk_pickup_location() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public String getbk_dropoff_location() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double getbk_from_date() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double getbk_to_date() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public String passengers() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double cab_type() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double trip_type() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public String getpassengers() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double getcab_type() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public double gettrip_type() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    
    private String bk_pickup_location;
    private String bk_dropoff_location;
    private String bk_from_date;
    private String bk_to_date;
    private String passengers;
    private String cab_type;
    private String trip_type;

    public String getBk_pickup_location() {
        return bk_pickup_location;
    }

    public void setBk_pickup_location(String bk_pickup_location) {
        this.bk_pickup_location = bk_pickup_location;
    }

    public String getBk_dropoff_location() {
        return bk_dropoff_location;
    }

    public void setBk_dropoff_location(String bk_dropoff_location) {
        this.bk_dropoff_location = bk_dropoff_location;
    }

    public String getBk_from_date() {
        return bk_from_date;
    }

    public void setBk_from_date(String bk_from_date) {
        this.bk_from_date = bk_from_date;
    }

    public String getBk_to_date() {
        return bk_to_date;
    }

    public void setBk_to_date(String bk_to_date) {
        this.bk_to_date = bk_to_date;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCab_type() {
        return cab_type;
    }

    public void setCab_type(String cab_type) {
        this.cab_type = cab_type;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setTrip_type(String trip_type) {
        this.trip_type = trip_type;
    }

    
    
    
}
