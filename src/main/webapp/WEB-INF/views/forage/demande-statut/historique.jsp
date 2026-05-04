<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listes Demande Statut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-demande-liste.css">
</head>
<body>
    <div class="container">

        <h2 class="text-center mb-4">Listes Demande Statut</h2>
        
        <div class="table-container">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>DEMANDE</th>
                        <th>STATUT</th>
                        <th>DATE</th>
                        <th>OBSERVATION</th>
                        <th>DUREE Total</th>
                        <th>DUREE Travaille</th>
                        <th>Mettre nouveau statut</th>
                        <th>Modif Observation/date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty listes}">
                            <c:forEach var="demandeStatut" items="${listes}">
                                <tr>
                                    <td>${demandeStatut.id}</td>
                                    <td>
                                        ${demandeStatut.demande.client.nom}, 
                                        ${demandeStatut.demande.lieu}, le ${demandeStatut.demande.date}
                                    </td>
                                    <td>${demandeStatut.statut.libelle}</td>
                                    <td>${demandeStatut.date}</td>
                                    <td>${demandeStatut.observation}</td>
                                    <td>${demandeStatut.dureeTotal} h</td>
                                    <td>${demandeStatut.dureeTravaille} h</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/demande-statut/form-demande-statut/${demandeStatut.id}" class="btn btn-secondary">
                                            Mettre nouveau statut
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/demande-statut/modifier-obsrvation-date/${demandeStatut.id}" class="btn btn-secondary">
                                            Modifier Observation ou date
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>

                    </c:choose>
                </tbody>
            </table>
        </div>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/demande-statut/statutActuel" class="btn btn-success">Retour</a>
        </div>
        
    </div>

</body>
</html> --%>




<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listes Demande Statut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style-demande-liste.css">
    <style>
        .level-critique { background-color: #f8d7da !important; color: #842029; font-weight: bold; }
        .level-eleve    { background-color: #fff3cd !important; color: #664d03; font-weight: bold; }
    </style>
</head>
<body>
<div class="container">

    <h2 class="text-center mb-4">Listes Demande Statut avec level - ETU3612</h2>

    <div class="table-container">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>DEMANDE</th>
                    <th>STATUT</th>
                    <th>DATE</th>
                    <th>OBSERVATION</th>
                    <th>DUREE Total</th>
                    <th>DUREE Travaille</th>
                    <th>LEVEL</th>
                    <th>Mettre nouveau statut</th>
                    <th>Modif Observation/date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${listes}">


                    <c:set var="rowClass" value="" />
                    <c:if test="${dto.level == 'critique'}">
                        <c:set var="rowClass" value="level-critique" />
                    </c:if>
                    <c:if test="${dto.level == 'eleve'}">
                        <c:set var="rowClass" value="level-eleve" />
                    </c:if>

                    <tr class="${rowClass}">
                        <td>${dto.demandeStatut.id}</td>
                        <td>
                            ${dto.demandeStatut.demande.client.nom},
                            ${dto.demandeStatut.demande.lieu}, le ${dto.demandeStatut.demande.date}
                        </td>
                        <td>${dto.demandeStatut.statut.libelle}</td>
                        <td>${dto.demandeStatut.date}</td>
                        <td>${dto.demandeStatut.observation}</td>
                        <td>${dto.demandeStatut.dureeTotal} h</td>
                        <td>${dto.demandeStatut.dureeTravaille} h</td>
                        <td>
                            <c:choose>
                                <c:when test="${dto.level == 'critique'}">
                                    <span class="badge bg-danger">Critique</span>
                                </c:when>
                                <c:when test="${dto.level == 'eleve'}">
                                    <span class="badge bg-warning text-dark">Élevé</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-success">Normal</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/demande-statut/form-demande-statut/${dto.demandeStatut.id}"
                               class="btn btn-secondary btn-sm">
                                Nouveau statut
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/demande-statut/modifier-obsrvation-date/${dto.demandeStatut.id}"
                               class="btn btn-secondary btn-sm">
                                Modifier
                            </a>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/demande-statut/statutActuel" class="btn btn-success">Retour</a>
    </div>

</div>
</body>
</html>