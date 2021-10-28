<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <base href="<%=basePath%>>">
    <title>用户登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
</head>
<body class="login-layout" style="background: image('https://z3.ax1x.com/2021/09/09/hL0kVO.jpg')">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <span class="red">维维超市</span>
                            <span class="white">进销存管理系统</span>
                        </h1>
                    </div>
                    <div class="space-6"></div>
                    <div class="position-relative">
                        <div id="login-box"
                             class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee orange"></i> 请输入您的账号和密码
                                    </h4>
                                    <div class="space-6"></div>
                                    <form action="checkUser" method="post" onsubmit="return check()">
                                        <fieldset>
                                            <label class="block clearfix"> <span
                                                    class="block input-icon input-icon-right">
                                                <input id="userId" name="loginAccount" type="text" class="form-control"
                                                       placeholder="请输入账号"/>
                                                <i class="icon-user"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                            <span class="block input-icon input-icon-right">
                                                <input id="userPw" name="password" type="password" class="form-control"
                                                       placeholder="请输入密码"/>
                                                <i class="icon-lock"></i>
                                            </span>
                                            </label>
                                            <div class="clearfix">
                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>
                                                    登陆
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
