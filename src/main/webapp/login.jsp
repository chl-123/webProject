<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chl
  Date: 2021/1/13
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--原本action="http://localhost:8080/webProject_war/loginServlet"--%>
<form action="http://localhost:8080/webProject_war/testFilterLoginServlet" method="get">
    用户名：<input type="text" name="username" <%--value="${cookie.username.value}"--%>><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">

</form>

</body>
</html>
