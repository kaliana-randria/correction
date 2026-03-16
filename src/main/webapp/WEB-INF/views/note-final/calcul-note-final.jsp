<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Interface note-final</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container mt-5">

    <h1><strong>ETU3612</strong></h1>
    </br>
    </br>
    <h2 class="text-center mb-4">Note Finale</h2>

    <form action="${pageContext.request.contextPath}/note-final/calculer" method="post">
        <div class="mb-3">
            <label for="candidatId" class="form-label">Candidat :</label>
            <select name="candidatId" id="candidatId" class="form-select" required>
                <option value=""> </option>
                <c:forEach var="c" items="${candidats}">
                    <option value="${c.id}">${c.nom} ${c.prenom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="matiereId" class="form-label">Matière :</label>
            <select name="matiereId" id="matiereId" class="form-select" required>
                <option value=""> </option>
                <c:forEach var="m" items="${matieres}">
                    <option value="${m.id}">${m.nom}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Calculer</button>
    </form>

    <c:if test="${not empty success}">
        <div class="text-success mt-3">
            ${success}
        </div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="text-danger mt-3">
            ${error}
        </div>
    </c:if>

    <c:if test="${not empty noteFinal}">
        <div class="card mt-4">
            <div class="card-body">
                <h3>Résultat</h3>
                <p><strong>Candidat :</strong> ${noteFinal.candidat.nom} ${noteFinal.candidat.prenom}</p>
                <p><strong>Matière :</strong> ${noteFinal.matiere.nom}</p>
                <p><strong>Note finale :</strong> <h1>${noteFinal.valeur}</h1></p>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>