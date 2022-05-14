<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Fifa World Cup 2022</title>
</head>
<body>
<h1>Fifa World Cup Qatar 2022</h1>
<p>${wedstrijd.toString()}</p>
<p>aantal tickets bechikbaar : ${wedstrijd.getTickets_left()}</p>
<form:form method="POST" modelAttribute="ticketOrder">
    <p>
        <label>email: </label>
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </p>
    <p>
        <label>aantal tickets: </label>
        <form:input path="aantalTickets"/>
        <form:errors path="aantalTickets" cssStyle="color: red" />
    </p>
    <p>
        <label>voetbalCode1 : </label>
        <form:input path="voetbalCode1"/>
        <form:errors path="voetbalCode1" cssStyle="color: red"/>
    </p>
    <p>
        <label>voetbalCode2: </label>
        <form:input path="voetbalCode2"/>
        <form:errors path="voetbalCode2" cssStyle="color: red"/>
    </p>
    <button type="submit">
        Koop
    </button>
</form:form>
</body>

</html>