<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Groupe" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des groupes</title>
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les groupes</h1>
</div>
<div class="content">
<table border="1">
<tr>
<th>ID du groupe</th>
<th>Nom du groupe</th>
</tr>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Groupe>grps=conn.ConsulterGroupes();
 for(Groupe grp : grps){
	 int num=grp.getID();
	
	 %>
	 <tr>
	 <td><%=num %></td>
	 <td><%=grp.getNom() %></td>
	  <td><a href='/Gestion_Scolarite/inc/GGroupe/Modif/modifGRP.jsp?num=<%=num %>&nom=<%=grp.getNom() %>'>Modifier le groupe</a></td>
	  <td><a href='/Gestion_Scolarite/inc/GGroupe/GestionEtdGRP.jsp?num=<%=num %>&nom=<%=grp.getNom() %>'>Gérer les étudiants</a></td>
	  <td><a href='/Gestion_Scolarite/inc/GGroupe/GestionEnsGRP.jsp?num=<%=num %>&nom=<%=grp.getNom() %>'>Gérer les enseignants</a></td>
	 </tr>
	 <% }
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
%>
</table>
</div>
<div class="Action_Btns">
<p><a href="<c:url value="/inc/GGroupe/Ajout/ajouterGRP.jsp"/>">Ajouter un groupe</a></p>

</div>
</body>
</html>