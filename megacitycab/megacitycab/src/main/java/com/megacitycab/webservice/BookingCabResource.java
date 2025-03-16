package com.megacitycab.webservice;

import com.megacitycab.dao.BookingCabDAO;
import com.megacitycab.model.BookingCab;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/bookingcb")
public class BookingCabResource {

    private final BookingCabDAO bookingCabDAO;

    public BookingCabResource() {
        this.bookingCabDAO = new BookingCabDAO();
    }

    // Create a new booking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBooking(BookingCabRequest bookingRequest) {
        try {
            BookingCab booking = new BookingCab();
            booking.setBkUsUserId(bookingRequest.getBkUsUserId());
            booking.setBkVId(bookingRequest.getBkVId());
            booking.setBkFromDate(bookingRequest.getBkFromDate());
            booking.setBkToDate(bookingRequest.getBkToDate());
            booking.setBkPickupLocation(bookingRequest.getBkPickupLocation());
            booking.setBkDropoffLocation(bookingRequest.getBkDropoffLocation());
            booking.setPassengers(bookingRequest.getPassengers());
            booking.setCabType(bookingRequest.getCabType());
            booking.setTripType(bookingRequest.getTripType());
            booking.setBkDriverUsUserID(bookingRequest.getBkDriverUsUserID());
            booking.setBkCreatedBy(bookingRequest.getBkCreatedBy());
            booking.setBkModifiedBy(bookingRequest.getBkModifiedBy());

            bookingCabDAO.addBooking(booking);
            return Response.status(Response.Status.CREATED)
                    .entity("Booking created successfully")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating booking: " + e.getMessage())
                    .build();
        }
    }

    // Retrieve all bookings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBookings() {
        try {
            List<BookingCab> bookings = bookingCabDAO.getAllBookings();
            return Response.ok(bookings).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving bookings: " + e.getMessage())
                    .build();
        }
    }

    // Retrieve a single booking by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingById(@PathParam("id") int bookingId) {
        try {
            BookingCab booking = bookingCabDAO.getBookingById(bookingId);
            if (booking != null) {
                return Response.ok(booking).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Booking not found")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving booking: " + e.getMessage())
                    .build();
        }
    }

    // Update a booking
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBooking(@PathParam("id") int bookingId, BookingCabRequest bookingRequest) {
        try {
            BookingCab booking = new BookingCab();
            booking.setBkUsUserId(bookingRequest.getBkUsUserId());
            booking.setBkVId(bookingRequest.getBkVId());
            booking.setBkFromDate(bookingRequest.getBkFromDate());
            booking.setBkToDate(bookingRequest.getBkToDate());
            booking.setBkPickupLocation(bookingRequest.getBkPickupLocation());
            booking.setBkDropoffLocation(bookingRequest.getBkDropoffLocation());
            booking.setPassengers(bookingRequest.getPassengers());
            booking.setCabType(bookingRequest.getCabType());
            booking.setTripType(bookingRequest.getTripType());
            booking.setBkDriverUsUserID(bookingRequest.getBkDriverUsUserID());
            booking.setBkModifiedBy(bookingRequest.getBkModifiedBy());

            bookingCabDAO.updateBooking(booking);
            return Response.ok("Booking updated successfully").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating booking: " + e.getMessage())
                    .build();
        }
    }

    // Delete a booking by ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBooking(@PathParam("id") int bookingId) {
        try {
            bookingCabDAO.deleteBooking(bookingId);
            return Response.ok("Booking deleted successfully").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting booking: " + e.getMessage())
                    .build();
        }
    }

    // Assign a driver to a booking
    @POST
    @Path("/{id}/assign-driver")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDriver(@PathParam("id") int bookingId, AssignDriverRequest assignDriverRequest) {
        try {
            String result = bookingCabDAO.assignDriver(assignDriverRequest.getDriverId(), bookingId);
            return Response.ok(result).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error assigning driver: " + e.getMessage())
                    .build();
        }
    }
}

// Request class for creating/updating a booking
class BookingCabRequest {
    private int bkUsUserId;
    private int bkVId;
    private String bkFromDate;
    private String bkToDate;
    private String bkPickupLocation;
    private String bkDropoffLocation;
    private int passengers;
    private String cabType;
    private String tripType;
    private int bkDriverUsUserID;
    private int bkCreatedBy;
    private int bkModifiedBy;

    // Getters and Setters
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

// Request class for assigning a driver
class AssignDriverRequest {
    private int driverId;

    // Getters and Setters
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}