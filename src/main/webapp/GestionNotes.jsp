<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Personne" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des notes</title>

</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="Home.jsp"/>">Retourner</a></p>
</div>
<div class="title">
<h1>Ajouter une note</h1>
</div>
<%

try {
	String msg="";
	msg=request.getParameter("msg");
	Connexion conn=new Connexion();
	ArrayList<Groupe> grp=conn.ConsulterGroupes();
	
	if(msg!=null){
%>
<p><%=msg %></p>
<%
}%>
<div>
<form method="get" action=" <c:url value="/inc/GNote/ajouter.jsp" />" >
<fieldset>
<legend>Choisir un groupe et saisir le numéro d'inscription de l'étudiant:</legend>
<label for="grp">Choisir le groupe:</label>
<select name="grp" id="grp">
<%
for(Groupe g : grp){
%>
<option value="<%=g.getID() %>"><%=g.getNom() %></option>
<%
}
%>
</select>
<br />
<label for="num">Num inscription</label>
<input type="text" id="num" name="num" value=""
size="30" maxlength="30" />
<br />

</fieldset>
<input type="submit" value="Suite" /><br/>

<%
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
%>
</form>
</div>
</body>
</html>