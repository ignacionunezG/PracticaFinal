
const user_name = document.getElementById("name");
const apellidos = document.getElementById("apellidos");
const email = document.getElementById("email");
const password = document.getElementById("password");  
const numTarjeta = document.getElementById("numTarjeta");
const cvv = document.getElementById("cvv");
const caducidad = document.getElementById("caducidad");
const form = document.getElementById("signup");



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
    var cad=new Date(input.value);
    console.log(cad.getMonth()+1)

    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    

    // check if the value is not empty
    if (!notEmpty(input)) {
        return false;
    }

    if (year > cad.getFullYear()) {
        return error(input)
    }
    else if (year == cad.getFullYear() && month > cad.getMonth()+1) {
        
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
    
    if (cvvString.length!=3){
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
        
        var cad=new Date(caducidad.value);
        const fechaCaducidad=String(cad.getMonth()+1)+ "/" + String(cad.getFullYear())
        const formData = new FormData();
        console.log(fechaCaducidad)

        let request = await fetch(" /api/v1/customers", {
            method: "POST",
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
        }).catch(console.error)
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
