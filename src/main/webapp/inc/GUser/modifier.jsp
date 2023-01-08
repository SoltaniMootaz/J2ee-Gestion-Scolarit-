<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Role,com.sdzee.gs.beans.Personne" %>
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
<title>Modifier utilisateur</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionUtilisateurs.jsp"/>">Annuler</a></p>
</div>

<div class="title">
<h1>Modifier un utilisateur</h1>
</div>

<%
if(request.getParameter("num")!=null){
try {
	Connexion conn=new Connexion();
	String num=request.getParameter("num");
	User p=conn.ConsulterUser(Integer.parseInt(num));
	ArrayList<Role> roles=conn.ConsulterRole();
	
	
%>

<div>
<form method="get" action=" <c:url value="/ModifierUser" />" >
<fieldset>
<legend>Modification</legend>

<label for="id_pers">ID</label>
<input type="text" name="id_pers" id="id_pers" value="<%=p.getID_PERS() %>" 
size="30" maxlength="30" readOnly />
<br />
<label for="num">ID utilisateur</label>
<input type="text" id="num" name="num" value="<%=num.toString() %>"
size="30" maxlength="30" readOnly />
<br />
<label for="nom">Nom</label>
<input type="text" id="nom" name="nom" value="<%=p.getNOM() %>"
size="30" maxlength="30" />
<br />
<label for="prenom">Prénom</label>
<input type="text" id="prenom" name="prenom" value="<%=p.getPRENOM() %>"
size="30" maxlength="30" />
<br />
<label for="adresse">Adresse</label>
<input type="text" id="adresse" name="adresse" value="<%=p.getADRESSE() %>"
size="30" maxlength="30" />
<br />
<label for="mail">Mail</label>
<input type="text" id="mail" name="mail" value="<%=p.getMAIL() %>"
size="30" maxlength="30" />
<br />
<label for="tel">Numero de télephone</label>
<input type="text" id="tel" name="tel" value="<%=p.getTEL() %>"
size="30" maxlength="30" />
<br />
<label for="cin">CIN</label>
<input type="text" id="cin" name="cin" value="<%=p.getCIN() %>"
size="30" maxlength="30" readOnly />
<br />
<label for="matricule">Matricule</label>
<input type="text" id="matricule" name="matricule" value="<%=p.getMATRICULE()%>"
size="30" maxlength="30"  />
<br />
<label for="mdp">Mot de pass</label>
<input type="text" id="mdp" name="mdp" value="<%=p.getPASS()%>"
size="30" maxlength="30"  />
<br />
<label for="role">Choisir son role:</label>
<select name="role" id="role">
<%
for(Role _r : roles){
%>
<option value="<%=_r.getID() %>"><%=_r.getNOM() %></option>
<%
}
%>
</select>
</fieldset>
<input type="submit" value="Enregistrer" /><br/>
</form>
</div>

<%
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} }else{
%>
<h1>Numero null !</h1>
<%} %>

</body>
</html>