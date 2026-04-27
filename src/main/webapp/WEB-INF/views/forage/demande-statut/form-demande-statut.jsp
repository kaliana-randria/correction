<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Demande Statut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter Demande Statut</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/demande-statut/save"
               method="post"
               modelAttribute="demandeStatut">

        <input type="hidden" name="id" value="${demandeStatut.id}"/>

        <input type="hidden" name="demande.id" value="${demandeStatut.demande.id}"/>

        <p>
            Demande : ${demandeStatut.demande.client.nom}
        </p>

        <div class="mb-3">
            <label for="statut" class="form-label">Statut</label>
            <form:select path="statut.id" cssClass="form-select" id="statut">
                <option value=""> </option>
                <c:forEach var="statut" items="${statuts}">
                    <form:option value="${statut.id}" label="${statut.libelle}" />
                </c:forEach>
            </form:select>
            <form:errors path="statut.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Date</label>
            <input type="datetime-local"
                   name="date"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Observation</label>
            <input type="text"
                   name="observation"
                   class="form-control"
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