<%--
  Created by IntelliJ IDEA.
  User: lsy93
  Date: 2021/4/19
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RestCRUD</title>
    <script type="text/javascript" src="WEB-INF/lib/jquery-3.3.1.js"></script>
    <script type="text/javascript" >
        function test() {
            $.ajax(
                {
                    url:"testAjax_Delete",
                    type:"DELETE",
                    data:{id:1001},
                    dataType:"json",
                    success: function (obj) {
                        alert(obj);
                    }
                }
            )
        }
    </script>
</head>
<body>
    <a href="testREST/1001">test GET</a>
    <br>
    <form action="testREST" method="POST">
        <input type="submit" value="TEST POST">
    </form>

    <br>
    <form action="testREST" method="POST">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="TEST PUT">
    </form>

    <br>
    <form action="testREST" method="POST">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="TEST Delete">
    </form>


<br>
    <input type="button" value="test AJax" onclick="test()">
</body>
</html>
