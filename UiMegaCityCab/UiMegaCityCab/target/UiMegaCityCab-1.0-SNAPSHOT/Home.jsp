<%-- 
    Document   : Home.jsp
    Created on : Mar 14, 2025, 12:33:11 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mega City Cab - Home</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    background: url('img/red\ 2.png') no-repeat center center/cover;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: rgba(0, 0, 0, 0.7);
    padding: 15px 20px;
    color: white;
}

.logo {
    font-size: 24px;
    font-weight: bold;
}

.nav-links {
    list-style: none;
    display: flex;
    gap: 15px;
}

.nav-links li a {
    color: white;
    text-decoration: none;
    font-size: 16px;
    transition: 0.3s;
}

.nav-links li a:hover {
    color: yellow;
}

.hero {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    text-align: center;
    color: white;
    height: 70vh;
}

.hero h2 {
    font-size: 48px;
    margin-bottom: 10px;
}

.hero p {
    font-size: 18px;
    margin-bottom: 20px;
}

.btn {
    padding: 12px 24px;
    background: yellow;
    color: black;
    text-decoration: none;
    font-weight: bold;
    border-radius: 5px;
    transition: 0.3s;
}

.btn:hover {
    background: orange;
}

.footer {
    background: rgba(0, 0, 0, 0.7);
    color: white;
    text-align: center;
    padding: 10px 0;
}

    </style>
</head>
<body>
    <nav class="navbar">
        <h1 class="logo">Mega City Cab</h1>
        <ul class="nav-links">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="booking.jsp">Bookings</a></li>
            <li><a href="ContactUs.jsp">Contact Us</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="Login.jsp">Login</a></li>
        </ul>
    </nav>
    
    <div class="hero">
        <div class="hero-content">
            <h2>Welcome to Mega City Cab</h2>
            <p>Fast, reliable, and affordable taxi service in Country.</p>
            <a href="booking.jsp" class="btn">Book a Ride</a>
        </div>
    </div>
    
    <footer class="footer">
        <p>&copy; 2025 Mega City Cab. All Rights Reserved.</p>
    </footer>
</body>
</html>
