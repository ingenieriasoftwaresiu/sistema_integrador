<%-- 
    Document   : cargo
    Created on : 10-jul-2012, 20:37:46
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.GestionSQL"%>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosCargo = null;
    
     if ((strNombre == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
         if (strAccion.equals("V")){
            strDatosCargo = GestionSQL.getFila("select c.txtIdentificacion as Id, c.txtNombre as Nombre from users_cargos c where c.txtIdentificacion = '" + strCodigo + "'");
        }
     }           
%>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="../Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesCargos.css" />
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSComunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSCargos.js"></script>
        <title>Administración de Usuarios: Gestión de Cargos</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header_Users.jsp" />
        <div align="center">
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE CARGO</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmCargo" name="frmCargo">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmCargo">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;"></td>
                                        <td class="LABELFORM">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;"></td>
                                     </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormCargo()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormCargo()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE CARGO</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmCargo" name="frmCargo">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmCargo">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strDatosCargo[0]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" value="<%=strDatosCargo[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;" readonly></td>
                                        <td class="LABELFORM">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosCargo[1]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;"></td>
                                    </tr>    
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <% if (strAccion.equals("C")){%>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormCargo()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormCargo()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <%}else{%>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormCargo()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <%}%>                                        
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
