<%-- 
    Document   : aplicacion
    Created on : 12-jul-2012, 18:31:14
    Author     : George
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.GestionSQL"%>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosApps = null;
    Vector arrCedulas = new Vector();
    Vector arrNombres = new Vector();
    
     if ((strNombre == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
        
        Vector arrUsuarios = GestionSQL.consultaSQL("select p.txtIdentificacion as Id, p.txtNombreCompleto as Nombre from users_personas p where p.txtEstadoActual = 'A' ORDER BY p.txtNombreCompleto","MAESTROS");
        String[] strTemp = null;

        for (int i=0;i<arrUsuarios.size();i++){
            strTemp = arrUsuarios.get(i).toString().split(",");
            arrCedulas.add(strTemp[0]);
            arrNombres.add(strTemp[1]);
        }
        
        if (strAccion.equals("V")){
            strDatosApps = GestionSQL.getFila("select app.txtCodigo, app.txtNombre, app.txtDescripcion, app.txtResponsable, app.txtUrlAcceso from users_apps app where app.txtCodigo = '" + strCodigo + "'");
        }
     }           
%>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesAplicaciones.css" />
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSComunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAplicaciones.js"></script>
        <title>Administración: Gestión de Aplicaciones</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header.jsp" />
        <div align="center">
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE APLICACIÓN</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmAplicacion" name="frmAplicacion">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmAplicacion">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM" style="width: 150px;">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;"></td>
                                        <td class="LABELFORM" style="width: 150px;">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;"></td>
                                     </tr>
                                     <tr>
                                        <td class="LABELFORM">* Responsable:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtResponsable" id="txtResponsable" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCedulas.size();i++){%>
                                                    <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">* URL de acceso:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtUrlAcceso" id="txtUrlAcceso" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;"></td>
                                     </tr>
                                     <tr>
                                        <td class="LABELFORM">* Descripción:</td>
                                        <td colspan="3" class="CELDACAMPOFORM"><input type="text" name="txtDescripcion" id="txtDescripcion" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 600px;"></td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormAplicacion()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormAplicacion()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE APLICACIÓN</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmAplicacion" name="frmAplicacion">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmAplicacion">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strDatosApps[0]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM" style="width: 150px;">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" value="<%=strDatosApps[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;" readonly></td>
                                        <td class="LABELFORM" style="width: 150px;">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosApps[1]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;"></td>
                                     </tr>
                                     <tr>
                                        <td class="LABELFORM">* Responsable:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtResponsable" id="txtResponsable" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCedulas.size();i++){%>
                                                 <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtResponsable");
                                                element.value = "<%=strDatosApps[3].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">* URL de acceso:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtUrlAcceso" id="txtUrlAcceso" value="<%=strDatosApps[4]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 210px;"></td>
                                     </tr>
                                     <tr>
                                        <td class="LABELFORM">* Descripción:</td>
                                        <td colspan="3" class="CELDACAMPOFORM"><input type="text" name="txtDescripcion" id="txtDescripcion" value="<%=strDatosApps[2]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 600px;"></td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormAplicacion()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
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
        <div style="padding-top: 80px;"></div>			
        <jsp:include page="footer.jsp" />	
    </body>
</html>
