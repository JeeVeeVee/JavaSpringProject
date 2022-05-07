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
<p>${ticket.getWedstrijd().toString()}</p>
<p>aantal tickets bechikbaar : ${ticket.getTickets()}</p>
<form:form method="POST" modelAttribute="ticketOrder">
    <p>
        <label>email: </label>
        <form:input path="email"/>
    </p>
    <p>
        <label>aantal tickets: </label>
        <form:input path="aantalTickets"/>
    </p>
    <p>
        <label>voetbalCode1 : </label>
        <form:input path="voetbalCode1"/>
    </p>
    <p>
        <label>voetbalCode2: </label>
        <form:input path="voetbalCode2"/>
    </p>
    <button type="submit">
        Koop
    </button>
</form:form>
</body>

</html>