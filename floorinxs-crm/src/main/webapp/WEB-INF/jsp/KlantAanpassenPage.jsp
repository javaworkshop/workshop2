<%-- 
    Document   : KlantAanpassenPage
    Created on : 5-okt-2015, 14:32:54
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
  <jsp:include page="include/Head.jsp" />
    <body>
        <jsp:include page="include/TopMenu.jsp" />        

        <section>
            <jsp:include page="include/KlantMenu.jsp" />
            
            <div class="content">
                <h2>Klant Aanpassen</h2>
                <p>Haal klantgegevens op door id in te vullen. Vervolgens kan
                de opgehaalde klant aangepast worden. Druk op knop 'Klant 
                Aanpassen' om veranderingen in de database op te slaan.</p>
                <form method="POST" action="/floorinxs-crm/KlantAanpassenPage/resultaat?adresno=0">
                    <label for="id" name="id">ID:</label>
                    <input name="id" id="id" type="text"/>
                    <div class="formbutton">
                        <input type="submit" value="zoeken"/>
                    </div>
                </form>
                <c:if test="${not empty klantap}">
                    <div id="klantgegevens">
                        <form:form method="POST" modelAttribute="klantap" action="/floorinxs-crm/KlantAanpassenPage/aanpassen" class="klantform">                        
                            <ul class="formlist">
                                <li>
                                    <div class="label"><strong>ID:</strong></div>
                                    <div class="value">${klantap.id}</div>
                                </li>
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
                                    <form:label path="iban">IBAN:</form:label>
                                    <form:input path="iban" type="text" class="required"/>
                                </li>
                                <li>
                                    <form:label path="rekeninghouder">Rekeninghouder:</form:label>
                                    <form:input path="rekeninghouder" type="text" class="required"/>
                                </li>
                            </ul>
                            <div class="formbutton">
                                <input type="submit" value="Klant Aanpassen"/>
                            </div>
                        </form:form>
                    </div>
                        <div id="adressen">
                          <form method="POST" action="/floorinxs-crm/KlantAanpassenPage/adresaanpassen?adresno=${adresno}" class="klantform">
                            <ul class="formlist">
                              <c:forEach items="${klantap.klant.adressen}" var="adres" begin="${adresno}" end="${adresno}">
                                <li>
                                    <label for="straatnaam" name="straatnaam${adresno}">Straatnaam:</label>
                                    <input name="straatnaam${adresno}" id="straatnaam" type="text" value="${adres.straatnaam}"/>
                                </li>
                                <li>
                                    <label for="huisnummer" name="huisnummer${adresno}">Huisnummer:</label>
                                    <input name="huisnummer${adresno}" id="huisnummer" type="text" value="${adres.huisnummer}"/>
                                </li>
                                <li>
                                    <label for="postcode" name="postcode${adresno}">Postcode:</label>
                                    <input name="postcode${adresno}" id="postcode" type="text" value="${adres.postcode}"/>
                                </li>
                                <li>
                                    <label for="woonplaats" name="woonplaats${adresno}">Woonplaats:</label>
                                    <input name="woonplaats${adresno}" id="woonplaats" type="text" value="${adres.woonplaats}"/>
                                </li>
                                <c:if test="${fn:length(klantap.klant.adressen) > adresno + 1}">
                                    <span style='text-align: right'><a href="resultaat?adresno=${adresno + 1}">&gt;&gt;</a></span>
                                </c:if>
                                <c:if test="${adresno > 0}">
                                    <span style='text-align: left'><a href="resultaat?adresno=${adresno - 1}">&lt;&lt;</a></span>
                                </c:if>
                              </c:forEach>
                            </ul>
                            <div class="formbutton">
                                <input type="submit" value="Adres Aanpassen"/>
                            </div>
                          </form>
                        </div>
                        <div id="nieuwadres">
                          <form:form method="POST" modelAttribute="klantap" action="/floorinxs-crm/KlantAanpassenPage/adrestoevoegen?adresno=${adresno}" class="klantform">
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
                            <div class="formbutton">
                                <input type="submit" value="Adres Toevoegen"/>
                            </div>
                          </form:form>
                        </div>                          
                </c:if>
                <p class="error">${error}</p>
                <p>${feedback}</p>
            </div>
        </section>
            
    </body>
</html>
