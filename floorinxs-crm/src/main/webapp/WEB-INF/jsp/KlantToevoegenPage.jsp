<%-- 
    Document   : KlantToevoegenPage
    Created on : 5-okt-2015, 14:31:06
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
        <jsp:include page="include/TopMenu.jsp" />
        
        <section>
            <jsp:include page="include/KlantMenu.jsp" />
            
            <div class="content">
                <h2>Klant Toevoegen</h2>
                <p>Vul klant attributen in en klik op knop 'Toevoegen'.</p>
                <form:form method="POST" modelAttribute="klanttv" action="/floorinxs-crm/KlantToevoegenPage" class="klantform">
                    <ul class="formlist">
                        <li>
                            <form:label path="voornaam">Voornaam:</form:label>
                            <form:input path="voornaam" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="achternaam" >Achternaam:</form:label>
                            <form:input path="achternaam" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="emailadres">Email:</form:label>
                            <form:input path="emailadres" type="text" class="required"/>
                        </li>
                    </ul>
                    <ul class="formlist">
                        <li>
                            <form:label path="straatnaam">Straatnaam:</form:label>
                            <form:input path="straatnaam" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="huisnummer">Huisnummer:</form:label>
                            <form:input path="huisnummer" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="postcode">Postcode:</form:label>
                            <form:input path="postcode" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="woonplaats">Woonplaats:</form:label>                        
                            <form:input path="woonplaats" type="text" class="required"/>
                        </li>
                    </ul>
                    <ul class="formlist">
                        <li>
                            <form:label path="iban">IBAN:</form:label>
                            <form:input path="iban" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="rekeninghouder">Rekeninghouder:</form:label>
                            <form:input path="rekeninghouder" type="text" class="required"/>
                        </li>
                    </ul>
                    <div class="formbutton">
                        <input type="submit" value="Toevoegen"/>
                    </div>
                </form:form>
                <p>${feedback}${id}</p>
            </div>
        </section>
    </body>
</html>
