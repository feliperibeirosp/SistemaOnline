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
	<script type="text/javascript" src="/javascripts/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="/javascripts/jquery.validate.min.js"></script>
	<form id="produtosForm" action="<c:url value="/produtos"/>" method="POST">
		<fieldset>
			<legend>Adicionar Produto</legend>
			
			<label for="nome">Nome:</label>
			<input id="nome" class="required" minlength="3" 
			type="text" name="produto.nome"value="${produto.nome }"/>
			
			<label for="descricao">Descrição:</label>
			<textarea id="descricao" class="required" maxlength="40"
			name="produto.descricao">${produto.descricao }</textarea>
			
			<label for="preco">Preço:</label>
			<input id="preco" min="0" type="text" name="produto.preco" value="${produto.preco }"/>
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>

	<script type="text/javascript">
		$('#produtosForm').validate();
	</script>
	
</body>
</html>