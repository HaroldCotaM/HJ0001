$(document).ready(function () {
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;

    var today = year + "-" + month + "-" + day;
    $("#fecha1").attr("value", today);
});

function listarPrestamo() {
    alert("hola");
    $.get("pc", {opc: 1}, function (data) {
        //alert("asas");
        $("#caja").html(data);
    });
}
function limpiar() {
    if ($('.modal-backdrop').is(':visible')) {
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    }
    ;
}
function nuevoPrestamo() {
    var idc = $("#clientes").val();
    var fecha1 = $("#fecha1").val();
    var fecha2 = $("#fecha2").val();
    //var f1 = moment(dateString).format('DD/MM/YYYY')
    var f1 = fecha1.split('-').reverse().join('/');
    var f2 = fecha2.split('-').reverse().join('/');
    //alert(info);
    alert(idc);
    alert(f1);
    alert(f2);


    $.post("pc", {idc: idc, fecha1: f1, fecha2: f2, opc: 2}, function (data) {
        if (data == 1) {
            alert(data);
            listarPrestamo();
            $("#add_new_record_modal").modal("hide");
            limpiar();
        }
    });
}
function modificarPrestamo(id) {
    alert("modifica");
    $("#idp-edit").val(id);
    //alert(id);
    $.post("pc", {
        id: id,
        opc: '3'
    }, function (data, status) {
        var uu = JSON.parse(data);
        //alert(uu.idrol);
        $.get("cc", {opc: 6}, function (data1) {
            //  alert(data1);
            var rr = JSON.parse(data1);
            $('#clientes2').html('');
            $("#clientes2").append('<option value="0">Seleccionar Cliente</option>');
            $.each(rr, function (index, obj) {                   //alert(obj.nomrol);                    
                if (uu.idcliente == obj.idcliente) {
                    // alert(obj.idrol);
                    $("#clientes2").append('<option value=' + obj.idcliente + '>' + obj.nombres + '</option>');
                    $("#clientes2").val(obj.idcliente).change();
                } else {
                    $("#clientes2").append('<option value=' + obj.idcliente + '>' + obj.nombres + '</option>');
                }
            });
        });

        var split = uu.fecha1.split(' ').reverse().join('/');
        var sec = split.substring(11);

        $("#fecha1-edit").val(sec);

        var split2 = uu.fecha2.split(' ').reverse().join('/');
        var sec2 = split2.substring(11);

        $("#fecha2-edit").val(sec2);
    }
    );
    $("#update_user_modal").modal("show");
}
function actualizarPrestamo() {
    //alert("aa");
    var idc = $("#clientes2").val();
    alert(idc);
    var fec1 = $("#fecha1-edit").val();
    var f1 = fec1.split('-').reverse().join('/');
    alert(f1);
    var fec2 = $("#fecha2-edit").val();
    var f2 = fec2.split('-').reverse().join('/');
    alert(f2);

    var idp = $("#idp-edit").val();
    alert(idp);

    $.post("pc", {
        idp: idp,
        idc: idc,
        fecha1: f1,
        fecha2: f2,
        opc: '4'
    },
            function (data, status) {
                alert(data);
                listarPrestamo();
                $("#update_user_modal").modal("hide");
                limpiar();
            }
    );

}



function mostrarDetalle(id) {
    alert("listadetalle");


    alert(id);
    $.post("dc", {idp: id, opc: 1}, function (data) {

        $("#caja").html(data);

    });


}


function listarCliente() {
    // alert("cliente");
    $.get("cc", {opc: 1}, function (data) {
        $("#caja").html(data);
        // alert(data);
    });
}


function nuevo() {
    alert("nuevo");
    $.get("nc", {opc: 1}, function (data) {
        alert(data);
        $("#caja").html(data);

        $.get("nc", {opc: 2}, function (data1, status) {
            alert(data1);
            $("#nrofactura").val(data1);
        })


    });
}

function nuevoPrestamo1() {
    var idc = $("option[value='" + $("input[name=selectClient]").val() + "']").attr('id');
    var fecha1 = $("#fecha1").val();
    var fecha2 = $("#fecha2").val();
    //var f1 = moment(dateString).format('DD/MM/YYYY')
    var f1 = fecha1.split('-').reverse().join('/');
    var f2 = fecha2.split('-').reverse().join('/');
    //alert(info);
    alert(idc);
    alert(f1);
    alert(f2);


    $.post("pc", {idc: idc, fecha1: f1, fecha2: f2, opc: 2}, function (data) {
        if (data == 1) {
            alert(data);
//                listarPrestamo();
//                $("#add_new_record_modal").modal("hide");
//                limpiar();                
        }
    });
}

function irdetalle() {


    $("#home").removeClass('tab-pane fade active in');
    $("#home").addClass('tab-pane fade');

    $("#menu1").removeClass('tab-pane fade');
    $("#menu1").addClass('tab-pane fade active in');
    $("#li1").removeClass('active');
    $("#li2").addClass('active');


}

function listarLibros(id) {

    alert(id);

    $.post("nc", {idpres: id, opc: 3}, function (data) {
        alert(data);
        $("#caja").html(data);
//        nuevo1();
        irdetalle();
        alert("hey tu porque desapareces");
    });

//    $.get("nc", {opc: 3}, function (data) {
////        $("#").html(data);
//        // alert(data);
//    });

}


function nuevo1(){
    alert("nuevo");
    $.get("nc", {opc: 1}, function (data) {
        alert(data);
        $("#caja").html(data);

        $.get("nc", {opc: 2}, function (data1, status) {
            alert(data1);
            $("#nrofactura").val(data1);
        })
         irdetalle();

    });
}

function insertarDetalle() {

    var n = $("#nrofactura").val();
    var array = n.substring(2).split("");
    var numero = "";

    var n = $("#nrofactura").val();
    var array = n.substring(2).split("");
    for (var i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            array.shift();
            i--;
        } else {
            numero = array.join("");
        }
    }

    alert(typeof (numero));


    var idlibro = $("option[value='" + $("input[name=selectLibro]").val() + "']").attr('id');

    $.post("dc", {idl: idlibro, numero: numero, opc: 2}, function (data) {
        alert(data);
        if (data == 1) {
            alert(data);
            listarLibros(numero);
            $("#add_new_record_modal").modal("hide");
            limpiar();
        }
    });

}

//function listaLibritos(){
//    $.post("nc", {opc: 4}, function (data) {
//        alert(data);
//        $("#add_new_record_modal").html(data);
//    });
//}


//$("#clientillos").text().split("                                        ");

//SELECT A.NOMBRES, A.APELLIDOS, B.TITULO, B.DESCRIPCION, B.CANTIDAD FROM AUTORES A , LIBROS B, DETALLE_AUTORES C
//WHERE C.IDAUTORES=A.IDAUTORES
//AND C.IDLIBRO=B.IDLIBRO;










