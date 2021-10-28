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
    <title>商品列表</title>
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
        <li>商品中心</li>
        <li>商品管理</li>
        <li>商品列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllProduct" method="get">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="productName" class="form-control" list="productList" id="activename"
                   placeholder="请输入商品名称">
            <datalist id="productList">
                <c:forEach items="${productPageInfo.list}" var="product">
                    <option value="${product.productName}">${product.productName}</option>
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
            <th>销售单价(元)</th>
            <th>供应商</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${productPageInfo.list}" var="product">
            <tr>
                <td>${product.barCode}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.productName}</td>
                <td>${product.salePrice}</td>
                <td>${product.supplier.supplierName}</td>
                <td>
                    <a href="toUpdateProduct?productId=${product.id}&pageNum=${productPageInfo.pageNum}">修改</a>
                    <button value="${product.id}" id="deleteProduct" class="btn btn-link">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllProduct?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${productPageInfo.hasPreviousPage}">
                        <a href="queryAllProduct?pn=${productPageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${productPageInfo.navigatepageNums}" var="page">
                    <c:if test="${page == productPageInfo.pageNum}">
                        <li class="active"><a href="queryAllProduct?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != productPageInfo.pageNum}">
                        <li><a href="queryAllProduct?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${productPageInfo.hasNextPage}">
                        <a href="queryAllProduct?pn=${productPageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllProduct?pn=${productPageInfo.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${productPageInfo.pageNum}"
              id="spanPage">当前第${productPageInfo.pageNum}页，共${productPageInfo.pages}页，共${productPageInfo.total}条记录</span>
        <hr>
    </div>
</div>

<script type="text/javascript">
    $(document).on("click", "#deleteProduct", function () {
        var value = $(this).attr("value");
        if (!confirm("您确定要删除该商品吗？")) {
            return;
        } else {
            $.ajax({
                url: "deleteProduct/" + value,
                type: "delete",
                success: function (result) {
                    if (result.code == 200) {
                        window.location.reload();
                    } else {
                        alert("删除失败！")
                    }
                }
            });
        }
    })
</script>
</body>
</html>
