var form;

function cargaBody(){	
    form = document.frmAplicacion;	             
    strAccion = form.txtAccion.value;

    if (strAccion == "C"){
        form.txtCodigo.focus();  
    }else{
        form.txtNombre.focus();
    }
}

function limpiarFormAplicacion(){	
    form.txtCodigo.value = "";
    form.txtNombre.value = "";
    form.txtResponsable.value = "S";
    form.txtResponsable.text = "Seleccione una opción";
    form.txtUrlAcceso.value = "";
    form.txtDescripcion.value = "";

    form.txtCodigo.focus();   

    ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormAplicacion(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoVacio(form.txtCodigo,"Código");
    strMsg += validarCampoVacio(form.txtNombre,"Nombre");
    strMsg += validarCampoSelect(form.txtResponsable,"Responsable");
    strMsg += validarCampoVacio(form.txtUrlAcceso,"URL de acceso");
    strMsg += validarCampoVacio(form.txtDescripcion,"Descripción");
    
    if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);

            strCodigo = form.txtCodigo.value;
            strNombre = form.txtNombre.value;
            strResponsable = form.txtResponsable.value;
            strUrlAcceso = form.txtUrlAcceso.value;
            strDescripcion = form.txtDescripcion.value;

            if ((strCodigo == "") && (strNombre == "") && (strResponsable == "") && (strUrlAcceso == "") && (strDescripcion == "")){
                    form.txtCodigo.focus();
            }else{
                    if (strCodigo == ""){
                            form.txtCodigo.focus();
                    }else{
                            if (strNombre == ""){
                                form.txtNombre.focus();
                            }else{
                                if (strResponsable == ""){
                                    form.txtResponsable.focus();
                                }else{
                                    if (strUrlAcceso == ""){
                                        form.txtUrlAcceso.focus();
                                    }else{
                                        form.txtDescripcion.focus();
                                    }
                                }

                            }
                    }
            }
            return false;
    }
        
    strAccion = form.txtAccion.value;
    document.getElementById("dMensaje").style.display = "block";

    getXMLHTTPRequest("Registro?txtForm=" + form.txtForm.value +"&txtCodigo=" + form.txtCodigo.value + "&txtNombre=" + encodeURIComponent(form.txtNombre.value) + "&txtResponsable=" + form.txtResponsable.value + "&txtUrlAcceso=" + form.txtUrlAcceso.value + "&txtDescripcion=" + encodeURIComponent(form.txtDescripcion.value) + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");

    if (form.txtAccion.value == "C"){
        form.txtCodigo.value = "";
        form.txtNombre.value = "";
        form.txtResponsable.value = "S";
        form.txtResponsable.text = "Seleccione una opción";
        form.txtUrlAcceso.value = "";
        form.txtDescripcion.value = "";
        form.txtCodigo.focus();
    }else{
        form.txtNombre.focus();
    }
}