<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hqs66
  Date: 2019/4/27
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<div class="container">
    <div class="col-lg-offset-2 col-lg-8">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>昵称</th>
                <th>性别</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="item">
                <tr>
                    <td>
                        <a href="<c:url value="/user/detail?id=${item.id}"/>">${item.id}</a>
                    </td>
                    <td>${item.name}</td>
                    <td>${item.nickname}</td>
                    <td>${item.gender}</td>
                    <td>${item.password}</td>
                    <td>
                        <a class="btn btn-danger" href="<c:url value="/user/delete/${item.id}"/>">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:choose>
            <c:when test="${pageInfo.pages > 1}">
                <nav aria-label="Page navigation" class="text-center">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${pageInfo.hasPreviousPage}">
                                <li>
                                    <a href="<c:url value="/user/index?page=${pageInfo.pageNum-1}"/>" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:when>
                        </c:choose>
                       <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                               <c:if test="${pageInfo.pageNum == page}">
                                   <li class="active">
                                       <span>${page}</span>
                                   </li>
                               </c:if>
                               <c:if test="${pageInfo.pageNum != page}">
                                   <li>
                                       <a c href="<c:url value="/user/index?page=${page}"/>">${page}</a>
                                   </li>
                               </c:if>
                       </c:forEach>
                        <c:choose>
                            <c:when test="${pageInfo.hasNextPage}">
                                <li>
                                    <a href="<c:url value="/user/index?page=${pageInfo.pageNum+1}"/>" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                </nav>
            </c:when>
        </c:choose>

        <a class="btn btn-default" href="<c:url value="/user/add"/>">添加</a>
    </div>
</div>
</body>
</html>
