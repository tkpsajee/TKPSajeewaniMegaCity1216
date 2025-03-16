<%-- 
    Document   : booking.jsp
    Created on : Mar 14, 2025, 12:49:34 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking - Mega City Cab</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background: url('img/red\ 2.png') no-repeat center center/cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .booking-container {
            background: rgba(0, 0, 0, 0.8);
            color: white;
            padding: 20px;
            border-radius: 8px;
            width: 500px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        label {
            display: block;
            text-align: left;
            margin-top: 10px;
            font-size: 14px;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: none;
            border-radius: 5px;
        }

        .btn {
            width: 100%;
            padding: 10px;
            margin-top: 15px;
            background: rgb(247, 118, 118);
            color: black;
            border: none;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }

        .btn:hover {
            background: rgb(53, 248, 228);
        }

        p {
            margin-top: 15px;
            font-size: 14px;
        }

        p a {
            color: rgb(53, 248, 228);
            text-decoration: none;
        }

        p a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="booking-container">
        <h2>Book Your Ride</h2>
        <form action="#" method="POST">
            <label for="pickup">Pick-up Location</label>
            <input type="text" id="pickup" name="pickup" required>
            
            <label for="drop">Drop Location</label>
            <input type="text" id="drop" name="drop" required>
            
            <label for="from_date">From Date</label>
            <input type="date" id="from_date" name="from_date" required>
            
            <label for="to_date">To Date</label>
            <input type="date" id="to_date" name="to_date" required>
            
            <label for="passengers">No. of Passengers</label>
            <input type="number" id="passengers" name="passengers" min="1" required>
            
            <label for="vehicle_type">Select Vehicle Type</label>
            <select id="vehicle_type" name="vehicle_type" required>
                <option value="">--Select--</option>
                <option value="sedan">Sedan</option>
                <option value="suv">SUV</option>
                <option value="van">Van</option>
            </select>
            
            <label for="trip_type">Trip Type</label>
            <select id="trip_type" name="trip_type" required>
                <option value="">--Select--</option>
                <option value="oneway">One Way</option>
                <option value="roundtrip">Round Trip</option>
            </select>
            
            <button type="submit" onclick="Registration.jsp" class="btn">Confirm Booking</button>
            
        </form>
    </div>
    <script>
        document.getElementById('booking-form').addEventListener('submit', function (e) {
            e.preventDefault();
            
            
                const bk_pickup_location = document.getElementById('pickup_location').value.trim();
                const bk_dropoff_location = document.getElementById('dropoff_location').value.trim();
                const bk_from_date = document.getElementById('from_date').value;
                const bk_to_date = document.getElementById('to_date').value;
                const passengers = document.getElementById('passengers').value;
                const cab_type= document.getElementById('cab_type').value;
                const trip_type= document.getElementById('trip_type').value;
                
                
            
            if (!bk_pickup_location || !bk_dropoff_location || !bk_from_date || !bk_to_date|| !	passengers || !	cab_type|| !trip_type) {
                showError('All fields are required.');
                return;
            }
            const payload = { bk_pickup_location,bk_dropoff_location, bk_from_date, bk_to_date, passengers, cab_type, trip_type };
            console.log('Sending payload:', payload);
            axios.post('http://localhost:8080/megacitycab-1.0-SNAPSHOT/api/bookings', payload, {
    headers: { 'Content-Type': 'application/json' }
})

.then(function(response) {
                    // Handle success
                    console.log('Response:', response);
                    if (response.status === 200) {
                        const resp = response.data; // Extract username and usertype from the response

                        alert(resp);
                        window.location.href = 'register.html'; // Redirect to login page
                } else {
                    showError('Unexpected response from server.');
    
                        // Store user details in localStorage
                        // localStorage.setItem('username', username);
                        // localStorage.setItem('usertype', usertype);
                        // localStorage.setItem('password', password);
    
                        
                    }
                })
            .catch(function(error) {
                    // Handle error
                    if (error.response) {
                        if (error.response.status === 401) {
                            document.getElementById('error-message').innerText = 'Incorrect credentials. Please try again.';
                        } else {
                            document.getElementById('error-message').innerText = 'An error occurred. Please try again later.';
                        }
                    } else {
                        document.getElementById('error-message').innerText = 'An error occurred. Please try again later.';
                    }
                    document.getElementById('error-message').style.display = 'block';
                });
        });
    </script>
</body>
</html>

