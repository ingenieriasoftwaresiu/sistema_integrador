<%-- 
    Document   : cargo
    Created on : 10-jul-2012, 20:37:46
    Author     : George
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.GestionSQL"%>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosServicio = null;
    Vector arrCedulas = new Vector();
    Vector arrNombres = new Vector();
    Vector arrCodigosP = new Vector();
    Vector arrNombresP = new Vector();
    String[] strTemp = null;
    
     if ((strNombre == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
                
        Vector arrProcesos = GestionSQL.consultaSQL("select p.txtCodigo as Id, p.txtNombre as Nombre from users_procesos p ORDER BY p.txtNombre","MAESTROS");
        
        for(int i=0;i<arrProcesos.size();i++){
            strTemp = arrProcesos.get(i).toString().split(",");
            arrCodigosP.add(strTemp[0]);
            arrNombresP.add(strTemp[1]);
        }
        
         if (strAccion.equals("V")){
            strDatosServicio = GestionSQL.getFila("select s.txtCodigo, s.txtNombre, s.txtProceso from users_servicios s where s.txtCodigo = '" + strCodigo + "'");
        }
     }           
%>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="../Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesServicios.css" />
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSComunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSServicios.js"></script>
        <title>Administración de Usuarios: Gestión de Servicios</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header_Users.jsp" />
        <div align="center">
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE SERVICIO</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmServicio" name="frmServicio">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmServicio">
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
                                     <tr>                                         
                                        <td class="LABELFORM">* Proceso asociado:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtProceso" id="txtProceso" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigosP.size();i++){%>
                                                 <option value="<%=arrCodigosP.get(i)%>"><%=arrNombresP.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                     </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormServicio()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormServicio()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE SERVICIO</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmServicio" name="frmServicio">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmServicio">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strDatosServicio[0]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" value="<%=strDatosServicio[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;" readonly></td>
                                        <td class="LABELFORM">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosServicio[1]%>" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;"></td>
                                    </tr>    
                                    <tr>                                         
                                        <td class="LABELFORM">* Proceso asociado</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtProceso" id="txtProceso" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 230px;">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigosP.size();i++){%>
                                                 <option value="<%=arrCodigosP.get(i)%>"><%=arrNombresP.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtProceso");
                                                element.value = "<%=strDatosServicio[2].toString()%>";                                                
                                            </script>
                                        </td>
                                     </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>                                    
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormServicio()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
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
