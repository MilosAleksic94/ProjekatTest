<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cards</title>
</head>
<body>

	<form action="/CardsWEB/CardServlet" method="post">
	
	<p>Posiljalac</p><input type="text" name="posiljalac">
	<p>Primalac</p><input type="text" name="primalac">
	<p>Email</p><input type="text" name="email">
	<p>Tip cestitke</p><input type="text" name="tip">
	
	
	<input type="submit" value="Posalji">
	
	</form>
</body>
</html>