<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Composer votre message</title>
	</head>
	<body>
		<form method="post" name="message_form"
		action="./ServletClientNouveauMessage">
		    Email / Pseudo:
		    <input type="text" name="email" required>
		   	Sujet:
		    <input type="text" name="sujet" required>
		    Message:
		    <textarea name="message" required></textarea>
		    <input type="submit" value="Submit" >
		</form>
	</body>
</html>