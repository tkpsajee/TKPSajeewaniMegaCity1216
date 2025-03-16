<%-- 
    Document   : vehicle.jsp
    Created on : Mar 16, 2025, 2:15:00 PM
    Author     : NEW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle List - Mega City Cabs</title>
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
    background-image: url('img/vehicle-bg.jpg'); /* Replace with actual background image */
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}

/* Container */
.container {
    background: rgba(255, 255, 255, 0.9);
    padding: 20px;
    border-radius: 10px;
    text-align: center;
    width: 80%;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

h2 {
    margin-bottom: 15px;
    color: #d32f2f;
}

/* Buttons */
.buttons {
    margin-bottom: 15px;
}

.btn {
    padding: 10px 15px;
    margin: 5px;
    border: none;
    border-radius: 5px;
    font-size: 1em;
    cursor: pointer;
    color: white;
}

.add {
    background: #388e3c; /* Green */
}

.update {
    background: #0288d1; /* Blue */
}

.status {
    background: #fbc02d; /* Yellow */
}

.delete {
    background: #d32f2f; /* Red */
}

.btn:hover {
    opacity: 0.8;
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

th, td {
    border: 2px solid rgb(200, 200, 200);
    padding: 10px;
    text-align: center;
}

th {
    background-color: #d32f2f;
    color: white;
}

/* Vehicle Status */
.available {
    color: green;
    font-weight: bold;
}

.unavailable {
    color: red;
    font-weight: bold;
}

    </style>

</head>
<body>

    <div class="container">
        <h2>Vehicle List</h2>

        <!-- Buttons -->
        <div class="buttons">
            <button class="btn add">Add Vehicle</button>
            <button class="btn update">Update Vehicle</button>
            <button class="btn status">Check Status</button>
            <button class="btn delete">Delete Vehicle</button>
        </div>

        <!-- Vehicle Table -->
        <table>
            <thead>
                <tr>
                    <th>Vehicle ID</th>
                    <th>Model</th>
                    <th>License Plate</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>V001</td>
                    <td>Toyota Prius</td>
                    <td>ABC-1234</td>
                    <td><span class="available">Available</span></td>
                    <td>
                        <button class="btn update">Update</button>
                        <button class="btn status">Check Status</button>
                        <button class="btn delete">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>V002</td>
                    <td>Honda City</td>
                    <td>XYZ-5678</td>
                    <td><span class="unavailable">On Trip</span></td>
                    <td>
                        <button class="btn update">Update</button>
                        <button class="btn status">Check Status</button>
                        <button class="btn delete">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>