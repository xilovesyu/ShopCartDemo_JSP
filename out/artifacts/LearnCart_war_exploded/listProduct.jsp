<%--
  Created by IntelliJ IDEA.
  User: xijiaxiang
  Date: 5/15/16
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<html>
<head>
    <title>list Product</title>
</head>
<body>
<c:if test="${!empty consumer}">
    <div align="center">
        current user:${consumer.name}
    </div>
</c:if>
<table align="center" border="1" cellpadding="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>purchase</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>
                <form action="addOrderItem" method="post">
                    numbers:<input type="text" value="1" name="num">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" value="purchase">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
