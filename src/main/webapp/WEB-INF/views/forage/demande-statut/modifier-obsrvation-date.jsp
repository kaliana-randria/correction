<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Demande Statut (Observation / date)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Modifier Demande Statut (Observation / date)</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/demande-statut/modifier"
               method="post"
               modelAttribute="demandeStatut">

        <input type="hidden" name="id" value="${demandeStatut.id}"/>

        <input type="hidden" name="demande.id" value="${demandeStatut.demande.id}"/>

        <input type="hidden" name="statut.id" value="${demandeStatut.statut.id}"/>

        <p>
            Demande : ${demandeStatut.demande.client.nom}
        </p>

        <div class="mb-3">
            <label class="form-label">Date</label>
            <input type="datetime-local"
                   name="date"
                   class="form-control"
                   value="${demandeStatut.date}"
                   required>q       
        </div>

        <div class="mb-3">
            <label class="form-label">Observation</label>
            <input type="text"
                   name="observation"
                   class="form-control"
                   value="${demandeStatut.observation}"
                   required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">Ajouter</button>
            <a href="${pageContext.request.contextPath}/demande-statut/statutActuel" class="btn btn-secondary">Retour</a>
        </div>

    </form:form>

</div>

</body>
</html>