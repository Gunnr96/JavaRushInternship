<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

	<style>
    .pagination {
      display: inline-block;
    }

    .pagination {
      display: inline-block;
    }

    .pagination a {
      color: black;
      float: left;
      padding: 8px 16px;
      text-decoration: none;
    }

    .pagination a.active {
      background-color: #337ab7;
      border-color: #2e6da4;
      color: white;
      border-radius: 5px;
    }

    .pagination a:hover:not(.active) {
      background-color: #ddd;
      border-radius: 5px;
    }


    </style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="">Internship</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="">В наличии</a></li>
					<li><a href="add">Добавить</a></li>
				</ul>
			</div>
		</div>
	</nav>

        <h3>Список компонентов страница ${page}</h3>
    <br>

    <form action="/search">
      Имя компонента:<br>
      <input type="text" name="query" value="">
      <br>

      <input type="submit" value="Найти">
    </form>

    <form method="GET">
      <select name="filter">
        <option value="all">Все</option>
        <option value="optional">Опциональные</option>
        <option value="necessary">Необходимые</option>
      </select>
      <br><br>
      <input type="submit" value="Применить">
    </form>

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


    <div class="pagination" id="pagination">
        <a href="//localhost:8080/parts?page=${page-1 < 1 ? 1 : page-1}&filter=${filter}" class="button">&laquo;</a>
        <c:forEach begin="1" end="${pagesNum}" var="i" step="1">
          <a href="//localhost:8080/parts?page=${i}&filter=${filter}" class="button${page == i ? ' active' : ''}">${i}</a>
        </c:forEach>
        <a href="//localhost:8080/parts?page=${page + 1 > pagesNum ? pagesNum : page + 1}&filter=${filter}" class = "button">&raquo;</a>
    </div>

</body>

</html>