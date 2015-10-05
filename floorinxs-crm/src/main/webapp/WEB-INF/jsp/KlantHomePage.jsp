<%-- 
    Document   : CustomerPage
    Created on : 1-okt-2015, 15:54:32
    Author     : Maarten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
        <!-- <link rel="stylesheet" href="style.css"> Kunnen we de boel mooi maken als we tijd over hebben-->
    </head>
    <body>
        <h1>Kies een actie</h1>
        <h2>Dynamische content: ${name}</h2>
        <h2><a href="KlantToevoegenPage.html">Klant toevoegen</a></h2>
        <h2><a href="KlantAanpassenPage.html">Klant aanpassen</a></h2>
        <h2><a href="KlantVerwijderenPage.html">Klant verwijderen</a></h2>
        <h2><a href="KlantenZoekenPage.html">Klanten zoeken</a></h2>
    </body>
</html>
