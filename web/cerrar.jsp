<%-- 
    Document   : cerrar
    Created on : 18/04/2012, 11:07:33 AM
    Author     : jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
%>

<html>
    <head>
        <META HTTP-EQUIV='Refresh' content='3; url=index.jsp'>
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel='stylesheet' type='text/css' href='Styles/StylesCierre.css'/> 
        <link rel='stylesheet' type='text/css' href='Styles/StylesComunes.css'/>
        <title>Sesión finalizada</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div class='TEXTOCIERRE'>
            Ha abandonado la sesión, para ingresar de nuevo presione <a href="index.jsp">aquí</a>.
        </div>
        <br><br><br><br><br><br><br><br><br><br><br>
        <jsp:include page="footer.jsp" />     
    </body>
</html>
           


