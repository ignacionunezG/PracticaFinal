
package com.PracticaFinal.madPark.controller;

import com.PracticaFinal.madPark.model.User;
import com.PracticaFinal.madPark.service.UserService;

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
@RequestMapping("/api/v1")
public class UserController {
    public record DataResponse (String result) {}

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> retrieveAllUsers() {
        Iterable<User> response = userService.retrieveAllUsers();
        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/users/{email}/")
    public ResponseEntity<DataResponse> retrieveUser(@PathVariable String email) {
        User response = userService.retrieveUser(email);

        if (response == null) {
            //MENSAJE DE: ESE USUARIO NO EXISTE.
            return ResponseEntity.ok().body(new DataResponse("KO"));
        } else {
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }

    }


    @PostMapping("/users")

    public ResponseEntity<DataResponse> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (newUser == null) {
            //MENSAJE DE: ESE USUARIO YA EXISTE.
            return ResponseEntity.ok().body(new DataResponse("KO"));
        } else {
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }
    }

}