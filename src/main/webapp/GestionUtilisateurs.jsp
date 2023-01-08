<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Role" %>
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
<title>Gestion des utilisateurs</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>


<div class="title">
<h1 >Gérer Les utilisateurs</h1>
</div>
<div class="content">
<table id="tableau">
<tr>
<th>ID</th>
<th>Nom</th>
<th>Prenom</th>
<th>Matricule</th>
<th>Role</th>

</tr>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<User>usr=conn.ConsulterUsers();
 for(User u : usr){
	 int num=u.getID_USER();
	 Role r=u.getRole();
	
	 %>
	 <tr>
	 <td><%=num %></td>
	 <td><%=u.getNOM() %></td>
	 <td><%=u.getPRENOM() %></td>
	 <td><%=u.getMATRICULE() %></td>
	 <td><%=r.getNOM() %></td>
	  <td><a href='/Gestion_Scolarite/inc/GUser/modifier.jsp?num=<%=num %>'>modifier</a></td>
	  <td><a href="SuprimerUser?num=<%=num %>&id=<%=u.getID_PERS() %>">Suprimer</a></td>
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
<p><a href="<c:url value="/inc/GUser/ajouter.jsp"/>">Ajouter</a></p>

</div>
</body>
</html>