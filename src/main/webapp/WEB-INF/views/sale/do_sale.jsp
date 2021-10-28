<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
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


<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">>
        <li>销售管理</li>
        <li>模拟销售</li>
    </ul>
</div>
<div id="sell">
    <form action="sellProduct?roleId=${sessionScope.user.roleId}" class="form-horizontal" method="post">
        <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">商品条码</label>
                    <div class="col-sm-9">
                        <input type="text" name="productBarCode" list="productList" class="form-control input-sm"/>
                        <datalist id="productList">
                            <c:forEach items="${products}" var="product">
                                <option value="${product.barCode}">${product.barCode}</option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">销售价格</label>
                    <div class="col-sm-9">
                        <input type="text" name="salePrice" class="form-control input-sm"/>
                    </div>
                </div>
            </div>
        </div>
        <!--结束 -->
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">销售日期</label>
                    <div class="col-sm-9">
                        <input type="text" name="saleDate" class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">销售数量</label>
                    <div class="col-sm-9">
                        <input type="text" name="saleCount" placeholder="${sellMsg}" class="form-control input-sm"/>
                    </div>
                </div>
            </div>
        </div>
        <!--结束 -->
        <div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <input type="submit" id="sell-btn" class="btn btn-success" value="提交"/>
            </div>
        </div>
    </form>
</div>
<%--<script type="text/javascript">--%>
<%--    $("#sell-btn").click(function () {--%>
<%--        $.ajax({--%>
<%--            url:"",--%>
<%--            type:"POST",--%>
<%--            data:$("#sell form").serialize(),--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
