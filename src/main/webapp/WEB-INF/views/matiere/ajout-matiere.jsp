<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Matière</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter une Matière</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form action="/matiere/ajouter" method="post">

        <div class="mb-3">
            <label class="form-label">Nom matiere</label>
            <input type="text"
                   name="nom"
                   class="form-control"
                   value="${matiere.nom}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Coefficient</label>
            <input type="number"
                   name="coeff"
                   class="form-control"
                   value="${matiere.coeff}"
                   min=1
                   required>
        </div>

        <div class="text-center">

            <button type="submit" class="btn btn-success">
                Ajouter
            </button>

            <a href="/matiere/list"
               class="btn btn-secondary">
                Retour
            </a>

        </div>

    </form>

</div>

</body>
</html>