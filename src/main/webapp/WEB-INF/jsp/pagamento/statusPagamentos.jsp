<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Entidades</title>
	</head>
	<body>
		<table style="border: 2px solid lightgrey">
			<thead>
				<th>De</th>
				<th>Para</th>
				<th>Valor</th>
				<th>Status</th>
			</thead>
			<tbody>
			<c:forEach var="e" items="${pagamentos}">
				<tr>
					<td >${e.pagador.nome}</td>
					<td>${e.recebedor.nome}</td>
					<td>${e.valor}</td>
					<td>${e.status}</td>
				</tr>
			</c:forEach>
			</tbody>

		</table>
	</body>
</html>
