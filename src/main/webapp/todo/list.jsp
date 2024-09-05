<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-05
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <h1>Todo List Page</h1>
<%--    ${dtolist}--%>
<%--    ${dtolist[0].tno} --- ${dtolist[0]. title} --- ${dtolist[0].dueDate}--%>
<%--<h3>${1+2+3}</h3>--%>
<%--<h2>${"AAA" += "BBB"}</h2>--%>
<%--<h3>${"AAA".equals("AAA")}</h3>--%>


<ul>
    <c:forEach var="dto" items="${dtolist}">
        <li>${dto}</li>
    </c:forEach>
</ul>

</body>
</html>
