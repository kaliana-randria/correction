<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Devis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/style-devis-ajout.css">
</head>
<body>

    <div class="container mt-5">

        <h2 class="text-center mb-4">Ajouter Devis</h2>


        <form action="/devis/ajout-devis" method="post">

            <div class="mb-3">
                <label class="form-label">Ref Demande</label>
                <input type="number" id="idDemande" name="idDemande" class="form-control" required>
                <div id="infoDemande"></div>
            </div>

            <div class="mb-3">
                <label for="type_devis" class="form-label">Type devis</label>
                <select name="idTypeDevis" class="form-select">
                    <option value=""> </option>
                    <c:forEach var="t" items="${type_devis}">
                        <option value="${t.id}">${t.libelle}</option>
                    </c:forEach>
                </select>
            </div>

            <table id="detailsTable">
                <label>Devis details</label>
                <tr>
                    <th>Libelle</th>
                    <th>PU</th>
                    <th>Quantité</th>
                    <th>Montant</th>
                </tr>

                <tr>
                    <td><input name="details[0].libelle"></td>
                    <td><input type="number" name="details[0].PU" oninput="calcul()" min="1"></td>
                    <td><input type="number" name="details[0].qtte" oninput="calcul()" min="1"></td>
                    <td class="montant">0</td>
                    <td><button type="button" onclick="supprimerLigne(this)">Supprimer</button></td>
                </tr>
            </table>

            <button type="button" class="btn btn-primary" onclick="ajoutLigne()">Ajouter ligne</button>

            <p><h3>Total: <span id="total">0</span></h3></p>

            <button type="submit" class="btn btn-success">CREER</button>

        </form>


    </div>

    <script src="/assets/js/demande.js"></script>
    <script src="/assets/js/devis-details.js"></script>
    <script>
        const REDUCTION = ${reduction};
    </script>

</body>
</html>