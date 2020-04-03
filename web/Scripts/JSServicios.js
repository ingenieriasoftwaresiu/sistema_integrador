var form;

function cargaBody(){	
        form = document.frmServicio;	             
        strAccion = form.txtAccion.value;
        
        if (strAccion == "C"){
            form.txtCodigo.focus();  
        }else{
            form.txtNombre.focus();
        }
}

function limpiarFormServicio(){	
        form.txtCodigo.value = "";
        form.txtNombre.value = "";
        form.txtProceso.value = "S";
        
        form.txtCodigo.focus();   
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormServicio(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoVacio(form.txtCodigo,"Código");
    strMsg += validarCampoVacio(form.txtNombre,"Nombre");
    strMsg += validarCampoSelect(form.txtProceso,"Proceso asociado");

    if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);

            strCodigo = form.txtCodigo.value;
            strNombre = form.txtNombre.value;

            if ((strCodigo == "") && (strNombre == "")){
                    form.txtCodigo.focus();
            }else{
                    if (strCodigo == ""){
                            form.txtCodigo.focus();
                    }else{
                            form.txtNombre.focus();
                    }
            }

            return false;
    }
        
    strAccion = form.txtAccion.value;
    strProceso = form.txtProceso.value;
    document.getElementById("dMensaje").style.display = "block";
    
    getXMLHTTPRequest("..//Registro?txtForm=" + form.txtForm.value +"&txtCodigo=" + form.txtCodigo.value + "&txtNombre=" + encodeURIComponent(form.txtNombre.value) + "&txtProceso=" + strProceso + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");

    if (form.txtAccion.value == "C"){
        form.txtCodigo.value = "";
        form.txtNombre.value = "";
        form.txtProceso.value = "S";
        form.txtCodigo.focus();
    }else{
        form.txtNombre.focus();
    }
}