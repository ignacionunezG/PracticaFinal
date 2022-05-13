//
let matricula1 = document.getElementById("matricula1");
let matricula2 = document.getElementById("matricula2");
let matricula3 = document.getElementById("matricula3");
let matricula4 = document.getElementById("matricula4");
let matricula5 = document.getElementById("matricula5");

matricula1.style.visubility="hidden";
matricula2.style.visubility="hidden";
matricula3.style.visubility="hidden";
matricula4.style.visubility="hidden";
matricula5.style.visubility="hidden";



//MOSTAR MATRÍCULAS ACTUALES

async function mostrarMatriculas() {

    fetch("/api/v1/matriculas/{email}") //Devuelve una promise
        .then(response => response.json())
        .then(data => {
            console.log(data)

            for (let i = 0; i < 5; i++) {
                if (data[0][i] != '') {

                    if (i == 0) {
                        matricula1.isVisible();
                        matricula1.value = data[0][i];
                    }
                    if (i == 1) {
                        matricula2.isVisible();
                        matricula2.value = data[0][i];
                    }
                    if (i == 2) {
                        matricula3.isVisible();
                        matricula3.value = data[0][i];
                    }
                    if (i == 3) {
                        matricula4.isVisible();
                        matricula4.value = data[0][i];
                    }
                    if (i == 4) {
                        matricula5.isVisible();
                        matricula5.value = data[0][i];
                    }
                }
            }
        })
}
//AÑADIR NUEVAS MATRÍCULAS
const dropdown_matriculas = document.getElementById("matriculas");
if (añadir_matricula == 1) {
    if (dropdown - menu < 6) {
        habilitarInsertarNuevaMatricula();
        mostrarBotonNuevaMat();
    }
}


function habilitarInsertarNuevaMatricula() {
    text_nuevaMat = Visible;
}

function mostrarBotonNuevaMat(){

}