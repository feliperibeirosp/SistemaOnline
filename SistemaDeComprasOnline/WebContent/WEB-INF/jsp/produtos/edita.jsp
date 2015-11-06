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
	<form id="produtosFormEdit" action="<c:url value="/produtos/${produto.id }"/>" method="POST">
		<fieldset>
		<legend>Editar Produto</legend>
		
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="produto.nome" class="required" minlength="3" value="${produto.nome }"/>
		
		<label for="descricao">Descrição:</label>
		<textarea id="descricao" name="produto.descricao" class="required" maxlength="40">${produto.descricao }</textarea>
		
		<label for="preco">Preço:</label>
		<input id="preco" type="text" min="0" name="produto.preco" value="${produto.preco }"/>
		
		<button type="submit" name="_method" value="PUT">Enviar</button>
		</fieldset>
	</form>
	<script type="text/javascript">
		$('#produtosFormEdit').validate();
	</script>
</body>
</html>