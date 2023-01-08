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
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/HomeStyles.css">
<script src="https://kit.fontawesome.com/63b8318701.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>

<div class="context">

<div class="container">
<p><a href="<c:url value="GestionUtilisateurs.jsp"/>">
<i class="fa-solid fa-user"></i>
Gérer les utilisateurs
</a></p>
</div>
<div class="container">
<p><a href="<c:url value="GestionEnseignants.jsp"/>">
<i class="fa-solid fa-chalkboard-user"></i>
Gérer les enseignants
</a></p>
</div>
<div class="container">
<p><a href="<c:url value="GestionEtudiants.jsp"/>">
<i class="fa-sharp fa-solid fa-graduation-cap"></i>
Gérer les étudiants
</a></p>
</div>
<div class="container">
<p><a href="<c:url value="GestionMatieres.jsp"/>">
<i class="fa-solid fa-book"></i>
Gérer les matières
</a></p>
</div>
<div class="container">
<p><a href="<c:url value="GestionGroupes.jsp"/>">
<i class="fa-solid fa-user-group"></i>
Gérer les groupes
</a></p>
</div>
<div class="container">
<p><a href="<c:url value="GestionNotes.jsp"/>">
<i class="fa-solid fa-box-archive"></i>
Gérer les notes
</a></p>
</div>

<div class="container">
<p><a href="<c:url value="Affichage.jsp"/>">
<i class="fa-solid fa-square-poll-vertical"></i>
Affichage
</a></p>
</div>

<div class="container">
<p><a href="<c:url value="/Logout"/>">
<i class="fa-solid fa-right-from-bracket"></i>
Log-out
</a></p>
</div>

</div>
<div class="area" >
            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
    </div >
</body>
</html>