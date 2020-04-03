<%-- 
    Document   : index
    Created on : 06-jul-2012, 14:09:01
    Author     : Jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styles/StylesLogin.css" />
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <script type="text/javascript" src="Scripts/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSComunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSLogin.js"></script>        
        <title>Sistema de Información Integrador de Aplicaciones - OSIU -</title>
    </head>
    <body onLoad="cargaBody()">
        <jsp:include page="Header.jsp" />
        <div style="padding-top: 50px;"></div>
        <div align="center">            
            <div style="padding-top: 30px;"></div>
            <form id="frmLogin" name="frmLogin" method="POST" action="Ingreso">
                    <table cellspacing="0" cellpadding="0" width="280px" class="TABLAFORM" border="0">                        
                        <tr>
                                <td colspan="2" style="text-align: center;" class="TITULOFORM">INICIO DE SESIÓN</td>				
                        </tr>                   
                        <tr>
                                <td class="LABELFORM">Usuario:</td>
                                <td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM" onFocus="hideAjaxMsg('dMensaje')"></td>
                        </tr>
                        <tr>
                                <td class="LABELFORM">Contraseña:</td>
                                <td class="CELDACAMPOFORM"><input type="password" name="txtPwd" id="txtPwd" class="CAMPOFORM" onFocus="hideAjaxMsg('dMensaje')"></td>
                        </tr>
                        <tr>
                                <td colspan="2" class="CELDABOTONFORM">
                                    <input type="button" value="Ingresar" id="btnIngresar" class="BOTONFORM" onclick="return validarFormLogin()">&nbsp;&nbsp;
                                    <input type="button" value="Limpiar" id="btnLimpiar" class="BOTONFORM" onclick="limpiarFormLogin()">
                                </td>		
                        </tr>
                    </table>				
            </form>
            <br /><br />
            <div id="dMensaje" class="TEXTOFALLO">                
            </div>
        </div>  
        <br /><br />
        <div align="center" class="MSGBROWSER">
            <<< Para una mejor visualización, se recomienda utilizar <b>Mozilla Firefox</b> o <b>Google Chrome</b> en una resolución superior 1024 x 768. >>>
        </div>
        <div style="padding-top: 30px;"></div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
