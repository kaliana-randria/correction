<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Candidat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Modifier une Candidat</h2>

    <form action="${pageContext.request.contextPath}/candidat/modifier" method="post">
        
        <input type="hidden" name="id" value="${candidat.id}" />

        <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${candidat.nom}" required>
        </div>

        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="${candidat.prenom}" required>
        </div>

        <div class="mb-3">
            <label for="dtn" class="form-label">Date de naissance</label>
            <input type="text" class="form-control" id="dtn" name="dtn" value="${candidat.dtn}" required>
        </div>

        <div class="mb-3">
            <label for="sexe" class="form-label">Sexe</label>
            <input type="text" class="form-control" id="sexe" name="sexe" value="${candidat.sexe}" required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="${pageContext.request.contextPath}/candidat/list" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>
</body>
</html>