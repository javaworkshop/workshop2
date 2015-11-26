<%-- 
    Document   : BestellingToevoegen
    Created on : 18-nov-2015, 20:52:43
    Author     : Sander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
        <jsp:include page="include/TopMenu.jsp" />
        
        <section>
            <jsp:include page="include/BestellingMenu.jsp" />
            
            <div class="content">
                <h2>Bestelling Toevoegen</h2>
                <p>Klant aanmaken? Eerst naar 'Klant toevoegen'</p>
                <p>En via via Klant Toevoegen naar dit scherm terug</p>
                <p>Klant wil niet toegevoegd worden, dan alleen klantid genereren</p>
                <br>
                <p>Vul gegevens van bestelling in</p>
                <p>Sla bestelling op, voeg toe aan order</p>
                <p>Voeg extra bestelling op tot alles erin staat</p>

            </div>
        </section>
    </body>
</html>
