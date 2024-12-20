<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Progression d'un colis</title>
</head>
<body>
<h1>Modifier la progression d'un colis</h1>

<c:if test='${success}'>
    <p>Le colis a bien été modifié !</p>
</c:if>

<c:if test='${colis != null}'>
    <form action="${pageContext.request.contextPath}/progressionColis/${colis.identifiant}" method="POST">
        <div>
            <label for="latitude">Latitude :</label>
            <input type="text" id="latitude" name="latitude" value="${colis.latitude}" required>
        </div>
        <div>
            <label for="longitude">Longitude :</label>
            <input type="text" id="longitude" name="longitude" value="${colis.longitude}" required>
        </div>
        <div>
            <label for="emplacement">Emplacement :</label>
            <input type="text" id="emplacement" name="emplacement" value="${colis.emplacement}" required>
        </div>
        <div>
            <label for="etat">État :</label>
            <select id="etat" name="etat" required>
                <option value="enregistrement" <c:if test="${colis.etat == 'enregistrement'}">selected</c:if>>
                    Enregistrement
                </option>
                <option value="en attente" <c:if test="${colis.etat == 'en attente'}">selected</c:if>>En attente</option>
                <option value="en acheminement" <c:if test="${colis.etat == 'en acheminement'}">selected</c:if>>En
                    acheminement
                </option>
                <option value="bloqué" <c:if test="${colis.etat == 'bloqué'}">selected</c:if>>Bloqué</option>
                <option value="livré" <c:if test="${colis.etat == 'livré'}">selected</c:if>>Livré</option>
            </select>
        </div>

        <button type="submit">Confirmer</button>
    </form>
</c:if>

<c:if test='${colis == null}'>
    Colis non trouvé
</c:if>
</body>
</html>