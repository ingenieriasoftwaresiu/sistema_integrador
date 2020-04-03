var form;

function cargaBody(){	
        form = document.frmPersona;        
        strAccion = form.txtAccion.value;
        
        if (strAccion == "C"){
            form.txtTipoId.focus();  
        }else{
            form.txtLugarExp.focus();            
        }              
}

function limpiarFormPersona(){	
        form.txtTipoId.value = "S";
        form.txtTipoId.text = "Seleccione una opción";
        form.txtNroId.value = "";
        form.txtLugarExp.value = "";
        form.txtNombre.value = "";
        form.txtEstadoCivil.value = "S";
        form.txtEstadoCivil.text = "Seleccione una opción";
        form.txtLugarRes.value = "";
        form.txtDireccion.value = "";
        form.txtBarrio.value = "";
        form.txtTelefonoRes.value = "";
        form.txtTipoVivienda.value = "S";
        form.txtTipoVivienda.text = "Seleccione una opción";
        form.txtMedioTrans.value = "S";
        form.txtMedioTrans.text = "Seleccione una opción";
        form.txtFechaNac.value = "";
        form.txtCelular.value = "";
        form.txtEmailP.value = "";
        form.txtFechaVin.value = "";
        form.txtFechaInicioC.value = "";
        form.txtFechaFinC.value = "";
        form.txtTipoContrato.value = "S";
        form.txtTipoContrato.text = "Seleccione una opción";
        form.txtCargo.value = "S";
        form.txtCargo.text = "Seleccione una opción";
        form.txtJefe.value = "S";
        form.txtJefe.text = "Seleccione una opción";
        form.txtSalario.value = "";
        form.txtTelefonoOf.value = "";
        form.txtEmailC.value = "";
        form.txtUsuario.value = "";
        form.txtPassword.value = "";
        form.txtAdmin.value = "SO";      
        form.txtAdmin.text = "Seleccione una opción";
        form.txtEstado.value = "S";      
        form.txtEstado.text = "Seleccione una opción";
        
        form.txtTipoId.focus();       
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormPersona(){
        
        var strMsg = "";
        var strMsgTotal = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
        var strMsgSeccionDG = "SECCIÓN: DATOS GENERALES\n\n";
        var strMsgSeccionDL = "SECCIÓN: DATOS LABORALES\n\n";
        var strMsgTotalSeccionDG = "";
        var strMsgTotalSeccionDL = "";
        
        // Validar campos obligatorios.

        strMsg += validarCampoSelect(form.txtTipoId,"Tipo de identificación");
        strMsg += validarCampoVacio(form.txtNroId,"Nro. de identificación");
        strMsg += validarCampoVacio(form.txtNombre,"Nombre completo");
        strMsg += validarCampoSelect(form.txtEstado,"Estado actual");
               
        
        if (strMsg != ""){
            strMsgTotalSeccionDG = strMsgSeccionDG + strMsg + "\n";                  
        }
         
	
        strMsgTotal = strMsgTotalSeccionDG;
       
        if (strMsgTotal != ""){
                strMsgTotal = strHead + strMsgTotal;
                alert(strMsgTotal);
                return false;
        } 
        
        // Gestión de campos opcionales.
        
        var strLugarExp;
        var strEstadoCivil;
        var strLugarRes;
        var strDireccion;
        var strBarrio;
        var strTelefonoRes;
        var strTipoVivienda;
        var strMedioTrans;
        var strFechaNac;
        var strFechaVin;
        var strFechaInicioC;
        var strTipoContrato;
        var strCargo;
        var strTelefonoOf;
        var strEmailC;
        
        strLugarExp = validarVacioTexto(form.txtLugarExp.value);        
        strEstadoCivil = validarVacioLista(form.txtEstadoCivil.value); 
        strLugarRes = validarVacioTexto(form.txtLugarRes.value);
        strDireccion = validarVacioTexto(form.txtDireccion.value);
        strBarrio = validarVacioTexto(form.txtBarrio.value);
        strTelefonoRes = validarVacioTexto(form.txtTelefonoRes.value);
        strTipoVivienda = validarVacioLista(form.txtTipoVivienda.value);        
        strMedioTrans = validarVacioLista(form.txtMedioTrans.value);
        strFechaNac = validarVacioFecha(form.txtFechaNac.value); 
        strFechaVin = validarVacioFecha(form.txtFechaVin.value);
        strFechaInicioC = validarVacioFecha(form.txtFechaInicioC.value);
        strTipoContrato = validarVacioLista(form.txtTipoContrato.value);
        strCargo = validarVacioLista(form.txtCargo.value);       
        strTelefonoOf = validarVacioTexto(form.txtTelefonoOf.value);
        strEmailC = validarVacioTexto(form.txtEmailC.value);   
                      
        if ((strDireccion != "") && (strDireccion != null)){            
            form.txtDireccion.value = deleteSpecialSigns(strDireccion)
        }
        
        var strAdmin = form.txtAdmin.value;
        
        if (strAdmin == "" || strAdmin == "SO"){
            strAdmin = "N";
        }
        
        var strTipoId =  form.txtTipoId.value;
        var strNroId = form.txtNroId.value;
        var strNombre = form.txtNombre.value;
        var strCelular = validarVacioTexto(form.txtCelular.value);
        var strEmailP = validarVacioTexto(form.txtEmailP.value);
        var strFechaFinC = validarVacioFecha(form.txtFechaFinC.value);
        var strJefe = form.txtJefe.value;
        var strSalario = validarVacioTexto(form.txtSalario.value);
        var strUsuario = form.txtUsuario.value;
        var strPassword = form.txtPassword.value;
        var strEstado = form.txtEstado.value;
        var strEsAdmin = form.txtEsAdmin.value;
        var strForm = form.txtForm.value;
        var strAccion = form.txtAccion.value;
        var strCodigoM = form.txtCodigoM.value;
      
        document.getElementById("dMensaje").style.display = "block";  
        var strURL;
                
        strURL = "txtForm=" + strForm+"&txtTipoId=" + strTipoId + "&txtNroId=" + strNroId + "&txtLugarExp=" + encodeURIComponent(strLugarExp) + 
                     "&txtNombre=" + encodeURIComponent(strNombre) + "&txtEstadoCivil=" + strEstadoCivil + "&txtLugarRes=" + encodeURIComponent(strLugarRes) + 
                     "&txtDireccion=" + encodeURIComponent(strDireccion) + "&txtBarrio=" + encodeURIComponent(strBarrio) + "&txtTelefonoRes=" + strTelefonoRes + 
                     "&txtTipoVivienda=" + strTipoVivienda + "&txtMedioTrans=" + strMedioTrans + "&txtFechaNac=" + strFechaNac + "&txtCelular=" + strCelular +
                     "&txtEmailP=" + strEmailP + "&txtFechaVin=" + strFechaVin + "&txtFechaInicioC=" + strFechaInicioC + "&txtFechaFinC=" + strFechaFinC +
                     "&txtTipoContrato=" + strTipoContrato + "&txtCargo=" + strCargo + "&txtJefe=" + strJefe + "&txtSalario=" + strSalario +
                     "&txtTelefonoOf=" + strTelefonoOf + "&txtEmailC=" + strEmailC+ "&txtEstado=" + strEstado+ "&txtAccion=" + strAccion + 
                     "&txtCodigoM=" + strCodigoM + "&txtEsAdmin=" + strEsAdmin; 
             
        if (strEsAdmin == "S"){           
            strURL = strURL + "&txtUsuario=" + strUsuario + "&txtPassword=" + strPassword + "&txtAdmin=" + strAdmin;   
        }             
                      
        getXMLHTTPRequest("..//Registro?" + strURL,"dMensaje");
        
        if (form.txtAccion.value == "C"){
            form.txtTipoId.value = "S";
            form.txtTipoId.text = "Seleccione una opción";
            form.txtNroId.value = "";
            form.txtLugarExp.value = "";
            form.txtNombre.value = "";
            form.txtEstadoCivil.value = "S";
            form.txtEstadoCivil.text = "Seleccione una opción";
            form.txtLugarRes.value = "";
            form.txtDireccion.value = "";
            form.txtBarrio.value = "";
            form.txtTelefonoRes.value = "";
            form.txtTipoVivienda.value = "S";
            form.txtTipoVivienda.text = "Seleccione una opción";
            form.txtMedioTrans.value = "S";
            form.txtMedioTrans.text = "Seleccione una opción";
            form.txtFechaNac.value = "";
            form.txtCelular.value = "";
            form.txtEmailP.value = "";
            form.txtFechaVin.value = "";
            form.txtFechaInicioC.value = "";
            form.txtFechaFinC.value = "";
            form.txtTipoContrato.value = "S";
            form.txtTipoContrato.text = "Seleccione una opción";
            form.txtCargo.value = "S";
            form.txtCargo.text = "Seleccione una opción";
            form.txtJefe.value = "S";
            form.txtJefe.text = "Seleccione una opción";
            form.txtSalario.value = "";
            form.txtTelefonoOf.value = "";
            form.txtEmailC.value = "";
            form.txtUsuario.value = "";
            form.txtPassword.value = "";
            form.txtAdmin.value = "SO";      
            form.txtAdmin.text = "Seleccione una opción";  
            form.txtEstado.value = "S";      
            form.txtEstado.text = "Seleccione una opción";
            
            form.txtTipoId.focus();   
        }else{
            form.txtLugarExp.focus();
        }
}

function cargarCalendarios(){
    setCalendario("txtFechaNac","imgFechaN");
    setCalendario("txtFechaVin","imgFechaV");
    setCalendario("txtFechaInicioC","imgFechaI");
    setCalendario("txtFechaFinC","imgFechaF");
}

function validarVacioTexto(strValor){
    if ((strValor == "") || (strValor == null)){
        return "-";
    }
    return strValor;
}

function validarVacioLista(strValor){
    if ((strValor == "S") || (strValor == null)){
        return "PD";
    }
    return strValor;
}

function validarVacioFecha(strValor){
    if ((strValor == "") || (strValor == null)){
        return null;
    }
    return strValor;
}

