<%-- 
    Document   : persona
    Created on : 16-jul-2012, 15:43:13
    Author     : jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");        
    String strCedula = (String) session.getAttribute("strCedula"); 
    String[] strDatos = null;
    
    strDatos = GestionSQL.getFila("select p.txtAdministrador from users_personas p where p.txtIdentificacion = '" + strCedula + "'");
           
    String strAdministrador = strDatos[0];
    
    if (strAdministrador == null){
        strAdministrador = "N";
    }
    
    String[] strDatosPersona = null;
    Vector arrCTipoId= new Vector();
    Vector arrNTipoId = new Vector();
    Vector arrCEstadosCiviles= new Vector();
    Vector arrNEstadosCiviles = new Vector();
    Vector arrCTiposVivienda = new Vector();
    Vector arrNTiposVivienda = new Vector();
    Vector arrCMediosTrans = new Vector();
    Vector arrNMediosTrans = new Vector();
    Vector arrCTiposContrato = new Vector();
    Vector arrNTiposContrato = new Vector();
    Vector arrCCargos = new Vector();
    Vector arrNCargos = new Vector();
    Vector arrCPersonas = new Vector();
    Vector arrNPersonas = new Vector();
    String[] strTemp = null;
    
     if (strAccion == null) {
        response.sendRedirect("cerrar.jsp");
     }else{
        
        // Tipos de Identificación,
        Vector arrTiposId = GestionSQL.consultaSQL("SELECT ti.txtIdentificador as Id, ti.txtNombre as Nombre from users_tipos_id ti ORDER BY ti.txtNombre","MAESTROS");

        for (int i=0;i<arrTiposId.size();i++){
            strTemp = arrTiposId.get(i).toString().split(",");
            arrCTipoId.add(strTemp[0]);
            arrNTipoId.add(strTemp[1]);
        }

        // Estados civiles.
        Vector arrEstadosCiviles = GestionSQL.consultaSQL("SELECT ec.txtIdentificador as Id, ec.txtNombre as Nombre from users_estados_civiles ec ORDER BY ec.txtNombre","MAESTROS");

        for (int i=0;i<arrEstadosCiviles.size();i++){
            strTemp = arrEstadosCiviles.get(i).toString().split(",");
            arrCEstadosCiviles.add(strTemp[0]);
            arrNEstadosCiviles.add(strTemp[1]);
        }

        // Tipos de vivienda.
        Vector arrTiposVivienda = GestionSQL.consultaSQL("SELECT tv.txtIdentificacion as Id, tv.txtNombre as Nombre from users_tipos_vivienda tv ORDER BY tv.txtNombre","MAESTROS");

        for (int i=0;i<arrTiposVivienda.size();i++){
            strTemp = arrTiposVivienda.get(i).toString().split(",");
            arrCTiposVivienda.add(strTemp[0]);
            arrNTiposVivienda.add(strTemp[1]);
        }    

        // Medios de transporte.
        Vector arrMediosTrans = GestionSQL.consultaSQL("SELECT mt.txtIdentificador as Id, mt.txtNombre as Nombre from users_medios_transporte mt ORDER BY mt.txtNombre","MAESTROS");

        for (int i=0;i<arrMediosTrans.size();i++){
            strTemp = arrMediosTrans.get(i).toString().split(",");
            arrCMediosTrans.add(strTemp[0]);
            arrNMediosTrans.add(strTemp[1]);
        }

        // Tipos de contrato.
        Vector arrTiposContrato = GestionSQL.consultaSQL("SELECT tc.txtIdentificador as Id, tc.txtNombre as Nombre from users_tipos_contratacion tc ORDER BY tc.txtNombre","MAESTROS");

        for (int i=0;i<arrTiposContrato.size();i++){
            strTemp = arrTiposContrato.get(i).toString().split(",");
            arrCTiposContrato.add(strTemp[0]);
            arrNTiposContrato.add(strTemp[1]);
        }

        // Cargos.
        Vector arrCargos = GestionSQL.consultaSQL("SELECT c.txtIdentificacion as Id, c.txtNombre as Nombre from users_cargos c ORDER BY c.txtNombre","MAESTROS");

        for (int i=0;i<arrCargos.size();i++){
            strTemp = arrCargos.get(i).toString().split(",");
            arrCCargos.add(strTemp[0]);
            arrNCargos.add(strTemp[1]);
        }

        // Personas.
        Vector arrPersonas = GestionSQL.consultaSQL("SELECT p.txtIdentificacion as Id, p.txtNombreCompleto as Nombre from users_personas p ORDER BY p.txtNombreCompleto","MAESTROS");

        for (int i=0;i<arrPersonas.size();i++){
            strTemp = arrPersonas.get(i).toString().split(",");
            arrCPersonas.add(strTemp[0]);
            arrNPersonas.add(strTemp[1]);
        }

        if (strAccion.equals("V")){
            strDatosPersona = GestionSQL.getFila("select * from users_personas p where p.txtIdentificacion = '" + strCodigo + "'");
            
            if (strDatosPersona[2] == null){
                strDatosPersona[2] = "";
            }
            
            if (strDatosPersona[3] == null){
                strDatosPersona[3] = "";
            }
            
            if (strDatosPersona[7] == null){
                strDatosPersona[7] = "";
            }
            
            if (strDatosPersona[8] == null){
                strDatosPersona[8] = "";
            }                       
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">             
        <link rel="SHORTCUT ICON" href="../Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/StylesPersonas.css" />
        <link rel="stylesheet" type="text/css" href="../Styles/calendar-system.css" />
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSCalendar.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSCalendar-setup.js"></script>  
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSComunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="../Scripts/JSPersonas.js"></script>
        <title>Administración de Usuarios: Gestión de Personas</title>
    </head>
    <body onload="cargaBody()">
        <jsp:include page="Header_Users.jsp" />        
        <div align="center">
            <br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE PERSONA</td>
                    </tr>
                    <tr>
                        <td class="SUBTITULOMENU1">Datos Generales</td>
                    </tr>
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmPersona" name="frmPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strCodigo%>">
                                <input type="hidden" name="txtEsAdmin" id="txtEsAdmin" value="<%=strAdministrador%>">
                                <table cellspacing="0" cellpadding="5" width="1200px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Tipo de identificación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoId" id="txtTipoId" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTipoId.size();i++){%>
                                                 <option value="<%=arrCTipoId.get(i)%>"><%=arrNTipoId.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">* Nro. de identificación:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNroId" id="txtNroId" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM"> Lugar de expedición:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtLugarExp" id="txtLugarExp" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* Nombre completo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Estado civil:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtEstadoCivil" id="txtEstadoCivil" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCEstadosCiviles.size();i++){%>
                                                 <option value="<%=arrCEstadosCiviles.get(i)%>"><%=arrNEstadosCiviles.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">Lugar de residencia:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtLugarRes" id="txtLugarRes" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Dirección:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtDireccion" id="txtDireccion" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Barrio:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtBarrio" id="txtBarrio" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Teléfono residencia:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefonoRes" id="txtTelefonoRes" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Tipo de vivienda:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoVivienda" id="txtTipoVivienda" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTiposVivienda.size();i++){%>
                                                 <option value="<%=arrCTiposVivienda.get(i)%>"><%=arrNTiposVivienda.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">Medio de transporte:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtMedioTrans" id="txtMedioTrans" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCMediosTrans.size();i++){%>
                                                 <option value="<%=arrCMediosTrans.get(i)%>"><%=arrNMediosTrans.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">Fecha de nacimiento:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaNac" id="txtFechaNac" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaN"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Teléfono celular:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCelular" id="txtCelular" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">E-mail personal:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmailP" id="txtEmailP" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Estado actual:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>                                               
                                                <option value="A">Activo</option>        
                                                <option value="I">Inactivo</option>  
                                            </select>
                                        </td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td colspan="6" class="SUBTITULOMENU2" style="height: 5px;">Datos Laborales</td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">Fecha de vinculación:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaVin" id="txtFechaVin" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaV"></td>
                                        <td class="LABELFORM">Fecha de inicio contrato:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM" style="vertical-align: middle;">                                       
                                                <input type="text" name="txtFechaInicioC" id="txtFechaInicioC" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaI">
                                        </td>                                  
                                        <td class="LABELFORM">Fecha de fin contrato:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaFinC" id="txtFechaFinC" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaF"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Tipo de contratación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoContrato" id="txtTipoContrato" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTiposContrato.size();i++){%>
                                                 <option value="<%=arrCTiposContrato.get(i)%>"><%=arrNTiposContrato.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">Cargo:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtCargo" id="txtCargo" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCCargos.size();i++){%>
                                                 <option value="<%=arrCCargos.get(i)%>"><%=arrNCargos.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                        <td class="LABELFORM">Jefe inmediato:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtJefe" id="txtJefe" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCPersonas.size();i++){%>
                                                 <option value="<%=arrCPersonas.get(i)%>"><%=arrNPersonas.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Salario:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtSalario" id="txtSalario" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Teléfono oficina:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefonoOf" id="txtTelefonoOf" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">E-mail corporativo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmailC" id="txtEmailC" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <div id="dDatosGenerales">                                    
                                        <tr>
                                            <td colspan="6" class="SUBTITULOMENU2" style="height: 5px;">Datos de Inicio de Sesión</td>
                                        </tr>
                                        <tr><td colspan="6" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Usuario:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM" onclick="ocultarDIV()"></td>                                       
                                            <td class="LABELFORM">Contraseña:</td>
                                            <td class="CELDACAMPOFORM" style="vertical-align: middle;"><input type="password" name="txtPassword" id="txtPassword" class="CAMPOFORM" onclick="ocultarDIV()"></td>                                  
                                            <td class="LABELFORM">¿Es Administrador?:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtAdmin" id="txtAdmin" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="SO">Seleccione una opción</option>                                               
                                                    <option value="S">Si</option>        
                                                    <option value="N" selected>No</option>  
                                                </select>
                                            </td>
                                        </tr>
                                        <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    </div>                                    
                                    <tr><td colspan="6" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormPersona()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormPersona()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="6" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                    <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE PERSONA</td>
                    </tr>
                    <tr>
                        <td class="SUBTITULOMENU1">Datos Generales</td>
                    </tr>
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmPersona" name="frmPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <input type="hidden" name="txtEsAdmin" id="txtEsAdmin" value="<%=strAdministrador%>">
                                <table cellspacing="0" cellpadding="5" width="1200px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">Tipo de identificación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoId" id="txtTipoId" class="CAMPOFORM" onclick="ocultarDIV()" disabled="disabled">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTipoId.size();i++){%>
                                                 <option value="<%=arrCTipoId.get(i)%>"><%=arrNTipoId.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtTipoId");
                                                element.value = "<%=strDatosPersona[21].toString()%>";                                                
                                            </script>
                                        </td>
                                            <td class="LABELFORM">Nro. de identificación:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNroId" id="txtNroId" value="<%=strDatosPersona[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        <td class="LABELFORM">Lugar de expedición:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtLugarExp" id="txtLugarExp" value="<%=strDatosPersona[14]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* Nombre completo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosPersona[1]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Estado civil:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtEstadoCivil" id="txtEstadoCivil" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCEstadosCiviles.size();i++){%>
                                                 <option value="<%=arrCEstadosCiviles.get(i)%>"><%=arrNEstadosCiviles.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtEstadoCivil");
                                                element.value = "<%=strDatosPersona[18].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">Lugar de residencia:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtLugarRes" id="txtLugarRes" value="<%=strDatosPersona[9]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Dirección:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtDireccion" id="txtDireccion" value="<%=strDatosPersona[10]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Barrio:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtBarrio" id="txtBarrio" value="<%=strDatosPersona[11]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Teléfono residencia:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefonoRes" id="txtTelefonoRes" value="<%=strDatosPersona[5]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Tipo de vivienda:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoVivienda" id="txtTipoVivienda" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTiposVivienda.size();i++){%>
                                                 <option value="<%=arrCTiposVivienda.get(i)%>"><%=arrNTiposVivienda.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtTipoVivienda");
                                                element.value = "<%=strDatosPersona[19].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">Medio de transporte:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtMedioTrans" id="txtMedioTrans" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCMediosTrans.size();i++){%>
                                                 <option value="<%=arrCMediosTrans.get(i)%>"><%=arrNMediosTrans.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtMedioTrans");
                                                element.value = "<%=strDatosPersona[20].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">Fecha de nacimiento:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaNac" id="txtFechaNac" value="<%=strDatosPersona[8]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaN"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Teléfono celular:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCelular" id="txtCelular" value="<%=strDatosPersona[12]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">E-mail personal:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmailP" id="txtEmailP" value="<%=strDatosPersona[13]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Estado actual:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>                                               
                                                <option value="A">Activo</option>        
                                                <option value="I">Inactivo</option>  
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtEstado");
                                                element.value = "<%=strDatosPersona[26].toString()%>";                                                
                                            </script>
                                        </td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td colspan="6" class="SUBTITULOMENU2" style="height: 5px;">Datos Laborales</td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">Fecha de vinculación:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaVin" id="txtFechaVin" value="<%=strDatosPersona[7]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaV"></td>
                                        <td class="LABELFORM">Fecha de inicio contrato:<br>(aaaa-mm-dd)</td>
                                        <td class="CELDACAMPOFORM" style="vertical-align: middle;">                                       
                                                <input type="text" name="txtFechaInicioC" id="txtFechaInicioC" class="CAMPOFORM" value="<%=strDatosPersona[2]%>" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaI">
                                        </td>                                  
                                        <td class="LABELFORM">Fecha de fin contrato:<br>(aaaa-mm-dd)</td>                    
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtFechaFinC" id="txtFechaFinC" value="<%=strDatosPersona[3]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly>&nbsp;<img src="../Images/Calendario.JPG" id="imgFechaF"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Tipo de contratación:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtTipoContrato" id="txtTipoContrato" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCTiposContrato.size();i++){%>
                                                 <option value="<%=arrCTiposContrato.get(i)%>"><%=arrNTiposContrato.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtTipoContrato");
                                                element.value = "<%=strDatosPersona[16].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">Cargo:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtCargo" id="txtCargo" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCCargos.size();i++){%>
                                                 <option value="<%=arrCCargos.get(i)%>"><%=arrNCargos.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtCargo");
                                                element.value = "<%=strDatosPersona[15].toString()%>";                                                
                                            </script>
                                        </td>
                                        <td class="LABELFORM">Jefe inmediato:</td>
                                        <td class="CELDACAMPOFORM">
                                            <select name="txtJefe" id="txtJefe" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCPersonas.size();i++){%>
                                                 <option value="<%=arrCPersonas.get(i)%>"><%=arrNPersonas.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <% String strJefe = "S";
                                                if (strDatosPersona[17] != null && !strDatosPersona[17].equals("")){
                                                    strJefe = strDatosPersona[17];
                                                }
                                            %>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtJefe");
                                                element.value = "<%=strJefe%>";                                                
                                            </script>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Salario:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtSalario" id="txtSalario" value="<%=strDatosPersona[6]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Teléfono oficina:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefonoOf" id="txtTelefonoOf" value="<%=strDatosPersona[4]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">E-mail corporativo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmailC" id="txtEmailC" value="<%=strDatosPersona[25]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr><td colspan="6" style="height: 10px;"></td></tr>                               
                                    <% if(strAdministrador.equals("S")){%>                                    
                                        <tr>
                                            <td colspan="6" class="SUBTITULOMENU2" style="height: 5px;">Datos de Inicio de Sesión</td>
                                        </tr>
                                        <tr><td colspan="6" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Usuario:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" value="<%=strDatosPersona[22]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>                                       
                                            <td class="LABELFORM">Contraseña:</td>
                                            <td class="CELDACAMPOFORM" style="vertical-align: middle;"><input type="password" name="txtPassword" id="txtPassword" value="<%=strDatosPersona[23]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>                                  
                                            <td class="LABELFORM">¿Es Administrador?:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtAdmin" id="txtAdmin" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="SO">Seleccione una opción</option>                                               
                                                    <option value="S">Si</option>        
                                                    <option value="N">No</option>  
                                                </select>
                                                <script language="javascript" type="text/javascript">                                                                                                          
                                                    element = document.getElementById("txtAdmin");
                                                    element.value = "<%=strDatosPersona[24].toString()%>";                                                
                                                </script>
                                            </td>
                                        </tr>
                                        <tr><td colspan="6" style="height: 10px;"></td></tr>
                                    <%}%>
                                    <tr><td colspan="6" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormPersona()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="6" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
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
        <div style="padding-top: 40px;"></div>			
        <jsp:include page="footer_users.jsp" />	
        <script language="javascript" type="text/javascript">
            cargarCalendarios();
        </script>
    </body>
</html>
