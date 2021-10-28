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
    <title>品类详情</title>
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
        <li>品类详情</li>
    </ul>
</div>

<div id="addDiv">
    <form class="form-horizontal">
        <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
        <!--开始 -->
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label class="col-sm-3 control-label">品类名称</label>
                    <div class="col-sm-9">
                        <input type="text" id="categoryName" name="categoryName" class="form-control input-sm"/>
                        <span id="helpBlock2" class="help-block"></span>
                    </div>
                </div>
            </div>
        </div>
        <!--结束 -->
        <div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <input id="btn-add-category" type="button" class="btn btn-success" value="提交"/>
                <a class="btn btn-warning" href="queryAllCategory">返回上一级</a>
            </div>
        </div>
    </form>
</div>


<script type="text/javascript">

    //检查品类是否重复
    $("#categoryName").mouseleave(function () {
        $.ajax({
            url: "checkCategoryName?name=" + $("#categoryName").val(),
            type: "GET",
            success: function (result) {
                if (result.code == 100) {
                    validate_add_form("#categoryName", "error", "该品类已存在")
                    return false;
                } else {
                    validate_add_form("#categoryName", "success", "")
                    return true;
                }
            }
        });
    });


    //格式错误提示信息
    function validate_add_form(ele, status, msg) {
        $(ele).parent().removeClass("has-error has-success");
        $(ele).next("span").text("");
        if ("error" == status) {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        } else if ("success" == status) {
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }
    }

    //发送添加品类请求
    $("#btn-add-category").click(function () {
        $.ajax({
            url: "addCategoryList",
            type: "POST",
            data: $("#addDiv form").serialize(),
            success: function (result) {
                if (result.code == 100) {
                    alert("添加失败！");
                } else {
                    alert("添加成功！")
                }
            }
        });
    });


</script>
</body>
</html>
