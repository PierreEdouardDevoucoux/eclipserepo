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
<table class="table table-bordered table-dark">
	<tr>	
		<th scope="col">ID</th>
		<th scope="col">titre</th>
		<th scope="col">InstructorID</th>
		<th scope="col">Boutton</th>
	</tr>
	<c:forEach var="cours" items="${listCours}">
		<tr>
			<td>
				<c:out value="${cours.id}" ></c:out>
			</td><td>
				<c:out value="${cours.title}"></c:out>
			</td><td>
				<c:out value="${cours.instructor.id}"></c:out>
			</td>
		
			<td>
			<form method="post" action="cou_update">
				<input type="hidden" name="option" value="L"/>
				<input type="hidden" name="id" value="${cours.id}"/>
				<input type="hidden" name="option" value="U"/>
				<input type="submit" value="Modifier"/>
			</form>
			<form method="post" action="">
				<input type="hidden" name="option" value="D"/>
				<input type="hidden" value="${cours.id}" name="id"/>
			 	<input type="submit" value="Supprimer"/>
			</form>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="cou_create">Créer</a>
</body>
</html>