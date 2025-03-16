/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.model;

/**
 *
 * @author Sumedh Adhikari
 */
public class BookingCab {

    private int bkUsUserId; // bk_us_user_id
    private int bkVId; // bk_v_id
    private String bkFromDate; // bk_from_date
    private String bkToDate; // bk_to_date
    private String bkPickupLocation; // bk_pickup_location
    private String bkDropoffLocation; // bk_dropoff_location
    private int passengers; // passengers
    private String cabType; // cab_type
    private String tripType; // trip_type
    private int bkDriverUsUserID; // bk_driver_us_UserID
    private int bkCreatedBy; // bk_created_by
    private int bkModifiedBy; // bk_modified_by

    // Getters and Setters for each field

    public int getBkUsUserId() {
        return bkUsUserId;
    }

    public void setBkUsUserId(int bkUsUserId) {
        this.bkUsUserId = bkUsUserId;
    }

    public int getBkVId() {
        return bkVId;
    }

    public void setBkVId(int bkVId) {
        this.bkVId = bkVId;
    }

    public String getBkFromDate() {
        return bkFromDate;
    }

    public void setBkFromDate(String bkFromDate) {
        this.bkFromDate = bkFromDate;
    }

    public String getBkToDate() {
        return bkToDate;
    }

    public void setBkToDate(String bkToDate) {
        this.bkToDate = bkToDate;
    }

    public String getBkPickupLocation() {
        return bkPickupLocation;
    }

    public void setBkPickupLocation(String bkPickupLocation) {
        this.bkPickupLocation = bkPickupLocation;
    }

    public String getBkDropoffLocation() {
        return bkDropoffLocation;
    }

    public void setBkDropoffLocation(String bkDropoffLocation) {
        this.bkDropoffLocation = bkDropoffLocation;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public int getBkDriverUsUserID() {
        return bkDriverUsUserID;
    }

    public void setBkDriverUsUserID(int bkDriverUsUserID) {
        this.bkDriverUsUserID = bkDriverUsUserID;
    }

    public int getBkCreatedBy() {
        return bkCreatedBy;
    }

    public void setBkCreatedBy(int bkCreatedBy) {
        this.bkCreatedBy = bkCreatedBy;
    }

    public int getBkModifiedBy() {
        return bkModifiedBy;
    }

    public void setBkModifiedBy(int bkModifiedBy) {
        this.bkModifiedBy = bkModifiedBy;
    }
}