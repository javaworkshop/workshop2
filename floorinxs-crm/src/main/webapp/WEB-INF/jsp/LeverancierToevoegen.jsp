<%-- 
    Document   : LeverancierToevoegen
    Created on : Nov 9, 2015, 11:08:14 AM
    Author     : gerbrich2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/Head.jsp" />
    <body>
         <jsp:include page="include/TopMenu.jsp" /> 
         
         <section>
           <jsp:include page="include/LeverancierMenu.jsp" /> 
           
             <div class="content">
        <p>Vul het forumulier in en klik daarna op toevoegen om een nieuwe leverancier toe te voegen.</p>
                        <form:form method="POST" modelAttribute="leveranciertv" action="/floorinxs-crm/LeverancierToevoegen" class="leverancierform">
                    <ul class="formlist">
                        <li>
                            <form:label path="bedrijfsnaam">Bedrijfsnaam:</form:label>
                            <form:input path="bedrijfsnaam" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="contactPersoon">ContactPersoon</form:label>
                            <form:input path="contactPersoon" type="text" class="required"/>
                        </li>
                        <li>
                            <form:label path="emailAdres">EmailAdres</form:label>
                            <form:input path="emailAdres" type="text" class="required"/>
                        </li>
                    </ul>
                    <div class="formbutton">
                        <input type="submit" value="Toevoegen"/>
                    </div>
                </form:form>
                <p>${feedback}${id}</p>
             </div>
         </section>>
    </body>
</html>
