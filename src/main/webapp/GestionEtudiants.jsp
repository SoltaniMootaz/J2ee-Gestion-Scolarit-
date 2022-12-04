<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les étudiants</h1>
</div>
<div class="content">
<table border="1">
<tr>
<th>Numero inscription</th>
<th>Nom</th>
<th>Prenom</th>
<th>Adresse</th>
<th>Mail</th>
<th>Numero telephone</th>
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
<div class="Action_Btns">
<p><a href="<c:url value="/inc/GEtudiant/ajouter.jsp"/>">Ajouter</a></p>

</div>
</body>
</html>