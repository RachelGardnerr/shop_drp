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
    <title>供应商列表</title>
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
        <li>供应商</li>
        <li>供应商列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="supplierList" method="get">
        <div class="form-group">
            <label class="" for="activename">供应商名称：</label>
            <input type="text" name="supplierName" class="form-control" list="supplierList" id="activename"
                   placeholder="请输入供应商名称">
            <datalist id="supplierList">
                <c:forEach items="${supplierPageInfo.list}" var="supplier">
                    <option value="${supplier.supplierName}">${supplier.supplierName}</option>
                </c:forEach>
            </datalist>
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="toAddSupplier">添加供应商</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>供应商编号</th>
            <th>供应商名称</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${supplierPageInfo.list}" var="supplier">
            <tr>
                <td>${supplier.id}</td>
                <td>${supplier.supplierName}</td>
                <td>${supplier.contactsName}</td>
                <td>${supplier.tel}</td>
                <td>${supplier.address}</td>
                <td>
                    <a href="toUpdateSupplier?supplierId=${supplier.id}&pageNum=${supplierPageInfo.pageNum}">修改</a>
                    <button value="${supplier.id}" id="deleteSupplier-btn">删除</button>
                </td>
            </tr>
        </c:forEach>

    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="supplierList?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${supplierPageInfo.hasPreviousPage}">
                        <a href="supplierList?pn=${supplierPageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${supplierPageInfo.navigatepageNums}" var="page">
                    <c:if test="${page == supplierPageInfo.pageNum}">
                        <li class="active"><a href="supplierList?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != supplierPageInfo.pageNum}">
                        <li><a href="supplierList?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${supplierPageInfo.hasNextPage}">
                        <a href="supplierList?pn=${supplierPageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="supplierList?pn=${supplierPageInfo.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${supplierPageInfo.pageNum}"
              id="spanPage">当前第${supplierPageInfo.pageNum}页，共${supplierPageInfo.pages}页，共${supplierPageInfo.total}条记录</span>
        <hr>
    </div>
</div>
<script type="text/javascript">
    $(document).on("click", "#deleteSupplier-btn", function () {
        var value = $(this).attr("value");
        if (!confirm("您确定要删除该供应商吗？")) {
            return;
        } else {
            $.ajax({
                url: "deleteSupplier/" + value,
                success: function (result) {
                    if (result.code == 200) {
                        window.location.reload();
                    } else {
                        alert("删除失败！")
                    }
                }
            });
        }
    });
</script>
</body>
</html>
