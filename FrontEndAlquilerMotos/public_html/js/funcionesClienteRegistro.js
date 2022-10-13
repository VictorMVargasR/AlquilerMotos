/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function guardarClientes() {
    //Declara las variables

    let nombreCliente = $('#nombre').val();
    let emailCliente = $('#email').val();
    let cemailCliente = $('#cemail').val();
    let edadCliente = $('#edad').val();
    let passCliente = $('#pass').val();
    let cpassCliente = $('#cpass').val();


    console.log(emailCliente);

    let estadoConformacion = confirmarCorreo(emailCliente);

    console.log(estadoConformacion);

    if (estadoConformacion) {
        if (emailCliente === cemailCliente) {
            if (passCliente === cpassCliente) {
                registrarCliente(nombreCliente, emailCliente, passCliente, edadCliente);
            } else {
                alert('La contraseña no coincide, por favor corregirla');
                $('#pass').val("");
                $('#cpass').val("");
            }
        } else {
            alert('El email no coincide, por favor corregirlo');
            $('#cemail').val("");
            $('#email').val("");
        }
    } else {
        alert('El email ya esta registrado');
    }

}


function registrarCliente(nombreCliente, emailCliente, passwordCliente, edadCliente) {

    let data = {
        idClient: "",
        password: passwordCliente,
        name: nombreCliente,
        email: emailCliente,
        age: edadCliente
    };

    let dataToSend = JSON.stringify(data);
    console.log(dataToSend);

    if (nombreCliente !== "" && emailCliente !== "" && nombreCliente !== "") {
        $.ajax({
            url: "http://localhost:8080/api/Client/save",
            type: "POST",
            datatype: "JSON",
            data: dataToSend,
            contentType: "application/json",
            success: function (Clientes) {
                /*$('#nombre').val();
                 $('#email').val();
                 $('#cemail').val();
                 $('#edad').val();
                 $('#pass').val();
                 $('#cpass').val();*/
            },
            error: function (xhr, status) {
                alert('Ha sucedido un problema');
            }
        });
    }
}


function confirmarCorreo(Correo) {

    let estado = true;

    console.log(estado);

    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: "GET",
        datatype: "JSON",
        //contentType: "application/json",
        success: function (Clientes) {
            let CS = Clientes.items;

            console.log(CS.email);

            for (i = 0; i < CS.length; i++) {
                if (CS[i].email === Correo) {
                    estado = false;
                    console.log(CS[i].email);
                }
            }

            console.log(estado);
            alert('alerta');

            return estado;
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete: function(xhr,status){
            console.log("CS.email");
        }
    });


}
