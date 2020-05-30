<%--
  Created by IntelliJ IDEA.
  User: chenqiangjun
  Date: 2020/5/30
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查询所有用户</h1>

<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>

</body>
</html>
