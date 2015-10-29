<%-- 
    Document   : KlantVerwijderenPage
    Created on : 5-okt-2015, 14:33:05
    Author     : Maarten
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
        <jsp:include page="include/TopMenu.jsp" />        

        <section>
            <jsp:include page="include/KlantMenu.jsp" />
            
            <div class="content">
                <h2>Klant Verwijderen</h2>
                <p>Haal klantgegevens op door id in te vullen. Vervolgens kan
                deze klant verwijderd worden.</p>
                <form method="POST" action="/floorinxs-crm/KlantVerwijderenPage/resultaat?adresno=0">
                    <label for="id" name="id">ID:</label>
                    <input name="id" id="id" type="text"/>
                    <div class="formbutton">
                        <input type="submit" value="zoeken"/>
                    </div>
                </form>
                <c:if test="${not empty klant}">
                    <div class="textcolumn">
                        <div class="label"><strong>ID:</strong></div>
                        <div class="value">${klant.id}</div>
                        </br>
                        <div class="label"><strong>Voornaam:</strong></div>
                        <div class="value">${klant.voornaam}</div>
                        </br>
                        <div class="label"><strong>Achternaam:</strong></div>
                        <div class="value">${klant.achternaam}</div>
                        </br>
                        <div class="label"><strong>Email:</strong></div>
                        <div class="value">${klant.emailadres}</div>
                    </div>
                    <div class="textcolumn">
                      <c:forEach items="${klant.adressen}" var="adres" begin="${adresno}" end="${adresno + 1}">
                        <div class="label"><strong>Straatnaam:</strong></div>
                        <div class="value">${adres.straatnaam}</div>
                        </br>
                        <div class="label"><strong>Huisnummer:</strong></div>
                        <div class="value">${adres.huisnummer}</div>
                        </br>
                        <div class="label"><strong>Postcode:</strong></div>
                        <div class="value">${adres.postcode}</div>
                        </br>
                        <div class="label"><strong>Woonplaats:</strong></div>
                        <div class="value">${adres.woonplaats}</div>
                        <c:if test="${fn:length(klant.adressen) > adresno + 1}">
                            <span><a href="resultaat?adresno=${adresno + 1}">>></a></span>
                        </c:if>
                        <c:if test="${adresno > 0}">
                            <span><a href="resultaat?adresno=${adresno - 1}"><<</a></span>
                        </c:if>
                      </c:forEach>
                    </div>
                    <div class="textcolumn">
                        <div class="label"><strong>IBAN:</strong></div>
                        <div class="value">${klant.rekeninggegevens.iban}</div>
                        </br>
                        <div class="label"><strong>Rekeninghouder:</strong></div>
                        <div class="value">${klant.rekeninggegevens.rekeninghouder}</div>
                    </div>
                    <form method="POST" action="/floorinxs-crm/KlantVerwijderenPage/verwijderen">
                        <div class="formbutton">
                            <input type="submit" value="verwijderen"/>
                        </div>
                    </form>
                </c:if>
                <p class="error">${error}</p>
                <p>${feedback}</p>
            </div>
        </section>
    </body>
</html>

