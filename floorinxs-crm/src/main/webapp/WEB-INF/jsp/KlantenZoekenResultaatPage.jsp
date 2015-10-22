<%-- 
    Document   : KlantenZoekenResultaatPage
    Created on : 14-okt-2015, 10:31:26
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
      <jsp:include page="include/TopMenu.jsp"/>
      
        <section>
          <jsp:include page="include/KlantMenu.jsp"/>          
          
          <div class="content">
            <h2>Zoekresultaten</h2>
            <table class="zoekresultaten">
              <tr>
                <th>ID</th>
                <th>Voornaam</th>
                <th>Achternaam</th>
                <th>E-Mail</th>
                <th>Adressen</th>
                <th>Rekeninghouder</th>
                <th>IBAN</th>
                <th>Offertes</th>
                <th>Facturen</th>
              </tr>
              <c:forEach items="${klanten}" var="klant" varStatus="loopCounter">
                <tr>
                  <td>${klant.id}</td>
                  <td>${klant.voornaam}</td>
                  <td>${klant.achternaam}</td>
                  <td>${klant.emailadres}</td>
                  <td><select class="tabledata">
                      <option selected hidden>Toon adressen</option>
                      <c:forEach items="${klant.adressen}" var="adres" varStatus="innerLoopCounter">
                          <option disabled>Adres${innerLoopCounter.count}</option>
                          <option> &nbsp;${adres.straatnaam} ${adres.huisnummer}</option>
                          <option> &nbsp;${adres.postcode}</option>
                          <option> &nbsp;${adres.woonplaats}</option>
                      </c:forEach>
                  </select></td>
                  <td>${klant.rekeninggegevens.rekeninghouder}</td>
                  <td>${klant.rekeninggegevens.iban}</td>
                  <td><a href="klant${klant.id}offertes">k${klant.id} offertes</a></td>
                  <td><a href="klant${klant.id}facturen">k${klant.id} facturen</a></td>
                </tr>
              </c:forEach>
            </table>
          </div>
      </section>
    </body>
</html>
