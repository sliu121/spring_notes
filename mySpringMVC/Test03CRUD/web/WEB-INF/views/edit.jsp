<%--
  Created by IntelliJ IDEA.
  User: lsy93
  Date: 2021/6/1
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<%--实际开发中，我们都会使用绝对路径，写法样式如下：--%>
<form action="${pageContext.request.contextPath}/emp" method="post">
    <input type="hidden" name="id" value="${emp.id}">
    <input type="hidden" name="_method" value="PUT">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td colspan="2"> Edit Employee</td>
        </tr>

        <tr>
            <td>
                LastName
            </td>
            <td>
                <input type="text" name="lastName" value="${emp.lastName}">
            </td>
        </tr>

        <tr>
            <td>
                Email
            </td>
            <td>
                <input type="text" name="email" value="${emp.email}">
            </td>
        </tr>

        <tr>
            <td>
                Gender
            </td>
            <td>
                <input type="radio" name="gender" value="1" <c:if test="${emp.gender==1}">checked = "checked"</c:if>> M
                <input type="radio" name="gender" value="0" <c:if test="${emp.gender==0}">checked = "checked"</c:if>> F
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
                        <option value="${dept.id}" ${dept.id == emp.department.id?'selected':''}>${dept.departmentName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="edit">
            </td>
        </tr>


    </table>
</form>

</body>
</html>
