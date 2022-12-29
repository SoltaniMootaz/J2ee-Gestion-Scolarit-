<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Role,com.sdzee.gs.beans.Personne" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../../GestionGroupes.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Ajouter un etudiant au groupe</h1>
</div>

<div>
<form method="get" action=" <c:url value="/ModifGroupe" />" >
<fieldset>
<legend>Ajout</legend>
<label for="id">ID du groupe</label>
<input type="text" id="id" name="id" value="<%=request.getParameter("num") %>"
size="30" maxlength="30" readOnly />
<br />
<label for="nom">Nom</label>
<input type="text" id="nom" name="nom" value="<%=request.getParameter("nom") %>"
size="30" maxlength="30" />
<br />
</fieldset>
<input type="submit" value="Enregistrer" /><br/>

</form>
</div>
</body>
</html>