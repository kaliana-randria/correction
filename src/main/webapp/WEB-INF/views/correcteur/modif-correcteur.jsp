<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Correcteur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Modifier une Correcteur</h2>

    <form action="${pageContext.request.contextPath}/correcteur/modifier" method="post">
        
        <input type="hidden" name="id" value="${correcteur.id}" />

        <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${correcteur.nom}" required>
        </div>

        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="${correcteur.prenom}" required>
        </div>

        <div class="mb-3">
            <label for="dtn" class="form-label">Date de naissance</label>
            <input type="text" class="form-control" id="dtn" name="dtn" value="${correcteur.dtn}" required>
        </div>

        <div class="mb-3">
            <label for="sexe" class="form-label">Sexe</label>
            <input type="text" class="form-control" id="sexe" name="sexe" value="${correcteur.sexe}" required>
        </div>

        <div class="mb-3">
            <label for="adresse" class="form-label">Adresse</label>
            <input type="text" class="form-control" id="adresse" name="adresse" value="${correcteur.adresse}" required>
        </div>

        <div class="mb-3">
            <label for="cin" class="form-label">CIN</label>
            <input type="text" class="form-control" id="cin" name="cin" value="${correcteur.cin}" required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="${pageContext.request.contextPath}/correcteur/list" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>
</body>
</html>