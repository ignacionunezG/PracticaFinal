//
let matricula1 = document.getElementById("matricula1");
let matricula2 = document.getElementById("matricula2");
let matricula3 = document.getElementById("matricula3");
let matricula4 = document.getElementById("matricula4");
let matricula5 = document.getElementById("matricula5");
let añadir_matricula = document.getElementById("añadirMatricula");
let form_mat = document.getElementById("formularioMatriculas");
let matricula_para_añadir  = document.getElementById("matriculaParaAñadir");
let matriculas  = document.getElementById("matriculas");


console.log(matricula1)
form_mat.style.visibility = "hidden";
matricula1.style.visibility = "hidden";
matricula2.style.visibility = "hidden";
matricula3.style.visibility = "hidden";
matricula4.style.visibility = "hidden";
matricula5.style.visibility = "hidden";


añadir_matricula.addEventListener("click", function (event) {
    // stop form submission
    event.preventDefault();
    form_mat.style.visibility = "visible";


});

void function mostrarAddMatricula() {
    console.log("esta aqui")
    form_mat.style.visibility = "visible";
    console.log(form_mat.style.visibility);
}

//MOSTAR MATRÍCULAS ACTUALES

async function mostrarMatriculas() {

    fetch("/api/v1/matriculas/{email}") //Devuelve una promise
        .then(response => response.json())
        .then(data => {
            console.log(data)

            for (let i = 0; i < 5; i++) {
                if (data[0][i] != '') {
                    matriculas.disabled=false;

                    if (i == 0) {
                        matricula1.style.visibility="visible";
                        matricula1.value = data[0][i];
                    }
                    if (i == 1) {
                        matricula2.style.visibility="visible";
                        matricula2.value = data[0][i];
                    }
                    if (i == 2) {
                        matricula3.style.visibility="visible";
                        matricula3.value = data[0][i];
                    }
                    if (i == 3) {
                        matricula4.style.visibility="visible";
                        matricula4.value = data[0][i];
                    }
                    if (i == 4) {
                        matricula5.style.visibility="visible";
                        matricula5.value = data[0][i];
                    }
                }
            }
        })
}
//VALIDACION MATRICULA



function showMessage(input, type) {
    if (!type) {
        input.className = "form-control is-invalid";
    } else {
        input.className = "form-control is-valid";
    }
    return type;
}

function error(input) {
    return showMessage(input, false);
}

function success(input) {
    return showMessage(input, true);
}

function validateMatricula(input) {

    let digitos_str = input.value.substring(0, 4);
    let letras = input.value.substring(4);
    try {
        let digitos = parseInt(digitos_str);
    }
    catch (error) {
        return error(input); //error si digitos no son en realidad 4 digitos
    }
    if (input.value.length != 7) {
        return error(input) //error si no son 4 digitos + 3 ....
    }
    for (let i = 0; i < letras.length; i++) {
        if (letras[i].toUpperCase() != letras[i].toLowerCase()) {//SI ES LETRA
            letras[i] = letras[i].toUpperCase();
            if (letras[i] == "A" || letras[i] == "E" || letras[i] == "I" || letras[i] == "O" || letras[i] == "U") { //si es vocal
                return error(input);
            }
        }
        else {
            return error(input);
        }
    }

    return true;
}

async function validateForm() {

    let matriculaValid = validateMatricula(matricula_para_añadir);

    if (matriculaValid) {
        form_mat.style.visibility="hidden";
        matricula_para_añadir.value="";
        window.location.href = "./reloj.html";

        //SE REALIZA PUT
// ESTOS COMENTARIOS SE VAN A TENER QUE DESCOMENTAR
//        let request = await fetch("http://localhost:8080/api/v1/matriculas/{email}", { //VER COMO PONER EL EMAIL DE VERDAD
//            method: "PUT" //VER COMO SE HACE PUT PARA INSERTAR MATRÍCULA
}}

form_mat.addEventListener("submit", function (event) {

    // stop form submission
    event.preventDefault();
    validateForm();

});
