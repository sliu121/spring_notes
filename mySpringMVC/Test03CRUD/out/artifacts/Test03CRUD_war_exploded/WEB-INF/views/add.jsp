<%--
  Created by IntelliJ IDEA.
  User: lsy93
  Date: 2021/6/1
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <form action="add" method="post">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td colspan="2"> Add Employee</td>
            </tr>

            <tr>
                <td>
                    LastName
                </td>
                <td>
                    <input type="text" name="lastName">
                </td>
            </tr>

            <tr>
                <td>
                    Email
                </td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>

            <tr>
                <td>
                    Gender
                </td>
                <td>
                    <input type="radio" name="gender" value="1"> M
                    <input type="radio" name="gender" value="0"> F
                </td>
            </tr>

            <tr>
                <td>
                    Department
                </td>
                <td>
                    <select name="department.id">
                        <option>--Select Department--</option>
                        <c:forEach items="${departments}" var="dept">
                            <option value="${dept.id}">${dept.departmentName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="add">
                </td>
            </tr>


        </table>
    </form>

</body>
</html>
