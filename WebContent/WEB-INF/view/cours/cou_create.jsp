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
<form:form action="cou_create" modelAttribute="course">
<input type="hidden" name="option" value="C"/>
	Titre: <form:input path="title"/><br>
	<form:errors path="title" />
	
	<input type="submit" value="Valider"/>
</form:form>
</body>
</html>