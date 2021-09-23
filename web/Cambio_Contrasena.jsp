<%-- 
    Document   : Cambio_Contrasena
    Created on : 25-jul-2013, 15:19:28
    Author     : jorge.correaj
--%>
<%
    //Recuperando los parámetros de la sesión actual.

    String strNombre = (String) session.getAttribute("strNombre");        
    String strUsuario = (String) session.getAttribute("strUsuario");  
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSComunes.js"></script>
        <title>Cambio de contraseña</title>
    </head>
    <body style="margin-top: 10px" onLoad="onLoad();">
        <div align="center">
            <form action="POST" id="frmCambioPwd" name="frmCambioPwd">
                <input type="hidden" value="<%=strUsuario%>" name="txtUsuario">
                <table cellpadding="0" cellspacing="0" border="0" width="280px;" class="TABLACAMBIO">
                    <tr>
                        <td class="TITULOCAMBIO" colspan="2">CAMBIO DE CONTRASEÑA</td>
                    </tr>
                    <tr>
                        <td class="LABEL">Nombre de usuario:</td>
                        <td style="width: 140px;" class="CELDACAMPO">
                            <input type="text" value="<%=strNombre%>" class="CAMPOR" readOnly>
                        </td>
                    </tr>
                    <tr>
                        <td class="LABEL">Contraseña actual:</td>
                        <td class="CELDACAMPO">
                            <input type="password" name="txtPwdActual" id="txtPwdActual" class="CAMPOW" onclick="ocultarDIV();">
                        </td>
                    </tr>
                    <tr>
                        <td class="LABEL">Contraseña nueva:</td>
                        <td class="CELDACAMPO">
                            <input type="password" name="txtPwdNueva1" id="txtPwdNueva1" class="CAMPOW" onclick="ocultarDIV();">
                        </td>
                    </tr>
                    <tr>
                        <td class="LABEL">Repetir contraseña nueva:</td>
                        <td class="CELDACAMPO">
                            <input type="password" name="txtPwdNueva2" id="txtPwdNueva2" class="CAMPOW" onclick="ocultarDIV();">
                        </td>
                    </tr>
                    <tr><td style="height: 10px;"></td></tr>
                    <tr>
                        <td colspan="2" style="width: 100%;text-align: center;padding-bottom: 5px;"><input type="button" value="Enviar" class="BOTONFORM" onclick="validarCambioPwd();">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarForm();">&nbsp;&nbsp;<input type="button" value="Salir" onclick="javascript:window.close();" class="BOTONFORM"></td>                            
                    </tr>
                    <tr><td style="height: 10px;"></td></tr>
                </table>
            </form>
        </div>
        <br>
        <div id="dMensaje" align="center">            
        </div>
    </body>
</html>
