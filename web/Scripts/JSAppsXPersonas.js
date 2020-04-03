var form;

function cargaBody(){	
    form = document.frmAppxPersona;	    
    
    form.txtAplicacion.focus();    
}

function limpiarFormAppXPersona(){	
    form.txtAplicacion.value = "S";
    form.txtAplicacion.text = "Seleccione una opción";
    form.txtPersona.value = "S";
    form.txtPersona.text = "Seleccione una opción";

    form.txtAplicacion.focus();   

    ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormAppXPersona(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoSelect(form.txtAplicacion,"Aplicación");
    strMsg += validarCampoSelect(form.txtPersona,"Persona");
    
    if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);

            strAplicacion = form.txtAplicacion.value;
            strPersona = form.txtPersona.value;

            if ((strAplicacion == "") && (strPersona == "")){
                    form.txtAplicacion.focus();
            }else{
                    if (strAplicacion == ""){
                            form.txtAplicacion.focus();
                    }else{
                            form.txtPersona.focus();
                    }
            }
            return false;
    }
        
    strAccion = form.txtAccion.value;
    document.getElementById("dMensaje").style.display = "block";

    getXMLHTTPRequest("Registro?txtForm=" + form.txtForm.value +"&txtApp=" + form.txtAplicacion.value + "&txtPersona=" + form.txtPersona.value + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");

    if (form.txtAccion.value == "C"){
        form.txtAplicacion.value = "S";
        form.txtAplicacion.text = "Seleccione una opción";
        form.txtPersona.value = "S";
        form.txtPersona.text = "Seleccione una opción";
    }else{
        form.txtAplicacion.focus();
    }
}