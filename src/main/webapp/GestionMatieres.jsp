<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Matiere" %>
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
<title>Gestion des matières</title>
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les étudiants</h1>
</div>
<div class="content">
<table id="tableau">
<tr>
<th>ID matiere</th>
<th>Nom du matiere</th>
<th>Enseignant du matiere</th>
<th>Groupe</th>
<th>Coef.</th>

</tr>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Matiere>mtr=conn.ConsulterMatiere();
 for(Matiere m : mtr){
	 int num=m.getID();
	
	 %>
	 <tr>
	 <td><%=num %></td>
	 <td><%=m.getNOM() %></td>
	 <td><%=m.getENS().getNOM() %> <%=m.getENS().getPRENOM() %></td>
	 <td><%=m.getGROUPE().getNom() %></td>
	 <td><%=m.getCOEF() %></td>
	  <td><a href='/Gestion_Scolarite/inc/GMatiere/modifier.jsp?id=<%=num %>&nom=<%=m.getNOM()%>&coef=<%=m.getCOEF() %>'>modifier</a></td>
	  <td><a href="SuprimerMatiere?id=<%=num %>">Suprimer</a></td>
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
<p><a href="<c:url value="/inc/GMatiere/ajouter.jsp"/>">Ajouter</a></p>

</div>
</body>
</html>