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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>进货录入</title>
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
        <li>进货管理</li>
        <li>进货录入</li>
    </ul>
</div>
<form action="addPurchase?roleId=${sessionScope.loginUser.roleId}" class="form-horizontal" method="get">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <input type="hidden" name="roleId" required value="${sessionScope.loginUser.roleId}">
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品条码</label>
                <div class="col-sm-9">
                    <input type="text" name="barCode" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品名称</label>
                <div class="col-sm-9">
                    <input type="text" name="productName"  required class="form-control input-sm"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">进货单价</label>
                <div class="col-sm-9">
                    <input type="text" name="purchasePrice" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">进货日期</label>
                <div class="col-sm-9">
                    <input type="text" name="purchaseDate" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">生产日期</label>
                <div class="col-sm-9">
                    <input type="text" name="proDate" required class="form-control input-sm"/>
                    <input type="hidden" name="roleId" value="1">
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">保质日期</label>
                <div class="col-sm-9">
                    <input type="text" name="expDate" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">进货数量</label>
                <div class="col-sm-9">
                    <input type="text" name="count" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">销售单价</label>
                <div class="col-sm-9">
                    <input type="text" name="salePrice" required class="form-control input-sm"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商</label>
                <div class="col-sm-6">
                    <select name="supplierId" class="form-control input-sm">
                        <c:forEach items="${suppliers}" var="supplier">
                            <option value="${supplier.id}">${supplier.supplierName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">所属品类</label>
                <div class="col-sm-6">
                    <select name="categoryId" class="form-control input-sm">
                        <c:forEach items="${categories}" var="categorie">
                            <option value="${categorie.id}">${categorie.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="submit" class="btn btn-success" value="提交"/>
        </div>
    </div>
</form>
</body>
</html>
