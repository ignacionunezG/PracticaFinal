package com.PracticaFinal.madPark.controller;

import com.PracticaFinal.madPark.model.Cobro;
import com.PracticaFinal.madPark.service.CobroService;
import com.PracticaFinal.madPark.service.UserService;

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
@RequestMapping("api/v1")
public class CobroController {
    public record DataResponse (String result) {}

    @Autowired
    private CobroService cobroService;

    @GetMapping("/cobro")
    public ResponseEntity<Iterable<Cobro>> retrieveAllCobros(){
        Iterable<Cobro> response = cobroService.retrieveAllCobros();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/cobro/{email}")
    public ResponseEntity<DataResponse> retrieveCobro(@PathVariable String email){
        Cobro response = cobroService.retrieveCobro(email);

        if(response == null){
            return ResponseEntity.ok().body(new DataResponse("KO"));
        }else{
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }
    }

    @PostMapping("/cobro")
    public ResponseEntity<Cobro> createCobro(@RequestBody Cobro cobro){

        Cobro newCobro = cobroService.createCobro(cobro);
        return ResponseEntity.ok().body(newCobro);
    }

    
}
