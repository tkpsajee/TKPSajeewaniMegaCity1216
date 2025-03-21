<%-- 
    Document   : Registration.jsp
    Created on : Mar 14, 2025, 12:39:36 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <title>Registration</title>
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

.register-container {
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

input {
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
        <!-- <div class="Registration-container">
        <h2>Registration</h2>
        <div id="error-message" class="error-message" style="display: none;"></div>
        <form id="Registration-form" name="Registration-form">

            <input type="text" id="us_full_name" placeholder="Full Name" required>
            <input type="text" id="us_login_user_name" placeholder="Username" required>
            <input type="password" id="us_password" placeholder="Password" required>
            <input type="text" id="us_email" placeholder="Email" required>
            <input type="text" id="us_address" placeholder="Address" required>
            <input type="text" id="us_contact_no" placeholder="Contact Number" required>
            <input type="text" id="us_nic" placeholder="NIC" required>
            <button type="submit">Registor</button>
        </form>
    </div> -->

    <div class="register-container">
        <h2>Register for Mega City Cab</h2>
        <form action="#" method="POST" onsubmit="return validateForm()">
            <label for="name">Full Name</label>
            <input type="text" id="us_full_name" required>
            <label for="username">Username</label>
            <input type="text" id="us_login_user_name" required>
            <label for="password">Password</label>
            <input type="password" id="us_password" required>
            <label for="email">Email</label>
            <input type="text" id="us_email" required>
            <label for="address">Address</label>
            <input type="text" id="us_address" required>
            <label for="contact">Contact Number</label>
            <input type="text" id="us_contact_no" required>
            <label for="nic">NIC</label>
            <input type="text" id="us_nic" required>
            <button type="submit" class="btn">Register</button>
        </form>
        <p>Already have an account? <a href="Login.jsp">Login here</a></p>
    </div>
    <script>
        // When the DOM is ready
        document.addEventListener('DOMContentLoaded', function() {
            // Handle form submission
            document.getElementById('register-form').addEventListener('submit', function(e) {
                e.preventDefault(); // Prevent default form submission
    
                // Get the username and password values
                const us_full_name = document.getElementById('fullname').value;
                const us_login_user_name = document.getElementById('username').value;
                const us_password = document.getElementById('password').value;
                const us_email = document.getElementById('email').value;
                const us_address = document.getElementById('address').value;
                const us_contact_no = document.getElementById('contactno').value;
                const us_nic = document.getElementById('nic').value;
                

                if(!us_full_name || !us_login_user_name || !us_password || !us_email || !us_address || !us_contact_no || !us_nic) {
                    showError('All fields are required.');
                    return;
                }
    
                // Validate inputs
                // if (!username || !password) {
                //     document.getElementById('error-message').innerText = 'Please enter both username and password.';
                //     document.getElementById('error-message').style.display = 'block';
                //     return;
                // }
    
                // Prepare payload
                const payload = {us_full_name,us_login_user_name,us_password,us_email,us_address,us_contact_no,us_nic};
                console.log('Sending payload:' , payload);
                
                // Make API call using Axios
                axios.post('http://localhost:8080/megacitycab-1.0-SNAPSHOT/api/users', payload, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
                .then(function(response) {
                    // Handle success
                    console.log('Response:', response);
                    if (response.status === 200) {
                        const resp = response.data; // Extract username and usertype from the response

                        alert(resp);
                        window.location.href = 'Login.jsp'; // Redirect to login page
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
        });
    </script>
    </body>
</html>
