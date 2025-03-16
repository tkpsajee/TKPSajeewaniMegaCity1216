<%-- 
    Document   : Logout.jsp
    Created on : Mar 14, 2025, 12:52:20 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Logout</title>
    <script>
        // Clear username from localStorage
        localStorage.removeItem('username');
       
        // Redirect to the login page
        window.location.href = 'Home.jsp';
    </script>
    </head>
    <body>
        <!-- Logging out... -->
    </body>
</html>
