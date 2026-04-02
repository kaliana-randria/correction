<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste Devis details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2>Détails du devis</h2>

    <p><strong>ID Devis :</strong> ${devis.id}</p>
    <p><strong>Date :</strong> ${devis.date}</p>

    <hr>

        <table border="1">
            <tr>
                <th>Libelle</th>
                <th>PU</th>
                <th>Quantite</th>
                <th>Montant</th>
            </tr>

            <c:set var="total" value="0" />

            <c:forEach var="d" items="${details}">
                <tr>
                    <td>${d.libelle}</td>
                    <td>${d.PU}</td>
                    <td>${d.qtte}</td>
                    <td>${d.PU * d.qtte}</td>
                </tr>

                <c:set var="total" value="${total + (d.PU * d.qtte)}" />
            </c:forEach>

            <tr>
                <td colspan="3"><strong>Total</strong></td>
                <td><strong>${total}</strong></td>
            </tr>
        </table>

    <br>

    <a href="${pageContext.request.contextPath}/devis/list">
        Retour
    </a>

</div>

</body>
</html>