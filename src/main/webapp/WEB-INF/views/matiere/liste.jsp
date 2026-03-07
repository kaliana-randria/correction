<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Matieres</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-matiere-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste des Matieres</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Matiere</th>
                        <th>Coefficient</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="matiere" items="${listes}">
                                <tr>
                                    <td>${matiere.id}</td>
                                    <td>${matiere.matiere}</td>
                                    <td>${matiere.coeff}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/matiere/modifier/${matiere.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/matiere/supprimer/${matiere.id}" class="btn btn-danger">
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
            <a href="${pageContext.request.contextPath}/matiere/ajout-matiere" class="btn btn-success">Ajouter Matiere</a>
        </div>
    </div>

</body>
</html>