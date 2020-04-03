function validarCampoVacio(campo,nombre){
	
    if (campo.value == ""){
            return nombre + "\n";
    }	
    return "";	
}

function validarCampoSelect(campo,nombre){
    if (campo.selectedIndex == 0){
        return nombre + "\n";
    }
    return "";
}

function cerrarSesion(){
    window.location = "cerrar.jsp";
}

function obtiene_fecha() {  
      
    var fecha_actual = new Date()  
  
    var dia = fecha_actual.getDate();  
    var mes = fecha_actual.getMonth() + 1;
    var anio = fecha_actual.getFullYear();  
  
    if (mes < 10)  
        mes = '0' + mes;  
  
    if (dia < 10)  
        dia = '0' + dia; 
  
    return (anio + "-" + mes + "-" + dia);
}

function setCalendario(campo,imagen){
    Calendar.setup({
        inputField: campo,
        ifFormat: "%Y-%m-%d",
        button: imagen,
        align: "TI",
        singleClick: true
    });
}

function deleteSpecialSigns(strCadena){   
    
    strCadena = strCadena.replace("#","Nro.");   
    
    return strCadena;
    
}

function trim(strCadena){
    
    return strCadena.replace(/^\s+/g,'').replace(/\s+$/g,'');
}

function hideAjaxMsg(strId){
    
    strValor = "<html>\n";
    strValor += "<head>\n";
    strValor += "</head>\n";
    strValor += "<body>\n";
    strValor += "</body>\n";
    strValor += "</html>";    
    
    mensaje = document.getElementById(strId)
    mensaje.innerHTML = strValor;
    mensaje.style.display = "none";
}

function showAjaxMsg(strId){
    document.getElementById(strId).style.display = "block";
}

function onLoad(){
    form = document.frmCambioPwd; 
     
    document.getElementById("dMensaje").style.display = "none";
    form.txtPwdActual.focus();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function limpiarForm(){
    form = document.frmCambioPwd; 
    
    form.txtPwdActual.value = "";
    form.txtPwdNueva1.value = "";
    form.txtPwdNueva2.value = "";
    
    ocultarDIV();
    form.txtPwdActual.focus();
}

function validarCambioPwd(){
    form = document.frmCambioPwd; 
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
    
     strMsg += validarCampoVacio(form.txtPwdActual,"Contraseña actual");
     strMsg += validarCampoVacio(form.txtPwdNueva1,"Contraseña nueva");
     strMsg += validarCampoVacio(form.txtPwdNueva2,"Repetir contraseña nueva");
     
     strPwdActual = form.txtPwdActual.value;
     strPwdNueva1 = form.txtPwdNueva1.value;
     strPwdNueva2 = form.txtPwdNueva2.value;
     
      if (strMsg != ""){
            strMsg = strHead + strMsg;
            alert(strMsg);
            
            if ((strPwdActual == "") && (strPwdNueva1 == "") && (strPwdNueva2 == "")){
                    form.txtPwdActual.focus();
            }else{
                    if (strPwdActual == ""){
                            form.txtPwdActual.focus();
                    }else{
                        if (strPwdNueva1 == ""){
                            form.txtPwdNueva1.focus();
                        }else{
                            form.txtPwdNueva2.focus();
                        }                            
                    }
            }
            return false;
    }
    
    if (strPwdNueva1 != strPwdNueva2){
        alert("Las contraseñas ingresadas no coinciden. Intente nuevamente!.");
        form.txtPwdNueva1.value = "";
        form.txtPwdNueva2.value = "";
        form.txtPwdNueva1.focus();
        return false;
    }
    
    if (strPwdActual == strPwdNueva1){
        alert("La contraseña actual debe ser diferente a la nueva. Por favor ingrese una nueva contraseña.");
        form.txtPwdNueva1.value = "";
        form.txtPwdNueva2.value = "";
        form.txtPwdNueva1.focus();
        return false;
    }
     
    strUsuario = form.txtUsuario.value;          
    document.getElementById("dMensaje").style.display = "block";
    
    getXMLHTTPRequest("CambioPWD?txtUsuario=" + strUsuario +"&txtPwdActual=" + strPwdActual + "&txtPwdNueva=" + strPwdNueva1,"dMensaje");
    
    form.txtPwdActual.value = "";
    form.txtPwdNueva1.value = "";
    form.txtPwdNueva2.value = "";
    
}