<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hqs66
  Date: 2019/4/27
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<div class="container">
    <div class="col-lg-offset-3 col-lg-6">
        <form:form cssClass="form-horizontal" commandName="user" action="save" method="post">
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">编号</label>
                <div class="col-sm-10">
                    <form:input path="id" id="id" name="id" cssClass="form-control" readonly="true"></form:input>
                    <div class="has-error">
                        <form:errors path="id" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <form:input path="name" id="name" name="name" cssClass="form-control"></form:input>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="nickname" class="col-sm-2 control-label">昵称</label>
                <div class="col-sm-10">
                    <form:input path="nickname" id="nickname" name="nickname" cssClass="form-control"></form:input>
                    <div class="has-error">
                        <form:errors path="nickname" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="gender" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <form:input path="gender" id="gender" name="gender" cssClass="form-control"></form:input>
                    <div class="has-error">
                        <form:errors path="gender" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <form:password path="password" id="password" name="password" showPassword="true" cssClass="form-control"></form:password>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a class="btn btn-default pull-left" href="<c:url value="/user/index"/>">返回</a>
                    <button type="submit" class="btn btn-primary pull-right">保存</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
