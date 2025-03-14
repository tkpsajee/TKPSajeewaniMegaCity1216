/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.megacitycab.controller;

import com.megacitycab.dao.BookingDAO;
import com.megacitycab.model.Booking;
import com.megacitycab.model.Customer;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author Sumedh Adhikari
 */
@WebServlet(name = "BookingServlet", urlPatterns = {"/Booking"})
public class BookingServlet extends HttpServlet {
    
      private BookingDAO bookingDAO;

    @Override
    public void init() throws ServletException {
      bookingDAO = new BookingDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action"); 
        if ("add".equals(action)) {
        addBooking(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("bookings", bookingDAO.getAllBookings());
            req.getRequestDispatcher("/WEB-INF/views/bookings.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving bookings", e);
        }  
    }
    
    private void addBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setNic(request.getParameter("nic"));
        customer.setPhone(request.getParameter("phone"));

        Booking booking = new Booking();
        booking.setDestination(request.getParameter("destination"));
        booking.setDistance(Double.parseDouble(request.getParameter("distance")));
        booking.setTotalFare(booking.getDistance() * 50 * 1.10); // Rs. 50 per km + 10% tax

        try {
            bookingDAO.addBooking(customer, booking);
            response.sendRedirect("Booking");
        } catch (SQLException e) {
            throw new ServletException("Error adding booking", e);
        }
    }
    
    
    
    

   

}
