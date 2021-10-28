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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>登录 | 每次登录都是与你の邂逅。</title><!-- Favicon -->
    <link rel="stylesheet" href="login/css/backend.css">
    <style type="text/css">
    
        @font-face {
        font-family: 'qiantu';
        src: url('login\\font\\qiantu.ttf');
        }
        .marlene-btn-login {
            font-family: 'qiantu';
            /* background-image: linear-gradient(135deg, #ffa7c1 0%, #f56692 100%); */
        }
    
        </style>
</head>

<body class=" ">
    <div class="wrapper"
        style="background: url(login/image/background.png); background-attachment: fixed; background-size: cover;">
        <section class="login-content">
            <div class="container">
                <div class="row align-items-center justify-content-center height-self-center">
                    <div class="col-lg-8">
                        <div class="card auth-card" style="overflow: inherit;border: 0px;">
                            <div class="card-body p-0">
                                <div class="d-flex  auth-content">
                                    <div class="col-lg-6  content-left"
                                        style="background-color: white;border-radius: 8px 0px 0px 8px;">
                                        <div class="p-3 ">
                                            <div>
                                                <h2 class="mb-2 text-primary"  >登录</h2>
<%--                                                <p>每次登录都是与你の邂逅。</p>--%>
                                                <p>これは別の世界への扉です</p>
                                            </div>
                                            <form action="user/check" method="post">
                                                <input type="hidden" required name="roleId" value="1">
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="floating-label form-group"><input
                                                                class="floating-input form-control" type="text"
                                                                name="loginAccount"
                                                                placeholder=" "
                                                                style="border-color:#f3f3f3"><label>用户名</label></div>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <div class="floating-label form-group"><input
                                                                class="floating-input form-control" required type="password"
                                                                name="password"
                                                                placeholder=" "
                                                                style="border-color:#f3f3f3"><label>密码</label></div>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <div class="custom-control custom-checkbox mb-3"><input
                                                                type="checkbox" class="custom-control-input"
                                                                id="customCheck1"><label
                                                                class="custom-control-label control-label-1 "
                                                                for="customCheck1">记住账号</label></div>
                                                    </div>
                                                    <div class="col-lg-6"><a href="auth-recoverpw.html"
                                                            class=" float-right">忘记密码?</a><a class="float-right">/</a><a
                                                            href="auth-sign-up.html" class="float-right">注册</a></div>
                                                </div>
                                                <button type="submit" class="btn btn-primary marlene-btn-login btn-block" style="border: 0px;font-size: 1.4rem;border-radius: 1.25rem;">登录</button>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 content-right"><img src="login/picture/luoxiqi.png"
                                        class="img-fluid image-right" alt="" style="margin-top: -3.5rem;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div><!-- Backend Bundle JavaScript --><!---->

    <script src="login/js/backend-bundle.min.js"></script><!-- Table Treeview JavaScript -->
</body>

</html>