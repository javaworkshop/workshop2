<%-- 
    Document   : CustomerPage
    Created on : 1-okt-2015, 15:54:32
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
        <jsp:include page="include/TopMenu.jsp" />        

        <section>
            <jsp:include page="include/KlantMenu.jsp" />
            
            <div class="content">
                <h2>Klantgegevens</h2>
                <p>Kies gewenste actie in het linkermenu om klantgegevens te bekijken
                en/of te bewerken.</p>
            </div>
        </section>
            
    </body>
</html>
