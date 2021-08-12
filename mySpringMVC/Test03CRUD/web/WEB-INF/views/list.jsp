<%--
  Created by IntelliJ IDEA.
  User: lsy93
  Date: 2021/6/1
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>EmpId</td>
            <td>LastName</td>
            <td>Gender</td>
            <td>Email</td>
            <td>DepartmentName</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${empList}" var="emp">
            <tr>
                <td>${emp.id }</td>
                <td>${emp.lastName }</td>
                <td>${emp.gender == 1?'M':'F'}</td>
                <td>${emp.email }</td>
                <td>${emp.department.departmentName }</td>
                <td><a href="emp/${emp.id}">Edit</a></td>
                <td><a href="">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

<a href="emp">Add Employee</a>

</body>
</html>
