<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Candidats</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-candidat-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste des Candidats</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Date de naissance</th>
                        <th>Sexe</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="candidat" items="${listes}">
                                <tr>
                                    <td>${candidat.id}</td>
                                    <td>${candidat.nom}</td>
                                    <td>${candidat.prenom}</td>
                                    <td>${candidat.dtn}</td>
                                    <td>${candidat.sexe}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/candidat/modifier/${candidat.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/candidat/supprimer/${candidat.id}" class="btn btn-danger">
                                            Supprimer
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
            <a href="${pageContext.request.contextPath}/candidat/ajout-candidat" class="btn btn-success">Ajouter candidat</a>
        </div>
    </div>

</body>
</html>