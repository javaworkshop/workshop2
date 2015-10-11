<%-- 
    Document   : KlantToevoegenPage
    Created on : 5-okt-2015, 14:31:06
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    </head>
    <body>
        <jsp:include page="include/TopMenu.jsp" />
        <jsp:include page="include/KlantMenu.jsp" />
        <section>
            <h2>Klant Toevoegen</h2>
            <h3>Vul klant attributen in en klik op knop toevoegen</h3>
            <form>
                voornaam:<br/>
                <input type="text" name="voornaam"/>
                <br/><br/>
                achternaam:<br/>
                <input type="text" name="achternaam"/>
                <br><br>
                <input type="submit" value="Voeg Toe">
            </form>
        </section>
    </body>
</html>
