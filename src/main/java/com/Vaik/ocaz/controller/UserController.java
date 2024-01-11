package com.Vaik.ocaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vaik.ocaz.model.*;
import com.Vaik.ocaz.service.*;
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        Utilisateur utilisateur = userService.getUserById(id);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Utilisateur utilisateur) {
        boolean isValidLogin = userService.isValidLogin(utilisateur.getNom(), utilisateur.getPassword());

        if (isValidLogin) {
            return new ResponseEntity<>("Authentification réussie", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentification échouée", HttpStatus.UNAUTHORIZED);
        }
    }

    // @PostMapping("/inscription")
    // public ResponseEntity<String> registerUser(@RequestBody Utilisateur utilisateur) {
    //     boolean isUserRegistered = userService.registerUser(utilisateur);

    //     if (isUserRegistered) {
    //         return new ResponseEntity<>("Utilisateur enregistré avec succès", HttpStatus.CREATED);
    //     } else {
    //         return new ResponseEntity<>("Échec de l'inscription de l'utilisateur", HttpStatus.BAD_REQUEST);
    //     }
    // }

    // Vous pouvez ajouter d'autres méthodes pour gérer les utilisateurs
}
