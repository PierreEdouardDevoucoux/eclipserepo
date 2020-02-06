<%@include file="../head.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
<form:form action="stu_create" modelAttribute="student">
<input type="hidden" name="option" value="C"/>
	Prénom: <form:input path="first_name"/><br>
	<form:errors path="first_name" />
	
	Nom: <form:input path="last_name"/><br>
	<form:errors path="last_name" />
	
	Email: <form:input path="email"/><br>
	<form:errors path="email" />
	Pick file #1:
    <form:input path="photo" type="file" name="fileUpload" size="50" />
	<input type="submit" value="Valider"/>
</form:form>
</body>
</html>