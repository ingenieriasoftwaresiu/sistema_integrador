var form;

function cargaBody(){		
    form = document.frmLogin;
    form.txtUsuario.focus();
    
    hideAjaxMsg("dMensaje");
}


function limpiarFormLogin(){	
    form.txtUsuario.value = "";
    form.txtPwd.value = "";	
    form.txtUsuario.focus();
    
    hideAjaxMsg("dMensaje");
}

function validarFormLogin(){
        
    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

    strMsg += validarCampoVacio(form.txtUsuario,"Usuario");
    strMsg += validarCampoVacio(form.txtPwd,"Contraseña");
    
    var strUsuario = form.txtUsuario.value;
    var strPwd = form.txtPwd.value;

    if (strMsg != ""){
        strMsg = strHead + strMsg;
        alert(strMsg);
       
        if ((strUsuario == "") && (strPwd == "")){
                form.txtUsuario.focus();
        }else{
                if (strUsuario == ""){
                        form.txtUsuario.focus();
                }else{
                        form.txtPwd.focus();
                }
        }		
        return false;
    }
    
    // Control de SQL Injection.
    
    if (strUsuario == "' or true -- "){
        form.txtUsuario.value = "";
        form.txtPwd.value = "";
        form.txtUsuario.focus();
        return false;
    }
        
    getXMLHTTPRequest("Ingreso?txtUsuario=" + form.txtUsuario.value +"&txtPwd=" + form.txtPwd.value,"dMensaje","principal.jsp");
    showAjaxMsg("dMensaje");    
}

$(function(){
    $("#txtUsuario").keypress(function(event){
        if (event.which == 13){
            event.preventDefault();
            $("#btnIngresar").click();
        }
   });
    
    $("#txtPwd").keypress(function(event){
        if (event.which == 13){
            event.preventDefault();
            $("#btnIngresar").click();
        }
    }); 
});