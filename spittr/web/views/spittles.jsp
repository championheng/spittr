<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hg_yi
  Date: 17-10-11
  Time: 下午4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--不创建seseion--%>
<%@ page session="false" %>

<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle" >
        <li id="<c:out value="spittle.id" />" >
            <div class="spittleMessage">
                <c:out value="${spittle.message}" />
            </div>
            <div>
                <span class="spittleTime">
                    <c:out value="${spittle.time}" />
                </span>
                <span class="spittleLocation">
                    (<c:out value="${spittle.latitude}" />,
                    <c:out value="${spittle.longitude}" />)
                </span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
