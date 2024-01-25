package com.Vaik.ocaz.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Vaik.ocaz.model.Annonce;
import com.Vaik.ocaz.service.AnnonceService;

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

@RestController
@RequestMapping("annonce")
public class AnnonceController {
    private final AnnonceService serv;

    @Autowired
    public AnnonceController(AnnonceService s){
        this.serv=s;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id) {
        Annonce a = serv.getAnnonceById(id);
        if (a != null) {
            return new ResponseEntity<>(a, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    

    @GetMapping("/getAll")
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
      List<Annonce> cat = serv.getAllAnnonces();
      if (cat != null && !cat.isEmpty()) {
          return new ResponseEntity<>(cat, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/add")
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce m) {
        Annonce savedCategory = serv.createAnnonce(m);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Annonce> updateAnnonce(@RequestBody Annonce m) {
        Annonce u = serv.updateAnnonce(m);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        serv.deleteAnnonce(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/valider/{id}")
        public ResponseEntity<Annonce> validerAnnonce(@PathVariable Long id) {
        Annonce a = serv.getAnnonceById(id);

        if (a != null) {
            a.setValid(true);  // Mettre à jour la propriété "isValid"
            Annonce up = serv.updateAnnonce(a);
            return new ResponseEntity<>(up, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
