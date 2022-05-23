<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<h2>Hello World!</h2>
<form action="controller">
    <input type="hidden" name="command" value="login"/>
    Login: <input type="text" name="username" value=""/>
    <br>
    Password: <input type="password" name="password" value=""/>
    <br>
    <input type="submit" value="Submit" name="submit"/>
</form>
<br>
${login_message}
</body>
</html>
