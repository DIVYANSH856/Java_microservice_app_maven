<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frontend Microservice</title>
</head>
<body>
    <h2>Welcome to Frontend Microservice</h2>
    <form action="frontend" method="post">
        Backend IP: <input type="text" name="backendIp"><br>
        Backend Port: <input type="text" name="backendPort"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
