<%--
  Created by IntelliJ IDEA.
  User: lsy93
  Date: 2021/4/20
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Param</title>
</head>
<body>

    <form action="param" method="post" modelAttribute = "User">
        user name: <input type="text" name="name"/><br>
        password: <input type="password" name="Password"/><br>
        age: <input type="text" name="age"/><br>
        State: <input name="address.state"><br>
        County: <input name="address.county"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
