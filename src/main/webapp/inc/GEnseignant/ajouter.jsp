<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Action_btns">
<p><a href="<c:url value="../../GestionEnseignants.jsp"/>">Annuler</a></p>
</div>
<div class="title">
<h1>Ajouter un enseignant</h1>
</div>

<div>
<form method="get" action=" <c:url value="/AjouterEnseignant" />" >
<fieldset>
<legend>Ajout</legend>
<label for="num">Numero cnss</label>
<input type="text" id="num" name="num" value=""
size="30" maxlength="30" />
<br />
<label for="nom">Nom</label>
<input type="text" id="nom" name="nom" value=""
size="30" maxlength="30" />
<br />
<label for="prenom">Prénom</label>
<input type="text" id="prenom" name="prenom" value=""
size="30" maxlength="30" />
<br />
<label for="adresse">Adresse</label>
<input type="text" id="adresse" name="adresse" value=""
size="30" maxlength="30" />
<br />
<label for="mail">Mail</label>
<input type="text" id="mail" name="mail" value=""
size="30" maxlength="30" />
<br />
<label for="tel">Numero de télephone</label>
<input type="text" id="tel" name="tel" value=""
size="30" maxlength="30" />
<br />
<label for="cin">CIN</label>
<input type="text" id="cin" name="cin" value=""
size="30" maxlength="30" />
<br />
</fieldset>
<input type="submit" value="Enregistrer" /><br/>
</form>
</div>
</body>
</html>