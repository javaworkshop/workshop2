<%-- 
    Document   : CustomerPage
    Created on : 1-okt-2015, 15:54:32
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM FloorInXs</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    </head>
    <body>
        <jsp:include page="include/TopMenu.jsp" />
        <jsp:include page="include/KlantMenu.jsp" />

        <section>
            <h2>Klantgegevens</h2>
            <p>Kies gewenste actie in het linkermenu om klantgegevens te beijken
            en/of te bewerken.</p>
        </section>
    </body>
</html>
