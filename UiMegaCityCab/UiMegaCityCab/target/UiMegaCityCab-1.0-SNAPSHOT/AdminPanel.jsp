<%-- 
    Document   : AdminPanel.jsp
    Created on : Mar 14, 2025, 12:42:06 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Mega City Cab</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    height: 100vh;
    display: flex;
    background-image: url('img/red\ 2.png'); /* Replace with your actual image path */
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}

/* Sidebar */
.sidebar {
    width: 250px;
    background: #d32f2f; /* Slight transparency */
    color: white;
    padding: 20px;
}

.sidebar h2 {
    text-align: center;
    margin-bottom: 20px;
}

.sidebar ul {
    list-style: none;
}

.sidebar ul li {
    padding: 10px;
    margin: 10px 0;
    background: #444;
    cursor: pointer;
    text-align: center;
    border-radius: 5px;
}

.sidebar ul li:hover {
    background: #555;
}

/* Content Area */
.content {
    flex-grow: 1;
    padding: 20px;
    background: rgba(255, 255, 255, 0.8); /* Light transparency for better readability */
    border-radius: 10px;
    margin: 20px;
}

.content h2 {
    margin-bottom: 20px;
}

    </style>
    </head>
    <body>
        <div class="sidebar">
        <h2>Admin Panel</h2>
        <ul>
            <li onclick="showSection('customers')">Manage Customers</li>
            <li onclick="showSection('bookings')">Manage Bookings</li>
            <li onclick="showSection('vehicle.jsp')">Manage Vehicles</li>
            <li onclick="showSection('drivers')">Manage Drivers</li>
            <li onclick="showSection('payments')">Manage Payments</li>
        </ul>
    </div>
    <div class="content">
        <h2 id="section-title">Dashboard</h2>
        <div id="section-content">Welcome to the Mega City Cab Admin Panel. Select an option from the menu.</div>
    </div>

    <script>
        function showSection(section) {
            document.getElementById('section-title').innerText = section.replace(/_/g, ' ');
            document.getElementById('section-content').innerText = "Manage " + section.replace(/_/g, ' ');
        }
    </script>
    </body>
</html>
