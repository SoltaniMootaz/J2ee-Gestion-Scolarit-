<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%
String user="";
if(session.getAttribute("user")!=null){
	user=session.getAttribute("user").toString();
}else{
	response.sendRedirect("Login.jsp");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="menu">
<p><a href="<c:url value="GestionEtudiants.jsp"/>">Gérer les étudiants</a></p>
<p><a href="<c:url value="GestionEnseignants.jsp"/>">Gérer les enseignants</a></p>
<p><a href="<c:url value="/Logout"/>">Log-out</a></p>
</div>
</body>
</html>