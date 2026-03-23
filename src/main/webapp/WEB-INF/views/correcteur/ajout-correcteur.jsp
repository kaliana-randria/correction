<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Correcteur</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter Correcteur</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form action="/correcteur/ajouter" method="post">

        <div class="mb-3">
            <label class="form-label">Nom</label>
            <input type="text"
                   name="nom"
                   class="form-control"
                   value="${correcteur.nom}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Prenom</label>
            <input type="text"
                   name="prenom"
                   class="form-control"
                   value="${correcteur.prenom}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Date de naissance</label>
            <input type="date"
                   name="dtn"
                   class="form-control"
                   value="${correcteur.dtn}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Sexe</label>
            <input type="text"
                   name="sexe"
                   class="form-control"
                   value="${correcteur.sexe}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Adresse</label>
            <input type="text"
                   name="adresse"
                   class="form-control"
                   value="${correcteur.adresse}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">CIN</label>
            <input type="text"
                   name="cin"
                   class="form-control"
                   value="${correcteur.cin}"
                   required>
        </div>

        <div class="text-center">

            <button type="submit" class="btn btn-success">
                Ajouter
            </button>

            <a href="/correcteur/list"
               class="btn btn-secondary">
                Retour
            </a>

        </div>

    </form>

</div>

</body>
</html>