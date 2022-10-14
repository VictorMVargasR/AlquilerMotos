/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


//Funciones de la tabla Administrador
$(document).ready(function (){
    traerInformacionAdmin();
});

//Funcion que trae la informacion de la tabla Administrador
function traerInformacionAdmin(){
    $.ajax({
        url:"http://127.0.0.1:8081/api/Admin/all", //colocar la http del modulo de la tabla CLIENT
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaAdmin(respuesta);
        }
    });
}

//Funcion que pinta la informacion de la tabla Administrador
function pintarRespuestaAdmin(respuesta){
    let myTable="<table><thead><th>Nombre</th><th>Correo</th></thead>";
    for(i=0; i<respuesta.length; i++){
        myTable += `<tr>
        <td>${respuesta[i].name}</td>
        <td>${respuesta[i].email}</td>
        <td><button type="submit" class="btn btn-info btn-lg btn-responsive" onclick="actualizarElementoAdmin(${respuesta[i].id})"><span class="glyphicon glyphicon-edit">Actualizar</button>
        <td><button type="submit" class="btn btn-info btn-lg btn-responsive" onclick="borrarElementoAdmin(${respuesta[i].id})"><span class="glyphicon glyphicon-trash"></span>Borrar</button>
        </td>`;
    }
    myTable+="</table>";
    $("#resultadoAdmin").html(myTable);
}

//Funcion que  guarda la informacion de la tabla Administrador
function guardarElementoAdmin(){
    let myData={
        name:$("#nameAdmin").val(),
        email:$("#email").val(),
        password:$("#password").val()
    };
    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(myData),
        
        url:"http://127.0.0.1:8081/api/Admin/save",
       
        
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("El Administrador se Guardo Correctamente");
            window.location.reload();
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload();
            alert("El Administrador no se guardo correctamente");
    
    
        }
        });
}
//Funcion que actualiza la informacion de la tabla Administrador
function actualizarElementoAdmin(idElementoA){
    let myData={
        id:idElementoA,
        name:$("#nameAdmin").val(),
        email:$("#email").val(),
        password:$("#password").val()
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://127.0.0.1:8081/api/Admin/update", //colocar la http del modulo de la tabla CLIENT
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoAdmin").empty();
            $("#idAdmin").val("");
            $("#name").val("");
            $("#email").val("");
            $("#password").val("");
            traerInformacionAdmin();
            alert("Administrador Actualizado con Exito");           
        },
        error: function(jqXHR, textStatus, errorThrown) {
            window.location.reload();
          alert("Administrador no se Guardo Correctamente");
        }
    });
}
//Funcion que borra la informacion de la tabla Administrador
function borrarElementoAdmin(idElementoA){
    let myData={
        id:idElementoA
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://127.0.0.1:8081/api/Admin/"+idElementoA,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoAdmin").empty();
            traerInformacionAdmin();
            alert("Administrador Borro Correctamente");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            window.location.reload();
          alert("Administrador no se Borro Correctamente");
        }
    });
}


