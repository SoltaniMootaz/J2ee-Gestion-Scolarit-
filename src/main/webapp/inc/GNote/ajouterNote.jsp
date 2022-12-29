<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.TypeNote,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Personne" %>
 
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
	ArrayList<Groupe> grp=conn.ConsulterGroupes();
	ArrayList<TypeNote> tns=conn.ConsulterTypeN();
	
	
%>
<div>
<form method="get" action=" <c:url value="/AjouterNote" />" >
<fieldset>
<legend>Ajout</legend>
<label for="num">Num insc de l'etudiant :  </label>
<input type="text" id="num" name="num"  value="<%=request.getParameter("num") %>"
size="30" maxlength="30" ReadOnly />
<br />
<label for="mtr">ID de la matière :  </label>
<input type="text" id="mtr" name="mtr"  value="<%=request.getParameter("mtr") %>"
size="30" maxlength="30" ReadOnly />
<br />
<%

for(TypeNote tn : tns){
%>
<label for="<%=tn.getNOM_TYPE() %>"><%=tn.getNOM_TYPE()%>  :  </label>
<input type="text" id="<%=tn.getNOM_TYPE() %>" name="<%=tn.getNOM_TYPE() %>" value="0"
size="30" maxlength="30" />
<br />
<%
}
%>

</fieldset>
<input type="submit" value="Enregistrer" /><br/>

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