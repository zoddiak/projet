<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inscription_style.css">
<title>Inscription</title>
</head>
<body>

	<form action="./ServletClientInscription">
	  <div class="container">
	    <label><b>Pseudo</b></label>
	    <input type="text" placeholder="Entrer votre pseudo" name="pseudo" required>
	    
	    <label><b>Nom</b></label>
	    <input type="text" placeholder="Entrer votre nom" name="nom" required>
	
	    <label><b>Mot de passe</b></label>
	    <input type="password" placeholder="Entrer mot de passe" name="password" required>
	
	    <label><b>Confirmer mot de passe</b></label>
	    <input type="password" placeholder="Confirmer mot de passe"name="psw-repeat" required>
	    <p>En cliquant sur « Créer un compte », vous acceptez les  <a href="#">conditions d'utilisation et la politique de confidentialité.</a>.</p>
	
	    <div class="clearfix">
	      <button type="reset"  class="cancelbtn">Annuler</button>
	      <button type="submit" class="signupbtn">Créer un compte</button>
	    </div>
	  </div>
	</form>

</body>
</html>