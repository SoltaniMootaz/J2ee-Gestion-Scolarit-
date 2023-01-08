<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sdzee.gs.db.Connexion,java.io.IOException,java.util.*,java.sql.*,com.sdzee.gs.beans.User,com.sdzee.gs.beans.Groupe,com.sdzee.gs.beans.Etudiant,com.sdzee.gs.beans.Matiere,com.sdzee.gs.beans.Note,com.sdzee.gs.beans.TypeNote" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/GeneralTableStryle.css">
</head>
<body>
<%

try {
	
	Connexion conn=new Connexion();
	ArrayList<Etudiant> etd=conn.ConsulterGroupeEtudiant(Integer.parseInt(request.getParameter("grp")));
	ArrayList<Matiere> mtr=conn.ConsulterMatiereFromGRP(Integer.parseInt(request.getParameter("grp")));
	ArrayList<TypeNote> tns=conn.ConsulterTypeN();
	ArrayList<Note> notes=conn.ConsulterNotes();
	
	float coefmoy=0;
	for(Matiere m : mtr){
		coefmoy+=m.getCOEF();
	}
	

%>
	
<table border="1">
<tr>
<th rowspan="2">Numero inscription</th>
<th rowspan="2">Nom et prenom</th>
<%
for(Matiere m: mtr){
%>
<th colspan="5"><%=m.getNOM() %>
<%} %>
<th rowspan="2">Moyenne génèrale</th>
</tr>
<tr>
<%
for(int i=0; i<mtr.size();i++){
	for (TypeNote tn: tns){
%>
<th><%=tn.getNOM_TYPE() %></th>
<%}%>
<th>Moy</th>

<% } %>
</tr>
<tr>
<%

for (Etudiant e:etd){
%>
<td><%=e.getNUM_INSC() %></td>
<td><%=e.getNOM() %> <%=e.getPRENOM() %></td>
<%
float moygen=0;
float tmpcoef=0;
for(Matiere m:mtr){
	float moymat=0;
	for(TypeNote tn:tns){
		Note n=new Note();
		n=n.RetournerNoteForMoy(notes, m.getID(), tn.getID_TypeN(), e.getID_ETD());
		moymat +=n.getNote()*n.getTYPE().getCOEF_N();	
		
	%>
	<td><%=n.getNote() %></td>
<%}
	
	moygen+=moymat* m.getCOEF() ;
	
%>
<td><%=moymat %></td>

<%}
moygen/=coefmoy;%>
<td><%=moygen %></td>
<%}
%>

</tr>
</table>
<%
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
%>
</body>
</html>