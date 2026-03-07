<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Parametre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter un Parametre</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/parametre/ajouter"
               method="post"
               modelAttribute="parametre">

        <div class="mb-3">
            <label for="matiere" class="form-label">Matiere</label>
            <form:select path="matiere.id" cssClass="form-select" id="matiere">
                <form:option value="" label="..."/>
                <c:forEach var="matiere" items="${matieres}">
                    <form:option value="${matiere.id}" label="${matiere.matiere}" />
                </c:forEach>
            </form:select>
            <form:errors path="matiere.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="seuil" class="form-label">Diff (SEUIL)</label>
            <form:input path="seuil" type="number" cssClass="form-control" id="seuil"/>
            <form:errors path="seuil" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="operateur" class="form-label">Operateur</label>
            <form:select path="operateur.id" cssClass="form-select" id="operateur">
                <form:option value="" label="..."/>
                <c:forEach var="operateur" items="${operateurs}">
                    <form:option value="${operateur.id}" label="${operateur.nom}" />
                </c:forEach>
            </form:select>
            <form:errors path="operateur.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="resolution" class="form-label">Resolution</label>
            <form:select path="resolution.id" cssClass="form-select" id="resolution">
                <form:option value="" label="..."/>
                <c:forEach var="resolution" items="${resolutions}">
                    <form:option value="${resolution.id}" label="${resolution.nom}" />
                </c:forEach>
            </form:select>
            <form:errors path="resolution.id" cssClass="text-danger"/>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">Ajouter</button>
            <a href="${pageContext.request.contextPath}/parametre/list" class="btn btn-secondary">Retour</a>
        </div>

    </form:form>

</div>

</body>
</html>