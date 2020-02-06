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

<button type="button" name="" value="" class="css3button">submit</button>
<table><tr><td width="100%" align="center"><font size=20 color="red">Liste des Students</font></td></tr></table>
<table  class="table table-bordered table-dark">
	<thead class="thead-dark">
	<tr>	
		<th scope="col">ID</th>
		<th scope="col">Prénom</th>
		<th scope="col">Nom</th>
		<th scope="col">Email</th>
		<th scope="col">Image</th>
		<th scope="col">Boutons</th>
		<th scope="col">Cours</th>
	</tr>
	</thead>
	<thead class="thead-dark">
	<tr>
		
		<td>
			<form method="post" action="">
				<input type="hidden" name="option" value="S"/>
				<input type="hidden" name="searchattribut" value="id"/>
				<input size ="2" type="text" value="" name="searchvalue"/>
			 	<input type="submit" value="Search"/>
			</form>
		</td>
		<td>
			<form method="post" action="">
				<input type="hidden" name="option" value="S"/>
				<input type="hidden" name="searchattribut" value="first_name"/>
				<input size ="10" type="text" value="" name="searchvalue"/>
			 	<input type="submit" value="Search"/>
			</form>
		</td>
		<td>
			<form method="post" action="">
				<input type="hidden" name="option" value="S"/>
				<input type="hidden" name="searchattribut" value="last_name"/>
				<input size ="10" type="text" value="" name="searchvalue"/>
			 	<input type="submit" value="Search"/>
			</form>
		</td>
		<td>
			<form method="post" action="">
				<input type="hidden" name="option" value="S"/>
				<input type="hidden" name="searchattribut" value="email"/>
				<input size ="10" type="text" value="" name="searchvalue"/>
			 	<input type="submit" value="Search"/>
			</form>
		</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach var="student" items="${listStudent}">
	
		<tr>
			<td>	
					<c:out value="${student.id}" ></c:out>
					</td><td>
					<c:out value="${student.first_name}"></c:out>
					</td><td>
					<c:out value="${student.last_name}"></c:out>
					</td><td>
					<c:out value="${student.email}"></c:out>
					</td><td>
					<img src="data:image/jpeg;base64,${image}" />
					<img src="data:image/jpeg;base64,${student.photo}" alt="No image">
					</td><td>
					
						<form method="post" action="stu_update">
							<input type="hidden" name="option" value="L"/>
							<input type="hidden" name="id" value="${student.id}"/>
							<input type="hidden" name="option" value="U"/>
							<input type="submit" value="Modifier"/>
						</form>
						<form method="post" action="">
						<input type="hidden" name="option" value="D"/>
						<input type="hidden" value="${student.id}" name="id"/>
						 	<input type="submit" value="Supprimer"/>
						</form>
						
					</td><td>
						<c:forEach var="course" items="${student.cours}">
						<c:out value="${course.id}"></c:out>
						<c:out value="${course.title}"></c:out>
						</c:forEach>
						</td>
		</tr>
	</c:forEach>
	</thead>
</table>
<a href="stu_create"><input type="button" value="Créer"/></a>
</body>
</html>