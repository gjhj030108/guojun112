<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品列表</title>
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
                    <small>对${name}产品名称的查询结果：</small>
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

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>产品名称</th>
                    <th>年化利率</th>
                    <th>募集总金额</th>
                    <th>已募集金额</th>
                    <th>产品周期</th>
                    <th>募集结束日期</th>
                </tr>
                </thead>
                <%--产品从数据库中查询出来，从list遍历--%>
                <tbody>
                <c:forEach var="product" items="${result}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.rate}</td>
                        <td>${product.amount}</td>
                        <td>${product.raised}</td>
                        <td>${product.cycle}</td>
                        <td>${product.endTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>