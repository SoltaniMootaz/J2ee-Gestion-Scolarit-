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
<p><a href="<c:url value="../../GestionUtilisateurs.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Ajouter un Utilisateur</h1>
</div>
<%

try {
	Connexion conn=new Connexion();
	ArrayList<Role> roles=conn.ConsulterRole();
	
	
%>
<div>
<form method="get" action=" <c:url value="/AjouterUser" />" >
<fieldset>
<legend>Ajout</legend>

<label for="nom">Nom</label>
<input type="text" id="nom" name="nom" value=""
size="30" maxlength="30" />
<br />
<label for="prenom">Prénom</label>
<input type="text" id="prenom" name="prenom" value=""
size="30" maxlength="30" />
<br />
<label for="adresse">Adresse</label>
<input type="text" id="adresse" name="adresse" value=""
size="30" maxlength="30" />
<br />
<label for="mail">Mail</label>
<input type="text" id="mail" name="mail" value=""
size="30" maxlength="30" />
<br />
<label for="tel">Numero de télephone</label>
<input type="text" id="tel" name="tel" value=""
size="30" maxlength="30" />
<br />
<label for="cin">CIN</label>
<input type="text" id="cin" name="cin" value=""
size="30" maxlength="30" />
<br />
<label for="matricule">Matricule</label>
<input type="text" id="matricule" name="matricule" "
size="30" maxlength="30"  />
<br />
<label for="mdp">Mot de pass</label>
<input type="text" id="mdp" name="mdp" 
size="30" maxlength="30"/>
<br />
<label for="role">Choisir son role:</label>
<select name="role" id="role">
<%
for(Role _r : roles){
%>
<option value="<%=_r.getID() %>"><%=_r.getNOM() %></option>
<%
}
%>
</select>
</fieldset>
<input type="submit" value="Enregistrer" /><br/>

<%
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
%>
</form>
</div>
</body>
</html>