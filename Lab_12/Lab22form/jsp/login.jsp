<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="post" action="j_security_check">
    Логин: <input type="text" name="j_username" />
    Пароль: <input type="password" name="j_password" />
   <input type="submit" />
</form> 
</body>
</html>

