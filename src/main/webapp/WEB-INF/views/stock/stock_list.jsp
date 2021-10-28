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
        <li>库存管理</li>
        <li>库存列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllStock" method="get">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="productName" class="form-control" list="stockList" id="activename"
                   placeholder="请输入商品名称">
            <datalist id="stockList">
                <c:forEach items="${stocks.list}" var="product">
                    <option value="${product.productName}"></option>
                </c:forEach>
            </datalist>
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>商品条码</th>
            <th>品类</th>
            <th>商品名称</th>
            <th>库存</th>
            <th>供应商</th>
            <th>供应商联系人</th>
            <th>供应商电话</th>
        </tr>
        <c:forEach items="${stocks.list}" var="product">
            <tr>
                <th>${product.barCode}</th>
                <th>${product.category.categoryName}</th>
                <th>${product.productName}</th>
                <th>${product.stock.stockCount}</th>
                <th>${product.supplier.supplierName}</th>
                <th>${product.supplier.contactsName}</th>
                <th>${product.supplier.tel}</th>
            </tr>
        </c:forEach>
    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllStock?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${stocks.hasPreviousPage}">
                        <a href="queryAllStock?pn=${stocks.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${stocks.navigatepageNums}" var="page">
                    <c:if test="${page == stocks.pageNum}">
                        <li class="active"><a href="queryAllStock?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != stocks.pageNum}">
                        <li><a href="queryAllStock?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${stocks.hasNextPage}">
                        <a href="queryAllStock?pn=${stocks.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllStock?pn=${stocks.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${stocks.pageNum}"
              id="spanPage">当前第${stocks.pageNum}页，共${stocks.pages}页，共${stocks.total}条记录</span>
        <hr>
    </div>
</div>
</body>
</html>
