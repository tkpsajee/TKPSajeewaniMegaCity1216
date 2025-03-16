<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>Usernames from the 'users' table:</h1>
    <ul>
        <c:forEach var="username" items="${usernames}">
            <li>${username}</li>
        </c:forEach>
    </ul>
</body>
</html>