<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Fifa World Cup 2022</title>
</head>
<body>
<h1>Fifa World Cup Qatar 2022</h1>
<h2>${ordered_tickets}</h2>
<form:form method="POST" modelAttribute="stadion">
    <label>kies een stadion</label>
    <form:select  path="id">
        <form:options items="${stadionlist}" itemValue="id"/>
    </form:select>
    <button type="submit">
        voer uit
    </button>
</form:form>

<form action='logout' method='post'>
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>