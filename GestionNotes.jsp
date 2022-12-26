<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.Note" %>
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
<h1 >Gérer Les Notes</h1>
</div>
<div class="content">
<table border="1">
<tr>
<th>ID Matiere</th>
<th>Num insc</th>
<th>type note</th>
<th>Note</th>
<th></th>
<%
 
try {
	Connexion conn=new Connexion();
	ArrayList<Note>mat=conn.ConsulterNote();
 for(Note e : note){
	
	
	 %>
	 <tr>
	<td><%=e.getIDMAT() %></td>
	 <td><%=e.getNUMINSC() %></td>
	 <td><%=e.getTYPE() %></td>
	 <td><%=e.getNOTE() %></td>
	 
	  
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
<p><a href="<c:url value="/inc/GNote/ajouter.jsp"/>">Ajouter</a></p>

</div>
</body>
</html>