<%-- 
    Document   : principal
    Created on : 18/04/2012, 11:00:36 AM
    Author     : jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<!DOCTYPE html>

<%
    String strCedula = (String) session.getAttribute("strCedula");
    String strNombre = (String) session.getAttribute("strNombre");        
        
    String[] strTemp;
    Vector arrApps;
    Vector arrNombre = new Vector();
    Vector arrDescripcion = new Vector();
    Vector arrResponsable = new Vector();
    Vector arrURL = new Vector();
           
    arrApps = GestionSQL.consultaSQL("select a.txtNombre, a.txtDescripcion, p.txtNombreCompleto, a.txtUrlAcceso from users_appsxpersona axp, users_apps a, users_personas p where (a.txtCodigo = axp.txtApp) and (p.txtIdentificacion = a.txtResponsable) and txtPersona = '" + strCedula + "' ORDER BY a.txtNombre, a.txtDescripcion, p.txtNombreCompleto","APPS");
    
    if (arrApps != null){
        for (int i=0;i<arrApps.size();i++){
            strTemp = arrApps.get(i).toString().split(",");
            arrNombre.add(strTemp[0]);
            arrDescripcion.add(strTemp[1]);
            arrResponsable.add(strTemp[2]);
            arrURL.add(strTemp[3]);
        }
    }        
   %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesPpal.css" />
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSComunes.js"></script>
        <script type='text/javascript' charset="UTF-8" src='Scripts/JSVisualizacion.js'></script>
        <script type='text/javascript'>
            function disableKeyPress(evt){               
                var evt = (evt) ? evt : ((event) ? event : null); 
                var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
                if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
            }
        </script>
        <title>Menú Principal de Aplicaciones SIU</title>
    </head>
    <body OnKeyPress="return disableKeyPress(event)">
        <%
            if (strNombre == null){
                response.sendRedirect("cerrar.jsp");
            }
        %>
        <jsp:include page="Header.jsp" />
        <div align="center">         
            <br>
            <table cellspacing="0" cellpadding="0" width="1200px" border="0">
                <tr>             
                    <td class="USERLOGED"><b>Bienvenido(a),</b> <%=strNombre%></td>                     
                    <td class="TEXTOPWD" style="text-align: center;border-right: 1px solid #116043;width: 140px;"><input type="button" value="Cambiar contraseña" class="BOTONFORM" onclick="abrirCambioPwd()" style="width: 120px;"></td>
                    <td class="CIERRESESION" style="text-align: right;width: 90px;"><input type="button" value="Cerrar sesión" class="BOTONFORM" onclick="cerrarSesion()"></td>
                </tr>
            </table>
            <br>
            <% if (arrApps == null){%>
                <br />
                <div class="TEXTONOACCESO">
                    <u><b>ADVERTENCIA</b></u><br />No cuentas con autorización para acceder a las aplicaciones SIU.<br />Para mayor información, puedes contactar el área de Ingeniería de Software SIU (Ext: 6429).
                </div>                   
            <%} else{%>
            <div class="TEXTONOTA" align="center">
                Presione sobre el botón ubicado en la columna Ingresar para acceder a la aplicación deseada.
            </div>                
            <br /><br />
            <table cellspacing="0" cellpadding="5" width="1200px" border="0" class="TABLARESULT">
                <tr>
                    <td colspan="6" class="TITULOMENU">MENÚ PRINCIPAL DE APLICACIONES SIU</td>
                </tr>            
                <tr>
                    <td class="SUBTITULOMENU" style="border-right: 1px dashed #116043;">Nombre de la Aplicación</td>
                    <td class="SUBTITULOMENU" style="border-right: 1px dashed #116043;">Descripción</td>
                    <td class="SUBTITULOMENU" style="border-right: 1px dashed #116043;">Responsable</td>
                    <td class="SUBTITULOMENU">Ingresar</td>
                </tr>
                <%String strRuta;
                    for (int i=0;i<arrNombre.size();i++){
                        strRuta = arrURL.get(i).toString();
                %>
                        <tr class="FILARESULT">
                            <td class="TEXTORESULT" style="text-align: left;border-right: 1px dashed #116043;"><%=arrNombre.get(i)%></td>                                
                            <td class="TEXTORESULT" style="text-align: left;border-right: 1px dashed #116043;"><%=arrDescripcion.get(i)%></td>
                            <td class="TEXTORESULT" style="border-right: 1px dashed #116043;"><%=arrResponsable.get(i)%></td>
                            <td class="TEXTORESULT"><input type="button" name="btnIngresar" id="btnIngresar" value="" onclick="abrirApp('<%=strRuta + "?txtCedula=" + strCedula%>&preload=true')" class="BOTONINGRESAR">                                
                        </tr>
                <%}%>
            </table>
            <%}%>             
        </div>        
        <div style="padding-top: 50px;"></div>			
       <jsp:include page="footer.jsp" />
     </body>
</html>
