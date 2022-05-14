package com.PracticaFinal.madPark.controller;

import com.PracticaFinal.madPark.model.Cobro;
import com.PracticaFinal.madPark.service.CobroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CobroController {
    @Autowired
    private CobroService cobroService;

    @GetMapping("/cobro")
    public ResponseEntity<Iterable<Cobro>> retrieveAllCobros(){
        Iterable<Cobro> response = cobroService.retrieveAllCobros();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/cobro/{email}"){
        public response = cobroService.retrieveCobro(email);
    }



    
}
