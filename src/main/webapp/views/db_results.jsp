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
<h2>Stadions</h2>
<c:forEach items="${stadionList}" var="stadion">
    <p>${stadion.toString()}</p>
    <p>${wedstrijdDAO.findInStadion(stadion)}</p>
</c:forEach>

<h2>Wedstrijden</h2>
<c:forEach items="${wedstrijdList}" var="wedstrijd">
    <p>${wedstrijd.toString()}</p>
</c:forEach>
</body>
</html>