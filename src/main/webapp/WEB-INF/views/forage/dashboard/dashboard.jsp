<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-client-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Dashboard</h2>
        
        <div class="table-container">
            <%-- <h1>Chiffre affaire Global : <fmt:formatNumber value="${data.chiffreAffaire}" type="number" /></h1> --%>

            <h1>
                <a href="${pageContext.request.contextPath}/dashboard/chiffre-affaire-detail" class="text-decoration-none">
                    Chiffre affaire Global :
                    <fmt:formatNumber value="${data.nbrDevis}" type="number" />
                </a>
            </h1>

            <h2><a href="${pageContext.request.contextPath}/client/list" class="btn btn-success">Nombres Clients : ${data.nbrClient}</a></h2>

            <h2><a href="${pageContext.request.contextPath}/devis/list" class="btn btn-success">Nombres Devis : ${data.nbrDevis}</a></h2>

            <h2>Statistiques par statut :</h2>

            <ul>
                <c:forEach var="s" items="${data.statuts}">
                    <li>
                        <a href="${pageContext.request.contextPath}/dashboard/statut/${s.id}">
                            ${s.libelle} : ${s.total}
                        </a>
                    </li>
                </c:forEach>
            </ul>

        </div>

    </div>

</body>
</html>