<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<%-- <form action="login.spring"  method="post">   --%>
	
	<form action="user.spring">  
		User name :<input type="text" name="user"/> <br>
		password :<input   type="text" name="pass"/> <br>
		<input type="submit"/>  
	</form>
</body> 
</html>
