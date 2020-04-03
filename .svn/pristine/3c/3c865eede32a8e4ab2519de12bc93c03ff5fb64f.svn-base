/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorge.correa
 */
public class Registro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();

        try {            
           HttpSession session = request.getSession(true);
           String strForm = request.getParameter("txtForm");  
           String strAccion = request.getParameter("txtAccion");               
               
           String strSQL = "";
           String strMensaje = "";
           String strResult = null;        
           
           // Configuración general
           
           if (strForm.equals("frmGeneral")){
               String strNroRegXPagina = request.getParameter("txtNroRegXPag");       
              
               //Creación
               
               if (strAccion.equals("C")){                           
                    strSQL = "INSERT INTO users_generales (txtCodigo,txtNroRegXPagina) VALUES('" + strForm + "','" + strNroRegXPagina + "');";                    
               }
               
               //Consulta
              
               if (strAccion.equals("V")){                   
                   strSQL = "update users_generales set txtNroRegXPagina = '" + strNroRegXPagina + "' where txtCodigo = 'frmGeneral'";
               }                    
           }
           
           // Gestión de Redes.
           
           if (strForm.equals("frmRed")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"R");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_redes (txtIdentificacion,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_redes set txtNombre = '" + strNombre + "' where txtIdentificacion = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Cargos.
           
           if (strForm.equals("frmCargo")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"C");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_cargos (txtIdentificacion,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_cargos set txtNombre = '" + strNombre + "' where txtIdentificacion = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Centros de costos.
           
           if (strForm.equals("frmCentroCostos")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"CC");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_centros_costos (txtCodigo,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_centros_costos set txtNombre = '" + strNombre + "' where txtCodigo = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Días no hábiles.
           
           if (strForm.equals("frmDiaNoHabil")){

               String strFecha = request.getParameter("txtFecha");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strFecha,"DNH");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_dias_no_habiles (dtFecha,txtNombre) VALUES('" + strFecha + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_dias_no_habiles set txtNombre = '" + strNombre + "' where dtFecha = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Grupos.
           
           if (strForm.equals("frmGrupo")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"G");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_grupos_siu (txtCodigo,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_grupos_siu set txtNombre = '" + strNombre + "' where txtCodigo = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Procesos.
           
           if (strForm.equals("frmProceso")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               String strResponsable = request.getParameter("txtResponsable");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"PR");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_procesos (txtCodigo,txtNombre,txtResponsable) VALUES('" + strCodigo + "','" + strNombre + "','" + strResponsable + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_procesos set txtNombre = '" + strNombre + "', txtResponsable = '" + strResponsable + "' where txtCodigo = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Servicios.
           
           if (strForm.equals("frmServicio")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");   
               String strProceso = request.getParameter("txtProceso");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"S");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_servicios (txtCodigo,txtNombre,txtProceso) VALUES('" + strCodigo + "','" + strNombre + "','" + strProceso + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_servicios set txtNombre = '" + strNombre + "', txtProceso = '" + strProceso + "' where txtCodigo = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Estados Civiles.
           
           if (strForm.equals("frmEstadoCivil")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"EC");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_estados_civiles (txtIdentificador,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_estados_civiles set txtNombre = '" + strNombre + "' where txtIdentificador = '" + strCodigoM +"'";
               }   
           }
           
           // Gestión de Medios de Transporte.
           
           if (strForm.equals("frmMedioTransporte")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"MT");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_medios_transporte (txtIdentificador,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_medios_transporte set txtNombre = '" + strNombre + "' where txtIdentificador = '" + strCodigoM +"'";
               }
           }           
                      
           // Gestión de Tipos de Contratación.
           
           if (strForm.equals("frmTipoContratacion")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"TC");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_tipos_contratacion (txtIdentificador,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_tipos_contratacion set txtNombre = '" + strNombre + "' where txtIdentificador = '" + strCodigoM +"'";
               } 
           }
           
           // Gestión de Tipos de Identificación.
           
           if (strForm.equals("frmTipoId")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"TI");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_tipos_id (txtIdentificador,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_tipos_id set txtNombre = '" + strNombre + "' where txtIdentificador = '" + strCodigoM +"'";
               }
           }
           
           // Gestión de Tipos de Vivienda.
           
           if (strForm.equals("frmTipoVivienda")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strCodigo,"TV");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_tipos_vivienda (txtIdentificacion,txtNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_tipos_vivienda set txtNombre = '" + strNombre + "' where txtIdentificacion = '" + strCodigoM +"'";
               }     
           }
           
           // Gestión de Aplicaciones.
           
           if (strForm.equals("frmAplicacion")){    
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                String strResponsable = request.getParameter("txtResponsable");
                String strUrlAcceso = request.getParameter("txtUrlAcceso");
                String strDescripcion = request.getParameter("txtDescripcion");
                    
               if (strAccion.equals("C")){   
                    //Validar duplicidad.

                    strResult = validarRegistro(strCodigo,"APP");
                    
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_apps (txtCodigo,txtNombre,txtDescripcion,txtResponsable,txtUrlAcceso) VALUES('" + strCodigo + "','" + strNombre + "','" + strDescripcion + "','" + strResponsable + "','" + strUrlAcceso + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){ 
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update users_apps set txtNombre = '"+ strNombre + "',txtDescripcion = '"+ strDescripcion +"',txtResponsable = '"+ strResponsable +"',txtUrlAcceso = '"+ strUrlAcceso + "' where txtCodigo = '" + strCodigoM +"'";
               }
           }   
           
           // Gestión de Aplicaciones por Persona.
           
           if (strForm.equals("frmAppxPersona")){

               String strAplicacion = request.getParameter("txtApp");
               String strPersona = request.getParameter("txtPersona");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strAplicacion + "," + strPersona,"AxP");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_appsxpersona (txtApp,txtPersona) VALUES('" + strAplicacion + "','" + strPersona + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");                        
                   String[] strTemp = strCodigoM.split(",");                 
                   strSQL = "update users_appsxpersona set txtApp = '"+ strAplicacion + "',txtPersona = '"+ strPersona + "' where txtApp = '" + strTemp[0] + "' and txtPersona='" + strTemp[1] + "'";
               }                                
           }
           
           // Gestión de Aplicaciones por Persona.
           
           if (strForm.equals("frmServicioXResp")){

               String strServicio = request.getParameter("txtServicio");
               String strPersona = request.getParameter("txtPersona");
                              
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strServicio + "," + strPersona,"SxR");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO users_servicios_x_responsable (txtServicio,txtResponsable) VALUES('" + strServicio + "','" + strPersona + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");                        
                   String[] strTemp = strCodigoM.split(",");                 
                   strSQL = "update users_servicios_x_responsable set txtServicio = '"+ strServicio + "',txtResponsable = '"+ strPersona + "' where txtServicio = '" + strTemp[0] + "' and txtResponsable='" + strTemp[1] + "'";
               }                                
           }
           
           // Gestión de Personas.
           
           if (strForm.equals("frmPersona")){
               
               String strTipoId = request.getParameter("txtTipoId");
               String strNroId = request.getParameter("txtNroId");
               String strLugarExp = request.getParameter("txtLugarExp");
               String strNombre = request.getParameter("txtNombre");
               String strEstadoCivil = request.getParameter("txtEstadoCivil");
               String strLugarRes = request.getParameter("txtLugarRes");
               String strDireccion = request.getParameter("txtDireccion");
               String strBarrio = request.getParameter("txtBarrio");
               String strTelefonoRes = request.getParameter("txtTelefonoRes");
               String strTipoVivienda = request.getParameter("txtTipoVivienda");
               String strMedioTrans = request.getParameter("txtMedioTrans");
               String strFechaNac = request.getParameter("txtFechaNac");
               String strCelular = request.getParameter("txtCelular");
               String strEmailP = request.getParameter("txtEmailP");
               String strFechaVin= request.getParameter("txtFechaVin");
               String strFechaInicioC = request.getParameter("txtFechaInicioC");
               String strFechaFinC = request.getParameter("txtFechaFinC");
               String strTipoContrato = request.getParameter("txtTipoContrato");
               String strCargo = request.getParameter("txtCargo");
               String strJefe = request.getParameter("txtJefe");
               String strSalario = request.getParameter("txtSalario");
               String strTelefonoOf = request.getParameter("txtTelefonoOf");
               String strEmailC  = request.getParameter("txtEmailC");
               String strUsuario = request.getParameter("txtUsuario");
               String strPassword= request.getParameter("txtPassword");
               String strAdmin = request.getParameter("txtAdmin");                  
               String strEstado = request.getParameter("txtEstado");    
               String strEsAdmin = request.getParameter("txtEsAdmin");  
               String strValores;                         
               
               if (!(strEsAdmin.equals("S"))){          
                    strUsuario = "";
                    strPassword = "";
                    strAdmin = "N";                                                                            
                }

                if(strFechaInicioC.equals("null")){
                    strFechaInicioC = null;
                }else{
                    strFechaInicioC = "'" + strFechaInicioC + "'";
                }

                if(strFechaNac.equals("null")){
                    strFechaNac = null;
                }else{
                    strFechaNac = "'" + strFechaNac + "'";
                }

                if(strFechaVin.equals("null")){
                    strFechaVin = null;
                }else{
                    strFechaVin = "'" + strFechaVin + "'";
                }

                if(strFechaFinC.equals("null")){
                    strFechaFinC = null;
                } else{
                    strFechaFinC = "'" + strFechaFinC + "'";
                }                
                                                                      
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar duplicidad.
                    strResult = validarRegistro(strNroId,"P");           
                  
                    if (strResult != null){
                        out.println(strResult);
                    }else{                                                                                               
                                                
                        strValores = "'" + strNroId + "','" + strNombre + "'," + strFechaInicioC + "," + strFechaFinC + ",'" + strTelefonoOf + "','" + strTelefonoRes + "','" + strSalario + "'," + strFechaVin + "," + strFechaNac + ",'" +
                                           strLugarRes + "','" + strDireccion + "','" + strBarrio + "','" + strCelular + "','" + strEmailP + "','" + strLugarExp + "','" + strCargo + "','" + strTipoContrato + "','" + strJefe + "','" +
                                           strEstadoCivil + "','" + strTipoVivienda + "','" + strMedioTrans + "','" + strTipoId + "','" + strUsuario + "','" + strPassword + "','" + strAdmin + "','" + strEmailC + "','" + strEstado + "'";    
                                                
                        strSQL = "INSERT INTO users_personas (txtIdentificacion,txtNombreCompleto,dtFechaInicio,dtFechaFin,txtTelOficina,txtTelResidencia,txtSalario,dtFechaVinculacion,dtFechaNacimiento,txtLugarResidencia,txtDireccion,txtBarrio,txtTelCelular,txtEmail,txtLugarExpedicion,txtCargo,txtTipoContratacion,txtJefeInmediato,txtEstadoCivil,txtTipoVivienda,txtMedioTransporte,txtTipoId,txtUsuario,txtPassword,txtAdministrador,txtEmailC,txtEstadoActual) VALUES(" + strValores + ");";
                       
                    }
               }               
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   
                   if (strEsAdmin.equals("S")){
                       strSQL = "update users_personas set txtNombreCompleto = '" + strNombre + "', dtFechaInicio = " + strFechaInicioC + ", dtFechaFin = " + strFechaFinC + ", txtTelOficina = '" + strTelefonoOf + 
                                 "', txtTelResidencia = '" + strTelefonoRes + "', txtSalario = '" + strSalario + "', dtFechaVinculacion = " + strFechaVin + ", dtFechaNacimiento = " + strFechaNac + 
                                 ", txtLugarResidencia = '" + strLugarRes + "', txtDireccion = '" + strDireccion + "', txtBarrio = '" + strBarrio + "', txtTelCelular = '" + strCelular + 
                                 "', txtEmail = '" + strEmailP + "', txtLugarExpedicion = '" + strLugarExp + "', txtCargo = '" + strCargo + "', txtTipoContratacion = '" + strTipoContrato + 
                                 "', txtJefeInmediato = '" + strJefe + "', txtEstadoCivil = '" + strEstadoCivil + "', txtTipoVivienda = '" + strTipoVivienda + "', txtMedioTransporte = '" + strMedioTrans + 
                                 "', txtTipoId = '" + strTipoId + "', txtUsuario = '" + strUsuario + "', txtPassword = '" + strPassword + "', txtAdministrador = '" + strAdmin + "', txtEmailC = '" + strEmailC + "', txtEstadoActual = '" + strEstado +
                                 "' where txtIdentificacion='" + strNroId + "'";
                   }else{
                       strSQL = "update users_personas set txtNombreCompleto = '" + strNombre + "', dtFechaInicio = " + strFechaInicioC + ", dtFechaFin = " + strFechaFinC + ", txtTelOficina = '" + strTelefonoOf + 
                                 "', txtTelResidencia = '" + strTelefonoRes + "', txtSalario = '" + strSalario + "', dtFechaVinculacion = " + strFechaVin + ", dtFechaNacimiento = " + strFechaNac + 
                                 ", txtLugarResidencia = '" + strLugarRes + "', txtDireccion = '" + strDireccion + "', txtBarrio = '" + strBarrio + "', txtTelCelular = '" + strCelular + 
                                 "', txtEmail = '" + strEmailP + "', txtLugarExpedicion = '" + strLugarExp + "', txtCargo = '" + strCargo + "', txtTipoContratacion = '" + strTipoContrato + 
                                 "', txtJefeInmediato = '" + strJefe + "', txtEstadoCivil = '" + strEstadoCivil + "', txtTipoVivienda = '" + strTipoVivienda + "', txtMedioTransporte = '" + strMedioTrans + 
                                 "', txtTipoId = '" + strTipoId + "', txtEmailC = '" + strEmailC + "', txtEstadoActual = '" + strEstado +
                                 "' where txtIdentificacion='" + strNroId + "'";
                   }                           
               }                        
             
           }                                              

           if (!strSQL.equals("")){
               strMensaje = GestionSQL.ejecuta(strSQL);

               if (strMensaje == null){
                   //Inserción exitosa.                   
                   
                   out.println("<html>");
                   out.println("<head>");
                   
                   if (!(strForm.equals("frmGeneral"))){                           
                        out.println("<script type='text/javascript'>");                         
                        out.println("setTimeout(function(){javascript:window.close();},2500);");
                        out.println("opener.frmRefresh.btnRefresh.click();");                       
                        out.println("</script>");                             
                    }      
                   
                    out.println("</head>");
                    out.println("<body>");         
                    out.println("<div class='TEXTOEXITO'>");                                                     
                    out.println("El registro fue ingresado correctamente!.");                  
                    out.println("</div>");                   
                    out.println("</body>");
                    out.println("</html>");                   
               }else{
                   //Inserción fallida                   
                   out.println("<html>");
                   out.println("<head>");
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<div class='TEXTOFALLO'>");
                   out.println("Se produjo el siguiente error al insertar el registro: " + strMensaje);
                   out.println("</div>");                  
                   out.println("</body>");
                   out.println("</html>");
               }
           }
        } finally {
            out.close();
        }        
    }
            
    private String validarRegistro(String strClave,String strAccion){
        
        String[] strResult = null;
        String strSQL = null;
        String strMensaje = null;
        
        // Eventos
        // D: Duplicidad de Registros.
        // E: Eliminación de Registro.
        
        // Redes.
        
        if (strAccion.equals("R")){
                strSQL = "select c.txtIdentificacion from users_redes c where c.txtIdentificacion = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de red con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Cargos.
        
        if (strAccion.equals("C")){
                strSQL = "select c.txtIdentificacion from users_cargos c where c.txtIdentificacion = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de cargo con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Centros de costos.
        
        if (strAccion.equals("CC")){
                strSQL = "select c.txtCodigo from users_centros_costos c where c.txtCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de centro de costos con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
       // Día no hábil.
        
        if (strAccion.equals("DNH")){
                strSQL = "select d.dtFecha from users_dias_no_habiles d where d.dtFecha = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de día no hábil para la fecha " + strClave + ". Por favor seleccione una fecha diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Grupos.
        
        if (strAccion.equals("G")){
                strSQL = "select g.txtCodigo from users_grupos_siu g where g.txtCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de grupo con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Procesos.
        
        if (strAccion.equals("PR")){
                strSQL = "select p.txtCodigo from users_procesos p where p.txtCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de proceso con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Servicios.
        
        if (strAccion.equals("S")){
                strSQL = "select s.txtCodigo from users_servicios s where s.txtCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de servicio con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Estados Civiles.
        
        if (strAccion.equals("EC")){
                strSQL = "select ec.txtIdentificador from users_estados_civiles ec where ec.txtIdentificador = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de estado civil con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
         // Medios de Transporte.
        
        if (strAccion.equals("MT")){
                strSQL = "select mt.txtIdentificador from users_medios_transporte mt where mt.txtIdentificador = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de medio de transporte con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Tipos de Contratación.
        
        if (strAccion.equals("TC")){
                strSQL = "select tc.txtIdentificador from users_tipos_contratacion tc where tc.txtIdentificador = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de tipo de contratación con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Tipos de Identificación.
        
        if (strAccion.equals("TI")){
                strSQL = "select ti.txtIdentificador from users_tipos_id ti where ti.txtIdentificador = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de tipo de identificación con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Tipos de Vivienda.
        
        if (strAccion.equals("TV")){
                strSQL = "select tv.txtIdentificacion from users_tipos_vivienda tv where tv.txtIdentificacion = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de tipo de vivienda con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Aplicación.
        
        if (strAccion.equals("APP")){
                strSQL = "select a.txtCodigo from users_apps a where a.txtCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de aplicación con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Aplicación por Persona.
        
        if (strAccion.equals("AxP")){
                String[] strTemp = strClave.split(",");
                
                strSQL = "select axp.txtApp from users_appsxpersona axp where axp.txtApp = '" + strTemp[0] + "' and txtPersona= '" + strTemp[1] + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de aplicación por persona para los valores seleccionados. Por favor seleccione valores diferentes.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
                        
        // Servicio por Responsable.
        
        if (strAccion.equals("SxR")){
                String[] strTemp = strClave.split(",");
                
                strSQL = "select s.txtServicio from users_servicios_x_responsable s where s.txtServicio = '" + strTemp[0] + "' and txtResponsable = '" + strTemp[1] + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de servicio por responsable para los valores seleccionados. Por favor seleccione valores diferentes.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
        }
        
        // Persona.
        
        if (strAccion.equals("P")){ 
                strSQL = "select p.txtIdentificacion from users_personas p where p.txtIdentificacion = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "</head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de persona con la identificación " + strClave + ". Por favor ingrese una identificación diferente.\n";
                strMensaje = strMensaje + "</div>\n";
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
