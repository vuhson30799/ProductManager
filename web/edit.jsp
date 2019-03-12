<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/11/2019
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<p><a href="/list">Back to product list</a> </p>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" value="${product.getId()}" name="id"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" value="${product.getName()}" name="name"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" value="${product.getPrice()}" name="price"/></td>
            </tr>
            <tr>
                <td>Number:</td>
                <td><input type="text" value="${product.getNumber()}" name="number"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="text" value="${product.getDate()}" name="date"/></td>
            </tr>
        </table>
    </fieldset>
    <input type="submit" value="Update Product">
</form>
</body>
</html>
