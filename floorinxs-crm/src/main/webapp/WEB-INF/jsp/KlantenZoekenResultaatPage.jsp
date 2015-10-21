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
            <table>
              <tr>
                <th>Voornaam</th>
                <th>Achternaam</th>
              </tr>
              <c:forEach items="${klanten}" var="klant">
                <tr>
                  <td><c:out value="${klant.voornaam}"/></td>
                  <td><c:out value="${klant.achternaam}"/></td>
                </tr>
              </c:forEach>
            </table>
          </div>
      </section>
    </body>
</html>
