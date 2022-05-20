package com.PracticaFinal.madPark.controller;

import com.PracticaFinal.madPark.model.Historial;
import com.PracticaFinal.madPark.service.HistorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("http://localhost:8081/api/v1")
public class HistorialController {
    
    public record DataResponse (String result) {}

    @Autowired
    private HistorialService HistorialService;

    
    @GetMapping("/historial")
    public ResponseEntity<Iterable<Historial>> retrieveAllHistorial() {
        Iterable<Historial> response = HistorialService.retrieveAllHistorial();
        return ResponseEntity.ok().body(response);

    }


    @GetMapping("/historial/{email}/")
    public ResponseEntity<DataResponse> retrieveHistorial(@PathVariable String email) {
        Historial response = HistorialService.retrieveHistorial(email);

        if (response == null) {
            //MENSAJE DE: ESE USUARIO NO EXISTE.
            return ResponseEntity.ok().body(new DataResponse("KO"));
        } else {
            //EL USUARIO EXISTE Y TIENE MATRÍCULAS
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }

    }


    @PutMapping("/historial/{email}/")
    public ResponseEntity<Historial> updateHistorial(@PathVariable String email, @RequestBody Historial Historial) {
        Historial newHistorial = HistorialService.updateHistorial(email, Historial);
        if (newHistorial == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newHistorial);
    }

}

