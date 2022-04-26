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

    fetch("/api/v1/matriculas") //Devuelve una promise
        .then(response => response.json())
        .then(data => {
            console.log(data)

            for (let i = 0; i < 5; i++) {
                if (data[0][i] != null) {

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
if (añadir_matricula = 1) {
    if (dropdown - menu < 6) {
        habilitarInsertarNuevaMatricula();
        mostrarBotonNuevaMat();
    }
}


function habilitarInsertarNuevaMatricula() {
    text_nuevaMat = Visible;

}
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


function notEmpty(input) {
    if (input.value.trim() === "") {
        return error(input);
    }
    //return true;
    return success(input);
}

function validateEmail(input) {
    // check if the value is not empty
    if (!notEmpty(input)) {
        return false;
    }
    // validate email format
    const emailRegex =
        /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    const email = input.value.trim();
    if (!emailRegex.test(email)) {
        //return false;
        return error(input);
    }
    return true;
}

function validatePassword(input) {
    var existsUpper = false;
    var existsLower = false;
    var existsInt = false;


    if (!notEmpty(input)) {
        return false;
    }

    if (input.value.length < 8) {
        return error(input);
    }
    var i = 0;
    while (i < input.value.length) {
        character = input.value.charAt(i);
        console.log(character)
        if (!isNaN(character * 1)) {
            console.log("Hay digito");
            console.log(i);
            existsInt = true;
        } else {
            if (character == character.toUpperCase()) {
                console.log("Hay mayuscula");
                console.log(i);
                existsUpper = true;
            }
            if (character == character.toLowerCase()) {
                console.log("Hay minuscula");
                console.log(i);
                existsLower = true;
            }
        }
        i++;
    }

    if (existsUpper && existsLower && existsInt) {
        return true;
    }
    else {
        return error(input);
    }
}


function validateTarjeta(input) {
    // check if the value is not empty
    if (!notEmpty(input)) {
        return false;
    }
    if (input.value.length != 16) {
        return error(input);
    }
    var i = 0;

    while (i <= input.value.length) {
        character = input.value.charAt(i);
        if (isNaN(character * 1)) {
            return error(input);
        }
        i++;
    }

    return true;
}


function validateCaducidad(input) {

    var today = new Date();
    var cad = new Date(input.value);
    console.log(cad.getMonth() + 1)

    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    //console.log("hola")
    //console.log(input.value)
    //console.log(year);
    //console.log(cad.getMonth()+1);

    // check if the value is not empty
    if (!notEmpty(input)) {
        return false;
    }

    if (year > cad.getFullYear()) {
        return error(input)
    }
    else if (year == cad.getFullYear() && month > cad.getMonth() + 1) {

        return error(input)
    }
    else {
        return true;

    }
}


function validateCVV(input) {
    var cvvString = String(input.value);

    if (!notEmpty(input)) {
        return false;
    }

    if (cvvString.length != 3) {
        return error(input)
    }
    else if (input.value > 999) {
        return error(input)
    }

    else {
        return true;

    }
}



async function validateForm() {

    let nombreValid = notEmpty(user_name);
    let apellidosValid = notEmpty(apellidos);
    let emailValid = validateEmail(email);
    let passwordValid = validatePassword(password);
    let numTarjetaValid = validateTarjeta(numTarjeta);
    let caducidadValid = validateCaducidad(caducidad);
    let cvvValid = validateCVV(cvv);

    //let docValid = validate_fileupload(form.elements["cv"],FILE_REQUIRED);
    // if valid, submit the form.
    if (nombreValid && apellidosValid && emailValid && passwordValid && numTarjetaValid && caducidadValid && cvvValid) {

        var cad = new Date(caducidad.value);
        const fechaCaducidad = String(cad.getMonth() + 1) + "/" + String(cad.getFullYear())
        const formData = new FormData();
        console.log(fechaCaducidad)

        let request = await fetch("/api/v1/matriculas", {
            method: "PUT",
            credentials: "same-origin",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
                "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
                "Content-type": "application/json"
            },
            body: JSON.stringify({
                name: user_name.value,
                apellidos: apellidos.value,
                email: email.value,
                password: password.value,
                numTarjeta: numTarjeta.value,
                cvv: cvv.value,
                caducidad: fechaCaducidad
            }),
            dataType: "json",
        })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Something went wrong');
            })
            .then(data => {
                console.log(data)
                if (data.result === "OK") {
                    window.location.href = "..html/map.html";
                    alert("Registrado con éxito");
                    //console.log(await request.json());
                }
                else {
                    window.location.href = "..html/login.html";
                    alert("Ya existe un usuario con esa cuenta");
                    //console.log(await request.json());

                }

                console.log("Done");
            })
            .catch(error => console.error(error));

    }
}

form.addEventListener("submit", function (event) {

    // stop form submission
    event.preventDefault();
    validateForm();

});
