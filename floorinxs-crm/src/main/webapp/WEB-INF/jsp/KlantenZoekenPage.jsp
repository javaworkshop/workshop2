<%-- 
    Document   : KlantenZoekenPage
    Created on : 5-okt-2015, 14:33:15
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
                <h2>Klanten Zoeken</h2>
                <p>Zoek op klantgegevens of bekijk alle op dit moment in de database
                    aanwezige klantdata door alle velden leeg te laten.</p>

                <form method="POST" action="/floorinxs-crm/KlantenZoekenPage" class="klantform">
                    <ul class="formlist">
                        <li>
                            <label for="id" name="id">ID:</label>
                            <input name="id" id="id" type="text"/>
                        </li>
                        <li>
                            <label for="voornaam" name="voornaam">Voornaam:</label>
                            <input name="voornaam" id="voornaam" type="text"/>
                        </li>
                        <li>
                            <label for="achternaam" name="achternaam">Achternaam:</label>
                            <input name="achternaam" id="achternaam" type="text"/>
                        </li>
                        <li>
                            <label for="emailadres" name="emailadres">Email:</label>
                            <input name="emailadres" id="emailadres" type="text"/>
                        </li>
                    </ul>
                    <ul class="formlist">
                        <li>
                            <label for="straatnaam" name="straatnaam">Straatnaam:</label>
                            <input name="adres.straatnaam" id="straatnaam" type="text"/>
                        </li>
                        <li>
                            <label for="huisnummer" name="huisnummer">Huisnummer:</label>
                            <input name="adres.huisnummer" id="huisnummer" type="text"/>
                        </li>
                        <li>
                            <label for="postcode" name="postcode">Postcode:</label>
                            <input name="adres.postcode" id="postcode" type="text"/>
                        </li>
                        <li>
                            <label for="woonplaats" name="woonplaats">Woonplaats:</label>
                            <input name="adres.woonplaats" id="woonplaats" type="text"/>
                        </li>
                    </ul>
                    <div class="formbutton">
                        <input type="submit" value="Zoeken"/>
                    </div>
                </form>

                <p class="error">${error}</p>
            </div>
        </section>
    </body>
</html>