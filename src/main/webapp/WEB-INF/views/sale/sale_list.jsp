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
    <title>销售报表</title>
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
        <li>销售管理</li>
        <li>销售报表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllSale" method="get">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="productName" class="form-control" list="saleList" id="activename"
                   placeholder="请输入商品名称">
            <datalist id="saleList">
                <c:forEach items="${sales.list}" var="purchase">
<%--                    <option value="${purchase.productName}">${purchase.productName}</option>--%>
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
            <th>商品名称</th>
            <th>销售单价</th>
            <th>销售数量</th>
            <th>销售金额</th>
            <th>销售日期</th>
        </tr>
        <c:forEach items="${sales.list}" var="sale">
            <tr>
                <td>${sale.product.barCode}</td>
                <td>${sale.product.productName}</td>
                <td>${sale.salePrice}</td>
                <td>${sale.saleCount}</td>
                <td>${sale.saleAmount}</td>
                <td>${sale.saleDate}</td>
            </tr>
        </c:forEach>
    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllSale?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${sales.hasPreviousPage}">
                        <a href="queryAllSale?pn=${sales.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${sales.navigatepageNums}" var="page">
                    <c:if test="${page == sales.pageNum}">
                        <li class="active"><a href="queryAllSale?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != sales.pageNum}">
                        <li><a href="queryAllSale?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${sales.hasNextPage}">
                        <a href="queryAllSale?pn=${sales.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllSale?pn=${sales.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${sales.pageNum}"
              id="spanPage">当前第${sales.pageNum}页，共${sales.pages}页，共${sales.total}条记录</span>
        <hr>
    </div>
</div>
</body>
</html>
