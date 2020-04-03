/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var form;

function cargaBody(){	
    form = document.frmDiaNoHabil;	             
    strAccion = form.txtAccion.value;

    if (strAccion == "C"){
        form.txtFecha.focus();  
    }else{
        form.txtNombre.focus();
    }
}

function limpiarFormEstadoCivil(){	
    form.txtFecha.value = "";
    form.txtNombre.value = "";

    form.txtFecha.focus();   

    ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormEstadoCivil(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoVacio(form.txtFecha,"Fecha");
    strMsg += validarCampoVacio(form.txtNombre,"Nombre");

    if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);

            strFecha = form.txtFecha.value;
            strNombre = form.txtNombre.value;

            if ((strFecha == "") && (strNombre == "")){
                    form.txtFecha.focus();
            }else{
                    if (strFecha == ""){
                            form.txtFecha.focus();
                    }else{
                            form.txtNombre.focus();
                    }
            }

            return false;
    }
        
    strAccion = form.txtAccion.value;
    document.getElementById("dMensaje").style.display = "block";
    
    getXMLHTTPRequest("..//Registro?txtForm=" + form.txtForm.value +"&txtFecha=" + form.txtFecha.value + "&txtNombre=" + encodeURIComponent(form.txtNombre.value) + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");

    if (form.txtAccion.value == "C"){
        form.txtFecha.value = "";
        form.txtNombre.value = "";
        form.txtFecha.focus();
    }else{
        form.txtNombre.focus();
    }
}

function cargarCalendarios(){
    setCalendario("txtFecha","imgFecha");
}
