<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Operateur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Modifier une Operateur</h2>

    <form action="${pageContext.request.contextPath}/operateur/modifier" method="post">
        
        <input type="hidden" name="id" value="${operateur.id}" />

        <div class="mb-3">
            <label for="nom" class="form-label">Operateur</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${operateur.nom}" required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="${pageContext.request.contextPath}/operateur/list" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>
</body>
</html>