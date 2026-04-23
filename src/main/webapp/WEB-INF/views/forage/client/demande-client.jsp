<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des demandes d'un Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-client-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste des demandes d'un Client</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>NOM</th>
                        <th>CONTACT</th>
                        <th>DATE</th>
                        <th>LIEU - DISTRICT</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                        <th>Devis</th>
                        <th>Demande statut</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty demandes}">
                            <c:forEach var="demande" items="${demandes}">
                                <tr>
                                    <td>${demande.id}</td>
                                    <td>${demande.client.nom}</td>
                                    <td>${demande.client.contact}</td>
                                    <td>${demande.date}</td>
                                    <td>${demande.lieu} - ${demande.district}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/demande/modifier/${demande.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/demande/supprimer/${demande.id}" class="btn btn-danger">
                                            Supprimer
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/client/demande-devis/${demande.id}" class="btn btn-secondary">
                                            Voir Devis
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/client/demande-statut/${demande.id}" class="btn btn-secondary">
                                            Voir Demande statut
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>

                    </c:choose>
                </tbody>
            </table>
        </div>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/demande/ajout-demande" class="btn btn-success">Ajouter demande</a>
        </div>
        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">DASHBOARD</a>
        </div>
    </div>

</body>
</html>