<%-- 
    Document   : appxpersona
    Created on : 12-jul-2012, 20:18:39
    Author     : George
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.GestionSQL"%>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosCargo = null;
    Vector arrCedulas = new Vector();
    Vector arrNombres = new Vector();
    Vector arrCodigos = new Vector();
    Vector arrAplicaciones = new Vector();
    String[] strTemp = null;
    
     if ((strNombre == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
        
        Vector arrPersonas = GestionSQL.consultaSQL("select p.txtIdentificacion as Id, p.txtNombreCompleto as Nombre from users_personas p where p.txtEstadoActual = 'A' ORDER BY p.txtNombreCompleto","MAESTROS");
        
        for (int i=0;i<arrPersonas.size();i++){
            strTemp = arrPersonas.get(i).toString().split(",");
            arrCedulas.add(strTemp[0]);
            arrNombres.add(strTemp[1]);
        }
        
        Vector arrApps = GestionSQL.consultaSQL("select a.txtCodigo as Id, a.txtNombre as Nombre from users_apps a ORDER BY a.txtNombre","MAESTROS");
  
        for (int i=0;i<arrApps.size();i++){
            strTemp = arrApps.get(i).toString().split(",");
            arrCodigos.add(strTemp[0]);
            arrAplicaciones.add(strTemp[1]);
        }
        
        if (strAccion.equals("V")){
            strTemp = strCodigo.split(",");
            strDatosCargo = GestionSQL.getFila("select app.txtNombre as Id, p.txtNombreCompleto as Nombre from users_appsxpersona apxp, users_apps app, users_personas p where (app.txtCodigo = apxp.txtApp) and (p.txtIdentificacion = apxp.txtPersona) and apxp.txtApp = '" + strTemp[0] + "' and apxp.txtPersona = '" + strTemp[1] + "'");
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
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAppsXPersonas.js"></script>
        <title>Administración: Gestión de Aplicaciones por Persona</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header.jsp" />
        <div align="center">
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE APLICACIÓN POR PERSONA</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmAppxPersona" name="frmAppxPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmAppxPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Aplicación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtAplicacion" id="txtAplicacion" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigos.size();i++){%>
                                                 <option value="<%=arrCodigos.get(i)%>"><%=arrAplicaciones.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">* Persona:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtPersona" id="txtPersona" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCedulas.size();i++){%>
                                                 <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                     </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormAppXPersona()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormAppXPersona()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE APLICACIÓN POR PERSONA</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmAppxPersona" name="frmAppxPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmAppxPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strTemp[0] + "," + strTemp[1]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Aplicación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtAplicacion" id="txtAplicacion" class="CAMPOFORM" onclick="ocultarDIV()" disabled="disabled" style="width:230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigos.size();i++){%>
                                                 <option value="<%=arrCodigos.get(i)%>"><%=arrAplicaciones.get(i)%></option>
                                                <%}%>                                               
                                            </select> 
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtAplicacion");
                                                element.value = "<%=strTemp[0].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">* Persona:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtPersona" id="txtPersona" class="CAMPOFORM" onclick="ocultarDIV()" disabled="disabled" style="width:230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCedulas.size();i++){%>
                                                 <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>                                               
                                            </select> 
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtPersona");
                                                element.value = "<%=strTemp[1].toString()%>";                                                
                                            </script>
                                        </td>
                                    </tr>    
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>                                               
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
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
