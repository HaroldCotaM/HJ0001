$(document).ready(function (){
    
});

$("#btnlogin").on("click",function (){
    var user = $("#user").val();
    var pass = $("#clave").val();
    var opcion = 1;
    var menucito = '<li><a href="#">Reportes</a></li>';
    $.post("lc",{user:user,pass:pass,opc:opcion},function (data) {
        var login = JSON.parse(data);
        if(login.op==1){   
            window.location = "home.jsp";            
        }else{
            window.location = "index.html";
        }
    });
    
});

