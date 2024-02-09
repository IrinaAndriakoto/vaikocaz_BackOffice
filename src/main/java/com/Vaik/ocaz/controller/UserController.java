package com.Vaik.ocaz.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.Vaik.ocaz.component.JwtUtils;
import com.Vaik.ocaz.model.*;
import com.Vaik.ocaz.repository.UserRepository;
import com.Vaik.ocaz.service.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> u = userService.getAllUsers();
        if(u!=null && !u.isEmpty()) {
            return new ResponseEntity<>(u,HttpStatus.OK);
        } else{
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
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
            }
            catch(Exception e){
                throw e;
            }

            // Vous pouvez renvoyer le token dans la réponse si nécessaire
            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentification échouée", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur u) {
        Utilisateur savedCategory = userService.createUtilisateur(u);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

}
