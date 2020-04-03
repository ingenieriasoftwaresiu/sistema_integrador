<%-- 
    Document   : admin
    Created on : 10-jul-2012, 14:08:05
    Author     : jorge.correa
--%>

<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String strCedula = (String) session.getAttribute("strCedula");
    String strNombre = (String) session.getAttribute("strNombre");    
    String[] strDatos = null;
    String strAdministrador = "N";
    
    if(strCedula == null){
        response.sendRedirect("../cerrar.jsp");
    }else{
        strDatos = GestionSQL.getFila("select p.txtAdministrador from users_personas p where p.txtIdentificacion = '" + strCedula + "'");

        strAdministrador = strDatos[0]; 

        if (strAdministrador == null){
            strAdministrador = "N";
        }

        strDatos = GestionSQL.getFila("select g.txtNroRegXPagina from users_generales g where g.txtCodigo = 'frmGeneral'");
    }
                 
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="../Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesAdmin.css" />
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSComunes.js"></script>
        <script type='text/javascript' charset="UTF-8" src='../Scripts/JSVisualizacion.js'></script>
        <script type="text/javascript">
            function disableKeyPress(evt){               
                var evt = (evt) ? evt : ((event) ? event : null); 
                var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
                if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
            }
        </script>
        <title>Sistema de Gestión de Usuarios OSIU</title>
    </head>
    <body onLoad ="onLoadBody()" OnKeyPress="return disableKeyPress(event)">
        <%
            if (strNombre == null){
                response.sendRedirect("../cerrar.jsp");
            }
        %>
        <jsp:include page="Header_Users.jsp" />
        <div align="center">            	   
            <br>
            <table cellspacing="0" cellpadding="0" width="1200px" border="0">
                <tr>
                    <td class="USERLOGED"><b>Bienvenido,</b> <%=strNombre%></td>                    
                    <td class="CIERRESESION"><input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td>                    
                </tr>
            </table>
            <br>
             <table cellspacing="0" cellpadding="0" width="1200px" border="0">
                <tr>
                    <td width="225px" style="vertical-align: text-top;">
                        <table cellspacing="0" cellpadding="7" width="225px" border="0" class="TABLAMENU">
                            <tr><td class="TITULOMENU" style="font-size: 15px;">MENÚ ADMINISTRATIVO</td></tr>
                            <tr><td class="SUBTITULOMENU">Parámetros del Sistema</td></tr>
                            <tr>
                                <td>
                                    <ul class="sidenav">
                                        <li class="ITEMMENU">
                                            <a href="#"> Redes
                                                <span onclick="javascript:window.open('red.jsp?txtAccion=C&txtCodigo=-1','Red','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nueva red</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=red','dMostrar');">Consultar redes</span>  
                                             </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#"> Cargos
                                                <span onclick="javascript:window.open('cargo.jsp?txtAccion=C&txtCodigo=-1','Cargo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo cargo</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=cargo','dMostrar');">Consultar cargos</span>  
                                             </a>
                                        </li>    
                                        <li class="ITEMMENU">
                                            <a href="#"> Centros de costos
                                                <span onclick="javascript:window.open('centro_costos.jsp?txtAccion=C&txtCodigo=-1','Centro_Costos','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo centro de costos</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=centro_costos','dMostrar');">Consultar centros de costos</span>  
                                             </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#"> Días no hábiles
                                                <span onclick="javascript:window.open('dia_no_habil.jsp?txtAccion=C&txtCodigo=-1','Dia_No_Habil','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo día no hábil</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=diasNoHabiles','dMostrar');">Consultar días no hábiles</span>  
                                             </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Estados civiles
                                                <span onclick="javascript:window.open('estadoCivil.jsp?txtAccion=C&txtCodigo=-1','Estado_Civil','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo estado civil</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=estadoC','dMostrar');">Consultar estados civiles</span>
                                            </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Medios de transporte
                                                <span onclick="javascript:window.open('medioTransporte.jsp?txtAccion=C&txtCodigo=-1','Medio_Transporte','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo medio de transporte</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=medioTrans','dMostrar');">Consultar medios de transporte</span>
                                            </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Tipos de contratación
                                                <span onclick="javascript:window.open('tipoContratacion.jsp?txtAccion=C&txtCodigo=-1','Tipo_Contratacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo tipo de contratación</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=tipoC','dMostrar');">Consultar tipos de contratación</span>
                                            </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Tipos de identificación
                                                <span onclick="javascript:window.open('tipoId.jsp?txtAccion=C&txtCodigo=-1','Tipo_Identificacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo tipo de identificación</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=tipoId','dMostrar');">Consultar tipos de identificación</span>
                                            </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Tipos de vivienda
                                                <span onclick="javascript:window.open('tipoVivienda.jsp?txtAccion=C&txtCodigo=-1','Tipo_Vivienda','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo tipo de vivienda</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=tipoV','dMostrar');">Consultar tipos de vivienda</span>
                                            </a>
                                        </li>
                                        <li class="ITEMMENU">
                                            <a href="#">Personas
                                                <span onclick="javascript:window.open('persona.jsp?txtAccion=C&txtCodigo=-1','Persona','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=1')">Crear nueva persona</span>
                                                <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=persona','dMostrar');">Consultar personas</span>
                                            </a>
                                        </li>        
                                        <li class="ITEMMENU">
                                                <a href="#"> Grupos
                                                    <span onclick="javascript:window.open('grupo.jsp?txtAccion=C&txtCodigo=-1','Grupo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo grupo</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=grupo','dMostrar');">Consultar grupos</span>  
                                                </a>
                                            </li>
                                            <li class="ITEMMENU">
                                                <a href="#"> Procesos
                                                    <span onclick="javascript:window.open('proceso.jsp?txtAccion=C&txtCodigo=-1','Proceso','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo proceso</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=proceso','dMostrar');">Consultar procesos</span>  
                                                </a>
                                            </li>
                                            <li class="ITEMMENU">
                                                <a href="#"> Servicios
                                                    <span onclick="javascript:window.open('servicio.jsp?txtAccion=C&txtCodigo=-1','Servicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo servicio</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=servicio','dMostrar');">Consultar servicios</span>  
                                                </a>
                                            </li>
                                            <li class="ITEMMENU">
                                                <a href="#"> Servicios por responsable
                                                    <span onclick="javascript:window.open('servicioxresp.jsp?txtAccion=C&txtCodigo=-1','ServicioXResponsable','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nuevo servicio por responsable</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=servicioxresp','dMostrar');">Consultar servicios por responsable</span>  
                                                </a>
                                            </li>
                                        <%if(strAdministrador.equals("S")){%>
                                            <li class="ITEMMENU">
                                                <a href="#">Aplicaciones
                                                    <span onclick="javascript:window.open('../aplicacion.jsp?txtAccion=C&txtCodigo=-1','Aplicacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nueva aplicación</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=app','dMostrar');">Consultar aplicaciones</span>
                                                </a>
                                            </li>
                                            <li class="ITEMMENU">
                                                <a href="#">Aplicaciones por persona
                                                    <span onclick="javascript:window.open('../appxpersona.jsp?txtAccion=C&txtCodigo=-1','Aplicacion_X_Persona','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear nueva aplicación por persona</span>
                                                    <span onclick="getXMLHTTPRequest('..//Visualizacion?txtAccion=appxp','dMostrar');">Consultar aplicaciones por persona</span>
                                                </a>
                                            </li>                                             
                                            <%if (strDatos == null){%> 
                                                <li class="ITEMMENU">
                                                    <a href="#">Generales
                                                        <span onclick="javascript:window.open('general.jsp?txtAccion=C&txtCodigo=-1','Generales','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Crear configuración general</span>                                                        
                                                    </a>
                                                </li>                                                
                                            <%}else{%>
                                                <li class="ITEMMENU">
                                                    <a href="#">Generales
                                                        <span onclick="javascript:window.open('general.jsp?txtAccion=V&txtCodigo=-1','Generales','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0')">Consultar configuración general</span>                                                        
                                                    </a>
                                                </li> 
                                            <%}%>                                            
                                        <%}%>
                                    </ul>
                                </td>
                            </tr>                            
                         </table>
                    </td>
                    <td width="20px"></td>
                    <td style="width:810px;text-align: center;vertical-align: top;">
                        <div id="dMostrar">                            
                        </div>
                    </td>
                </tr>
             </table>                                    
        </div>
        <div style="padding-top: 40px;"></div>			
        <jsp:include page="footer_users.jsp" />
     </body>
</html>
