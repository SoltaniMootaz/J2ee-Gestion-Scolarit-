<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Enseignant" %>
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
<title>Gestion des enseignants des groupes</title>
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionGroupes.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1 >Gérer Les enseignants du groupe: <%=request.getParameter("nom") %></h1>
</div>
<div class="content">
<table id="tableau">
<tr>
<th>ID du groupe</th>
<th>Nom du groupe</th>
<th>Num CNSS</th>
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
	ArrayList<Enseignant>enss=conn.ConsulterGroupeEnseignant(id);
	for(Enseignant ens : enss){
		 int num=ens.getCNSS();
		
		 %>
		 <tr>
		 <td><%=id %></td>
		 <td><%=request.getParameter("nom") %></td>
		 <td><%=num %></td>
		 <td><%=ens.getNOM() %></td>
		 <td><%=ens.getPRENOM() %></td>
		 <td><%=ens.getADRESSE() %></td>
		 <td><%=ens.getMAIL() %></td>
		 <td><%=ens.getTEL() %></td>
		  <td><a href="/Gestion_Scolarite/SuprimerEnseignantGroupe?num=<%=num %>&id=<%=id %>">Suprimer du groupe</a></td>
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

<p><a href="<c:url value="/inc/GGroupe/Ajout/ajouterEnsGRP.jsp?id="/><%=id %>">Ajouter un enseignant au groupe</a></p>

</div>
</body>
</html>