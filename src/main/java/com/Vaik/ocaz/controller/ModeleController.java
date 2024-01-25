package com.Vaik.ocaz.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vaik.ocaz.model.Modele;
import com.Vaik.ocaz.service.ModeleService;


@RestController
@RequestMapping("/modele")
public class ModeleController {
    private final ModeleService ms;

    @Autowired
    public ModeleController(ModeleService ms){
        this.ms=ms;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> getModeleById(@PathVariable Long id){
        Modele md = ms.getModeleById(id);
        if(md != null) {
            return new ResponseEntity<>(md,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Modele>> getAllModeles() {
        List<Modele> md = ms.getAllModeles();
        if(md!=null && !md.isEmpty()) {
            return new ResponseEntity<>(md,HttpStatus.OK);
        } else{
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<Modele> createModele(@RequestBody Modele m) {
        Modele savedCategory = ms.createModele(m);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

        @PutMapping("/update")
    public ResponseEntity<Modele> updateModele(@RequestBody Modele m) {
        Modele updatedCategory = ms.updateModele(m);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModele(@PathVariable Long id) {
        ms.deleteModele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
