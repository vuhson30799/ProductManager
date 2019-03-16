
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/10/2019
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<c:if test="${message != null}">
    <h2 style="color: red;">${message}</h2>
</c:if>
<p><a href="list">Back to product list</a> </p>
<form method="post">
    <fieldset>
        <legend>
            Product Information
        </legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" placeholder="xxxx" name="id" value=""/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" placeholder="Name" name="name"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" placeholder="Price" name="price"/></td>
            </tr>
            <tr>
                <td>Number:</td>
                <td><input type="text" placeholder="Number" name="number"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="text" placeholder="Date" name="date"/></td>
            </tr>
        </table>
        <input type="submit" value="Create New Product"/>
    </fieldset>
</form>
</body>
</html>
