<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <title>Suivre un colis</title>
</head>
<body>
    <h1>Suivre un colis</h1>

    <jsp:useBean id="colis" scope="request" type="fr.usmb.jee.transportcolis.Colis"/>
    <c:if test="${colis != null}">
        <p>Identifiant : ${colis.identifiant}</p>
        <p>Poids : ${colis.poids}</p>
        <p>Valuer : ${colis.valeur}</p>
        <p>Origine : ${colis.origine}</p>
        <p>Destination : ${colis.destination}</p>

        <p>Latitude : ${colis.latitude}</p>
        <p>Longitude : ${colis.longitude}</p>
        <p>Emplacement : ${colis.emplacement}</p>
        <p>Etat : ${colis.etat}</p>
    </c:if>

    <c:if test="${colis == null}">
        <p>Ce coli n'a pas été trouvé. Essayez avec un autre identifiant.</p>
    </c:if>

</body>
</html>