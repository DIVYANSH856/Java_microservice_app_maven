<!DOCTYPE html>
<html>
<head>
    <title>Simple Website</title>
</head>
<body>
    <h1>Hello, this is our second frontend page!</h1>
    <form action="/connect" method="post">
        <label for="ip">Backend Server IP:</label>
        <input type="text" id="ip" name="ip" required>
        <label for="port">Backend Server Port:</label>
        <input type="text" id="port" name="port" required>
        <button type="submit">Connect</button>
    </form>
    <div>
        <p id="status"></p>
    </div>
</body>
</html>

