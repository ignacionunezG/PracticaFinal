const searchBtn = document.querySelector('#btn-form');
// Find a <table> element with id="tabla":
var table = document.getElementById("tabla");
var distrito = null;
var barrio = null;
var direccion = null;

function buscar() {

    loading.classList.remove("visually-hidden");
    table.style.visibility = "hidden";

    //Borramos los elementos de la tabla
    limpiarTabla();

    let api = 'https://datos.madrid.es/portal/site/egob/menuitem.ac61933d6ee3c31cae77ae7784f1a5a0/?vgnextoid=00149033f2201410VgnVCM100000171f5a0aRCRD&format=json&file=0&filename=202625-0-aparcamientos-publicos&mgmtid=26e6cc885fcd3410VgnVCM1000000b205a0aRCRD&preview=full';


    console.log(api)


    fetch(api, //Devuelve una promise
        {
            headers: new Headers({
                "Access-Control-Allow-Origin": "*",
                //"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
                //"Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
                "Content-type": "application/json"
            })
        })
        .then(response => response.json())
        .then(data => {
            console.log("length")
            console.log(data.length)
            console.log("data")
            console.log(data)
            if (data.error) {
                document.querySelector('h3').innerHTML = "No hay parkings disponibles con las indicaciones especificadas";
                return;
            }
            const info = data.info;

            document.querySelector('h1').innerHTML = "";

            //Miramos a ver si hay más páginas antes o después de la actual

            const results = data.results;

            for (let i = 0; i < results.length; i++) {
                //document.getElementById("data").appendChild(img);
                console.log(table)

                // Create an empty <tr> element and add it to the last position of the table:
                var row = table.insertRow();

                // Insert new cells (<td> elements) of the "new" <tr> element:
                var cell1 = row.insertCell(0);
                cell1.classList.add('align-middle');
                var cell2 = row.insertCell(1);
                cell2.classList.add('align-middle');
                

                // Add some text to the new cells:
                result1=results.@graph[i].

                cell1.innerHTML = results[i].name;
                cell2.innerHTML = results[i].status;
                cell4.innerHTML = results[i].species;
                cell5.innerHTML = results[i].type;
                cell6.innerHTML = results[i].gender;
                cell7.innerHTML = results[i].origin.name;
                cell8.innerHTML = results[i].location.name;

            }

        })
    setTimeout(function () {
        table.style.visibility = "visible";
        document.getElementById('pagination').style.visibility = "visible";
        loading.classList.add("visually-hidden");
    }, 500)

}

document.addEventListener('DOMContentLoaded', function () {
    buscar();

    document.querySelector('form').onsubmit = () => {
        pagina = 1;
        //Recogemos los valores introducidos por el usuario
        nombre = document.querySelector('#Name').value;
        estado = document.querySelector('#Status').value;
        species = document.querySelector('#Species').value;
        type = document.querySelector('#Type').value;
        gender = document.querySelector('#Gender').value;

        //Limpiamos los campos
        document.querySelector('#Name').value = '';
        document.querySelector('#Status').value = "Any";
        document.querySelector('#Species').value = '';
        document.querySelector('#Type').value = '';
        document.querySelector('#Gender').value = 'Any';

        buscar();
        //Stop form from submitting
        return false;
    }
});

function limpiarTabla() {
    var rowCount = tabla.rows.length;
    for (var i = rowCount - 1; i > 0; i--) {
        tabla.deleteRow(i);
    }
}

