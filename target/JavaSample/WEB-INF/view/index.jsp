<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hqs66
  Date: 2019/4/13
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/site.css"/>"/>
    <style>
        .color{

        }
    </style>
</head>
<body>
<h2>Hello World! My son is shuaibo</h2>
<h2>${user.name} - ${user.gander} - ${user.age}</h2>
<a href="<c:url value="/home/about/2"/>">HaHaHa</a>
<form:form commandName="user" action="save" method="post" cssClass="color" cssStyle="text-align: center" enctype="multipart/form-data">
    <form:input path="name" id="name" name="name"></form:input>
    <form:hidden path="age" id="age" name="age"></form:hidden>
    <form:input path="gander" id="gander" name="gander"></form:input>
    <form:password path="pwd" id="pwd" name="pwd" showPassword="true"></form:password>
    <input type="file" name="multipartFile"/>
    <%--<input type="file" name="multipartFile[0]" multiple/>多文件上传--%>
    <input type="submit" value="submit">
</form:form>

<p><fmt:formatDate value="${now}" type="both"/></p>
<c:forEach var="x" items="${[1,2,3,5]}">
    <p>${x}</p>
</c:forEach>
</body>
</html>
