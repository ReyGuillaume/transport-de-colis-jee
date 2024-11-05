<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <title>Enregistrer un colis</title>
</head>
<body>
<h1>Enregistrer un colis</h1>

<c:if test='${colis != null}'>
    <p>Le colis <strong>${colis.identifiant}</strong> a bien été créé !</p>
</c:if>

<form action="${pageContext.request.contextPath}/enregistrerColis" method="post">
    <div>
        <label for="identifiant">Identifiant :</label>
        <input type="text" id="identifiant" name="identifiant" required>
    </div>
    <div>
        <label for="poids">Poids (kg) :</label>
        <input type="number" id="poids" name="poids" step="0.01" required>
    </div>
    <div>
        <label for="valeur">Valeur (€) :</label>
        <input type="number" id="valeur" name="valeur" step="0.01" required>
    </div>
    <div>
        <label for="origine">Origine :</label>
        <input type="text" id="origine" name="origine" required>
    </div>
    <div>
        <label for="destination">Destination :</label>
        <input type="text" id="destination" name="destination" required>
    </div>
    <div>
        <label for="latitude">Latitude :</label>
        <input type="text" id="latitude" name="latitude" required>
    </div>
    <div>
        <label for="longitude">Longitude :</label>
        <input type="text" id="longitude" name="longitude" required>
    </div>
    <div>
        <label for="emplacement">Emplacement :</label>
        <input type="text" id="emplacement" name="emplacement" required>
    </div>

    <button type="submit">Confirmer</button>
</form>
</body>
</html>