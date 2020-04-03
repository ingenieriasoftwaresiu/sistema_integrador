function abrirApp(strURL){
    window.open(strURL,'','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=1');
}

function onLoadBody(){
    getXMLHTTPRequest('..//Visualizacion?txtAccion=persona','dMostrar');
}

function abrirRegRed(strCodigo){
     window.open("red.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Red",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegCargo(strCodigo){
     window.open("cargo.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Cargo",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegCentroCostos(strCodigo){
    window.open("centro_costos.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Cargo",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegDiaNoHabil(strCodigo){
    window.open("dia_no_habil.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Cargo",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegGrupo(strCodigo){
     window.open("grupo.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Grupo",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegProceso(strCodigo){
     window.open("proceso.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Proceso",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegServicio(strCodigo){
     window.open("servicio.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Servicio",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegEstadoCivil(strCodigo){
     window.open("estadoCivil.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Estado_civil",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegMedioTrans(strCodigo){
     window.open("medioTransporte.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Medio_Transporte",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegTipoC(strCodigo){
     window.open("tipoContratacion.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Tipo_Contratacion",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegTipoId(strCodigo){
     window.open("tipoId.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Tipo_Identificación",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegTipoV(strCodigo){
     window.open("tipoVivienda.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Tipo_Vivienda",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=0');
}

function abrirRegPersona(strCodigo){
     window.open("persona.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Persona",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=1,scrollbars=1');
}

function abrirRegAplicacion(strCodigo){
     window.open("../aplicacion.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Aplicación",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=0,scrollbars=0');
}

function abrirRegAppXP(strCodigo){
    window.open("../appxpersona.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Aplicación_X_Persona",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=0,scrollbars=0');
}

function abrirRegServicioXResp(strCodigo){
    window.open("servicioxresp.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Servicio_X_Responsable",'top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=0,scrollbars=0');
}

function abrirCambioPwd(){
   window.open("Cambio_Contrasena.jsp","Cambio_de_contraseña",'top='+(screen.availHeight)/3+',left='+(screen.availWidth)/3+',width=350px,height =230px,toolbar=0 ,location=0,directories=0,status=0,menubar=0,resizable=1,scrolling=0,scrollbars=0');
}

function eliminarRegRed(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=red&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegCargo(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=cargo&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegCentroCostos(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=centro_costos&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegDiaNoHabil(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=diasNoHabiles&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegGrupo(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=grupo&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegProceso(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=proceso&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegServicio(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=servicio&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");   
    }
}

function eliminarRegEstadoCivil(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=estadoC&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");        
    }
}

function eliminarRegMedioTrans(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=medioTrans&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");          
    }
}

function eliminarRegTipoC(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){   
        getXMLHTTPRequest("..//Visualizacion?txtAccion=tipoC&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");        
    }
}

function eliminarRegTipoId(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){  
        getXMLHTTPRequest("..//Visualizacion?txtAccion=tipoId&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");        
    }
}

function eliminarRegTipoV(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){         
        getXMLHTTPRequest("..//Visualizacion?txtAccion=tipoV&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");    
    }
}

function eliminarRegApp(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=app&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");         
    }
}

function eliminarRegAppxP(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=appxp&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");         
    }
}

function eliminarRegServicioxResp(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=servicioxresp&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");         
    }
}

function eliminarRegPersona(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("..//Visualizacion?txtAccion=persona&txtEvento=Eliminar&txtCodigo=" + strCodigo,"dMostrar");        
    }
}

function buscarRegistro(strAccion){
    form = document.frmBusqueda;  

    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
	
    strMsg += validarCampoSelect(form.txtCriterio,"Criterio");
    strMsg += validarCampoVacio(form.txtClave,"Clave");
    
    if (strMsg != ""){
        strMsg = strHead + strMsg;
        alert(strMsg);

        strCriterio = form.txtCriterio;
        strClave = form.txtClave.value;                

        if ((strCriterio.selectedIndex == 0) && (strClave == "")){
                form.txtCriterio.focus();
        }else{
                if (strCriterio.selectedIndex == 0){
                        form.txtCriterio.focus();
                }else{
                        form.txtClave.focus();
                }
        }

        return false;
      }
      var strRequest = '..//Visualizacion?txtAccion=' + strAccion + '&txtEvento=busqueda&txtCriterio=' + form.txtCriterio.value + '&txtClave=' + form.txtClave.value;   
      getXMLHTTPRequest(strRequest,'dMostrar');
}
