<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Correcteurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-correcteur-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste des Correcteurs</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Date de naissance</th>
                        <th>Sexe</th>
                        <th>Adresse</th>
                        <th>CIN</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="correcteur" items="${listes}">
                                <tr>
                                    <td>${correcteur.id}</td>
                                    <td>${correcteur.nom}</td>
                                    <td>${correcteur.prenom}</td>
                                    <td>${correcteur.dtn}</td>
                                    <td>${correcteur.sexe}</td>
                                    <td>${correcteur.adresse}</td>
                                    <td>${correcteur.cin}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/correcteur/modifier/${correcteur.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/correcteur/supprimer/${correcteur.id}" class="btn btn-danger">
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
            <a href="${pageContext.request.contextPath}/correcteur/ajout-correcteur" class="btn btn-success">Ajouter correcteur</a>
        </div>
    </div>

</body>
</html>