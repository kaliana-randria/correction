<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détail Statut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">

    <h2 class="text-center mb-4">
        Statut : ${libelle}
    </h2>

    <table class="table table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>Client</th>
                <th>Demande ID</th>
                <th>Lieu</th>
                <th>District</th>
                <th>Date</th>
                <th>Observation</th>
                <th>Mettre nouveau statut</th>
                <th>Modif Observation/date</th>
                <th>Demande</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="d" items="${listes}">
                <tr>
                    <td>${d.demande.client.nom}</td>
                    <td>${d.demande.id}</td>
                    <td>${d.demande.lieu}</td>
                    <td>${d.demande.district}</td>
                    <td>${d.date}</td>
                    <td>${d.observation}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/demande-statut/form-demande-statut/${d.id}" class="btn btn-secondary">
                            Mettre nouveau statut
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/demande-statut/modifier-obsrvation-date/${d.id}" class="btn btn-secondary">
                            Modifier Observation ou date
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/client/demande/${d.demande.id}" class="btn btn-primary">
                            Voir demande
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">
            Retour Dashboard
        </a>
    </div>

</div>

</body>
</html>