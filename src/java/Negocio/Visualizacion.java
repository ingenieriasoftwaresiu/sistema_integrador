/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge.correa
 */
public class Visualizacion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            String strAccion = null;
            String strEvento = null;
            
            strAccion = request.getParameter("txtAccion");  
            strEvento = request.getParameter("txtEvento");
                        
            if (strEvento == null){
                strEvento = "";
            } 
            
            int intRegistrosAEmpezar;
            int intPaginaActual;
            int intRegistrosAMostrar;
            String[] strDatosGenerales = null;          
                        
            String strSQL = "";
            String strTitulo = "";
            String strHTML = "";         
            String strTipoConsulta = "";
            String strCabecera = "";
            String strBusqueda = "";
            String strSQLTotal = "";
            String strMsgError = "";  
            String strResult = "";
            String strCriterio = "";
            String strClave = "";
            
            strDatosGenerales = GestionSQL.getFila("SELECT g.txtNroRegXPagina FROM users_generales g where g.txtCodigo = 'frmGeneral'");            
            intRegistrosAMostrar = Integer.parseInt(strDatosGenerales[0]);
            
            if (request.getParameter("txtPagina") != null){
                intPaginaActual = Integer.parseInt(request.getParameter("txtPagina"));                
                intRegistrosAEmpezar = (intPaginaActual - 1) * intRegistrosAMostrar;                
            }else{
                intRegistrosAEmpezar = 0;
                intPaginaActual = 1;
            }
                                   
            if (strEvento.equals("Eliminar")){                        
                String strMensaje = "";
                String strCodigo = request.getParameter("txtCodigo");                                                                  
                                
                //Eliminación
               
                if (strAccion.equals("red")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"R");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_redes where txtIdentificacion = '" + strCodigo + "'";                             
                    }                   
                }
                
                if (strAccion.equals("cargo")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"C");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_cargos where txtIdentificacion = '" + strCodigo + "'";                             
                    }                   
                }
                
                if (strAccion.equals("centro_costos")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"CC");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_centros_costos where txtCodigo = '" + strCodigo + "'";                             
                    }                   
                }
                
                if (strAccion.equals("diasNoHabiles")){
                    strSQL = "delete from users_dias_no_habiles where dtFecha = '" + strCodigo + "'"; 
                }
                
                //Eliminación
               
                if (strAccion.equals("grupo")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"G");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_grupos_siu where txtCodigo = '" + strCodigo + "'";                             
                    }                   
                }
                
                //Eliminación
               
                if (strAccion.equals("proceso")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"PR");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_procesos where txtCodigo = '" + strCodigo + "'";                             
                    }                   
                }
                
                //Eliminación
               
                if (strAccion.equals("servicio")){
                     
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"S");                                        

                    if (strResult == null){          
                            strSQL = "delete from users_servicios where txtCodigo = '" + strCodigo + "'";                             
                    }                   
                }

                //Eliminación

                if (strAccion.equals("estadoC")){                 
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"EC");

                    if (strResult == null){
                            strSQL = "delete from users_estados_civiles where txtIdentificador = '" + strCodigo + "'"; 
                    }                   
                }

                //Eliminación

                if (strAccion.equals("medioTrans")){                   
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"MT");

                    if (strResult == null){
                            strSQL = "delete from users_medios_transporte where txtIdentificador = '" + strCodigo + "'"; 
                    }                   
                }

                //Eliminación

                if (strAccion.equals("tipoC")){                   
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"TC");

                    if (strResult == null){
                            strSQL = "delete from users_tipos_contratacion where txtIdentificador = '" + strCodigo + "'"; 
                    }                   
                }

                //Eliminación

                if (strAccion.equals("tipoId")){                
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"TI");

                    if (strResult == null){
                            strSQL = "delete from users_tipos_id where txtIdentificador = '" + strCodigo + "'"; 
                    }                   
                }

                //Eliminación

                if (strAccion.equals("tipoV")){                
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"TV");

                    if (strResult == null){
                           strSQL = "delete from users_tipos_vivienda where txtIdentificacion = '" + strCodigo + "'"; 
                    }                   
                }

                //Eliminación

                if (strAccion.equals("app")){                                                  
                    // Validar asociación con otros registros.
                    strResult = validarRegistro(strCodigo,"APP");

                    if (strResult == null){
                            strSQL = "delete from users_apps where txtCodigo = '" + strCodigo + "'";   
                    }
                }

                //Eliminación

                if (strAccion.equals("appxp")){                 
                    String[] strTemp = strCodigo.split(","); 
                    strSQL = "delete from users_appsxpersona where txtApp = '" + strTemp[0]  + "' and txtPersona='" + strTemp[1]  + "'";                    
                }
                
                if (strAccion.equals("servicioxresp")){                 
                    String[] strTemp = strCodigo.split(","); 
                    strSQL = "delete from users_servicios_x_responsable where txtServicio = '" + strTemp[0]  + "' and txtResponsable = '" + strTemp[1]  + "'";                    
                }

                //Eliminación

                if (strAccion.equals("persona")){                                 
                    String strCedulaUserSession = (String) session.getAttribute("strCedula");
                    
                     if (strCedulaUserSession.equals(strCodigo)){
                         
                        strResult = "<html>\n";
                        strResult = strResult + "<head>\n";
                        strResult = strResult + "<body>\n";
                        strResult = strResult + "<span class='TEXTOFALLO'>\n";
                        strResult = strResult + "No se puede eliminar el registro de la persona que actualmente se encuentra en sesión. Por favor seleccione otro registro de persona a eliminar o inicie sesión con un usuario diferente.\n";
                        strResult = strResult + "</span>\n";
                        strResult = strResult + "</body>\n";
                        strResult = strResult + "</html>";   
                        strSQL = "";
                   }else{
                        // Validar asociación con otros registros.
                        strResult = validarRegistro(strCodigo,"P");                      
                        
                        if (strResult == null){                                          
                            strSQL = "delete from users_personas where txtIdentificacion = '" + strCodigo + "'";        
                        }
                     }                    
                }
                
                if (!strSQL.equals("")){
                    strMensaje = GestionSQL.ejecuta(strSQL);                   
                }
            }            
            
            // Visualizar Redes.
            
            if (strAccion.equals("red")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE REDES";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE REDES";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select c.txtIdentificacion as Id, c.txtNombre as Nombre from users_redes c ORDER BY c.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_redes";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            } 
            
            // Visualizar Cargos.
            
            if (strAccion.equals("cargo")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE CARGOS";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE CARGOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select c.txtIdentificacion as Id, c.txtNombre as Nombre from users_cargos c ORDER BY c.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_cargos";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            } 
            
            // Visualizar Centros de costos.
            
            if (strAccion.equals("centro_costos")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE CENTROS DE COSTOS";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE CENTROS DE COSTOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select cc.txtCodigo as Id, cc.txtNombre as Nombre from users_centros_costos cc ORDER BY cc.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_centros_costos";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Días no hábiles.
            
            if (strAccion.equals("diasNoHabiles")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE DÍAS NO HÁBILES";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE DÍAS NO HÁBILES";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='F'>Fecha</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select d.dtFecha as Id, d.txtNombre as Nombre from users_dias_no_habiles d ORDER BY d.dtFecha DESC LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_dias_no_habiles";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha (aaaa-mm-dd)</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }            
            
            // Visualizar Grupos.
            
            if (strAccion.equals("grupo")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE GRUPOS ";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE GRUPOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select g.txtCodigo as Id, g.txtNombre as Nombre from users_grupos_siu g ORDER BY g.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_grupos_siu";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            } 
            
            // Visualizar Procesos.
            
            if (strAccion.equals("proceso")){
                strTipoConsulta = "PROCESOS";
                strTitulo = "CONSULTA DE PROCESOS ";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE PROCESOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select p.txtCodigo, p.txtNombre, pe.txtNombreCompleto from users_procesos p, users_personas pe where (p.txtResponsable = pe.txtIdentificacion) ORDER BY p.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_procesos";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Responsable</td>\n"; 
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Servicios.
            
            if (strAccion.equals("servicio")){
                strTipoConsulta = "PROCESOS";
                strTitulo = "CONSULTA DE SERVICIOS ";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE SERVICIOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select s.txtCodigo, s.txtNombre, p.txtNombre from users_servicios s, users_procesos p where (s.txtProceso = p.txtCodigo) ORDER BY s.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_servicios";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";  
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Proceso asociado</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Estados Civiles.
                    
            if (strAccion.equals("estadoC")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE ESTADOS CIVILES";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE ESTADOS CIVILES";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select ec.txtIdentificador as Id, ec.txtNombre as Nombre from users_estados_civiles ec ORDER BY ec.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;         
                strSQLTotal = "select count(*) from users_estados_civiles";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Medios de Transporte.
                    
            if (strAccion.equals("medioTrans")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE MEDIOS DE TRANSPORTE";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MEDIOS DE TRANSPORTE";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select mt.txtIdentificador as Id, mt.txtNombre as Nombre from users_medios_transporte mt ORDER BY mt.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;             
                strSQLTotal = "select count(*) from users_medios_transporte";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }         
            
            // Visualizar Tipos de Contrato.
                    
            if (strAccion.equals("tipoC")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE TIPOS DE CONTRATACIÓN";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE TIPOS DE CONTRATACIÓN";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select tc.txtIdentificador as Id, tc.txtNombre as Nombre from users_tipos_contratacion tc ORDER BY tc.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;          
                strSQLTotal = "select count(*) from users_tipos_contratacion";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Tipos de Identificación.
                    
            if (strAccion.equals("tipoId")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE TIPOS DE IDENTIFICACIÓN";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE TIPOS DE IDENTIFICACIÓN";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select ti.txtIdentificador as Id, ti.txtNombre as Nombre from users_tipos_id ti ORDER BY ti.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;                   
                strSQLTotal = "select count(*) from users_tipos_id";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Tipos de Vivienda.
                    
            if (strAccion.equals("tipoV")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE TIPOS DE VIVIENDA";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE TIPOS DE VIVIENDA";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select tv.txtIdentificacion as Id, tv.txtNombre as Nombre from users_tipos_vivienda tv ORDER BY tv.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_tipos_vivienda";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
            
            // Visualizar Aplicaciones.
                    
            if (strAccion.equals("app")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE APLICACIONES";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE APLICACIONES";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select a.txtCodigo as Id, a.txtNombre as Nombre from users_apps a ORDER BY a.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;     
                strSQLTotal = "select count(*) from users_apps";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                
            }
                
            // Visualizar Aplicaciones por Persona.
                    
            if (strAccion.equals("appxp")){
                strTipoConsulta = "APPS";
                strTitulo = "CONSULTA DE APLICACIONES POR PERSONA";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE APLICACIONES / PERSONA";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Nombre de la aplicación</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre de la persona</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select apx.txtApp, apx.txtPersona, ap.txtNombre, p.txtNombreCompleto from users_appsxpersona apx, users_apps ap, users_personas p where (ap.txtCodigo = apx.txtApp) and (p.txtIdentificacion = apx.txtPersona) order by ap.txtNombre, p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;                     
                strSQLTotal = "select count(*) from users_appsxpersona";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre de la aplicación</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre de la persona</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                      
            }
            
           // Visualizar Servicios por responsable.
                    
            if (strAccion.equals("servicioxresp")){
                strTipoConsulta = "APPS";
                strTitulo = "CONSULTA DE SERVICIOS POR RESPONSABLE";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE SERVICIOS / RESPONSABLE";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Nombre del servicio</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre del responsable</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select sxr.txtServicio, sxr.txtResponsable, s.txtNombre, p.txtNombreCompleto from users_servicios_x_responsable sxr, users_servicios s, users_personas p where (s.txtCodigo = sxr.txtServicio) and (p.txtIdentificacion = sxr.txtResponsable) order by s.txtNombre, p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;                     
                strSQLTotal = "select count(*) from users_servicios_x_responsable";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del servicio</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del responsable</td>\n";               
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                      
            }
                                    
            if (strAccion.equals("persona")){
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE PERSONAS";
                strCabecera = "<td colspan='8' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='929px' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE PERSONAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Criterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 20px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='I'>Identificación</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre completo</option>";
                strBusqueda = strBusqueda + "<option value='C'>Cargo</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='../Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";   
                strSQL = "select p.txtIdentificacion, p.txtNombreCompleto, c.txtNombre, p.txtEstadoActual from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) ORDER BY p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                strSQLTotal = "select count(*) from users_personas";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Identificación</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre completo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Cargo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado actual</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
                                                       
            if (strEvento != null){                  
                if (strEvento.equals("busqueda")){                    
                    strCriterio = request.getParameter("txtCriterio");
                    strClave = request.getParameter("txtClave");                    
                    
                    if (strAccion.equals("red")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_redes tbl where tbl.txtIdentificacion = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_redes tbl where tbl.txtIdentificacion = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_redes tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_redes tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("cargo")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_cargos tbl where tbl.txtIdentificacion = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_cargos tbl where tbl.txtIdentificacion = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_cargos tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_cargos tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("centro_costos")){
                        if (strCriterio.equals("C")){                             
                            strSQL = "select cc.txtCodigo as Id, cc.txtNombre as Nombre from users_centros_costos cc where cc.txtCodigo = '" + strClave + "' ORDER BY cc.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_centros_costos cc where cc.txtCodigo = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select cc.txtCodigo as Id, cc.txtNombre as Nombre from users_centros_costos cc where cc.txtNombre like '%" + strClave + "%' ORDER BY cc.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_centros_costos cc where cc.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("grupo")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_grupos_siu tbl where tbl.txtCodigo = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_grupos_siu tbl where tbl.txtCodigo = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_grupos_siu tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_grupos_siu tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("proceso")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_procesos tbl where tbl.txtCodigo = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_procesos tbl where tbl.txtCodigo = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_procesos tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_procesos tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("servicio")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_servicios tbl where tbl.txtCodigo = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_servicios tbl where tbl.txtCodigo = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_servicios tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_servicios tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("estadoC")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_estados_civiles tbl where tbl.txtIdentificador = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_estados_civiles tbl where tbl.txtIdentificador = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_estados_civiles tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_estados_civiles tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("medioTrans")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_medios_transporte tbl where tbl.txtIdentificador = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_medios_transporte tbl where tbl.txtIdentificador = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_medios_transporte tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_medios_transporte tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("tipoC")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_tipos_contratacion tbl where tbl.txtIdentificador = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_contratacion tbl where tbl.txtIdentificador = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_tipos_contratacion tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_contratacion tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("tipoId")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_tipos_id tbl where tbl.txtIdentificador = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_id tbl where tbl.txtIdentificador = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificador as Id, tbl.txtNombre as Nombre from users_tipos_id tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_id tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("tipoV")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_tipos_vivienda tbl where tbl.txtIdentificacion = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_vivienda tbl where tbl.txtIdentificacion = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtIdentificacion as Id, tbl.txtNombre as Nombre from users_tipos_vivienda tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_tipos_vivienda tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("app")){
                        if (strCriterio.equals("C")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_apps tbl where tbl.txtCodigo = '" + strClave + "' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_apps tbl where tbl.txtCodigo = '" + strClave + "'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select tbl.txtCodigo as Id, tbl.txtNombre as Nombre from users_apps tbl where tbl.txtNombre like '%" + strClave + "%' ORDER BY tbl.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_apps tbl where tbl.txtNombre like '%" + strClave + "%'";
                        }                          
                    }
                    
                    if (strAccion.equals("appxp")){
                        if (strCriterio.equals("C")){
                            strSQL = "select appx.txtApp, appx.txtPersona, app.txtNombre, p.txtNombreCompleto from users_appsxpersona appx, users_apps app, users_personas p where (appx.txtApp = app.txtCodigo) and (appx.txtPersona = p.txtIdentificacion) and app.txtNombre like '%" + strClave + "%' ORDER BY app.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_appsxpersona appx, users_apps app, users_personas p where (appx.txtApp = app.txtCodigo) and (appx.txtPersona = p.txtIdentificacion) and app.txtNombre like '%" + strClave + "%'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select appx.txtApp, appx.txtPersona, app.txtNombre, p.txtNombreCompleto from users_appsxpersona appx, users_apps app, users_personas p where (appx.txtApp = app.txtCodigo) and (appx.txtPersona = p.txtIdentificacion) and p.txtNombreCompleto like '%" + strClave + "%' ORDER BY app.txtNombre LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_appsxpersona appx, users_apps app, users_personas p where (appx.txtApp = app.txtCodigo) and (appx.txtPersona = p.txtIdentificacion) and p.txtNombreCompleto like '%" + strClave + "%'";
                        }  
                    }
                    
                    if (strAccion.equals("servicioxresp")){
                        if (strCriterio.equals("C")){
                            strSQL = "select sxr.txtServicio, sxr.txtResponsable, s.txtNombre, p.txtNombreCompleto from users_servicios_x_responsable sxr, users_servicios s, users_personas p where (s.txtCodigo = sxr.txtServicio) and (p.txtIdentificacion = sxr.txtResponsable) and s.txtNombre like '%" + strClave + "%' order by s.txtNombre, p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_servicios_x_responsable sxr, users_servicios s, users_personas p where (s.txtCodigo = sxr.txtServicio) and (p.txtIdentificacion = sxr.txtResponsable) and s.txtNombre like '%" + strClave + "%'";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select sxr.txtServicio, sxr.txtResponsable, s.txtNombre, p.txtNombreCompleto from users_servicios_x_responsable sxr, users_servicios s, users_personas p where (s.txtCodigo = sxr.txtServicio) and (p.txtIdentificacion = sxr.txtResponsable) and p.txtNombreCompleto like '%" + strClave + "%' order by s.txtNombre, p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_servicios_x_responsable sxr, users_servicios s, users_personas p where (s.txtCodigo = sxr.txtServicio) and (p.txtIdentificacion = sxr.txtResponsable) and p.txtNombreCompleto like '%" + strClave + "%'";
                        }  
                    }
                                       
                    if (strAccion.equals("persona")){
                        if (strCriterio.equals("I")){                        
                            strSQL = "select p.txtIdentificacion, p.txtNombreCompleto, c.txtNombre, p.txtEstadoActual from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and p.txtIdentificacion like '%" + strClave + "%' ORDER BY p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and p.txtIdentificacion like '%" + strClave + "%'";
                        }       
                        
                        if (strCriterio.equals("N")){                        
                            strSQL = "select p.txtIdentificacion, p.txtNombreCompleto, c.txtNombre, p.txtEstadoActual from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and p.txtNombreCompleto like '%" + strClave + "%' ORDER BY p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and p.txtNombreCompleto like '%" + strClave + "%'";
                        } 
                        
                        if (strCriterio.equals("C")){                        
                            strSQL = "select p.txtIdentificacion, p.txtNombreCompleto, c.txtNombre, p.txtEstadoActual from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and c.txtNombre like '%" + strClave + "%' ORDER BY p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and c.txtNombre like '%" + strClave + "%'";
                        } 
                        
                        if (strCriterio.equals("E")){                        
                            strSQL = "select p.txtIdentificacion, p.txtNombreCompleto, c.txtNombre, p.txtEstadoActual from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and IF(p.txtEstadoActual = 'A','Activo','Inactivo') like '%" + strClave + "%' ORDER BY p.txtNombreCompleto LIMIT " + intRegistrosAEmpezar + "," + intRegistrosAMostrar;
                            strSQLTotal = "select count(*) from users_personas p, users_cargos c where (p.txtCargo = c.txtIdentificacion) and IF(p.txtEstadoActual = 'A','Activo','Inactivo') like '%" + strClave + "%'";
                        }                    
                    }                
                }               
            }                  
            
            Vector arrDatos = GestionSQL.consultaSQL(strSQL,strTipoConsulta);
            
            if (arrDatos == null){            
                out.println("<html>");
                out.println("<head>");                
                out.println("</head>");
                out.println("<body OnKeyPress='return disableKeyPress(event)'>");
                out.println("<div class='TEXTOFALLO' style='padding-top: 200px;font-size: 16px;'>");
                out.println("No se encontraron registros que concuerden con la búsqueda ingresada.");
                out.println("</div>");
                out.println("<br>");
                out.println("<span class='TEXTOEXITO'>");
                out.println("<input type='button' class='BOTONFORM' value='Regresar' onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "','dMostrar');\"");
                out.println("</span>");
                out.println("</body>");
                out.println("</html>");
            }else{                 
                
                String strTablaRefresh = "";
                
                strTablaRefresh += "<table cellpadding='5' cellspacing='0' border='0' width='929px'>\n";
                strTablaRefresh += "<tr>\n";
                strTablaRefresh += "<td style='text-align:left; vertical-align: middle;width:30px;'>\n";
                strTablaRefresh += "<form name='frmRefresh' id='frmRefresh'>\n";
                strTablaRefresh += "<img src='../Images/Refresh.png' width='30px' height='29px' border='0' id='btnRefresh' onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "','dMostrar');\">\n";
                strTablaRefresh += "</form>\n";
                strTablaRefresh += "</td>\n";
                strTablaRefresh += "<td class='TEXTOREFRESH'>\n";
                strTablaRefresh += "<a href='#' onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "','dMostrar');\">Actualizar datos</a>\n";
                strTablaRefresh += "</td>\n";
                strTablaRefresh += "</tr>\n";
                strTablaRefresh += "</table>\n";
                
                out.println("<html>");
                out.println("<head>");                
                out.println("</head>");
                out.println("<body OnKeyPress='return disableKeyPress(event)'>");
                out.println(strBusqueda);
                out.println(strTablaRefresh);    
                out.println("<table cellpadding='5' cellspacing='0' border='0' width='929px' class='TABLARESULT'>");
                out.println("<tr>");
                out.println(strCabecera);
                out.println("</tr>");
                out.println("<tr>");
                out.println(strHTML);
                out.println("</tr>");
                
                String[] strTemp = null;                                   
                
                for(int i=0;i<arrDatos.size();i++){
                    strTemp = arrDatos.get(i).toString().split(",");                      
                    out.println("<tr class='FILARESULT'>");                               
                     
                    if (strAccion.equals("red")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegRed('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegRed('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegRed('" + strTemp[0] + "')\"></td>");                         
                     }
                    
                     if (strAccion.equals("cargo")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegCargo('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegCargo('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegCargo('" + strTemp[0] + "')\"></td>");                         
                     }
                     
                     if (strAccion.equals("centro_costos")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegCentroCostos('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegCentroCostos('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegCentroCostos('" + strTemp[0] + "')\"></td>");
                     }
                                                              
                     if (strAccion.equals("diasNoHabiles")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegDiaNoHabil('" + strTemp[0] + "')\">" + strTemp[0] + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegDiaNoHabil('" + strTemp[0] + "')\">" + strTemp[1] + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegDiaNoHabil('" + strTemp[0] + "')\"></td>");              
                     }
                     
                     if (strAccion.equals("grupo")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegGrupo('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegGrupo('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegGrupo('" + strTemp[0] + "')\"></td>");                         
                     }
                     
                      if (strAccion.equals("proceso")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegProceso('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegProceso('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegProceso('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegProceso('" + strTemp[0] + "')\"></td>");                         
                     }
                     
                     if (strAccion.equals("servicio")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegServicio('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegServicio('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegServicio('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegServicio('" + strTemp[0] + "')\"></td>");                         
                     }
                     
                     if (strAccion.equals("estadoC")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegEstadoCivil('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegEstadoCivil('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegEstadoCivil('" + strTemp[0] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("medioTrans")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegMedioTrans('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegMedioTrans('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegMedioTrans('" + strTemp[0] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("tipoC")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegTipoC('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegTipoC('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegTipoC('" + strTemp[0] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("tipoId")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegTipoId('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegTipoId('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegTipoId('" + strTemp[0] + "')\"></td>");
                     }   
                     
                     if (strAccion.equals("tipoV")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegTipoV('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegTipoV('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegTipoV('" + strTemp[0] + "')\"></td>");
                     }   
                     
                     if (strAccion.equals("app")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegAplicacion('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegAplicacion('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegApp('" + strTemp[0] + "')\"></td>");
                     } 
                     
                     if (strAccion.equals("appxp")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegAppXP('" + strTemp[0] + "," + strTemp[1] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegAppXP('" + strTemp[0] + "," + strTemp[1] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegAppxP('" + strTemp[0] + "," + strTemp[1] + "')\"></td>");
                     } 
                     
                     if (strAccion.equals("servicioxresp")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegServicioXResp('" + strTemp[0] + "," + strTemp[1] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegServicioXResp('" + strTemp[0] + "," + strTemp[1] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegServicioxResp('" + strTemp[0] + "," + strTemp[1] + "')\"></td>");
                     }
                                                               
                     if (strAccion.equals("persona")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirRegPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirRegPersona('" + strTemp[0] + "')\">" + validarEstado(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegPersona('" + strTemp[0] + "')\"></td>");
                     }
                                                                                                   
                    out.println("</tr>");                    
                }     
                out.println("</table>");
                out.println("<br>");
                
                //Paginación.
                
                int  intPagAnt, intPagSig, intPagUlt, intNroRegistros;
                float ftRes;
                     
                String[] strDatos = GestionSQL.getFila(strSQLTotal);
                intNroRegistros = Integer.parseInt(strDatos[0]);                            

                intPagAnt = intPaginaActual - 1;
                intPagSig = intPaginaActual + 1;
                intPagUlt = (intNroRegistros/intRegistrosAMostrar);
                               
                ftRes = (intNroRegistros % intRegistrosAMostrar);
                
                if (ftRes>0){
                    intPagUlt = ((int)intPagUlt) + 1;
                }                
                
                if (strEvento.equals("busqueda")){
                    out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtEvento=busqueda&txtCriterio=" + strCriterio + "&txtClave=" + strClave + "&txtAccion=" + strAccion + "&txtPagina=1','dMostrar');\" class=\"TEXTOPAGINACION\">Primera</a>");
                    if (intPaginaActual > 1){
                        out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtEvento=busqueda&txtCriterio=" + strCriterio + "&txtClave=" + strClave + "&txtAccion=" + strAccion + "&txtPagina=" + intPagAnt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Anterior</a>");
                    }
                    out.println("<span class='TEXTOPAGINACION' style='font-weight: bold;'>Página " + intPaginaActual + "/" + intPagUlt + "</span>");
                    if (intPaginaActual < intPagUlt){                        
                        out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtEvento=busqueda&txtCriterio=" + strCriterio + "&txtClave=" + strClave + "&txtAccion=" + strAccion + "&txtPagina=" + intPagSig + "','dMostrar');\" class=\"TEXTOPAGINACION\">Siguiente</a>");
                    } 
                    out.println("<a href=\"#\"  onclick=\"getXMLHTTPRequest('..//Visualizacion?txtEvento=busqueda&txtCriterio=" + strCriterio + "&txtClave=" + strClave + "&txtAccion=" + strAccion + "&txtPagina=" + intPagUlt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Última</a>");
                }else{
                    out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "&txtPagina=1','dMostrar');\" class=\"TEXTOPAGINACION\">Primera</a>");
                    if (intPaginaActual > 1){
                        out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "&txtPagina=" + intPagAnt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Anterior</a>");
                    }
                    out.println("<span class='TEXTOPAGINACION' style='font-weight: bold;'>Página " + intPaginaActual + "/" + intPagUlt + "</span>");
                    if (intPaginaActual < intPagUlt){
                        out.println("<a href=\"#\" onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "&txtPagina=" + intPagSig + "','dMostrar');\" class=\"TEXTOPAGINACION\">Siguiente</a>");
                    } 
                    out.println("<a href=\"#\"  onclick=\"getXMLHTTPRequest('..//Visualizacion?txtAccion=" + strAccion + "&txtPagina=" + intPagUlt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Última</a>");
                }
                
                if (strResult != null ){   
                    out.println("<br><br>");
                    out.println(strResult);                                
                }
                out.println("</body>");
                out.println("</html>");                
            }           
            
        } finally {            
            out.close();
        }
    }    
    
    private String validarVacio(String strValor){
        
        if ((strValor == null) || (strValor.equals("")) || (strValor.equals(" "))){
            return "N/A";
        }else{
            return strValor;
        }            
    }
    
    private String validarEstado(String strValor){
        
        if (strValor.equals("A")){
            return "Activo";
        }else{
            return "Inactivo";
        }            
    }
    
    private String validarRegistro(String strClave,String strAccion){
        
        String[] strResult = null;
        String strSQL = null;
        String strMensaje = null;
        
        // Redes.
        
        if (strAccion.equals("R")){              
            strSQL = "select p.txtRadicado from buzon.buzon_pqrs p where p.txtRedIngreso = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head></head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de red seleccionado debido a que se encuentra asociado con solicitudes pqrsfd existentes.\n";
            strMensaje = strMensaje + "</span>\n";    
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
        
        // Cargos.
        
        if (strAccion.equals("C")){              
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtCargo = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head></head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de cargo seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";    
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
        
        // Grupos.
        
        if (strAccion.equals("G")){              
            strSQL = "select p.txtGrupo_Entidad from users.users_grupos_siu g, buzon.buzon_pqrs p where (g.txtCodigo = p.txtGrupo_Entidad) and g.txtCodigo = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head></head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de grupo seleccionado debido a que se encuentra asociado con PQRS existentes.\n";
            strMensaje = strMensaje + "</span>\n";    
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
        
        // Procesos.
        
        if (strAccion.equals("PR")){              
            strSQL = "select p.txtCodigo from users_procesos p, users_servicios s where (s.txtProceso = p.txtCodigo) and p.txtCodigo = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head></head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de proceso seleccionado debido a que se encuentra asociado con servicios existentes.\n";
            strMensaje = strMensaje + "</span>\n";    
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
                
        // Servicios.
        
        if (strAccion.equals("S")){              
            strSQL = "select s.txtCodigo from users.users_servicios s, buzon.buzon_pqrs p where (s.txtCodigo = p.txtServicio) and s.txtCodigo = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head></head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de servicio seleccionado debido a que se encuentra asociado con PQRS existentes.\n";
            strMensaje = strMensaje + "</span>\n";    
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
        
        // Estados Civiles.
        
        if (strAccion.equals("EC")){                   
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtEstadoCivil = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de estado civil seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                       
        }
        
         // Medios de Transporte.
        
        if (strAccion.equals("MT")){               
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtMedioTransporte = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de medio de transporte seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                     
        }
        
        // Tipos de Contratación.
        
        if (strAccion.equals("TC")){     
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtTipoContratacion = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de tipo de contratación seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                        
        }
        
        // Tipos de Identificación.
        
        if (strAccion.equals("TI")){          
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtTipoId = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de tipo de identificación seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                      
        }
        
        // Tipos de Vivienda.
        
        if (strAccion.equals("TV")){        
            strSQL = "select p.txtIdentificacion from users_personas p where p.txtTipoVivienda = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de tipo de vivienda seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                        
        }
        
        // Aplicación.
        
        if (strAccion.equals("APP")){        
            strSQL = "select p.txtApp from users_appsxpersona p where p.txtApp = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de aplicación seleccionado debido a que se encuentra asociado con personas existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";                  
        }        
        
        // Persona.
        
        if (strAccion.equals("P")){  
            strSQL = "select * from users_appsxpersona apxp, users_servicios_x_responsable sxr where apxp.txtPersona = '" + strClave + "' or sxr.txtResponsable = '" + strClave + "'";
            strMensaje = "<html>\n";
            strMensaje = strMensaje + "<head>\n";
            strMensaje = strMensaje + "<body>\n";
            strMensaje = strMensaje + "<span class='TEXTOFALLO'>\n";
            strMensaje = strMensaje + "No se puede eliminar el registro de persona seleccionado debido a que se encuentra asociado con aplicaciones o permisos sobre aplicaciones existentes.\n";
            strMensaje = strMensaje + "</span>\n";
            strMensaje = strMensaje + "</body>\n";
            strMensaje = strMensaje + "</html>";            
        }
                       
        if (strSQL != null){
            strResult = GestionSQL.getFila(strSQL);
            
            if (strResult != null){
                return strMensaje;
            }else{
                 return null;
            }
        }else{
            return null;
        }                
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}