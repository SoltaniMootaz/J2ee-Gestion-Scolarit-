<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Personne" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionMatieres.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Modifier une matiere</h1>
</div>
<%
int ID_MAT=Integer.parseInt(request.getParameter("id"));
float coef=Float.parseFloat(request.getParameter("coef"));
String nom=request.getParameter("nom");


%>
<div>
<form method="get" action=" <c:url value="/ModifierMatiere" />" >
<fieldset>
<legend>Ajout</legend>
<label for="id">ID du matiere</label>
<input type="text" id="id" name="id" value="<%=ID_MAT %>"
size="30" maxlength="30" />
<br />
<label for="nom">Nom du matiere</label>
<input type="text" id="nom" name="nom" value="<%=nom %>"
size="30" maxlength="30" />
<br />
<label for="coef">Coef.</label>
<input type="text" id="coef" name="coef" value="<%=coef %>"
size="30" maxlength="30" />
<br />

</fieldset>
<input type="submit" value="Enregistrer" /><br/>

</form>
</div>
</body>
</html>