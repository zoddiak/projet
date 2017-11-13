<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>


<h1>Bienvenue <%=(String)session.getAttribute("login")%></h1>

<a href="nouv_message.jsp">
    <button>Nouveau message</button>
</a>
<br>

<h1>TEST <% List list = (List) session.getAttribute("messages");%></h1>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>


<h1>TEST2 <%= list = (List) session.getAttribute("messages")%></h1>
<%   
String getStringList = (String) list.get(0);
String stringSplit[] = getStringList.split(";");

%>
				
<h1>TEST3
<% 
String corps = stringSplit[0];
String emetteur = stringSplit[1];
String sujet = stringSplit[2];
String recepteur = stringSplit[3];

%><%= corps + " " + emetteur + " " + sujet + " " + recepteur %><br>

</h1>
</body>
</html>