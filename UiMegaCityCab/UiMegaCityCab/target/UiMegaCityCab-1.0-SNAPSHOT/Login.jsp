<%-- 
    Document   : Login.jsp
    Created on : Mar 14, 2025, 12:37:41 PM
    Author     : Poorna Sajiwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    background: url('img/redred\ 2.png') no-repeat center center/cover;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-container {
    background: rgba(0, 0, 0, 0.8);
    color: white;
    padding: 20px;
    border-radius: 8px;
    width: 400px;
    text-align: right;
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
         <div class="login-container">
        <button class="close-btn" onclick="closeLogin()">&times;</button>
        <h2>Login</h2>
        <form action="#" method="POST" name="login-form" id="login-form">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit" class="btn">Login</button>
        </form>
        <p>Don't have an account? <a href="Registration.jsp">Register here</a></p>
    </div>


    <script>
        // When the DOM is ready
        document.addEventListener('DOMContentLoaded', function() {
            // Handle form submission
            document.getElementById('login-form').addEventListener('submit', function(e) {
                e.preventDefault(); // Prevent default form submission
    
                // Get the username and password values
                const username = document.getElementById('username').value;
                const password = document.getElementById('password').value;
    
                // Validate inputs
                if (!username || !password) {
                    document.getElementById('error-message').innerText = 'Please enter both username and password.';
                    document.getElementById('error-message').style.display = 'block';
                    return;
                }
    
                // Prepare payload
                const payload = { username, password };
    
                // Make API call using Axios
                axios.post('http://localhost:8080/megacitycab-1.0-SNAPSHOT/api/users/authenticate', payload, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
                .then(function(response) {
                    // Handle success
                    console.log('Response:', response);
                    if (response.status === 200) {
                        const { username, usertype } = response.data; // Extract username and usertype from the response
    
                        // Store user details in localStorage
                        localStorage.setItem('username', username);
                        localStorage.setItem('usertype', usertype);
    
                        // Redirect based on usertype
                        if (usertype === 'admin') {
                            window.location.href = 'AdminPanel.jsp'; // Redirect to admin dashboard
                        } else if (usertype === 'Driver') {
                            window.location.href = 'Driver.jsp'; // Redirect to driver dashboard
                        } else {
                            window.location.href = 'dashboard.jsp'; // Default dashboard for other user types
                        }
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
