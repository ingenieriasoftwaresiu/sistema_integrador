var form;

function cargaBody(){	
    form = document.frmServicioXResp;	    
    
    form.txtServicio.focus();    
}

function limpiarFormServicioXResp(){	
    form.txtServicio.value = "S";
    form.txtServicio.text = "Seleccione una opción";
    form.txtPersona.value = "S";
    form.txtPersona.text = "Seleccione una opción";

    form.txtServicio.focus();   

    ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormServicioXResp(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoSelect(form.txtServicio,"Servicio");
    strMsg += validarCampoSelect(form.txtPersona,"Responsable");
    
    if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);

            strServicio = form.txtServicio.value;
            strPersona = form.txtPersona.value;

            if ((strServicio == "") && (strPersona == "")){
                    form.txtServicio.focus();
            }else{
                    if (strServicio == ""){
                            form.txtServicio.focus();
                    }else{
                            form.txtPersona.focus();
                    }
            }
            return false;
    }
        
    strAccion = form.txtAccion.value;
    document.getElementById("dMensaje").style.display = "block";
    var strData = "..//Registro?txtForm=" + form.txtForm.value +"&txtServicio=" + form.txtServicio.value + "&txtPersona=" + form.txtPersona.value + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value;
    
    getXMLHTTPRequest(strData,"dMensaje");

    if (form.txtAccion.value == "C"){
        form.txtServicio.value = "S";
        form.txtServicio.text = "Seleccione una opción";
        form.txtPersona.value = "S";
        form.txtPersona.text = "Seleccione una opción";
    }else{
        form.txtServicio.focus();
    }
}