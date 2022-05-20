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
    https://datos.madrid.es/egob/catalogo/202625-0-aparcamientos-publicos.json?distrito_nombre=SAN%20BLAS-CANILLEJAS&barrio_nombre=Retiro

    let api = 'https://datos.madrid.es/egob/catalogo/202625-0-aparcamientos-publicos.json'

    if (distrito !== null && distrito != ""){
        api += '?distrito_nombre=' + distrito;
    }
    if (barrio !== "Any" && barrio!= null){
        api += '&barrio_nombre=' + barrio;
    }

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
                var cell3 = row.insertCell(1);
                cell3.classList.add('align-middle');
                

                // Add some text to the new cells

                cell1.innerHTML = results.graph[i].title,
                cell2.innerHTML = results.graph[i].address.street-address,
                cell3.innerHTML = results.graph[i].organization.organization-desc



            }

        })
    setTimeout(function () {
        table.style.visibility = "visible";
        document.getElementById('pagination').style.visibility = "visible";
        loading.classList.add("visually-hidden");
    }, 500)

}

document.addEventListener('DOMContentLoaded',function(){
    buscar();

    document.querySelector('form').onsubmit = () =>{
        pagina = 1;
        //Recogemos los valores introducidos por el usuario
        barrio = document.querySelector('#barrio').value;
        distrito = document.querySelector('#distrito').value;
        

        //Limpiamos los campos
        document.querySelector('#barrio').value = '';
        document.querySelector('#distrito').value = '';
        

        buscar();
        //Stop form from submitting
        return false;
    }
});


function limpiarTabla(){
    var rowCount = tabla.rows.length;
    for (var i = rowCount-1;i>0;i--){
        tabla.deleteRow(i);
    }
}

