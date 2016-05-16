<%--
  Created by IntelliJ IDEA.
  User: xijiaxiang
  Date: 5/15/16
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>lists</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>

    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.product.price*oi.num}</td>
        </tr>
    </c:forEach>
    <c:if test="${!empty ois}">
        <tr>
            <td colspan="4" align="right">
                <a href="/createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>
