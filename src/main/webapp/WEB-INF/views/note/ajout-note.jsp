<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Note</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter un Note</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/note/ajouter"
               method="post"
               modelAttribute="note">

        <div class="mb-3">
            <label for="candidat" class="form-label">Candidat</label>
            <form:select path="candidat.id" cssClass="form-select" id="candidat">
                <option value=""> </option>
                <c:forEach var="candidat" items="${candidats}">
                    <form:option value="${candidat.id}" label="${candidat.nom} ${candidat.prenom}" />
                </c:forEach>
            </form:select>
            <form:errors path="candidat.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="matiere" class="form-label">Matiere</label>
            <form:select path="matiere.id" cssClass="form-select" id="matiere">
                <option value=""> </option>
                <c:forEach var="matiere" items="${matieres}">
                    <form:option value="${matiere.id}" label="${matiere.nom}" />
                </c:forEach>
            </form:select>
            <form:errors path="matiere.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="valeur" class="form-label">Note</label>
            <form:input path="valeur" type="number" step="any" cssClass="form-control" id="valeur"/>
            <form:errors path="valeur" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="correcteur" class="form-label">Correcteur</label>
            <form:select path="correcteur.id" cssClass="form-select" id="correcteur">
                <option value=""> </option>
                <c:forEach var="correcteur" items="${correcteurs}">
                    <form:option value="${correcteur.id}" label="${correcteur.nom} ${correcteur.prenom}" />
                </c:forEach>
            </form:select>
            <form:errors path="correcteur.id" cssClass="text-danger"/>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">Ajouter</button>
            <a href="${pageContext.request.contextPath}/note/list" class="btn btn-secondary">Retour</a>
        </div>

    </form:form>

</div>

</body>
</html>