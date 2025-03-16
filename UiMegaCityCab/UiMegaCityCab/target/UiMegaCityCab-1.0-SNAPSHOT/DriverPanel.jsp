<%-- 
    Document   : DriverPanel.jsp
    Created on : Mar 14, 2025, 12:45:45 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Driver Panel - Mega City Cab</title>
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
        background-image: url('img/red\ 2.png'); /* Set your background image */
        background-size: cover;  
        background-position: center;  
        background-repeat: no-repeat;  
    }
    
    /* Sidebar */
    .sidebar {  
        width: 250px;  
        background: rgba(51, 51, 51, 0.9); /* Slight transparency */
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
        <h2>Driver Panel</h2>
        <ul>
            
            
            <li onclick="showSection('Trips')">View Trips</li>
            <li onclick="showSection('payments')">view my Payments</li>
        </ul>
    </div>
    <div class="content">
        <h2 id="section-title">Dashboard</h2>
        <div id="section-content">Welcome to the Mega City Cab Driver Panel. Select an option from the menu.</div>
    </div>

    <script>
        function showSection(section) {
            document.getElementById('section-title').innerText = section.replace(/_/g, ' ');
            document.getElementById('section-content').innerText = "Manage " + section.replace(/_/g, ' ');
        }
    </script>
    </body>
</html>
