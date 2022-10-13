function traerinfoMot() {

    $.ajax({
        url: "localhost:8081/api/Motorbike/all",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta),
                $("#resultado").empty();
            pintarRespuesta(respuesta.items)

        }

    });

}

function pintarRespuesta(items) {
    let myTable = "<table>";

    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].brand + "</td>";
        myTable += "<td>" + items[i].model + "</td>";
        myTable += "<td>" + items[i].category_id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td><button onclick='BorrarElementoMot(" + items[i].id + ")'>Borrar</Button>";

        myTable += "</tr>";

    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}

function BorrarElementoMot(idElemento) {
    let myData = {
        id: idElemento
    };
    let dataTosent = JSON.stringify(myData);
    $.ajax({
        url: "localhost:8081/api/Motorbike/{id}",
        type: "DELETE",
        datatype: "JSON",
        data: dataTosent,
        contentType: "application/json",
        success: function (respta) {
            $("#resultado").empty();
            traerinfoMot();
            alert("Moto Borrada")

        }
    })

}

function creaMot() {

    let id = $("#idm").val();
    let marca = $("#mm").val();
    let model = $("#model").val();
    let categ = $("#categ").val();
    let name = $("#name").val();

    let data = {
        id: id,
        brand: marca,
        model: model,
        category_id: categ,
        name: name,

    }
    let dataTosent = JSON.stringify(data);
    console.log(dataTosent)


    $.ajax({
        url: "localhost:8081/api/Motorbike/save",
        type: "POST",
        datatype: "JSON",
        data: dataTosent,
        contentType: "application/json",
        success: function (dataTosent) {
            console.log(dataTosent);
        },
        error: function (xhr, status) {
            alert("El ID ESTA SIENDO UTILIZADO POR OTRO CLIENTE O TIENE CAMPOS VACIOS");
        }

    });


}