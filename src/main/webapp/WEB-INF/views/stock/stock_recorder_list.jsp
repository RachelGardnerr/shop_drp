<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
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
        <li>变更记录</li>
        <li>记录列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllStockModifyRecord" method="get">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="productName" class="form-control" list="recordList" id="activename"
                   placeholder="请输入商品名称">
            <datalist id="recordList">
                <c:forEach items="${stockRecordPageInfo.list}" var="record">
                    <option value="${record.product.productName}">${record.product.productName}</option>
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
            <th>变更数量</th>
            <th>变更类型</th>
            <th>时间</th>
        </tr>
        <c:forEach items="${stockRecordPageInfo.list}" var="record">
            <tr>
                <th>${record.product.barCode}</th>
                <th>${record.category.categoryName}</th>
                <th>${record.product.productName}</th>
                <th>${record.modifyCount}</th>
                <th>
                    <c:choose>
                        <c:when test="${record.modifyType == 'PURCHASE'}">
                            进货
                        </c:when>
                        <c:when test="${record.modifyType == 'SALE'}">
                            销售
                        </c:when>
                    </c:choose>
                </th>
                <th>${record.updateTime}</th>
            </tr>
        </c:forEach>

    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllStockModifyRecord?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${stockRecordPageInfo.hasPreviousPage}">
                        <a href="queryAllStockModifyRecord?pn=${stockRecordPageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${stockRecordPageInfo.navigatepageNums}" var="page">
                    <c:if test="${page == stockRecordPageInfo.pageNum}">
                        <li class="active"><a href="queryAllStockModifyRecord?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != stockRecordPageInfo.pageNum}">
                        <li><a href="queryAllStockModifyRecord?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${stockRecordPageInfo.hasNextPage}">
                        <a href="queryAllStockModifyRecord?pn=${stockRecordPageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllStockModifyRecord?pn=${stockRecordPageInfo.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${stockRecordPageInfo.pageNum}"
              id="spanPage">当前第${stockRecordPageInfo.pageNum}页，共${stockRecordPageInfo.pages}页，共${stockRecordPageInfo.total}条记录</span>
        <hr>
    </div>
</div>
</body>
</html>
