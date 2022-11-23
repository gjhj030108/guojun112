<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
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
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateProduct" method="post">
        <input type="hidden" name="id" value="${product.id}"/>
        <div class="form-group">
            <label>产品名称：</label>
            <input type="text" name="name" value="${product.name}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>年化利率：</label>
            <input type="text"  name="rate" value="${product.rate}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>募集总额：</label>
            <input type="text"  name="amount" value="${product.amount}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>已募集额：</label>
            <input type="text" name="raised" value="${product.raised}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>产品周期：</label>
            <input type="text"  name="cycle" value="${product.cycle}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>结束日期：</label>
            <input type="text"  name="endTime" value="${product.endTime}" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="提交">
        </div>
    </form>

</div>