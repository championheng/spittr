<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hg_yi
  Date: 17-11-8
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>Register</h1>
    <sf:form method="post" commandName="spitter" enctype="multipart/form-data" >
        <sf:errors path="*" element="div" cssClass="errors" />
        username:<sf:input path="username" />
            <sf:errors path="username" cssClass="error" /><br />
        password:<sf:password path="password" />
            <sf:errors path="password" cssClass="error" /><br />
        firstName:<sf:input  path="firstName" />
            <sf:errors path="firstName" cssClass="error" /><br />
        lastName:<sf:input path="lastName" />
            <sf:errors path="lastName" cssClass="error" /><br />
        <input type="file" name="profilePicture" />Profile Picture<br />

        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
