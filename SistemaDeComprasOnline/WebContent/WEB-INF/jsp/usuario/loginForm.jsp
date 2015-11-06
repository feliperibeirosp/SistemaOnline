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
	<form action="<c:url value="/login"/>" method="POST">
		<fieldset>
			<legend>Efetue o login</legend>
			<label for="login">Login:</label> <input id="login" type="text"
				name="usuario.login" /> <label for="senha">Senha:</label> <input
				id="senha" type="password" name="usuario.senha" />
			<button type="submit">Login</button>
		</fieldset>
	</form>
</body>
</html>