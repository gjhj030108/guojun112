<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增产品</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增产品</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
        </div>

        <div class="col-md-4 column">
        </div>

        <div class="col-md-4 column">
            <a class="btn btn-primary" style="float: right" href="${pageContext.request.contextPath}/product">返回主页</a>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/addProduct" method="post">
        <div class="form-group">
            <label>产品名称：</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>年化利率：</label>
            <input type="text"  name="rate" class="form-control" required>
        </div>
        <div class="form-group">
            <label>募集总额：</label>
            <input type="text"  name="amount" class="form-control" required>
        </div>
        <div class="form-group">
            <label>已募集额：</label>
            <input type="text" name="raised" class="form-control" required>
        </div>
        <div class="form-group">
            <label>产品周期：</label>
            <input type="text"  name="cycle" class="form-control" required>
        </div>
        <div class="form-group">
            <label>结束日期：</label>
            <input type="text"  name="endTime" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="上架">
        </div>
    </form>

</div>