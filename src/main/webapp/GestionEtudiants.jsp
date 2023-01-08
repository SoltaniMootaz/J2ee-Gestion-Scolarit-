<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Etudiant" %>
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
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
<title>Gestion des étudiants</title>
</head>
<body>
<div class="Header">
<div class="Return">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="Title">
<center><h1 >Gérer Les étudiants</h1></center>
</div>
</div>
<div class="content">
<table id="tableau">
<tr>
<th>Numero inscription</th>
<th>Nom</th>
<th>Prenom</th>
<th>Adresse</th>
<th>Mail</th>
<th>Numero telephone</th>
<th></th>
<th></th>
</tr>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Etudiant>etds=conn.ConsulterEtudiant();
 for(Etudiant etd : etds){
	 int num=etd.getNUM_INSC();
	
	 %>
	 <tr>
	 <td><%=num %></td>
	 <td><%=etd.getNOM() %></td>
	 <td><%=etd.getPRENOM() %></td>
	 <td><%=etd.getADRESSE() %></td>
	 <td><%=etd.getMAIL() %></td>
	 <td><%=etd.getTEL() %></td>
	  <td><a href='/Gestion_Scolarite/inc/GEtudiant/modifier.jsp?num=<%=num %>'>modifier</a></td>
	  <td><a href="SuprimerEtudiant?num=<%=num %>&id=<%=etd.getID_PERS() %>">Suprimer</a></td>
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

<div >
<center><p><a class="Add" href="<c:url value="/inc/GEtudiant/ajouter.jsp"/>">Ajouter</a></p><center>

</div>
</body>
</html>