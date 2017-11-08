<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hg_yi
  Date: 17-11-8
  Time: 下午7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />" >
</head>
<body>
<c:forEach items="${spitterList}" var="spitter" >
    <c:out value="${spitter.username}" /><br />
    <c:out value="${spitter.firstName}" />
    <c:out value="${spitter.lastName}" /><br />
</c:forEach>
</body>
</html>
