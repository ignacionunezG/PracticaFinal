
const email = document.getElementById("email");
const password = document.getElementById("password");


async function validateForm() {


    //let docValid = validate_fileupload(form.elements["cv"],FILE_REQUIRED);
    // if valid, submit the form.

    const formData = new FormData();

    let api = "/api/v1/users/" + email

    fetch(api) //Devuelve una promise
        .then((response) => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong');
        })
        .then(data => {
            console.log(data)
            if (data.result === "OK") {
                if (password == data.password) {
                    window.location.href = "..html/mapa.html";
                    alert("Login successful");
                    console.log(await request.json());
                }
                else {
                    window.location.href = "..html/login.html";
                    alert("Contraseña incorrecta. Pruebe otra vez");
                    console.log(await request.json());

                }
            } else {
                window.location.href = "..html/login.html";
                alert("Error. Usuario no reconocido");
                console.log(await request.json());
            }

            console.log("Done");
        })
        .catch(error => console.error(error));

}


form.addEventListener("submit", function (event) {
    // stop form submission
    event.preventDefault();
    validateForm();

});
