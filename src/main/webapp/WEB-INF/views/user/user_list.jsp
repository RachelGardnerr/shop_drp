<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>模拟销售</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>用户列表</li>
    </ul>
</div>
<c:if test="${sessionScope.loginUser.roleId == 1}">
    <div class="row alert alert-info" style="margin:0px; padding:3px;">
        <form class="form-inline" action="user/toManagerPage?roleId=${sessionScope.user.roleId}" method="get">
            <div class="form-group">
                <label class="" for="activename">用户姓名：</label>
                <input type="text" name="userName" class="form-control" list="userList" id="activename"
                       placeholder="请输入用户姓名">
                <datalist id="userList">
                    <c:forEach items="${users}" var="user">
                        <option value="${user.userName}">${user.userName}</option>
                    </c:forEach>
                </datalist>
            </div>
            <input type="hidden" name="roleId" value="${sessionScope.loginUser.roleId}">
            <input type="submit" class="btn btn-danger" value="查询"/>
            &nbsp;&nbsp;
            <a class="btn btn-success" href="user/toAdd?roleId=${sessionScope.loginUser.roleId}">添加用户</a>
        </form>
    </div>
</c:if>

<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>登陆账号</th>
            <th>电话</th>
            <th>微信号</th>
            <th>身份证号</th>
            <th>地址</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.loginAccount}</td>
                <td>${user.tel}</td>
                <td>${user.wxAccount}</td>
                <td>${user.idNo}</td>
                <td>${user.address}</td>
                <c:if test="${user.roleId == 1}">
                    <td>管理员</td>
                </c:if>
                <c:if test="${user.roleId == 2}">
                    <td>普通用户</td>
                </c:if>

                <td>
                    <a href="user/toUpdate?username=${user.userName}&roleId=1">修改</a>
                    <c:if test="${sessionScope.loginUser.roleId == 1}">
                        <a href="user/delete?id=${user.id}&roleId=1" class="btn btn-link"><font size="3">删除</font></a>
                    </c:if>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">

    $(document).on("click", "#deleteUser2-btn", function () {
        var userId = $(this).val();
        if (!confirm("您确定要删除该用户吗？")) {
            return;
        } else {
            $.ajax({
                url: "user/delete?id=" + userId + "&roleId=1",
                type: "GET",
                success: function (result) {
                    if (result.code == 200) {
                        window.location.reload();
                    } else {
                        alert("删除失败！")
                    }
                }
            });
        }
    })

</script>
</body>
</html>
