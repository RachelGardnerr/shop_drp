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
    <title>进货记录列表</title>
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
        <li>进货记录</li>
        <li>记录列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllPurchase" method="get">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="productName" class="form-control" list="purchaseList" id="activename" placeholder="请输入商品名称">
            <datalist id="purchaseList">
                <c:forEach items="${purchases.list}" var="purchase">
                    <option value="${purchase.product.productName}"></option>
                </c:forEach>
            </datalist>
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <%--    ${purchases}--%>
    <table class="table  table-condensed table-striped">
        <tr>
            <th>进货批号</th>
            <th>供应商</th>
            <th>商品条码</th>
            <th>品类</th>
            <th>商品名称</th>
            <th>进货单价(元)</th>
            <th>进货数量</th>
            <th>进货金额</th>
            <th>保质期限</th>
        </tr>
        <c:forEach items="${purchases.list}" var="purchase">
            <tr>
                <td>${purchase.id}</td>
                <td>${purchase.supplier.supplierName}</td>
                <td>${purchase.product.barCode}</td>
                <td>${purchase.category.categoryName}</td>
                <td>${purchase.product.productName}</td>
                <td>${purchase.purchasePrice}</td>
                <td>${purchase.count}</td>
                <td>${purchase.amount}</td>
                <td>${purchase.expDate}</td>
            </tr>
        </c:forEach>

    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllPurchase?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${purchases.hasPreviousPage}">
                        <a href="queryAllPurchase?pn=${purchases.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${purchases.navigatepageNums}" var="page">
                    <c:if test="${page == purchases.pageNum}">
                        <li class="active"><a href="queryAllPurchase?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != purchases.pageNum}">
                        <li><a href="queryAllPurchase?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${purchases.hasNextPage}">
                        <a href="queryAllPurchase?pn=${purchases.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllPurchase?pn=${purchases.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${purchases.pageNum}"
              id="spanPage">当前第${purchases.pageNum}页，共${purchases.pages}页，共${purchases.total}条记录</span>
        <hr>
    </div>
</div>
</body>
</html>
