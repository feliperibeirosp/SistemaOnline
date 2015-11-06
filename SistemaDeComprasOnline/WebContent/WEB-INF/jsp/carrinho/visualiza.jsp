<%@page import="sco.model.Carrinho"%>
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

	<h3>Itens do seu carrinho de compras</h3>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Qtde</th>
				<th>Total</th>
				<th>Remover</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
				<tr>
					<td>${item.produto.nome }</td>
					<td>${item.produto.descricao }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.produto.preco }" /></td>
					<td>${item.quantidade }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.quantidade * item.produto.preco }" /></td>
					<td>
						
						<form action="<c:url value="/carrinho/${s.index }"/>"
							method="POST">
							
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"></td>
				<th colspan="2">Total:</th>
				<th><fmt:formatNumber type="currency"
						value="${carrinho.total }" /></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>