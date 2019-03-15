<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/10/2019
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List:</h1>
<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PRICE</td>
        <td>NUMBER</td>
        <td>DATE</td>
        <td>EDIT</td>
        <td>DELETE</td>
    </tr>
        <c:forEach items="${products}" var="product">
    <tr>
        <td>${product.getId()}</td>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getNumber()}</td>
        <td>${product.getDate()}</td>
        <td><a href="list?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="list?action=delete&id=${product.getId()}">delete</a></td>
    </tr>
    </c:forEach>
</table>
<h2><a href="list?action=create">Create New Product</a> </h2>

</body>
</html>
