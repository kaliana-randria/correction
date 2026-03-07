<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Notes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-note-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste des Notes</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Candidat</th>
                        <th>Matiere</th>
                        <th>Correcteur</th>
                        <th>Note</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="note" items="${listes}">
                                <tr>
                                    <td>${note.id}</td>
                                    <td>${note.candidat.nom} ${note.candidat.prenom}</td>
                                    <td>${note.matiere.nom}</td>
                                    <td>${note.correcteur.nom} ${note.correcteur.prenom}</td>
                                    <td>${note.valeur}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/note/modifier/${note.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/note/supprimer/${note.id}" class="btn btn-danger">
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
            <a href="${pageContext.request.contextPath}/note/ajout-note" class="btn btn-success">Ajouter note</a>
        </div>
    </div>

</body>
</html>