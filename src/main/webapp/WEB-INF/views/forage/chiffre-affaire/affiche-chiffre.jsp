<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chiffres affaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-client-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Chiffres affaire</h2>
        
        <div class="table-container">
            <h1>
                Chiffre affaire Global :

                <fmt:formatNumber value="${chiffre.montantDevisTotal}" type="number" />
            </h1>
            
        </div>

    </div>

</body>
</html>