<%-- 
    Document   : KlantToevoegenPage
    Created on : 5-okt-2015, 14:31:06
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Klant Toevoegen</h1>
        <h2>Vul klant attributen in en klik op knop toevoegen</h2>
        <form>
            voornaam:<br/>
            <input type="text" name="voornaam"/>
            <br/><br/>
            achternaam:<br/>
            <input type="text" name="achternaam"/>
            <br><br>
            <input type="submit" value="Voeg Toe">
        </form>
        <br/>
        <h2><a href="KlantHomePage.html"><<< Terug</a></h2>
    </body>
</html>
