package com.Vaik.ocaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.Vaik.ocaz.component.JwtUtils;
import com.Vaik.ocaz.model.*;
import com.Vaik.ocaz.service.*;

import io.jsonwebtoken.Claims;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
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
    public ResponseEntity<String> login(@RequestBody Utilisateur utilisateur) throws Exception {
        boolean isValidLogin = userService.isValidLogin(utilisateur.getNom(), utilisateur.getPassword());
        String jwtToken = null;
        if (isValidLogin) {
            // Si l'authentification réussit, générer le jeton JWT
            try{
                jwtToken = jwtUtils.generateJwt(utilisateur);
            // Claims cl = jwtUtils.verify(jwtToken);
            }
            catch(Exception e){
                throw e;
            }

            // Vous pouvez renvoyer le token dans la réponse si nécessaire
            return new ResponseEntity<>("Authentification réussie. Token JWT : " + jwtToken, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentification échouée", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> registerUser(@RequestBody Utilisateur utilisateur) {
        boolean isUserRegistered = userService.registerUser(utilisateur);

        if (isUserRegistered) {
            return new ResponseEntity<>("Utilisateur enregistré avec succès", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Échec de l'inscription de l'utilisateur", HttpStatus.BAD_REQUEST);
        }
    }

}
