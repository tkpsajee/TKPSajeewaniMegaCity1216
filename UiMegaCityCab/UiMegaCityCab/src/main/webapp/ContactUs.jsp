<%-- 
    Document   : ContactUs.jsp
    Created on : Mar 16, 2025, 11:04:38 AM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Mega City Cabs</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-image: url('img/redred\ 2.png');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}

/* Contact Container */
.contact-container {
    background: rgba(255, 255, 255, 0.95);
    padding: 25px;
    border-radius: 10px;
    text-align: center;
    width: 350px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.contact-container h2 {
    margin-bottom: 15px;
    color: #d32f2f;
}

/* Contact Info */
.contact-info p {
    font-size: 1em;
    margin-bottom: 8px;
    color: #333;
}

/* Google Map */
.map-container {
    margin: 15px 0;
    border-radius: 8px;
    overflow: hidden;
}

/* Contact Form */
.contact-form {
    display: flex;
    flex-direction: column;
}

.contact-form input,
.contact-form textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.contact-form button {
    background: #d32f2f;
    color: white;
    padding: 10px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    font-size: 1.1em;
}

.contact-form button:hover {
    background: #b71c1c;
}

    </style>
</head>
<body>

    <div class="contact-container">
        <h2>Contact Us</h2>
        
        <div class="contact-info">
            <p><strong>📍 Address:</strong> 123 Main Street, Kandy, Sri Lanka</p>
            <p><strong>📞 Phone:</strong> +94 76 123 4567</p>
            <p><strong>📧 Email:</strong> support@megacitycabs.lk</p>
        </div>

        <!-- Google Map (Replace with actual location) -->
        <div class="map-container">
            <iframe 
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3958.822789993196!2d80.63657327470841!3d7.156948292852675!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae37b8c8d91b99b%3A0x5a19e14f0d41b45c!2sKandy%2C%20Sri%20Lanka!5e0!3m2!1sen!2sus!4v1709458762198!5m2!1sen!2sus" 
                width="100%" 
                height="250" 
                style="border:0;" 
                allowfullscreen="" 
                loading="lazy">
            </iframe>
        </div>

        <!-- Contact Form -->
        <form class="contact-form">
            <input type="text" placeholder="Your Name" required>
            <input type="email" placeholder="Your Email" required>
            <textarea placeholder="Your Message" rows="5" required></textarea>
            <button type="submit">Send Message</button>
        </form>
    </div>

</body>
</html>
