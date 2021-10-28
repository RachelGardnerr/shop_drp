<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>>">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>供应商详情</title>
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
        <li>进货管理></li>
        <li>供应商</li>
        <li>供应商详情</li>
    </ul>
</div>
<form action="updateSupplier?pn=${pageNum}" method="post" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商编号</label>
                <div class="col-sm-9">
                    <input type="text" name="" value="${supplier.id}" disabled="disabled" class="form-control input-sm" />
                    <input type="hidden" name="id" value="${supplier.id}">
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商名称</label>
                <div class="col-sm-9">
                    <input type="text" name="supplierName" value="${supplier.supplierName}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系人</label>
                <div class="col-sm-9">
                    <input type="text" name="contactsName"  value="${supplier.contactsName}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <input type="text" name="tel" value="${supplier.tel}"  class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">地址</label>
                <div class="col-sm-9">
                    <input type="text" name="address" value="${supplier.address}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="supplierList">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
