<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
    <form action="/add/form">
    Имя компонента: <input type="text" name="PartName" value=""><br>
    Необходимо: <input type="checkbox" name="IsNecessary" value="true"><br>
    Количество: <input type="number" name="Amount" value=""><br>
    <input type="submit" value="Добавить">
    </form>

</body>
</html>