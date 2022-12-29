<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionGroupes.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les etudiants du groupe: <%=request.getParameter("nom") %></h1>
</div>
<div class="content">
<table border="1">
<tr>
<th>ID du groupe</th>
<th>Nom du groupe</th>
<th>Num d'inscription</th>
<th>Nom </th>
<th>Prenom</th>
<th>Adresse</th>
<th>NMAIL</th>
<th>Numero de télèphone</th>
</tr>
<%
 int id =Integer.parseInt( request.getParameter("num"));
try {
	Connexion conn=new Connexion();
	ArrayList<Etudiant>etds=conn.ConsulterGroupeEtudiant(id);
	for(Etudiant etd : etds){
		 int num=etd.getNUM_INSC();
		
		 %>
		 <tr>
		  <td><%=id %></td>
		   <td><%=request.getParameter("nom") %></td>
		 <td><%=num %></td>
		 <td><%=etd.getNOM() %></td>
		 <td><%=etd.getPRENOM() %></td>
		 <td><%=etd.getADRESSE() %></td>
		 <td><%=etd.getMAIL() %></td>
		 <td><%=etd.getTEL() %></td>
		 <td>
    	 <a href="/Gestion_Scolarite/SuprimerEtudiantGroupe?num=<%=num %>&id=<%=id %>">Retirer du groupe</a>   
		 
		 </td>
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

<p><a href="<c:url value="/inc/GGroupe/Ajout/ajouterEtdGRP.jsp?id="/><%=id %>">Ajouter un étudiant au groupe</a></p>

</div>
</body>
</html>