<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>品类列表</title>
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
        <li>品类管理</li>
        <li>品类列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="queryAllCategory" method="get">
        <div class="form-group">
            <label class="" for="activename">品类名称：</label>
            <input type="text" name="categoryName" class="form-control" list="categoryList" id="activename"
                   placeholder="请输入品类名称">
            <datalist id="categoryList">
                <c:forEach items="${categoryPageInfo.list}" var="cate">
                    <option value="${cate.categoryName}">${cate.categoryName}</option>
                </c:forEach>
            </datalist>
        </div>
        <input type="submit" id="btn-queryCateByName" class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="toAddCategory">添加品类</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>品类编号</th>
            <th>品类名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${categoryPageInfo.list}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.categoryName}</td>
                <td>
                    <a href="toUpdateCategory?categoryId=${category.id}&pn=${categoryPageInfo.pageNum}">修改</a>
                    <button value="${category.id}" class="btn btn-link btn-default"  id="deleteCate-btn">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    分页条--%>
    <div class="row" align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="queryAllCategory?pn=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                    <%--                    上一页--%>
                    <c:if test="${categoryPageInfo.hasPreviousPage}">
                        <a href="queryAllCategory?pn=${categoryPageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${categoryPageInfo.navigatepageNums}" var="page">
                    <c:if test="${page == categoryPageInfo.pageNum}">
                        <li class="active"><a href="queryAllCategory?pn=${page}">${page}</a></li>
                    </c:if>
                    <c:if test="${page != categoryPageInfo.pageNum}">
                        <li><a href="queryAllCategory?pn=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <%--                    下一页--%>
                    <c:if test="${categoryPageInfo.hasNextPage}">
                        <a href="queryAllCategory?pn=${categoryPageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <a href="queryAllCategory?pn=${categoryPageInfo.pages}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <span pageNum="${categoryPageInfo.pageNum}"
              id="spanPage">当前第${categoryPageInfo.pageNum}页，共${categoryPageInfo.pages}页，共${categoryPageInfo.total}条记录</span>
        <hr>
    </div>

</div>

<script type="text/javascript">
    $(document).on("click", "#deleteCate-btn", function () {
        var cateId = $(this).attr("value");
        if (!confirm("您确定要删除该品类吗？")) {
            return;
        } else {
            $.ajax({
                url: "deleteCategory/" + cateId,
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
