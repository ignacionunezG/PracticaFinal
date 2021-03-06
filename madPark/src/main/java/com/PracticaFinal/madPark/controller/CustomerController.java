
package com.PracticaFinal.madPark.controller;

import com.PracticaFinal.madPark.model.Customer;
import com.PracticaFinal.madPark.service.CustomerService;

//import com.PracticaFinal.madPark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    public record DataResponse (String result) {}

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> retrieveAllCustomers(@AuthenticationPrincipal Customer c) {
        Iterable<Customer> response = customerService.retrieveAllCustomers();
        for (Customer customer : response) {
            System.out.println(customer.toString());
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/customers/{email}/")
    public ResponseEntity<DataResponse> retrieveCustomer(@PathVariable String email) {
        Customer response = customerService.retrieveCustomer(email);

        if (response == null) {
            //MENSAJE DE: ESE USUARIO NO EXISTE.
            return ResponseEntity.ok().body(new DataResponse("KO"));
        } else {
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }
    }   

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        //customer.setEmail(null);
        
        String hashedPass = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashedPass);
        Customer newCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok().body(newCustomer);
    }

}