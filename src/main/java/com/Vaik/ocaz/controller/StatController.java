package com.Vaik.ocaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vaik.ocaz.service.StatService;

@RestController
@RequestMapping("/statistiques")
@CrossOrigin
public class StatController {

    @Autowired
    private StatService statistiqueService;

    @GetMapping("/getNbUserByAnnonce")
    public ResponseEntity<Long> getNombreUtilisateursAvecAnnonce() {
        long nombreUtilisateursAvecAnnonce = statistiqueService.getNombreUtilisateursAvecAnnonce();
        return new ResponseEntity<>(nombreUtilisateursAvecAnnonce, HttpStatus.OK);
    }
}