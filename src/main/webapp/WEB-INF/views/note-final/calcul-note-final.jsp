<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Interface note-final</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Interface Note Final</h2>

    <form th:action="@{/note-final/calculer}" method="post">
        <label>Candidat :</label>
        <select name="candidatId">
            <option th:each="c : ${candidats}" th:value="${c.id}" th:text="${c.nom + ' ' + c.prenom}"></option>
        </select>

        <label>Matière :</label>
        <select name="matiereId">
            <option th:each="m : ${matieres}" th:value="${m.id}" th:text="${m.nom}"></option>
        </select>

        <button type="submit">Calculer</button>
    </form>

    <div th:if="${noteFinal != null}">
        <h3>Résultat</h3>
        <p>Candidat : <span th:text="${noteFinal.candidat.nom + ' ' + noteFinal.candidat.prenom}"></span></p>
        <p>Matière : <span th:text="${noteFinal.matiere.nom}"></span></p>
        <p>Note finale : <span th:text="${noteFinal.valeur}"></span></p>
    </div>

    <div th:if="${error != null}">
        <p th:text="${error}"></p>
    </div>
    </div>
</body>
</html>