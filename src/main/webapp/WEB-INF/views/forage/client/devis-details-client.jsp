<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste details devis Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-client-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Liste details devis Client</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Libellé</th>
                        <th>Prix unitaire</th>
                        <th>Quantité</th>
                        <th>Total</th>
                        <%-- <th>Modifier</th>
                        <th>Supprimer</th> --%>
                        <%-- <th>Details Devis</th> --%>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty details}">
                            <c:forEach var="dt" items="${details}">
                                <tr>
                                    <td>${dt.id}</td>
                                    <td>${dt.libelle}</td>
                                    <td>${dt.PU}</td>
                                    <td>${dt.qtte}</td>
                                    <td>${dt.PU * dt.qtte}</td>
                                    <%-- <td>
                                        <a href="${pageContext.request.contextPath}/devis/modifier/${dt.id}" class="btn btn-secondary">
                                            Modifier
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/devis/supprimer/${dt.id}" class="btn btn-danger">
                                            Supprimer
                                        </a>
                                    </td> --%>
                                    <%-- <td>
                                        <a href="${pageContext.request.contextPath}/client/devis-details/${d.id}" class="btn btn-secondary">
                                            Voir Devis details
                                        </a>
                                    </td> --%>
                                </tr>
                            </c:forEach>
                        </c:when>

                    </c:choose>
                </tbody>
            </table>
        </div>

        <%-- <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/devis/ajout-devis" class="btn btn-success">Ajouter devis</a>
        </div> --%>
        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">DASHBOARD</a>
        </div>
    </div>

</body>
</html>