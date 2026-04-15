<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listes Demande Statut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-demande-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Listes Demande Statut</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>DEMANDE</th>
                        <th>STATUT</th>
                        <th>DATE</th>
                        <th>OBSERVATION</th>
                        <%-- <th>Mettre nouveau statut</th> --%>
                        <%-- <th>Supprimer</th> --%>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="demandeStatut" items="${listes}">
                                <tr>
                                    <td>${demandeStatut.id}</td>
                                    <td>
                                        ${demandeStatut.demande.client.nom}, 
                                        ${demandeStatut.demande.lieu}, le ${demandeStatut.demande.date}
                                    </td>
                                    <td>${demandeStatut.statut.libelle}</td>
                                    <td>${demandeStatut.date}</td>
                                    <td>${demandeStatut.observation}</td>
                                    <%-- <td>
                                        <a href="${pageContext.request.contextPath}/demande-statut/form-demande-statut/${demandeStatut.id}" class="btn btn-secondary">
                                            Mettre nouveau statut
                                        </a>
                                    </td> --%>
                                    <%-- <td>
                                        <a href="${pageContext.request.contextPath}/demande-statut/supprimer/${demandeStatut.id}" class="btn btn-danger">
                                            Supprimer
                                        </a>
                                    </td> --%>
                                </tr>
                            </c:forEach>
                        </c:when>

                    </c:choose>
                </tbody>
            </table>
        </div>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/demande-statut/statutActuel" class="btn btn-success">Retour</a>
        </div>
        
    </div>

</body>
</html>