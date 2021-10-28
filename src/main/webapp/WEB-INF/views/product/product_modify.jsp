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
    <title>商品详情</title>
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
        <li><a href="#">商品中心</a></li>
        <li>商品管理</li>
        <li>商品详情</li>
    </ul>
</div>
    <form class="form-horizontal" action="updateProduct?pn=${pageNum}" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">商品条码</label>
                    <div class="col-sm-9">
                        <input type="text" value="${product.barCode}" name="barCode" class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">商品名称</label>
                    <div class="col-sm-9">
                        <input type="text" value="${product.productName}" name="productName"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
        </div>
        <!--结束 -->
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">销售单价</label>
                    <div class="col-sm-9">
                        <span style="color: #ff0006">${addProductMsg}</span>
                        <input type="text" value="${product.salePrice}" name="salePrice" class="form-control input-sm"/>
                    </div>
                </div>
            </div>
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
        </div>
        <!--结束 -->
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">品类</label>
                    <div class="col-sm-6">
                        <select name="categoryId" class="form-control input-sm">
                            <c:forEach items="${categories}" var="categorie">
                                <option value="${categorie.id}">${categorie.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                </div>
            </div>
        </div>
        <!--结束 -->
        <div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <input type="submit" class="btn btn-success" value="提交"/>
                <a class="btn btn-warning" href="queryAllProduct?pn=${pageNum}">返回上一级</a>
            </div>
        </div>
    </form>

</body>
</html>
