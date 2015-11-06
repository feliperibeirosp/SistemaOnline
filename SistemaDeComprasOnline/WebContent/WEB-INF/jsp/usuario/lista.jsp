<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/goodbuy.css"/>" rel="stylesheet" type="text/css"media="screen" /> 
<link href="<c:url value="/javascripts/jquery.autocomplete.css"/>" rel="stylesheet" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Login</th>
				<th>Nome</th>
				<th>Remover</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td>${usuario.login }</td>
					<td>${usuario.nome }</td>
					
					<td>
					<c:if test="${usuarioWeb.usuarioLogado != usuario.login}">
						<form action="<c:url value="/usuario/${usuario.login }"/>" method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>