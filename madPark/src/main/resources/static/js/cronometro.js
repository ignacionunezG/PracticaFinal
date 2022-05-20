
const stopwatch = document.getElementById('stopwatch');
const playPauseButton = document.getElementById('play-pause');
const secondsSphere = document.getElementById('seconds-sphere');
let stopwatchInterval;
let runningTime = 0;
const coste = 0;


const playPause = () => {
    const isPaused = !playPauseButton.classList.contains('running');
    if (isPaused) {
        playPauseButton.classList.add('running');
        start();
    } else {
        playPauseButton.classList.remove('running');
        pause();
    }
}

const pause = () => {
    secondsSphere.style.animationPlayState = 'paused';
    clearInterval(stopwatchInterval);
}

const stop = () => {
    secondsSphere.style.transform = 'rotate(-90deg) translateX(60px)';
    secondsSphere.style.animation = 'none';
    playPauseButton.classList.remove('running');
    runningTime = 0;
    clearInterval(stopwatchInterval);
    stopwatch.textContent = '00:00';
    
    tiempo=calculateTime();
    var today = new Date();

    //POST EN BASES DE DATOS

    let request = await fetch("/api/v1/historial", {
        method: "POST",
        credentials: "same-origin",
        headers: {
            "Access-Control-Allow-Origin": "*",
            //"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
            //"Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            email:"",
            idPark:"",
            parking:""

        }),
        dataType: "json",
    }).catch(console.error)

    console.log(request)
    if (request.status === 200) {
        let data = await request.json();
        if (data.result === "OK") {
            alert("Todo OK")
        }
    }
    else {
        throw new Error('Something went wrong');
    }

    
    let request2 = await fetch("/api/v1/cobro", {
        method: "POST",
        credentials: "same-origin",
        headers: {
            "Access-Control-Allow-Origin": "*",
            //"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
            //"Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            email:"",
            idPark:"",
            date:today,
            time:tiempo,
            cost:coste

        }),
        dataType: "json",
    }).catch(console.error)

    console.log(request)
    if (request.status === 200) {
        let data = await request.json();
        if (data.result === "OK") {
            alert("Todo OK")
        }
    }
    else {
        throw new Error('Something went wrong');
    }




}

const start = () => {
    console.log("Hola")
    secondsSphere.style.animation = 'rotacion 60s linear infinite';
    let startTime = Date.now() - runningTime;
    secondsSphere.style.animationPlayState = 'running';
    stopwatchInterval = setInterval(() => {
        runningTime = Date.now() - startTime;
        stopwatch.textContent = calculateTime(runningTime);
    }, 1000)
}

function round(num) {
    var m = Number((Math.abs(num) * 100).toPrecision(15));
    return Math.round(m) / 100 * Math.sign(num);
}

function calculatePrecio(total_minutes, total_seconds) {
    let precio = total_minutes * 0.05;
    precio = precio + (total_seconds / 60) * 0.05;
    precio = round(precio);

    return precio;
}

const calculateTime = runningTime => {
    const total_seconds = Math.floor(runningTime / 1000);
    const total_minutes = Math.floor(total_seconds / 60);

    const display_seconds = (total_seconds % 60).toString().padStart(2, "0");
    const display_minutes = total_minutes.toString().padStart(2, "0");

    coste = calculatePrecio(total_minutes, total_seconds);
    //console.log(coste)
    return `${display_minutes}:${display_seconds}`
}



start();
