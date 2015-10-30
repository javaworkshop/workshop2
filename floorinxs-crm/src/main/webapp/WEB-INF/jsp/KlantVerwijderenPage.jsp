<%-- 
    Document   : KlantVerwijderenPage
    Created on : 5-okt-2015, 14:33:05
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
                <c:if test="${not empty klantvw}">
                    <div class="textcolumn">
                        <div class="label"><strong>ID:</strong></div>
                        <div class="value">${klantvw.id}</div>
                        </br>
                        <div class="label"><strong>Voornaam:</strong></div>
                        <div class="value">${klantvw.voornaam}</div>
                        </br>
                        <div class="label"><strong>Achternaam:</strong></div>
                        <div class="value">${klantvw.achternaam}</div>
                        </br>
                        <div class="label"><strong>Email:</strong></div>
                        <div class="value">${klantvw.emailadres}</div>
                    </div>
                    <div class="textcolumn">
                      <c:forEach items="${klantvw.adressen}" var="adres" begin="${adresno}" end="${adresno + 1}">
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
                        <c:if test="${fn:length(klantvw.adressen) > adresno + 1}">
                            <span><a href="resultaat?adresno=${adresno + 1}">&gt;&gt;</a></span>
                        </c:if>
                        <c:if test="${adresno > 0}">
                            <span><a href="resultaat?adresno=${adresno - 1}">&lt;&lt;</a></span>
                        </c:if>
                      </c:forEach>
                    </div>
                    <div class="textcolumn">
                        <div class="label"><strong>IBAN:</strong></div>
                        <div class="value">${klantvw.rekeninggegevens.iban}</div>
                        </br>
                        <div class="label"><strong>Rekeninghouder:</strong></div>
                        <div class="value">${klantvw.rekeninggegevens.rekeninghouder}</div>
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

