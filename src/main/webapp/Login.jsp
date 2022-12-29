<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Gestion_Scolarite/inc/Styles/LoginStyles.css">
<title>Log-in</title>
</head>
<body >
<div class="margintop">ㅤ</div>
<div class="login" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">S'Authentifié</h2>

<form class="login-container" method="get" action="<c:url value="LoginServlet"/>">

<input type="text" id="user" name="user" value=""
size="30" placeholder="Matricule" maxlength="30" />
<br />
<input type="password" id="mdp" name="mdp" value=""
size="30" placeholder="Mot de passe" maxlength="60" />
<br />

<input type="submit" value="V A L I D E R" />

</form>
</div>

</body>
</html>