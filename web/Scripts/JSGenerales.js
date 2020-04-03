var form;

function cargaBody(){	
        form = document.frmGeneral;	             
        strAccion = form.txtAccion.value;
        
        form.txtNroRegXPag.focus();
}

function limpiarFormGeneral(){	
        form.txtNroRegXPag.value = "";   
            
        form.txtNroRegXPag.focus();
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormGeneral(){
        
        var strMsg = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

        strMsg += validarCampoVacio(form.txtNroRegXPag,"Número de registros por página");

        if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);           
              
                form.txtNroRegXPag.focus();
                return false;
        }        
                
        strAccion = form.txtAccion.value;
        document.getElementById("dMensaje").style.display = "block";
        getXMLHTTPRequest("..//Registro?txtForm=" + form.txtForm.value +"&txtNroRegXPag=" + form.txtNroRegXPag.value + "&txtAccion=" + strAccion,"dMensaje");

       if (form.txtAccion.value == "C"){
            form.txtNroRegXPag.value = "";              
       }
       form.txtNroRegXPag.focus();
       
}