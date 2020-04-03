<%-- 
    Document   : rol
    Created on : 19/04/2012, 02:13:44 PM
    Author     : jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String strFirma = "";
    String strCadena = null;
    String[] strDatosGenerales = null;
    String[] arrCadena = null;
    
     if (strAccion == null){
                response.sendRedirect("../cerrar.jsp");
     }else{
        
        strDatosGenerales = GestionSQL.getFila("SELECT g.txtNroRegXPagina FROM users_generales g where g.txtCodigo = 'frmGeneral'");
        
        if (strDatosGenerales == null){
            strAccion = "C";
        }else{
            strAccion = "V";          
        }
     }    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">           
        <link rel="SHORTCUT ICON" href="../Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesGenerales.css" />
        <script type="text/javascript" src="../Scripts/JSAjax.js"></script>
        <script type="text/javascript" src="../Scripts/JSComunes.js"></script>
        <script type="text/javascript" src="../Scripts/JSGenerales.js"></script>
        <title>Administración: Crear Parámetros Generales</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header_Users.jsp" />
        <div align="center">            
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE PARÁMETROS GENERALES</td>
                    </tr>                    
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmGeneral" name="frmGeneral">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmGeneral">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">                         
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM" style="width: 200px;">* Número de registros por página:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNroRegXPag" id="txtNroRegXPag" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td colspan="2" style="height: 10px;"></td>
                                    </tr>                                    
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>                                            
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormGeneral()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormGeneral()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE PARÁMETROS GENERALES</td>
                    </tr>
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmGeneral" name="frmGeneral">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmGeneral">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">                                
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Número de registros por página:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNroRegXPag" id="txtNroRegXPag" value="<%=strDatosGenerales[0]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>                                    
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormGeneral()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}%>
            <br><br>
            <div id="dMensaje">                
            </div>
        </div>
        <div style="padding-top: 60px;"></div>			
        <jsp:include page="footer_users.jsp" />	
    </body>
</html>
