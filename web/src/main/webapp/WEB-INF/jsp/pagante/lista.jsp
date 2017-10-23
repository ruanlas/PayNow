<%--
  Created by IntelliJ IDEA.
  User: renato
  Date: 21/10/17
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagantes registrados</title>
</head>
<body>
<ul>
    <c:forEach var="pagante" items="${pagantes}">
        <li><c:out value="${pagante}" /></li>
    </c:forEach>
</ul>
</body>
</html>
