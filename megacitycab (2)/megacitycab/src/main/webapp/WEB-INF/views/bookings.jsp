<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bookings</title>
</head>
<body>
    <h1>Bookings</h1>
    <table border="1">
        <tr>
            <th>Booking ID</th>
            <th>Customer ID</th>
            <th>Destination</th>
            <th>Distance (km)</th>
            <th>Total Fare (Rs.)</th>
        </tr>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.bookingId}</td>
                <td>${booking.customerId}</td>
                <td>${booking.destination}</td>
                <td>${booking.distance}</td>
                <td>${booking.totalFare}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add New Booking</h2>
    <form action="Booking" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name" required><br>
        Address: <input type="text" name="address" required><br>
        NIC: <input type="text" name="nic" required><br>
        Phone: <input type="text" name="phone" required><br>
        Destination: <input type="text" name="destination" required><br>
        Distance (km): <input type="number" step="0.1" name="distance" required><br>
        <input type="submit" value="Add Booking">
    </form>
</body>
</html>