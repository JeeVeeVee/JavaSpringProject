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
<h1>${tickets[0].getStadion()}</h1>
<table>
    <tr>
        <th>Nr</th>
        <th>Voetbalmatch</th>
        <th>Datum</th>
        <th>Aftrap</th>
        <th>Tickets</th>
    </tr>
    <c:forEach items="${tickets}" var="ticket">
        <c:set var="match" value="${ticket}"/>
        <tr>

                <td>
                    <a href="/fifa/${match.id}">
                        ${match.id}
                    </a>
                </td>

            <td>
                ${match.getLanden()[0]}-${match.getLanden()[1]}
            </td>
            <td>
                ${String.format("%d-11", match.getDag())}
            </td>
            <td>
                ${match.getUur()}
            </td>
            <td>
                ${ticket.getTickets_left()}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>