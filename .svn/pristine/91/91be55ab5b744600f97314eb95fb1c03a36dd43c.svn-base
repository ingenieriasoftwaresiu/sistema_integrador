var url;
var id;
var destino;

function getXMLHTTPRequest(strUrl,strId,strDestino){    
    try{
        req = new XMLHttpRequest();
    }catch(err1){
        try{
            req = new ActiveXObject("Msxml2.XMLHTPP");
        }catch(err2){
            try{
                req = new ActiveXObject("Microsoft.XMLHTPP");
            }catch(err3){
                req = false;
            }
        }	
    }    
    
    if (req != ""){         
        url = strUrl;
        id = strId;
        destino = strDestino;        
        req.onreadystatechange = procesarRespuesta;
        req.open("POST",url,true);            
        req.send(null);       

    }
}

function procesarRespuesta(){   
    contenido = document.getElementById(id);   
    
    if (req.readyState==4 && req.status==200){   
        if (req.responseText == "null"){
            contenido.innerHTML = " ";
            if (destino != ""){
                window.location = destino;
            }
        }else{    
            contenido.innerHTML = req.responseText;  
        }              
    }       
}