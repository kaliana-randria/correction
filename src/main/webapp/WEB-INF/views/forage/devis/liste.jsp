<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste Devis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Liste des Devis</h2>

    <div class="text-end mb-3">
        <a href="/devis/ajout-devis" class="btn btn-primary">+ Nouveau Devis</a>
    </div>

    <div class="text-end mb-3">
        <a href="/chiffre-affaire/calcul" class="btn btn-success">
            Voir chiffre d'affaire
        </a>
    </div>

    <div class="text-end mb-3">
        <a href="/demande-statut/statutActuel" class="btn btn-primary">Statut demande Actuel</a>
    </div>

    <table class="table table-bordered table-hover text-center">

        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Date</th>
                <th>Client</th>
                <th>Lieu</th>
                <th>District</th>
                <th>Devis details</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="d" items="${listes}">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.typeDevis.libelle}</td>
                    <td>${d.date}</td>
                    <td>${d.demande.client.nom}</td>
                    <td>${d.demande.lieu}</td>
                    <td>${d.demande.district}</td>
                    <td><a href="/devis/devis-details/${d.id}">Voir devis details</a></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>