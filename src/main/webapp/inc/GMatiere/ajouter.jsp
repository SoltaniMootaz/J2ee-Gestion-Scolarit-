<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Personne" %>
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
<title>Ajouter matière</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionMatieres.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Ajouter une matiere</h1>
</div>
<%

try {
	Connexion conn=new Connexion();
	ArrayList<Groupe> grp=conn.ConsulterGroupes();
	
	
%>
<div>
<form method="get" action=" <c:url value="/AjouterMatiere" />" >
<fieldset>
<legend>Ajout</legend>

<label for="nom">Nom du matiere</label>
<input type="text" id="nom" name="nom" value=""
size="30" maxlength="30" />
<br />
<label for="prenom">CNSS de l'enseignant</label>
<input type="text" id="num" name="num" value=""
size="30" maxlength="30" />
<br />
<label for="coef">Coef.</label>
<input type="text" id="coef" name="coef" value=""
size="30" maxlength="30" />
<br />
<label for="grp">Choisir le groupe:</label>
<select name="grp" id="grp">
<%
for(Groupe g : grp){
%>
<option value="<%=g.getID() %>"><%=g.getNom() %></option>
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