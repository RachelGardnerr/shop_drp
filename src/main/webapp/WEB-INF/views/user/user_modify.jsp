<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <base href="<%=basePath%>>">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">系统管理</a></li>
        <li>用户管理</li>
        <li>用户详情</li>
    </ul>
</div>
<form action="user/update" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户编号</label>
                <div class="col-sm-9">
                    <input type="text"  value="${user2.id}" name="" disabled="disabled" class="form-control input-sm"  />
                    <input type="hidden" name="id" value="${user2.id}">
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名</label>
                <div class="col-sm-9">
                    <input type="text" value="${user2.userName}"  name="userName" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">登陆账号</label>
                <div class="col-sm-9">
                    <input type="text"  value="${user2.loginAccount}" name="loginAccount" class="form-control input-sm" />
                    <input type="hidden" name="roleId" value="1">
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">登陆密码</label>
                <div class="col-sm-9">
                    <input type="text" value="${user2.password}" name="password" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">电话</label>
                <div class="col-sm-9">
                    <input type="text"  value="${user2.tel}" name="tel" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">微信号</label>
                <div class="col-sm-9">
                    <input type="text" value="${user2.wxAccount}" name="wxAccount" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">身份证号</label>
                <div class="col-sm-9">
                    <input type="text" value="${user2.idNo}" name="idNo" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">地址</label>
                <div class="col-sm-9">
                    <input type="text" value="${user2.address}" name="address" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <c:if test="${user2.roleId == 1}">
                        <select name="updateRoleId" class="form-control input-sm">
                            <option value="1">管理员</option>
                            <option value="2">普通用户</option>
                        </select>
                    </c:if>
                    <c:if test="${user2.roleId == 2}">
                        <select name="updateRoleId" class="form-control input-sm">
                            <option value="2">普通用户</option>
                            <option value="1">管理员</option>
                        </select>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="user/toManagerPage?roleId=2&username=${sessionScope.loginUser.userName}">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
