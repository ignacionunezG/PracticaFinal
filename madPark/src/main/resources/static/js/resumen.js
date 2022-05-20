var table = document.getElementById("tabla");
var tiempo = null;
var precio = null;
var parking = null;
var fecha = null;
var email="inunezg@gmail.com"



    //Borramos los elementos de la tabla

    let api = "/api/v1/cobro/" + email;
    
    fetch(api) //Devuelve una promise
            .then(response =>  response.json())
            .then(data => {
                
                if(data.error){
                    document.querySelector('h1').innerHTML = "Not found";
                    return;
                }
                const info = data.info;

                document.querySelector('h1').innerHTML = ""

                //Miramos a ver si hay más páginas antes o después de la actual
                

                const results = data.results;
                
                for(let i = 0;i<results.length;i++){
                    

                    // Create an empty <tr> element and add it to the last position of the table:
                    var row = table.insertRow();

                    // Insert new cells (<td> elements) of the "new" <tr> element:
                    var cell1 = row.insertCell(0);
                    cell1.classList.add('align-middle');
                    var cell2 = row.insertCell(1);
                    cell2.classList.add('align-middle');
                    var cell3 = row.insertCell(2);
                    cell3.classList.add('align-middle');
                    var cell4 = row.insertCell(3);
                    cell4.classList.add('align-middle');
                    
                    //var cell2 = row.insertCell(1);

                    // Add some text to the new cells:
                    cell2.innerHTML = results[i].time;
                    cell2.innerHTML = results[i].cost;
                    cell3.innerHTML = results[i].idPark;
                    cell4.innerHTML = results[i].date;
                    

                }

        })
    
    


