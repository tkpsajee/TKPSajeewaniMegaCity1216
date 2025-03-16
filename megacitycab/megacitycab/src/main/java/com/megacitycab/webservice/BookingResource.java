package com.megacitycab.webservice;

import com.megacitycab.dao.BookingDAO;
import com.megacitycab.model.Booking;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/bookings")
public class BookingResource {

    private static final Logger LOGGER = Logger.getLogger(BookingResource.class.getName());
    private final BookingDAO bookingDAO = new BookingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBookings() {
        LOGGER.info("getAllBookings method called");

        try {
            List<Booking> bookings = bookingDAO.getAllBookings();
            LOGGER.log(Level.INFO, "Retrieved {0} bookings from the database", bookings.size());
            bookings.forEach(booking -> LOGGER.log(Level.FINE, "Booking: {0}", booking));

            return Response.ok(bookings).build();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving bookings from the database", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("An error occurred while retrieving bookings. Please try again later.")
                          .build();
        }
    }
    


//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createBooking(bookingRequest bookingRequest) {
//        try {
//            boolean isCreated = bookingDAO.createBooking(bookingRequest.getbk_pickup_location(), bookingRequest.getbk_dropoff_location(), bookingRequest.getbk_from_date(), bookingRequest.getbk_to_date(),bookingRequest.getpassengers(), bookingRequest.getcab_type(), bookingRequest.gettrip_type());
//            if (isCreated) {
//                return Response.status(Response.Status.CREATED)
//                        .entity("User created successfully")
//                        .build();
//            } else {
//                return Response.status(Response.Status.BAD_REQUEST)
//                        .entity("Failed to create user")
//                        .build();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error creating user: " + e.getMessage())
//                    .build();
//        }

 
    
    
    
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getABooking(@PathParam("id") int bookingId) {
        LOGGER.log(Level.INFO, "getABooking method called for booking ID: {0}", bookingId);

        try {
            Booking booking = bookingDAO.getABooking(bookingId);
            if (booking != null) {
                LOGGER.log(Level.INFO, "Retrieved booking: {0}", booking);
                return Response.ok(booking).build();
            } else {
                LOGGER.log(Level.WARNING, "Booking with ID {0} not found", bookingId);
                return Response.status(Response.Status.NOT_FOUND)
                              .entity("Booking not found.")
                              .build();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving booking from the database", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("An error occurred while retrieving the booking. Please try again later.")
                          .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBooking(@PathParam("id") int bookingId, Booking booking) {
        LOGGER.log(Level.INFO, "updateBooking method called for booking ID: {0}", bookingId);

        if (booking == null) {
            LOGGER.warning("Invalid booking data provided");
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity("Invalid booking data.")
                          .build();
        }

        try {
            booking.setBookingId(bookingId); // Ensure the booking ID matches the path parameter
            bookingDAO.updateBooking(booking);
            LOGGER.log(Level.INFO, "Updated booking: {0}", booking);
            return Response.ok(booking).build();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating booking in the database", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("An error occurred while updating the booking. Please try again later.")
                          .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBooking(@PathParam("id") int bookingId) {
        LOGGER.log(Level.INFO, "deleteBooking method called for booking ID: {0}", bookingId);

        try {
            bookingDAO.deleteBooking(bookingId);
            LOGGER.log(Level.INFO, "Deleted booking with ID: {0}", bookingId);
            return Response.ok().entity("Booking deleted successfully.").build();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting booking from the database", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("An error occurred while deleting the booking. Please try again later.")
                          .build();
        }
    }
    
   /* @PUT
@Path("/{id}/assigndriver")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateBooking(@PathParam("id") int bookingId, @QueryParam("assigndriver") int driverId) {
    LOGGER.log(Level.INFO, "updateBooking method called for booking ID: {0}", bookingId);
    String message = "";

    // Validate input parameters
    if (bookingId <= 0 || driverId <= 0) {
        LOGGER.warning("Invalid booking ID or driver ID provided");
        return Response.status(Response.Status.BAD_REQUEST)
                      .entity("Invalid booking ID or driver ID.")
                      .build();
    }

    try {
        // Call the DAO method to assign the driver
        message = bookingDAO.AssignDriver(driverId, bookingId);
        LOGGER.log(Level.INFO, "Updated Driver for Booking: {0}", driverId);
        return Response.ok(message).build();
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error updating booking in the database", e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                      .entity("An error occurred while updating the booking. Please try again later.")
                      .build();
    }
}*/
}