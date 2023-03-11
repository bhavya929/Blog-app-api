package com.example.Blogappapi.controllers;

import com.example.Blogappapi.entities.User;
import com.example.Blogappapi.payloads.Userdt;
import com.example.Blogappapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Userdt> getUser(@PathVariable Integer id) {
        Userdt userById = userService.getUserById(id);
        return new ResponseEntity<Userdt>(userById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Userdt>> getAllUser() {
        List<Userdt> userById = userService.getAllUsers();
        return new ResponseEntity<List<Userdt>>(userById, HttpStatus.OK);
    }

    @PostMapping
    public Userdt createUser(@Valid @RequestBody Userdt userdt) {
        Userdt user = userService.createUser(userdt);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public Userdt updateUser(@Valid @RequestBody Userdt userdt , @PathVariable Integer id){
        Userdt updateUser = userService.updateUser( userdt, id);
        return updateUser;
    }


}
