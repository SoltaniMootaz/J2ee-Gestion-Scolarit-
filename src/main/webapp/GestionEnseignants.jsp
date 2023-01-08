<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Enseignant" %>
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
<title>Gestion des enseignants</title>
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les enseignants</h1>
</div>
<div class="content">
<table id="tableau">
<tr>
<th>Numero cnss</th>
<th>Nom</th>
<th>Prenom</th>
<th>Adresse</th>
<th>Mail</th>
<th>Numero telephone</th>
</tr>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Enseignant>ens=conn.ConsulterEnseignant();
 for(Enseignant e : ens){
	 int num=e.getCNSS();
	
	 %>
	 <tr>
	 <td><%=num %></td>
	 <td><%=e.getNOM() %></td>
	 <td><%=e.getPRENOM() %></td>
	 <td><%=e.getADRESSE() %></td>
	 <td><%=e.getMAIL() %></td>
	 <td><%=e.getTEL() %></td>
	  <td><a href='/Gestion_Scolarite/inc/GEnseignant/modifier.jsp?num=<%=num %>'>modifier</a></td>
	  <td><a href="SuprimerEnseignant?num=<%=num %>&id=<%=e.getID_PERS() %>">Suprimer</a></td>
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
<p><a href="<c:url value="/inc/GEnseignant/ajouter.jsp"/>">Ajouter</a></p>

</div>
</body>
</html>