/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


$.ajax({
    url: "http://localhost:8080/api/Motorbike/" + localStorage.getItem("idMoto"),
    type: "GET",
    datatype: "JSON",
    contentType: "application/json",
    success: function (Moto) {

        pintarMotos(Moto);
        $("#btnCargar").remove();
    },
    error: function (xhr, status) {
        alert('Ha sucedido un problema');
    }
});


function pintarMotos(Moto) {

    $("#nombre").val(Moto.name);
    $("#marca").val(Moto.brand);
    $("#modelo").val(Moto.year);

}

function dates() {
    let fechain = $("#fechai").val();
    let fechafi = $("#fechaf").val();

    let fechai = fechain.split("-");
    let fechaf = fechafi.split("-");

    let anoi = parseInt(fechai[0]);
    let mesi = parseInt(fechai[1]);
    let diai = parseInt(fechai[2]);

    let anof = parseInt(fechaf[0]);
    let mesf = parseInt(fechaf[1]);
    let diaf = parseInt(fechaf[2]);

    var fechaActual = new Date();
    var dd = fechaActual.getDate();
    var mm = fechaActual.getMonth() + 1;
    var yyyy = fechaActual.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }

    if (mm < 10) {
        mm = '0' + mm;
    }

    if (yyyy === anoi && yyyy === anof) {
        if (mesi === mm) {
            
        }
    } else {
        console.log("ano incorrecta");
    }



    if (fechai === fechaActual.toString()) {
        console.log("Fecha correcta");
    } else {
        console.log("Fecha incorrecta");
    }
}