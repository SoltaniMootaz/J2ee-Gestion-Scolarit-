<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-in</title>
</head>
<body>
<div>
<form method="get" action="<c:url value="LoginServlet"/>">
<fieldset>
<legend>GS LOGON</legend>
<label for="userName">Utilisateur</label>
<input type="text" id="user" name="user" value=""
size="30" maxlength="30" />
<br />
<label for="passWord">Mot de pass</label>
<input type="password" id="mdp" name="mdp" value=""
size="30" maxlength="60" />
<br />

</fieldset>
<input type="submit" value="Valider" />
<input type="reset" value="Changer mot de pass" /> <br
/>
</form>
</div>
</body>
</html>