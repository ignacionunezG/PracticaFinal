
package com.PracticaFinal.madPark.controller;

import java.util.ArrayList;

import com.PracticaFinal.madPark.model.Matriculas;
import com.PracticaFinal.madPark.service.MatriculasService;

//import com.PracticaFinal.madPark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("http://localhost:8080/api/v1")
public class MatriculaController {
    public record DataResponse (String result) {}

    @Autowired
    private MatriculasService matriculasService;

    
    @GetMapping("/matriculas")
    public ResponseEntity<Iterable<Matriculas>> retrieveAllMatriculas() {
        Iterable<Matriculas> response = matriculasService.retrieveAllMatriculas();
        return ResponseEntity.ok().body(response);

    }


    @GetMapping("/matriculas/{email}/")
    public ResponseEntity<DataResponse> retrieveMatricula(@PathVariable String email) {
        ArrayList<String> response = matriculasService.retrieveMatriculas(email);

        if (response == null) {
            //MENSAJE DE: ESE USUARIO NO EXISTE.
            return ResponseEntity.ok().body(new DataResponse("KO"));
        } else {
            //EL USUARIO EXISTE Y TIENE MATRÍCULAS
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }

    }


//    @PostMapping("/users")

//    public ResponseEntity<DataResponse> createUser(@RequestBody User user) {
//        User newUser = userService.createUser(user);
//        if (newUser == null) {
            //MENSAJE DE: ESE USUARIO YA EXISTE.
//            return ResponseEntity.ok().body(new DataResponse("KO"));
//        } else {
//            return ResponseEntity.ok().body(new DataResponse("OK"));
//        }
//    }

}