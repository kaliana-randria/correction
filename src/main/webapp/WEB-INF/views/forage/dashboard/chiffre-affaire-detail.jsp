<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container mt-4">

    <h2 class="text-center">Chiffre d'affaire par type de devis</h2>

    <ul class="list-group">

        <c:forEach var="d" items="${details}">
            <li class="list-group-item d-flex justify-content-between">
                <span>${d[0]}</span>
                <span>
                    <fmt:formatNumber value="${d[1]}" type="number"/> Ar
                </span>
            </li>
        </c:forEach>

    </ul>

    <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">
            Retour
        </a>
    </div>

</div>