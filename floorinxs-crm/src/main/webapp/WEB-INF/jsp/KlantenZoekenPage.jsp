<%-- 
    Document   : KlantenZoekenPage
    Created on : 5-okt-2015, 14:33:15
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
            <h2>Klanten Zoeken</h2>
            <p>Zoek op klantgegevens of bekijk alle op dit moment in de database
                aanwezige klantdata door alle velden leeg te laten.</p>
            
            <form method="POST" action="/floorinxs-crm/KlantenZoekenPage" class="klantform">
                <ul class="formlist">
                    <li>
                        <label for="id" name="id">ID:</label>
                        <input name="id" id="id" type="text"/>
                    </li>                    
                </ul>
                <div class="formbutton">
                    <input type="submit" value="Zoeken"/>
                </div>
            </form>
            
            <p class="error">${error}</p>
        </section>
    </body>
</html>