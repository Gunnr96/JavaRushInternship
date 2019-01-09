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

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Internship</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">В наличии</a></li>
					<li><a href="#add">Добавить</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<h3>Список компонентов</h3>
    <br>
    <table class="table table-hover">

       <thead>
          <tr>
            <th><b>Имя компонента</b></th>
            <th><b>Необходимо</b></th>
            <th><b>Количество</b></th>
          </tr>
       </thead>
       <tbody>
          <c:forEach items="${list}" var="part">
             <tr>
                <td><c:out value="${part.partName}"></c:out></td>
                <td><c:out value="${part.necessary ? 'Да' : 'Нет'}"></c:out></td>
                <td><c:out value="${part.amount}"></c:out></td>
        		<td>
                   <a href="/${part.id}/edit">
                      <button type="submit" class="btn btn-primary">Изменить</button>
                   </a>
                </td>
                <td>
                   <a href="/${part.id}/delete">
                      <button type="submit" class="btn btn-primary">Удалить</button>
                   </a>
                </td>
             </tr>
           </c:forEach>
        </tbody>
    </table>
    </div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>