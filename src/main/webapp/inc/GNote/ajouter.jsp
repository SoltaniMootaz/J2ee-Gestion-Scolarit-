<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Matiere" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionMatieres.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Ajouter une note</h1>
</div>
<%

try {
	Connexion conn=new Connexion();
	int isETDGRP=conn.VerifEtdGRP(Integer.parseInt(request.getParameter("num")), Integer.parseInt(request.getParameter("grp")));
	ArrayList<Matiere> mtr=conn.ConsulterMatiereFromGRP(Integer.parseInt(request.getParameter("grp")));
	if(isETDGRP>0){
	
%>
<%=isETDGRP %>
<div>
<form method="get" action=" <c:url value="/inc/GNote/ajouterNote.jsp" />" >
<fieldset>
<legend>Ajout</legend>
<label for="num">Num insc de l'etudiant :  </label>
<input type="text" id="num" name="num"  value="<%=request.getParameter("num") %>"
size="30" maxlength="30" ReadOnly />
<br />
<label for="mtr">Choisir la matiere:</label>
<select name="mtr" id="mtr">
<%
for(Matiere m : mtr){
%>
<option value="<%=m.getID() %>"><%=m.getNOM() %></option>
<%
}
%>
</select>
</fieldset>
<input type="submit" value="Suite" /><br/>

<%
	}
else{
	response.sendRedirect("/Gestion_Scolarite/GestionNotes.jsp?msg=etudiant et groupe missmatch");
}
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