<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Demande</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter Demande</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/demande/ajouter"
               method="post"
               modelAttribute="demande">

        <div class="mb-3">
            <label class="form-label">Date</label>
            <input type="datetime-local"
                   name="date"
                   class="form-control"
                   value="${demande.date}"
                   required>
        </div>

        <div class="mb-3">
            <label for="client" class="form-label">Client</label>
            <form:select path="client.id" cssClass="form-select" id="client">
                <option value=""> </option>
                <c:forEach var="client" items="${clients}">
                    <form:option value="${client.id}" label="${client.nom} ${client.contact}" />
                </c:forEach>
            </form:select>
            <form:errors path="client.id" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Lieu</label>
            <input type="text"
                   name="lieu"
                   class="form-control"
                   value="${demande.lieu}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">District</label>
            <input type="text"
                   name="district"
                   class="form-control"
                   value="${demande.district}"
                   required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">Ajouter</button>
            <a href="${pageContext.request.contextPath}/demande/list" class="btn btn-secondary">Retour</a>
        </div>
         <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">DASHBOARD</a>
        </div>

    </form:form>

</div>

</body>
</html>