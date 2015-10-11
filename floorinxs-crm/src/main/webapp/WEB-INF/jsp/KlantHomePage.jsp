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
        <title>Klantgegevens</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    </head>
    <body>
        <jsp:include page="include/TopMenu.jsp" />
        <jsp:include page="include/KlantMenu.jsp" />

        <section>
            <h2>Kies een actie</h2>
            <h3>Dynamische content: ${name}</h3>
        </section>
    </body>
</html>
