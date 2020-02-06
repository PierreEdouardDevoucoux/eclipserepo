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
	<form:form action="stu_update" modelAttribute="student">
	<input type="hidden" name="option" value="U"/>
		Id:<form:input path="id"/><br>
        <form:errors path="id" />
        Prénom:<form:input path="first_name"/><br>
        <form:errors path="first_name" />
        Nom:<form:input path="last_name"/><br>
        <form:errors path="last_name" />
        Email:<form:input path="email"/><br>
        <form:errors path="email" />
        <c:forEach var="course" items="${student.cours}">
			<c:out value="${course.id}"></c:out>
			<c:out value="${course.title}"></c:out>
		</c:forEach>
        <input type="submit" value="Valider"/>
	</form:form>
	<form:form action="stu_update" modelAttribute="student">
	<input type="hidden" name="option" value="A"/>
		<select name="coursid">
		   <c:forEach var="cours" items="${listCours}">
		     <option value='<c:out value="${cours.id}"/>'><c:out value="${cours.title}"/></option>
		   </c:forEach>
		</select>
        <input type="submit" value="Ajouter"/>
	</form:form>
</body>
</html>