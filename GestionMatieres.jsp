<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Matiere" %>
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
<h1 >Gérer Les Matieres</h1>
</div>
<div class="content">
<table border="1">
<tr>
<th>ID</th>
<th>CNSS</th>
<th>Nom Matiere</th>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Matiere>mat=conn.ConsulterMatiere();
 for(Matiere e : mat){
	 int num=e.getID();
	
	 %>
	 <tr>
	
	 <td><%=e.getNOM() %></td>
	 <td><%=e.getENS() %></td>
	 
	  
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