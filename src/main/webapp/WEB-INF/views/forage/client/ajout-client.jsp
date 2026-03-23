
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Client</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Ajouter Client</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <form action="/client/ajouter" method="post">

        <div class="mb-3">
            <label class="form-label">Nom</label>
            <input type="text"
                   name="nom"
                   class="form-control"
                   value="${client.nom}"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Contact</label>
            <input type="text"
                   name="contact"
                   class="form-control"
                   value="${client.contact}"
                   required>
        </div>

        <div class="text-center">

            <button type="submit" class="btn btn-success">
                Ajouter
            </button>

            <a href="/client/list"
               class="btn btn-secondary">
                Retour
            </a>

        </div>

    </form>

</div>

</body>
</html>
